package com.syetc.macm.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handle,
			Exception e) {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/error.action");
		if(e instanceof MyException){
			mav.addObject("errorcode", ((MyException) e).getErrorCode());
			
		}else{
			mav.addObject("errorcode", MyExceptionType.SYSTEM_ERROR);
		}
		
		return mav;
	}

}
