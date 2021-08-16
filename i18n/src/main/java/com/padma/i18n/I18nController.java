package com.padma.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class I18nController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/hello-world")
	public String helloWorld(/* @RequestHeader(name = "Accept-Language", required = false ) Locale locale */) {
		//return messageSource.getMessage("good.morning.message", null, locale);
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	 
}
