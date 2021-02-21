package org.acme.getting.started;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.enterprise.context.ApplicationScoped;

//@Singleton
@ApplicationScoped
public class JacksonConfig implements ObjectMapperCustomizer {

    @Override
    public void customize(ObjectMapper objectMapper) {
        // Allow empty fields
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

//        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    }
}
