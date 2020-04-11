package com.lnterceptor.pattern.example.config;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * log time in and out of web request to our application Demonstration of
 * different ways to log time
 * 
 * @author Samarth Narula
 *
 */
@Slf4j
@Component
public class LoggerInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		log.info("Completed request and rendered page at: " + new Timestamp(System.currentTimeMillis()));

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		log.info("Executed Method: " + new Timestamp(System.currentTimeMillis()));

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		log.info("Started request at: " + new Timestamp(System.currentTimeMillis()));
		return true;
	}
}
