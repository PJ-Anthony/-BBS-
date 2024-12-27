package com.syetc.macm.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.syetc.macm.entity.Message;
import com.syetc.macm.entity.User;



/**
 * Application Lifecycle Listener implementation class InitDataListener
 *
 */
@WebListener
public class InitDataListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitDataListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	Long t = new Date().getTime();
    	System.out.println(">>>>>>>开始加载初识数据");
    	ServletContext ctx = event.getServletContext();
    	
    	Map userMap = new HashMap();
		User u1 = new User("lisi","123456","李小四","headPic/1.jpg");
		User u2 = new User("zhangsan","123456","张小三","headPic/2.jpg");
		User u3 = new User("wangwu","123456","王小五","headPic/3.jpg");
		userMap.put(u1.getLoginId(), u1);
		userMap.put(u2.getLoginId(), u2);
		userMap.put(u3.getLoginId(), u3);
		ctx.setAttribute("users", userMap);
		
		List<Message> messageList = new ArrayList();
		messageList.add(new Message("555555555",new Date(t-2*60*1000),1,u1,u2));
		messageList.add(new Message("不喜欢",new Date(t-5*60*1000),2,u2,u1));
		messageList.add(new Message("悄悄的问一下，你喜欢我么",new Date(t-12*60*1000),2,u1,u2));
		messageList.add(new Message("你能悄悄问我么",new Date(t-26*60*1000),2,u2,u1));
		messageList.add(new Message("你喜欢我么",new Date(t-44*60*1000),1,u1,u2));
		messageList.add(new Message("试着发一条",new Date(t-25*60*60*100),1,u3,u2));
		messageList.add(new Message("发着玩",new Date(t-25*60*60*100),1,u3,u1));
		
		ctx.setAttribute("messages", messageList);
		System.out.println(">>>>>>>加载初识数据完成");
    }	
}
