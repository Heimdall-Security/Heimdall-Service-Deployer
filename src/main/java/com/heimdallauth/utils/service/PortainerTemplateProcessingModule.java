package com.heimdallauth.utils.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heimdallauth.utils.constants.Recipe;
import com.heimdallauth.utils.constants.ServiceConstants;
import com.heimdallauth.utils.constants.TemplateEngine;
import com.heimdallauth.utils.dto.template.request.TemplateProcessRequestDTO;
import com.heimdallauth.utils.dto.template.templates.HeimdallStackDeploymentInformation;
import com.heimdallauth.utils.exceptions.DownstreamServiceException;
import jakarta.annotation.PostConstruct;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PortainerTemplateProcessingModule {
    @Value("${constants.report.processor}")
    private String reportProcessorEndpoint;
    private static final String API_REPORT_ENDPOINT = "/api/report";
    private static final ObjectMapper JSON_CONVERTOR = new ObjectMapper();
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static final MediaType JSON_MEDIA = MediaType.parse("application/json; charset=utf-8");
    private static final int UNAUTHORIZED_CODE = 401;
    private Map<ServiceConstants, String> cacheMap;

    @PostConstruct
    public void initComponent() {
        updateCacheTemplate();
    }

    private void updateCacheTemplate() {
        List<ServiceConstants> serviceConstantsList = List.of(ServiceConstants.values());
        cacheMap.clear();
        serviceConstantsList.stream().forEach(service -> cacheMap.put(service, fetchTemplate(service)));
    }

    public String processedTemplate(ServiceConstants service, HeimdallStackDeploymentInformation stackDeploymentInformation) {
        TemplateProcessRequestDTO processingRequest = TemplateProcessRequestDTO.builder()
                .content(cacheMap.get(service))
                .data(stackDeploymentInformation)
                .engine(TemplateEngine.HANDLEBARS)
                .recipe(Recipe.TEXT)
                .build();
        try {
            RequestBody payloadBody = RequestBody.create(JSON_CONVERTOR.writeValueAsString(processingRequest), JSON_MEDIA);
            Request payload = new Request.Builder().post(payloadBody).url(reportProcessorEndpoint + API_REPORT_ENDPOINT).build();
            return validateResponse(HTTP_CLIENT.newCall(payload).execute());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String fetchTemplate(ServiceConstants service) {
        Request httpRequest = new Request.Builder().get().url(service.templateWebLocation).build();
        try {
            String validatedResponse = validateResponse(HTTP_CLIENT.newCall(httpRequest).execute());
            return validatedResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String validateResponse(Response httpResponse) throws IOException {
        if (!httpResponse.isSuccessful()) {
            return httpResponse.body().string();
        } else if (!httpResponse.isSuccessful() && httpResponse.code() == UNAUTHORIZED_CODE) {
            throw new DownstreamServiceException(httpResponse.body().string(), httpResponse.request().url().toString());
        } else {
            throw new DownstreamServiceException("Unknown Error", httpResponse.request().url().toString());
        }
    }

    private static Response processTemplate(String endpoint, Object payloadData) {
        try {
            RequestBody payload = RequestBody.create(JSON_CONVERTOR.writeValueAsString(payloadData), JSON_MEDIA);
            Request httpRequest = new Request.Builder().url(endpoint).post(payload).build();
            Response httpResponse = HTTP_CLIENT.newCall(httpRequest).execute();
            if (!httpResponse.isSuccessful()) {
                throw new DownstreamServiceException(httpResponse.body().string(), endpoint);
            }
            return httpResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
