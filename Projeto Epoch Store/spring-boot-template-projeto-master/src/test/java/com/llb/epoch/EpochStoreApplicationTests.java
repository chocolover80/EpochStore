package com.llb.epoch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.llb.epoch.EpochStoreApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EpochStoreApplication.class)
@WebAppConfiguration
public class EpochStoreApplicationTests {

	@Test
	public void contextLoads() {
	}

}
