package com.lxt.core.filter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 请求响应时间filer
 *
 * @author zer0
 * @version 1.0
 */
public class RequestInfoFilter implements Filter{

    private static final Log logger = LogFactory.getLog(RequestInfoFilter.class);
    private static final List<String> ignoreList = new ArrayList<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ignoreList.add("js");
        ignoreList.add("css");
        ignoreList.add("png");
        ignoreList.add("ico");
        ignoreList.add("gif");
        ignoreList.add("jpg");
        ignoreList.add("txt");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            long startTime = System.currentTimeMillis();
            String uri = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());
            if(!isIgnore(uri)) {
                logger.info("==================== RequestInfoFilter Start ====================");
                logger.info(request.getMethod() + " : " + uri);
                logger.info("request time：" + request.getSession().getMaxInactiveInterval());

                logHeaders(request);
                logParams(request);

                filterChain.doFilter(request, response);

                long endTime = System.currentTimeMillis();
                logger.info(request.getMethod() + " " + "taking：" + (endTime - startTime) + " ms");
                logger.info("==================== RequestInfoFilter End ====================");
            } else {
                filterChain.doFilter(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void logHeaders(javax.servlet.http.HttpServletRequest request) {
        Map<String, String> headerMap = new HashMap<>();

        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headName = headers.nextElement();
            if (headName != null && !"".equals(headName)) {
                headerMap.put(headName, request.getHeader(headName));
            }
        }
        headerMap.put("RemoteHost", request.getRemoteHost() + ":" + request.getRemotePort());

        logger.info(headerMap);
    }

    private void logParams(javax.servlet.http.HttpServletRequest request) {
        Map<String, String> maps = new HashMap<>();

        Enumeration<String> keys = request.getParameterNames();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if (StringUtils.isNotEmpty(key)) {
                String values = request.getParameter(key);
                maps.put(key, values);
            }
        }

        logger.info(maps.toString());
    }

    private static final boolean isIgnore(String url) {
        boolean ignore = false;
        int index = url.lastIndexOf(".");
        if(index > 0) {
            String subfix = url.substring(index + 1, url.length());
            if(ignoreList.contains(subfix)) {
                ignore = true;
            }
        }
        return ignore;
    }

    @Override
    public void destroy() {

    }
}
