package com.syetc.macm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class ExceptionController {
	
	@RequestMapping(value="/error.action",produces="application/json")
	@ResponseBody
	public Map exceptionJson(HttpServletRequest request){
		Integer errorCode = (Integer)request.getAttribute("errorcode");
		Map map = new HashMap();
		map.put("errorcode", errorCode);
		return map;
	}
}
