package com.heimdallauth.utils.representations;

import com.heimdallauth.utils.constants.ContainerRestartPolicy;
import com.heimdallauth.utils.constants.ServiceConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Map;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceRepresentation {
    private ImageRepresentation image;
    private ContainerRestartPolicy restartPolicy;


}
