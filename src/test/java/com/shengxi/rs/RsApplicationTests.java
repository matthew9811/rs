package com.shengxi.rs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class RsApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void test(){
		String time = "19-03-10";
		System.out.println(time.substring(6,8));
	}
}
