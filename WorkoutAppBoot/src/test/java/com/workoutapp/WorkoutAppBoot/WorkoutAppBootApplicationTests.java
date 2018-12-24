package com.workoutapp.WorkoutAppBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@EnableConfigurationProperties
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class WorkoutAppBootApplicationTests {

	@Test
	public void contextLoads() {
	}

}

