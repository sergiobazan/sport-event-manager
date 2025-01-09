package com.bazan.sporteventmanager;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class SportEventManagerApplicationTests {

	static ApplicationModules modules = ApplicationModules.of(SportEventManagerApplication.class);

	@Test
	void verifyModules() {
		modules.forEach(System.out::println);
		modules.verify();
	}

}
