package com.wisely.ch7_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Ch74Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch74Application.class, args);
	}

	// 服务器配置的第二种方法：新建一个静态内部类
//	@Component
//	public static class CustomServletContainer implements EmbeddedServletContainerCustomizer {
//		@Override
//		public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
//			configurableEmbeddedServletContainer.setPort(9090);
//			configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
//			configurableEmbeddedServletContainer.setSessionTimeout(10, TimeUnit.MINUTES);
//		}
//	}

	// 服务器配置的第三种方法：针对特定的服务器配置，返回一个 bean。
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(7070);
		factory.setSessionTimeout(10, TimeUnit.MINUTES);
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
		return factory;
	}

}
