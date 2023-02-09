package com.heimdallauth.utils.constants;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ContainerRestartPolicy {
    @JsonProperty("no")
    NO,
    @JsonProperty("always")
    ALWAYS,
    @JsonProperty("unless-stopped")
    UNLESS_STOPPED
}
