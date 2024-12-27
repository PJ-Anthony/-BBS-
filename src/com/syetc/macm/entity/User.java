package com.syetc.macm.entity;
	
public class User {
	private String loginId;
	private String loginPwd;
	private String nickName;
	private String headPicUrl;
	
	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", loginPwd=" + loginPwd + ", nickName=" + nickName + ", headPicUrl="
				+ headPicUrl + "]";
	}
	public User() {
		super();
	}
	public User(String loginId, String loginPwd, String nickName, String headPicUrl) {
		super();
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.nickName = nickName;
		this.headPicUrl = headPicUrl;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadPicUrl() {
		return headPicUrl;
	}
	public void setHeadPicUrl(String headPicUrl) {
		this.headPicUrl = headPicUrl;
	}
	
}
