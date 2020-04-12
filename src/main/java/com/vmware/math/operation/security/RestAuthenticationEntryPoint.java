package com.vmware.math.operation.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse httpServletResponse,
			AuthenticationException authEx) throws IOException {
		httpServletResponse.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
		httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = httpServletResponse.getWriter();
		writer.println("HTTP Status 401 - " + authEx.getMessage());
	}

	@Override
	public void afterPropertiesSet() {
		setRealmName("Shalini");
		super.afterPropertiesSet();
	}
}
