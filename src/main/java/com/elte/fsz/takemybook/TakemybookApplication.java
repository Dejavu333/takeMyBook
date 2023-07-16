package com.elte.fsz.takemybook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.elte.fsz.takemybook.application.service.TestDataGenerator;

@SpringBootApplication
@EntityScan(basePackages = {"com.elte.fsz.takemybook.domain"})
@Controller
public class TakemybookApplication {
	@Autowired
	private TestDataGenerator testDataGenerator;

	public static void main(String[] args) {
		SpringApplication.run(TakemybookApplication.class, args);
	}

	@RequestMapping(path = "/maps", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView mapUI() {
		return new ModelAndView("maps");
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args->{
			testDataGenerator.ceateTestData();
			ctx.getBean(TakemybookApplication.class).play();

		};
	}

	public void play() {
	}
}
