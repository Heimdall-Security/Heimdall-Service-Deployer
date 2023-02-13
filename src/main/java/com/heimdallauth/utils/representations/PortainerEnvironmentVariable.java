package com.heimdallauth.utils.representations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PortainerEnvironmentVariable {
    private String name;
    private String value;
}
