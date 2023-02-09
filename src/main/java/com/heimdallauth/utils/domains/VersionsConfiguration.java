package com.heimdallauth.utils.domains;

import com.heimdallauth.utils.representations.ImageRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VersionsConfiguration {
    @Id
    private String versionId;
    private ImageRepresentation serviceDiscoveryImage;
    private List<ImageRepresentation> frontendDeploymentImages;
    private ImageRepresentation apiGateway;
    private List<ImageRepresentation> microservices;
}
