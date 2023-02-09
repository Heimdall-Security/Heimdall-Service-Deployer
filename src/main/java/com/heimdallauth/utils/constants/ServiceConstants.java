package com.heimdallauth.utils.constants;

public enum ServiceConstants {
    HEIMDALL_STACK("https://raw.githubusercontent.com/Heimdall-Security/templates/main/heimdall-stack-template.yml");
    public final String templateWebLocation;

    ServiceConstants(String templateWebLocation) {
        this.templateWebLocation = templateWebLocation;
    }
}
