package com.vmware;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("api-gateway")
public interface SVCOne {
	@RequestMapping("/api/greet")
	public String greet();

}
