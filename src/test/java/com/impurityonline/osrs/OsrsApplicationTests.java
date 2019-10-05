package com.impurityonline.osrs;

import com.impurityonline.osrs.test.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author impurity
 */
class OsrsApplicationTests extends AbstractTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	@DisplayName("The application entry works")
	void application_entry() {
		OsrsApplication.main(new String[]{"Apples", "Bananas"});
		assertNotNull(applicationContext);
	}

	@Test
	@DisplayName("The application context loads")
	void context_loads() {
		assertNotNull(applicationContext);
	}

}
