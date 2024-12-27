package com.syetc.macm.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonTools {
	public static Map getQueryMap(String name, Object value){
		Map map = new LinkedHashMap();
		map.put("errorcode", 0);
		Map resultMap = new LinkedHashMap();
		resultMap.put(name, value);
		map.put("result", resultMap);
		return map;
	}
	public static Map getQueryMap(Map<String,Object> resultMap){
		Map map = new LinkedHashMap();
		map.put("errorcode", 0);
		map.put("result", resultMap);
		return map;
	}
	public static Map getExecuteMap(){
		Map map = new LinkedHashMap();
		map.put("errorcode", 0);
		return map;
	}
}
