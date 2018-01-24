package com.centit.hlwyw.core.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;


/**
 * XssFilter
 *
 */
public class XssFilter extends OncePerRequestFilter {
    private FilterConfig filterConfig = null;



    /**
     * destroy
     *
     */
    public void destroy() {
        this.filterConfig = null;
    }

    /**
     * doFilterInternal
     *
     */
    public void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    	Enumeration<String> paraNames=request.getParameterNames();
    	for(Enumeration e=paraNames;e.hasMoreElements();){
    	       String thisName=e.nextElement().toString();
    	       String thisValue=request.getParameter(thisName);
    	       String value = cleanXSS(thisValue);
    	      if("false".equals(value)){
    	    	  response.sendRedirect(request.getContextPath() + "/serviceError");
    	      }
    	}
    	 String referer = request.getHeader("Referer");   //REFRESH  
    	   String serverName = request.getServerName();
    	if(null != referer&&referer.indexOf(serverName) < 0){            
    		request.getRequestDispatcher(request.getRequestURI()).forward(request, response);  
    	   }
    	chain.doFilter(request, response);
    }
    
    private String cleanXSS(String value) {
    	String oldvalue = value
    			//.replaceAll("<", "& lt;")
    			//.replaceAll(">", "& gt;") 
 				//.replaceAll("\\(", "& #40;")
 				//.replaceAll("\\)", "& #41;") 
 				.replaceAll("eval\\((.*)\\)", "") 
 				.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		int oldValueLength=oldvalue.length();
		String nowvalue = oldvalue
				.replaceAll("'", "") 
				.replaceAll("script", "") 
				.replaceAll("delete", "") 
				.replaceAll("select", "") 
				.replaceAll("update", "") 
				.replaceAll("drop", "") 
				.replaceAll("insert", "") 
				.replaceAll("export", "") 
				.replaceAll("insert", "") 
				.replaceAll("import", "") 
				.replaceAll("set", "") 
				.replaceAll("from", "") 
				.replaceAll("where", "") 
				.replaceAll("into", "") 
				.replaceAll(" or ", "") 
				.replaceAll(" and ", "") 
				.replaceAll("%", "") 
				.replaceAll("ltrim", "") 
				.replaceAll("load_file", "") 
				.replaceAll("union", "") 
				.replaceAll("\"", "") 
				.replaceAll("exec", "") 
				.replaceAll(";", "") 
				.replaceAll("|", "") 
				.replaceAll("&", "") 
				.replaceAll("$", "") 
				.replaceAll(";", "") 
				.replaceAll("CR", "") 
				.replaceAll("LF", "");
//		value = value.replaceAll("(", "");
//		value = value.replaceAll(")", "");
	//	value = value.replaceAll("+", "");
		//value = value.replaceAll("\\", "");
		int nowValueLength = nowvalue.length();
		if(nowValueLength!=oldValueLength){
			return "false";
		}
		return value;
	}
}