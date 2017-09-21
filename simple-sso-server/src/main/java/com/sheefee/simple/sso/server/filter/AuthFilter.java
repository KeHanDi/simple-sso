package com.sheefee.simple.sso.server.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sheefee.simple.sso.client.constant.AuthConst;

public class AuthFilter implements Filter{
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		
		String uri = request.getRequestURI();
		
		// 已经登录，放行，实际上，登录后，只能访问success页面
		if (session.getAttribute(AuthConst.IS_LOGIN) != null) {
			if (!"/success".equals(uri)) {
				response.sendRedirect("/success");
				return;
			}
			chain.doFilter(req, res);
			return;
		}
		// 登录请求，放行
		if ("/".equals(uri) || "/login".equals(uri)) {
			chain.doFilter(req, res);
			return;
		}
		
		// 其他请求，拦截
		response.sendRedirect("/");
	}

	public void init(FilterConfig config) throws ServletException {
	}
}