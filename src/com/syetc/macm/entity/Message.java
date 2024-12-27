package com.syetc.macm.entity;

import java.util.Date;

public class Message {
	private static int id = 1000;
	private Integer messageId;
	private String info;
	private Date time;
	//1:公开，2：私密
	private Integer visitType = 1;
	private User fromUser;
	private User toUser;
	{
		messageId  = ++id;
	}
	public Message() {
		super();
	}
	
	public Message(String info, Date time, Integer visitType, User fromUser, User toUser) {
		super();
		this.info = info;
		this.time = time;
		this.visitType = visitType;
		this.fromUser = fromUser;
		this.toUser = toUser;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getVisitType() {
		return visitType;
	}

	public void setVisitType(Integer visitType) {
		this.visitType = visitType;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	

	
}
