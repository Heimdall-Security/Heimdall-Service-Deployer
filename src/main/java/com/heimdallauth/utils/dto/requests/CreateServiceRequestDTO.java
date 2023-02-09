package com.heimdallauth.utils.dto.requests;

import com.heimdallauth.utils.constants.ServiceConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateServiceRequestDTO {
    private ServiceConstants service;
    private String deploymentPathPrefix;
    private String requesterEmail;

}
