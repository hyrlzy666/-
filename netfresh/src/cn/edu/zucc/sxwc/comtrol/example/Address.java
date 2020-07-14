package cn.edu.zucc.sxwc.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.edu.zucc.sxwc.model.BeanAddress;
import cn.edu.zucc.sxwc.model.BeanCoupon;
import cn.edu.zucc.sxwc.model.BeanManager;
import cn.edu.zucc.sxwc.model.BeanUser;
import cn.edu.zucc.sxwc.util.BaseException;
import cn.edu.zucc.sxwc.util.BusinessException;
import cn.edu.zucc.sxwc.util.DBUtil;
import cn.edu.zucc.sxwc.util.DbException;

/**
 * 地址控件
 */
public class Address {
	public List<BeanAddress> loadAddress() throws BaseException{
		// TODO Auto-generated method stub
		List<BeanAddress> result=new ArrayList<BeanAddress>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT\n" +
					"\t`id`,\n" +
					"\t`province`,\n" +
					"\t`city`,\n" +
					"\t`detailed` AS `address`,\n" +
					"\t`contacts`,\n" +
					"\t`phonenum` \n" +
					"FROM\n" +
					"\t(\n" +
					"SELECT\n" +
					"\tP.`name` AS `province`,\n" +
					"\tC.`name` AS `city` \n" +
					"FROM\n" +
					"\t( SELECT `id`, `name` FROM `province` WHERE id = 1 ) P\n" +
					"\tINNER JOIN `city` C ON C.province_id = P.id \n" +
					"WHERE\n" +
					"\tC.id = 1 \n" +
					"\t) M\n" +
					"\tINNER JOIN `address` A ON userid =?";

			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			if (BeanUser.currentLoginUser!=null)
			pst.setString(1,BeanUser.currentLoginUser.getUserid());
			else
				pst.setString(1, BeanManager.currentLoginManager.getEmployeeid());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				BeanAddress u=new BeanAddress();
				u.setAddid(rs.getString(1));
				if (BeanUser.currentLoginUser!=null)
					u.setUserid(BeanUser.currentLoginUser.getUserid());
				else
					u.setUserid( BeanManager.currentLoginManager.getEmployeeid());
				u.setProvince(rs.getString(2));
				u.setCity(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setContact(rs.getString(5));
				u.setPhonenum(rs.getString(6));
				
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

	public void deleteAdd(String addid, String userid) throws BaseException{
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from address where id=? and userid=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,addid);
			pst.setString(2, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("所选不 存在");
			//if(rs.getDate(1)!=null) throw new BusinessException("该账号已经被删除");
			rs.close();
			pst.close();
			
			sql="delete from address where id=? and userid=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, addid);
			pst.setString(2, userid);
			pst.execute();
			pst.close();
			
			
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
}

	public void createManager(BeanAddress ad) throws BaseException{
		// TODO Auto-generated method stub
		if(ad.getAddid()==null || "".equals(ad.getAddid()) || ad.getAddid().length()>50){
			throw new BusinessException("地址编号必须是1-50个字");
		}
		if(ad.getProvince()==null  ){
			throw new BusinessException("'省'不能为空");
		}
		if(ad.getCity()==null || "".equals(ad.getCity()) ){
			throw new BusinessException("'市'必须填写");
		}

		if(ad.getAddress()==null || "".equals(ad.getAddress()) ){
			throw new BusinessException("'地址'必须填写");
		}
		if(ad.getContact()==null || "".equals(ad.getContact()) ){
			throw new BusinessException("'联系人'必须填写");
		}
		if(ad.getPhonenum()==null || "".equals(ad.getPhonenum()) ){
			throw new BusinessException("'电话'必须填写");
		}
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from address where userid=? and id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,BeanUser.currentLoginUser.getUserid());
			pst.setString(2, ad.getAddid());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("你的地址编号已经存在");
			rs.close();
			pst.close();
			sql="insert into `address`(id,userid,province_id,city_id,detailed,contacts,phonenum) values(?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, ad.getAddid());
			pst.setString(2, BeanUser.currentLoginUser.getUserid());
			pst.setInt(3,Integer.valueOf(ad.getProvince()));
			pst.setInt(4,Integer.valueOf(ad.getCity()));
			pst.setString(5, ad.getAddress());
			pst.setString(6, ad.getContact());
			pst.setString(7, ad.getPhonenum());
			pst.execute();
			pst.close();
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
	}
	public static String[] getAllProvince(){
		Connection conn=null;
		String[] d=new String[34];
		try {
			conn=DBUtil.getConnection();
			String sql="select name from province";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();

			for (int i=0;rs.next();i++){
				d[i]=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}
	public static String[] getAllCity(int pro_id){
		Connection conn=null;
		List<String> list=new ArrayList<>();
		try {
			conn=DBUtil.getConnection();
			String sql="select name from `city` where province_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,pro_id);
			java.sql.ResultSet rs=pst.executeQuery();
			for (int i=0;rs.next();i++){
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
		String[] name=new String[list.size()];
		int index=0;
		for (String i:list){
			name[index++]=i;
		}
		return name;
	}
	public static int getOneProvince(String name){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select `id` from province where  name =?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			java.sql.ResultSet rs=pst.executeQuery();
			if (!rs.next())  throw new BusinessException("找不到地址");
			int anInt = rs.getInt(1);
			return anInt;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public static int getOneCity(String name){
		Connection conn=null;

		try {
			conn=DBUtil.getConnection();
			String sql="select `id` from `city` where  name =?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);

			pst.setString(1,name);
			java.sql.ResultSet rs=pst.executeQuery();
			if (!rs.next())  throw new BusinessException("找不到地址");
			int id = rs.getInt(1);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		return -1;
	}
}
