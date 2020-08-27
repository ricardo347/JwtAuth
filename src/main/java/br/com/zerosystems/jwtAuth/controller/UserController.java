package br.com.zerosystems.jwtAuth.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@PostMapping("/users")
	@ResponseBody
	public String getUsers() {
		logger.debug("debug");
		logger.info("info");
		return "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"}," +
		           "{\"name\":\"Jackie\",\"country\":\"China\"}]}";
	}
	@PostMapping("/secret")
	@ResponseBody
	public String getSecret() {
		logger.info("bateu no endpoint secret");
		return "END POINT LIVRE DO FILTRO";
	}
}
