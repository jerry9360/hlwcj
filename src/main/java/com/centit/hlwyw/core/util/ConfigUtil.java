package com.centit.hlwyw.core.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

 
/**
 * 配置文件�?
 * @author mrpod2g
 *
 */
public class ConfigUtil {
	private static Logger log = Logger.getLogger(ConfigUtil.class);  
	private static Properties config = null;
	
	static 
	{
 				config = new Properties();
				try {
					config.load(ConfigUtil.class.getClassLoader().getResourceAsStream("system.properties"));
				} catch (IOException e) {
 						log.error(e.getMessage());
						log.info(e); 
 				}
 	}

	public static String getValue(String key) {
		return config.getProperty(key)!=null?config.getProperty(key):"";
	}
}