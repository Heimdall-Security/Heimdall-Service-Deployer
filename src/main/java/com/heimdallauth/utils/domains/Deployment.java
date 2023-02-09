package com.heimdallauth.utils.domains;

import com.heimdallauth.utils.representations.APIGatewayService;
import com.heimdallauth.utils.representations.FrontendService;
import com.heimdallauth.utils.representations.PortainerEnvironmentVariable;
import com.heimdallauth.utils.representations.ServiceRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "deployments-collection")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Deployment {
    @Id
    private String id;
    private ServiceRepresentation serviceDiscoveryServerInformation;
    private ServiceRepresentation datastoreServerInformation;
    private List<PortainerEnvironmentVariable> environment;
    private List<FrontendService> frontendServices;
    private List<APIGatewayService> apiGatewayService;
    private List<ServiceRepresentation> serviceRepresentation;
}
