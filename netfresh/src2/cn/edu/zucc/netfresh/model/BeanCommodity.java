package cn.edu.zucc.netfresh.model;

public class BeanCommodity {
	private String CommodityId;
	private String CommodityName;
	private String CategoryId;
	private double CommodityPrice;
	private double VipPrice;
	private String CommodityDesc;
	private int CommodityNum;
	private String CommodityType;
	public String getCommodityId() {
		return CommodityId;
	}
	public void setCommodityId(String commodityId) {
		CommodityId = commodityId;
	}
	public String getCommodityName() {
		return CommodityName;
	}
	public void setCommodityName(String commodityName) {
		CommodityName = commodityName;
	}
	public String getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}
	public double getCommodityPrice() {
		return CommodityPrice;
	}
	public void setCommodityPrice(double commodityPrice) {
		CommodityPrice = commodityPrice;
	}
	public double getVipPrice() {
		return VipPrice;
	}
	public void setVipPrice(double vipPrice) {
		VipPrice = vipPrice;
	}
	public String getCommodityDesc() {
		return CommodityDesc;
	}
	public void setCommodityDesc(String commodityDesc) {
		CommodityDesc = commodityDesc;
	}
	public int getCommodityNum() {
		return CommodityNum;
	}
	public void setCommodityNum(int commodityNum) {
		CommodityNum = commodityNum;
	}
	public String getCommodityType() {
		return CommodityType;
	}
	public void setCommodityType(String commodityType) {
		CommodityType = commodityType;
	}
	
}
