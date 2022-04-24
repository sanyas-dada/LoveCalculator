package com.sanyasdada.ic.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LCAppintializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		/*
		 * Class arr[] = {LoveCalculatorAppConfig.class};
		 * 
		 * return arr;
		 */
		return new Class[] {LoveCalculatorAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		/*
		 * String arr[] = {"/"}; return arr;
		 */
		return new String[] {"/"};
	}

}
