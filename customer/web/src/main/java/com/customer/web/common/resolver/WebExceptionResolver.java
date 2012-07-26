package com.customer.web.common.resolver;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * <p>
 * WEB层异常解释器
 * </p>
 * 
 * @author Eric.fu
 * @version $Id: WebExceptionResolver.java, v 0.1 2010-3-26 下午02:44:47
 *          fuyangbiao Exp $
 */
public class WebExceptionResolver extends SimpleMappingExceptionResolver {
    private static final Log logger = LogFactory.getLog(WebExceptionResolver.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.servlet.handler.SimpleMappingExceptionResolver
     * #logException(java.lang.Exception, javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected void logException(Exception ex, HttpServletRequest request) {
        logger.error(buildLogMessage(ex, request), ex);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.servlet.handler.SimpleMappingExceptionResolver
     * #buildLogMessage(java.lang.Exception,
     * javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected String buildLogMessage(Exception ex, HttpServletRequest request) {
        StringBuffer message = new StringBuffer("页面操作异常！");
        message.append("页面路径：").append(request.getRequestURI());

        return message.toString();
    }
}
