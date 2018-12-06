package com.vmware;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@Value("${app.greeting}")
	private String greeting;

	@Value("${server.port}")
	private String port;

	@RequestMapping("/greet")
	public String m1() {
		return greeting + " -> " + port;
	}

}
