package com.heimdallauth.utils.api;

import com.heimdallauth.utils.constants.ServiceConstants;
import com.heimdallauth.utils.dto.ServiceTemplateDTO;
import com.heimdallauth.utils.dto.requests.AddNewServiceDeploymentTemplate;
import com.heimdallauth.utils.service.DeploymentTemplatesAdministrationModule;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Administration API", description = "This API provides the endpoints that are used to perform administration operations on the application")
public class AdministrationAPI {
    private final DeploymentTemplatesAdministrationModule deploymentTemplatesAdministrationModule;

    public AdministrationAPI(DeploymentTemplatesAdministrationModule deploymentTemplatesAdministrationModule) {
        this.deploymentTemplatesAdministrationModule = deploymentTemplatesAdministrationModule;
    }

    @GetMapping("/admin/templates/{templateId}")
    public ResponseEntity<ServiceTemplateDTO> getServiceTemplate(@PathVariable("templateId") String templateId) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/admin/templates")
    public ResponseEntity<List<ServiceTemplateDTO>> getServiceTemplatesAndVersions(@RequestParam("service") ServiceConstants serviceConstants) {
        return ResponseEntity.status(HttpStatus.OK).body(deploymentTemplatesAdministrationModule.fetchServiceTemplates(serviceConstants));
    }

    @PostMapping("/admin/templates")
    public ResponseEntity<ServiceTemplateDTO> createNewServiceTemplate(@RequestBody AddNewServiceDeploymentTemplate createServiceRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deploymentTemplatesAdministrationModule.createNewServiceTemplate(createServiceRequestDTO));
    }

    @PutMapping("/admin/templates/{templateId}")
    public ResponseEntity<ServiceTemplateDTO> updateServiceTemplate(@PathVariable("templateId") String templateId, @RequestBody ServiceTemplateDTO serviceTemplateDTO) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/admin/templates/{templateId}")
    public ResponseEntity<Void> removDeploymentTemplate(@PathVariable("templateId") String templateId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
