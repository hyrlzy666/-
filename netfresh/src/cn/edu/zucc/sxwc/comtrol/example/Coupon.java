package cn.edu.zucc.sxwc.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.sxwc.model.BeanCoupon;
import cn.edu.zucc.sxwc.model.BeanManager;
import cn.edu.zucc.sxwc.model.BeanUser;
import cn.edu.zucc.sxwc.util.BaseException;
import cn.edu.zucc.sxwc.util.DBUtil;
import cn.edu.zucc.sxwc.util.DbException;

public class Coupon {

	public List<BeanCoupon> loadCp() throws BaseException{
		// TODO Auto-generated method stub
		List<BeanCoupon> result=new ArrayList<BeanCoupon>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select `id`,`describe`,`symoney`,`jmmoney`,`startdate`,`enddate` from coupon where userid =? order by `id`";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,BeanUser.currentLoginUser.getUserid());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				BeanCoupon u=new BeanCoupon();
				u.setCouponid(rs.getString(1));
				u.setCoucontent(rs.getString(2));
				u.setSymoney(rs.getFloat(3));
				u.setJmmoney(rs.getFloat(4));
				u.setBedate(rs.getDate(5));
				u.setEnddate(rs.getDate(6));
				result.add(u);
			}
		} catch (SQLException e) {
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
	public List<BeanCoupon> loadCp1() throws BaseException{
		// TODO Auto-generated method stub
		List<BeanCoupon> result=new ArrayList<BeanCoupon>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select `id`,`describe`,symoney,jmmoney,startdate,enddate,userid from coupon order by `id`";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			//pst.setString(1,BeanManager.currentLoginManager.getEmployeeid());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				BeanCoupon u=new BeanCoupon();
				u.setCouponid(rs.getString(1));
				u.setCoucontent(rs.getString(2));
				u.setSymoney(rs.getFloat(3));
				u.setJmmoney(rs.getFloat(4));
				u.setBedate(rs.getDate(5));
				u.setEnddate(rs.getDate(6));
				u.setUserid(rs.getString(7));
				result.add(u);
			}
		} catch (SQLException e) {
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
