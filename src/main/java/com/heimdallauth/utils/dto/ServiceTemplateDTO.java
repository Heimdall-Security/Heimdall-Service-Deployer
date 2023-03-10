package com.heimdallauth.utils.dto;

import com.heimdallauth.utils.constants.ServiceConstants;
import com.heimdallauth.utils.representations.ImageRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceTemplateDTO {
    private String templateId;
    private ServiceConstants service;
    private int version;
    private ImageRepresentation apiGateway;
    private List<ImageRepresentation> frontends;
    private List<ImageRepresentation> microservices;
    private ImageRepresentation serviceDiscovery;
    private ImageRepresentation datastore;
    private Boolean isLatest;
    private Boolean isActive;
    private String createdOn;
    private String updatedOn;
}
