package com.syetc.macm.controller;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.syetc.macm.entity.User;
import com.syetc.macm.util.JsonTools;
import com.syetc.macm.util.MyException;
import com.syetc.macm.util.MyExceptionType;



@Controller


public class UserController {
	
	@RequestMapping("/user/login.action")
	@ResponseBody
	public Object userLogin( User user, HttpServletRequest request,HttpSession session){
		ServletContext ctx = request.getServletContext();
		Map<String,User> userMap = (Map<String,User>)ctx.getAttribute("users");
		User u = userMap.get(user.getLoginId());
		if(u!=null && u.getLoginPwd().equals(user.getLoginPwd())){
			session.setAttribute("loginUser",u);
			return JsonTools.getQueryMap("user", u);		
		}else{
			throw new MyException(MyExceptionType.LOGIN_ERROR);
		}
		
	}
	@RequestMapping("/user/register.action")
	@ResponseBody
	public Object userRegister(User user, MultipartFile headPic, HttpServletRequest request){
		ServletContext ctx = request.getServletContext();
		Map<String,User> userMap = (Map<String,User>)ctx.getAttribute("users");
		User u = userMap.get(user.getLoginId());
		if(u!=null){
			throw new MyException(MyExceptionType.USER_EXIST_ERROR);
		}
		String path = ctx.getRealPath("/headPic");
		String endName = headPic.getOriginalFilename().substring(headPic.getOriginalFilename().lastIndexOf("."));
		String headPicName = user.getLoginId()+endName;
		File headPicFile = new File(path, headPicName);
		System.out.println(path+"/"+headPicName);
		try {
	    	headPic.transferTo(headPicFile);
	    	user.setHeadPicUrl("/headPic/"+headPicName);
	    	userMap.put(user.getLoginId(), user);
			return JsonTools.getExecuteMap();
	    } catch (Exception e) {
	    	throw new MyException(MyExceptionType.SYSTEM_ERROR);
	    }
		
		
	}
}
