package com.vmware.math.operation.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AccessDeniedException e) throws IOException, ServletException {

		httpServletResponse.setContentType("application/json");
		httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode().put("error", true).put("cause", "FORBIDDEN").put("message",
				"Forbidden: You do not have the privileges to access this resource.");
		PrintWriter out = httpServletResponse.getWriter();
		out.print(node.toString());
		out.flush();
		out.close();
	}

}