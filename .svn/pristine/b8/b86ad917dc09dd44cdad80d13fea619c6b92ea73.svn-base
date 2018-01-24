package com.centit.hlwyw.core.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import com.centit.hlwyw.account.entity.Principal;

/**
 * XssFilter
 *
 */
public class IndexFilter extends OncePerRequestFilter {
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
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String url = request.getRequestURI();
		url = url.substring(1, url.length());
		String[] urls = { "", "index-maintain", "index-analyze",
				"index-service", "login" };
		Boolean flag = false;
		for (String u : urls) {
			if (u.equals(url)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = request.getSession();
			Principal principal = (Principal) session.getAttribute("userinfo");
			if (principal != null && principal.getIndex() != null) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/");
			}
		}
	}
}