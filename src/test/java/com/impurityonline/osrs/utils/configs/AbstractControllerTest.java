package com.impurityonline.osrs.utils.configs;

import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@Tag("Controller")
@AutoConfigureMockMvc
public abstract class AbstractControllerTest extends AbstractTest {
    @Autowired
    protected MockMvc mockMvc;
}
