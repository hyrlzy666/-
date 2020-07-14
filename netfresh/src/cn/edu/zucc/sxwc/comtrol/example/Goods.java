package cn.edu.zucc.sxwc.comtrol.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.sxwc.model.BeanGoods;
import cn.edu.zucc.sxwc.model.BeanLb;
import cn.edu.zucc.sxwc.util.BaseException;
import cn.edu.zucc.sxwc.util.DBUtil;
import cn.edu.zucc.sxwc.util.DbException;

public class Goods {

	public void sddGoods(BeanGoods gs){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into goods(goodsid,lbid,goodsname,gprice,givpprice,gamount,guige,details) value(?,?,?,?,?,?,?,?)";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1,gs.getGoodsid());
			pr.setString(2,gs.getLbid());
			pr.setString(3,gs.getGoodsname());
			pr.setFloat(4,gs.getGprice());
			pr.setFloat(5,gs.getGvipprice());
			pr.setInt(6,gs.getGamount());
			pr.setString(7,gs.getGuige());
			pr.setString(8,gs.getDatails());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public List<BeanGoods> loadGoods(BeanLb lb) throws BaseException {
		List<BeanGoods> result=new ArrayList<BeanGoods>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from goods "
					+ "where lbid = ? order by goodsid";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, lb.getLbid());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				BeanGoods p=new BeanGoods();
				p.setGoodsid(rs.getString(1));
				p.setLbid(rs.getString(2));
				p.setGoodsname(rs.getString(3));
				p.setGprice(rs.getFloat(4));
				p.setGvipprice(rs.getFloat(5));
				p.setGamount(rs.getInt(6));
				p.setGuige(rs.getString(7));
				p.setDatails(rs.getString(8));
				result.add(p);
				}
			rs.close();
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
		
	}

	
}
