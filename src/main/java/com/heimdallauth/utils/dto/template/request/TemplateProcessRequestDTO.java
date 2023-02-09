package com.heimdallauth.utils.dto.template.request;

import com.heimdallauth.utils.constants.Recipe;
import com.heimdallauth.utils.constants.TemplateEngine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TemplateProcessRequestDTO {
    private String content;
    private TemplateEngine engine;
    private Recipe recipe;
    private Object data;
}
