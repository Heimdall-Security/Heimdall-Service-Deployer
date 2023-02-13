package com.heimdallauth.utils.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heimdallauth.utils.constants.ServiceConstants;
import com.heimdallauth.utils.domains.TemplateCollection;
import com.heimdallauth.utils.dto.ServiceTemplateDTO;
import com.heimdallauth.utils.dto.requests.AddNewServiceDeploymentTemplate;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class DeploymentTemplatesAdministrationModule {
    private final MongoTemplate mongoTemplate;
    private final ObjectMapper JSON_CONVERTOR = new ObjectMapper();
    private final ModelMapper MODEL_CONVERTOR = new ModelMapper();

    public DeploymentTemplatesAdministrationModule(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ServiceTemplateDTO createNewServiceTemplate(AddNewServiceDeploymentTemplate addNewTemplate) {
        List<TemplateCollection> templatesAvailable = getTemplates(addNewTemplate.getService());
        TemplateCollection savedTemplate = mongoTemplate.save(TemplateCollection.builder()
                .datastoreImage(addNewTemplate.getDatastore())
                .frontends(addNewTemplate.getFrontends())
                .apiGateway(addNewTemplate.getApiGateway())
                .serviceDiscoveryImage(addNewTemplate.getServiceDiscovery())
                .microservices(addNewTemplate.getMicroservices())
                .serviceDNS(addNewTemplate.getServiceDNS())
                .service(addNewTemplate.getService())
                .createdOn(Instant.now())
                .updatedOn(Instant.now())
                .version(createNewVersionNumber(templatesAvailable))
                .build());
        return MODEL_CONVERTOR.map(savedTemplate, ServiceTemplateDTO.class);
    }

    public void deleteExistingTemplate(String templateId) {
        this.mongoTemplate.findAndRemove(Query.query(Criteria.where("templateId").is(templateId)), TemplateCollection.class);
    }

    public List<ServiceTemplateDTO> fetchServiceTemplates(ServiceConstants service) {
        List<TemplateCollection> templates = this.getTemplates(service);
        return templates.stream().map(template -> MODEL_CONVERTOR.map(template, ServiceTemplateDTO.class)).toList();

    }

    private List<TemplateCollection> getTemplates(ServiceConstants service) {
        return this.mongoTemplate.find(Query.query(Criteria.where("service").is(service)), TemplateCollection.class);
    }

    private int createNewVersionNumber(List<TemplateCollection> templates) {
        if (!templates.isEmpty()) {
            int highestVersion = templates.stream().mapToInt(TemplateCollection::getVersion).max().orElseThrow(() -> new RuntimeException("Unable to map highest"));
            return highestVersion + 1;
        } else {
            return 1;
        }
    }
}
