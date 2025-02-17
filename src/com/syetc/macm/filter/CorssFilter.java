package com.syetc.macm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorssFilter  implements Filter{
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String origin = request.getHeader("Origin");
//		System.out.println(origin);
		response.addHeader("Access-Control-Allow-Origin", origin);//添加响应头
		response.addHeader("Allow", "GET,OPTIONS,POST");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type,Access-Control-Allow-Origin,Access-Control-Allow-Credentials");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
