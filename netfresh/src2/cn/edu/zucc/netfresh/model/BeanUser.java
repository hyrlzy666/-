package cn.edu.zucc.netfresh.model;

import java.util.Date;

public class BeanUser {
	private String userId;
	private String userName;
	private Boolean userSex;
	private String userEmail;
	private String userPwd;
	private String userPhone;
	private String siteCity;
	private Boolean isVip;
	private Date vipEndDate;
	private Date vipBeginDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Boolean getUserSex() {
		return userSex;
	}
	public void setUserSex(Boolean userSex) {
		this.userSex = userSex;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getSiteCity() {
		return siteCity;
	}
	public void setSiteCity(String siteCity) {
		this.siteCity = siteCity;
	}
	public Boolean getIsVip() {
		return isVip;
	}
	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}
	public Date getVipEndDate() {
		return vipEndDate;
	}
	public void setVipEndDate(Date vipEndDate) {
		this.vipEndDate = vipEndDate;
	}
	public Date getVipBeginDate() {
		return vipBeginDate;
	}
	public void setVipBeginDate(Date vipBeginDate) {
		this.vipBeginDate = vipBeginDate;
	}
}
