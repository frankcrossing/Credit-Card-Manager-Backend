package com.jieandata.web.filter;

import java.io.IOException;
import java.util.ArrayList;
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

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@WebFilter(filterName = "urlFilter", urlPatterns = "/*")
public class UrlFilter implements Filter {

	@Value("${myOriginUrl}")
	private String myOriginUrl;

	private static List<String> ignoreUriList = new ArrayList<String>();
	static {
		ignoreUriList = new ArrayList<String>();
		ignoreUriList.add("swagger");
		ignoreUriList.add("/v2/api-docs");
		ignoreUriList.add("/images");
		ignoreUriList.add("/configuration");
		ignoreUriList.add("/test");
		ignoreUriList.add("/login");
		ignoreUriList.add("/goLoginPage");
		ignoreUriList.add("/doLogin");
	}
	private static boolean isIgnoreUri(String uri) {
		for (String str : ignoreUriList) {
			if (uri.indexOf(str) > -1) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("UrlFilter启动成功!");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", myOriginUrl);
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie, X-Token");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		//预检请求(OPTIONS)
		if(isPrecheck(request)){
			chain.doFilter(request, response);
			return;
		}

        //特殊地址
        String uri = request.getRequestURI();
        System.out.println("=======" + uri);
        if(StringUtils.isNotBlank(uri)) {
        	if(isIgnoreUri(uri)) {
        		chain.doFilter(request, response);
        		return;
        	}
        }
        //微信服务器将发送GET请求到填写的URL上,这里需要判定是否为GET请求
        boolean isGet = request.getMethod().toLowerCase().equals("get");

		chain.doFilter(request, response);
	}

	/**
	 * 判断是否为预检请求
	 * @param request
	 * @return
	 */
	private boolean isPrecheck(HttpServletRequest request) {
		if(StringUtils.equals(RequestMethod.OPTIONS.name(), request.getMethod())){
			return true;
		}
		return false;
	}

	@Override
	public void destroy() {
		log.info("UrlFilter销毁成功!");
	}

}
