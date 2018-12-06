package com.vmware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MyRestController {

	@Value("${app.greeting}")
	private String greeting;

	@Value("${server.port}")
	private String port;

	@Autowired
	private SVCOne svc;

	@RequestMapping("/greet")
	public String m1() {
		return greeting + " -> " + port;
	}

	@RequestMapping("/getone")
	@HystrixCommand(fallbackMethod = "oldReliable")
	public String m2() {
		return svc.greet();
	}

	public String oldReliable() {
		return "Good thing this one works!";
	}

}
