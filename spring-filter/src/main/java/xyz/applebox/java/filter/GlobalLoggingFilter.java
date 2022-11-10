package xyz.applebox.java.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class GlobalLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(httpServletRequest, httpServletResponse);

        String url = httpServletRequest.getRequestURI();
        String requestContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request >> url: {}, body: {}", url, requestContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();
        log.info("response >> httpStatus: {}, body: {}", httpStatus, resContent);

        httpServletResponse.copyBodyToResponse();
    }

}
