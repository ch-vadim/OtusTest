package com.example.demo;

import com.example.demo.service.MessagesService;
import com.example.demo.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

//		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

//		TestService testService = ctx.getBean(TestService.class);
//		MessagesService messagesService = ctx.getBean(MessagesService.class);
//
//		messagesService.sayHello();
//		testService.startTest();
//		messagesService.sayResult(testService.getTestResult());
	}

}
