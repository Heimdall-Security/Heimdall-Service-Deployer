package com.heimdallauth.utils.representations;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FrontendService extends ServiceRepresentation {
    private String servicePathPrefix;
    private String namingStrategy;
    private int forwardToPort;
}
