package com.heimdallauth.utils.representations;

import com.heimdallauth.utils.constants.ContainerRestartPolicy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceRepresentation {
    private ImageRepresentation image;
    private ContainerRestartPolicy restartPolicy;
}
