package com.heimdallauth.utils.constants;

public enum ImageRegistry {
    GITHUB_CONTAINER_REGISTRY("ghcr.io"),
    DOCKER_REGISTRY("");
    public final String registryPrefix;

    ImageRegistry(String registryPrefix) {
        this.registryPrefix = registryPrefix;
    }
}
