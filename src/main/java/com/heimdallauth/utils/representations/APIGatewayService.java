package com.heimdallauth.utils.representations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class APIGatewayService extends ServiceRepresentation{
    private String apiGatewayPrefix;
    private String pathPrefix;
    private Boolean stripPathPrefix;
    private int forwardToPort;
}
