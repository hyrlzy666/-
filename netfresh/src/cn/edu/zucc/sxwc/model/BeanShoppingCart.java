package cn.edu.zucc.sxwc.model;

public class BeanShoppingCart {
	private String goodsid;//��Ʒ���
	private String lbid;//�����
	private String goodsname;//��Ʒ����
	private Float price;//�۸�
	private int amount;//����
	private String userid;
	private Float sumprice;
	public static final String[] CartTitles={"��Ʒ���","�����","��Ʒ����"," ����","����","�ۺ��ܼ�"};
	public String getCell(int col){
		if(col==0) return String.valueOf(goodsid);
		else if(col==1) return String.valueOf(lbid);
		else if(col==2) return String.valueOf(goodsname);
		else if(col==3) return String.valueOf(price);
		else if(col==4) return String.valueOf(amount);
		else if(col==5) return String.valueOf(sumprice);
		else return "";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Float getSumprice() {
		return sumprice;
	}
	public void setSumprice(Float sumprice) {
		this.sumprice = sumprice;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getLbid() {
		return lbid;
	}
	public void setLbid(String lbid) {
		this.lbid = lbid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}