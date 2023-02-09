package com.heimdallauth.utils.domains;

import com.heimdallauth.utils.representations.ImageRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "template-collection")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TemplateCollection {
    @Id
    private String id;
    private ImageRepresentation apiGateway;
    private List<ImageRepresentation> frontends;
    private List<ImageRepresentation> microservices;
    private String serviceDNS;
    private ImageRepresentation datastoreImage;
    private ImageRepresentation serviceDiscoveryImage;
    private ImageRepresentation vaultImage;
}
