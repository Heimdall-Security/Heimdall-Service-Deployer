package com.heimdallauth.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateServiceResponseDTO {
    private String deploymentId;
    private String requesterEmail;

}
