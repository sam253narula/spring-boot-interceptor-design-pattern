package com.lnterceptor.pattern.example.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*To be noticed noticed, @RestController annotation doesn't works with Thymeleaf, 
so had to do little old fashion way of using @Controller, reason is because thymeleaf redirects to HTML page rather than returning a response*/

@Controller
public class ExampleController implements ApplicationContextAware {
	private ApplicationContext context;

	@GetMapping("/informationAboutThisApp")
	public @ResponseBody String informationAboutThisApp() {
		return "type http://localhost:9999/home url to open thymeleaf UI";
	}

	@GetMapping("/informationAboutInterceptorPattern")
	public @ResponseBody String informationAboutInterceptorPattern() {
		return "Check the logs in console, logged the start time of each interceptor handler method";
	}

	@GetMapping("/home")
	public String home(@RequestParam(value = "name", required = false, defaultValue = "buddy") String name,
			Model model) {
		model.addAttribute("name", name);
		return "home";
	}

	@PostMapping("/shutdown")
	public void shutDown() {
		((ConfigurableApplicationContext) context).close();
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.context = ctx;
	}
}
