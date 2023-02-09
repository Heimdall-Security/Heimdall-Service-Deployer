package com.heimdallauth.utils.dto.template.templates;

import com.heimdallauth.utils.representations.APIGatewayService;
import com.heimdallauth.utils.representations.FrontendService;
import com.heimdallauth.utils.representations.ServiceRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HeimdallStackDeploymentInformation {
    private String deploymentId;
    private ServiceRepresentation discoveryServer;
    private ServiceRepresentation datastoreServer;
    private APIGatewayService gateway;
    private List<FrontendService> frontendServices;
    private List<ServiceRepresentation> microservices;
}
