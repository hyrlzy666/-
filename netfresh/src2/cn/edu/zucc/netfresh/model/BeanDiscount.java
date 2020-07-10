package cn.edu.zucc.netfresh.model;

import java.util.Date;

public class BeanDiscount {
	private String discountId;
	private String discountDesc;
	private Date beginDate;
	private Date EndDate;
	private double disPrice;
	public String getDiscountId() {
		return discountId;
	}
	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}
	public String getDiscountDesc() {
		return discountDesc;
	}
	public void setDiscountDesc(String discountDesc) {
		this.discountDesc = discountDesc;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public double getDisPrice() {
		return disPrice;
	}
	public void setDisPrice(double disPrice) {
		this.disPrice = disPrice;
	}
	
	
}
