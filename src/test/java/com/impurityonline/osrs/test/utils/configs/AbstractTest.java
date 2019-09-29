package com.impurityonline.osrs.test.utils.configs;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static com.impurityonline.osrs.constant.Profiles.UNIT_TEST;

/**
 * @author impurity
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles(UNIT_TEST)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Map the object to json string
     *
     * @param obj an object to be converted
     * @return a json string of the object
     * @throws JsonProcessingException if it cannot be processed
     */
    protected String mapToJson(Object obj)
            throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * Convert the json string to an object
     *
     * @param json is the json string
     * @param clazz is the object that this string converts to
     * @param <T> the type of the object to convert to
     * @return The object we have converted from json
     * @throws JsonParseException if it cannot be parsed
     * @throws JsonMappingException if it cannot be mapped
     * @throws IOException if there is an IO exception
     */
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        return objectMapper.readValue(json, clazz);
    }
}
