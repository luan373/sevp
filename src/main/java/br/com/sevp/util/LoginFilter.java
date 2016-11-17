package br.com.sevp.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sevp.controller.bean.LoginBean;

@WebFilter(value = "/login.xhtml")
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		boolean isLoggedIn = false;

		try {
			HttpServletRequest httpReq = (HttpServletRequest) request;
			HttpServletResponse httpResp = (HttpServletResponse) response;
			HttpSession session = httpReq.getSession(true);

			httpReq.setCharacterEncoding("UTF-8");
			httpResp.setCharacterEncoding("UTF-8");
			httpResp.setContentType("application/json");

			isLoggedIn = session.getAttribute("usuario") != null;
			/*
			 * isLoggedIn = (boolean) System.out.println(isLoggedIn);
			 */
		} catch (Exception e) {
			isLoggedIn = false;
		}

		// Check if the user is accessing "login.xhtml"
		if (((HttpServletRequest) request).getRequestURI().equals("/sevp/login.xhtml")
				|| ((HttpServletRequest) request).getRequestURI().equals("/sevp/")) {
			if (isLoggedIn) {
				// Redirect to "home.xhtml"
				HttpServletResponse res = (HttpServletResponse) response;
				res.sendRedirect(((HttpServletRequest) request).getContextPath() + "/pages/index.xhtml");
			} else {
				// Otherwise, nothing to do if he has not logged in
				chain.doFilter(request, response);
			}

		} else {
			// For all other pages,
			if (isLoggedIn) {
				// Nothing to do
				chain.doFilter(request, response);
			} else {
				// Redirect to "login.xhtml" if he has not logged in
				HttpServletResponse res = (HttpServletResponse) response;
				res.sendRedirect(((HttpServletRequest) request).getContextPath() + "/login.xhtml");
			}
		}
	}

	@Override
	public void destroy() {

	}

}
