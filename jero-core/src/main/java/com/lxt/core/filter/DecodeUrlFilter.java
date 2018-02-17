package com.lxt.core.filter;

import com.lxt.common.utils.EncodeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DecodeUrlFilter implements Filter {
    private static final Log logger = LogFactory.getLog(DecodeUrlFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        try {
            chain.doFilter(new HttpServletRequestWrapper(request){
                @Override
                public String getParameter(String name) {
                    return EncodeUtils.urlDecode(name);
                }

                @Override
                public String[] getParameterValues(String name) {
                    String[] values = super.getParameterValues(name);
                    if (values == null) {
                        return null;
                    }
                    for (int i = 0; i < values.length; i++) {
                        values[i] = EncodeUtils.urlDecode(values[i]);
                    }
                    return values;
                }

                @Override
                public String getRequestURI() {
                    String url = super.getRequestURI();
                    String decodeUrl = EncodeUtils.urlDecode(url);
                    return decodeUrl;
                }

            }, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }

}
