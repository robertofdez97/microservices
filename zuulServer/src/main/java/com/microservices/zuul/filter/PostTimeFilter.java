package com.microservices.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTimeFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostTimeFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Long initTime = (Long) request.getAttribute("initTime");
		Long totalTime = System.currentTimeMillis() - initTime;
		log.info("Method: " + request.getMethod() + " enrutado: " + request.getRequestURL().toString() + " total time: " + totalTime/1000);
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
