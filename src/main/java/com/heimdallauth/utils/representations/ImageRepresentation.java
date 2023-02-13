package com.heimdallauth.utils.representations;

import com.heimdallauth.utils.constants.ImageRegistry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImageRepresentation {
    private ImageRegistry imageRegistry;
    private String imageName;
    private String tag;
}
