/*
 */
package com.centit.hlwyw.core.util;

import java.util.Locale;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.LocaleResolver;

/**
 * Utils - Spring
 * 
 * @author
 * @version 1.0
 */
@Component("springUtils")
@Lazy(false)
public final class SpringUtils implements ApplicationContextAware,
		DisposableBean {

	/** applicationContext */
	private static ApplicationContext applicationContext;

	private SpringUtils() {
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtils.applicationContext = applicationContext;
	}

	public void destroy()   {
		applicationContext = null;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) {
		Assert.hasText(name);
		return applicationContext.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> type) {
		Assert.hasText(name);
		Assert.notNull(type);
		return applicationContext.getBean(name, type);
	}

	public static String getMessage(String code, Object... args) {
		LocaleResolver localeResolver = getBean("localeResolver",
				LocaleResolver.class);
		Locale locale = localeResolver.resolveLocale(null);
		return applicationContext.getMessage(code, args, locale);
	}

}