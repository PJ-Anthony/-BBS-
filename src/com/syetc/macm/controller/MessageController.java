package com.syetc.macm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syetc.macm.entity.Message;
import com.syetc.macm.entity.User;
import com.syetc.macm.util.JsonTools;
import com.syetc.macm.util.MyException;
import com.syetc.macm.util.MyExceptionType;



@Controller


public class MessageController {
	
	@RequestMapping("/message/find.action")
	@ResponseBody
	public Object find(Integer type, HttpServletRequest request,HttpSession session){
		if(type==null){
			type = 1;
		}
		ServletContext ctx = request.getServletContext();
		
		List<Message> list = (List)ctx.getAttribute("messages");
		switch(type){
		case 1:
			list = list.stream().filter((m)->{
				return m.getVisitType()==1;
			}).collect(Collectors.toList());
			break;
		case 2:
			User user = (User)session.getAttribute("loginUser");
			if(user == null){
				throw new MyException(MyExceptionType.NO_LOGIN_ERROR);
			}
			list = list.stream().filter((m)->{
				return m.getToUser().getLoginId().equals(user.getLoginId())||m.getFromUser().getLoginId().equals(user.getLoginId());
			}).collect(Collectors.toList());
			break;
		default:
			throw new MyException(MyExceptionType.PARAM_ERROR);
		}
		return JsonTools.getQueryMap("messages", list);
		
	}
	
	@RequestMapping("/message/add.action")
	@ResponseBody
	public Object addMessage(String info, String toUserId, Integer type, HttpServletRequest request,HttpSession session){
		ServletContext ctx = request.getServletContext();
		Map<String, User> userMap = (Map)ctx.getAttribute("users");
		User fromUser = (User)session.getAttribute("loginUser");
		User toUser = userMap.get(toUserId);
		if(toUserId == null || type == null){
			throw new MyException(MyExceptionType.NO_DATA);
		}
		List<Message> list = (List)ctx.getAttribute("messages");
		list.add(0, new Message(info,new Date(), type, fromUser, toUser));
		ctx.setAttribute("messages", list);
		return JsonTools.getExecuteMap();
		
	}
	@RequestMapping("/message/del.action")
	@ResponseBody
	public Object delMessage(String id, HttpServletRequest request){
		if(id==null){
			throw new MyException(MyExceptionType.PARAM_ERROR);
		}
		int mid = 0;
		try {
			mid = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			throw new MyException(MyExceptionType.PARAM_ERROR);
		}
		
		ServletContext ctx = request.getServletContext();
		List<Message> list = (List)ctx.getAttribute("messages");
		for(Message m : list){
			if(m.getMessageId()==mid){
				list.remove(m);
				return JsonTools.getExecuteMap();
			}
		}
		throw new MyException(MyExceptionType.NO_DATA);
	}
}
