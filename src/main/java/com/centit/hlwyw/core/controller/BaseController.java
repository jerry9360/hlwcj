package com.centit.hlwyw.core.controller;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.util.HtmlUtils;

import com.centit.hlwyw.core.util.DateEditor;
import com.centit.hlwyw.core.util.TimestampEditor;




@Controller
public abstract  class BaseController {


	/**
	 * 绑定所有字符串参数绑定，将Html字符转义
	 * 
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new PropertiesEditor() {

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(StringUtils.hasText(text) ? HtmlUtils.htmlEscape(text) : text);
			}

			@Override
			public String getAsText() {
				return StringUtils.hasText((String) getValue()) ? String.valueOf(getValue()) : (String) getValue();
			}
		});
		binder.registerCustomEditor(Date.class, new DateEditor(true));
		binder.registerCustomEditor(Timestamp.class, new TimestampEditor(true));
	}




}
