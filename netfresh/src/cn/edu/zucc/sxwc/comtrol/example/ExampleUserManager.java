package cn.edu.zucc.sxwc.comtrol.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.sxwc.model.BeanUser;
import cn.edu.zucc.sxwc.util.BaseException;
import cn.edu.zucc.sxwc.util.BusinessException;
import cn.edu.zucc.sxwc.util.DBUtil;
import cn.edu.zucc.sxwc.util.DbException;

public class ExampleUserManager {
	
	public BeanUser login(String userid, String passwd) throws BaseException{
		// TODO Auto-generated method stub
				Connection conn=null;
				try {
					conn=DBUtil.getConnection();
					String sql="select * from `user` where userid="+userid;
					java.sql.PreparedStatement pst=conn.prepareStatement(sql);
					java.sql.ResultSet rs=pst.executeQuery();
					if(!rs.next()) throw new BusinessException("登录账号不存在");
					BeanUser u=new BeanUser();
					u.setUserid(rs.getString("userid"));
					u.setUsername(rs.getString("username"));
					u.setSex(rs.getString("sex"));
					u.setPasswd(rs.getString("password"));
					u.setPhonenum(rs.getString("phone"));
					u.setMail(rs.getString("email"));
					u.setCity(rs.getString("city"));
					u.setRegtime(rs.getDate("registertime"));
					u.setIsvip(rs.getString("isvip"));
					u.setVipenddate(rs.getDate("vipenddate"));
					if(!(passwd).equals(u.getPasswd())){
						throw new BusinessException("密码错误");
					}
					rs.close();
					pst.close();
					return u;
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

	public BeanUser reg(String userid, String username,String passwd1, String passwd2,String sex,String phonenum,String email,String city)throws BaseException {//注册
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if(userid==null || "".equals(userid) || userid.length()>12||userid.length()<6){
					throw new BusinessException("注册账号必须是6-12个字");
				}
				if(passwd1==null || "".equals(passwd1)){
					throw new BusinessException("密码不能为空");
				}
				if(!passwd1.equals(passwd2)){
					throw new BusinessException("两个输入的密码不一致");
				}

				Connection conn=null;
				try {
					conn=DBUtil.getConnection();
					//检查用户是否存在
					String sql="select * from `user` where userid="+userid;
					java.sql.PreparedStatement pst=conn.prepareStatement(sql);
					java.sql.ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						throw new BusinessException("账号已经存在");
					}
					rs.close();
					pst.close();
					sql="insert into `user`(userid,username,sex,password,phone,email,city,registertime,isvip) value(?,?,?,?,?,?,?,?,?)";
					pst=conn.prepareStatement(sql);
					pst.setString(1, userid);
					pst.setString(2, username);
					pst.setString(3, sex);
					pst.setString(4, passwd1);
					pst.setString(5, phonenum);
					pst.setString(6, email);
					pst.setDate(8, new Date(new java.util.Date().getTime()));
					pst.setString(7, city);
					pst.setString(9, "否");
					BeanUser u=new BeanUser();
					u.setUserid(userid);
					u.setUsername(username);
					u.setSex(sex);
					u.setPasswd(passwd1);
					u.setPhonenum(phonenum);
					u.setMail(email);
					u.setCity(city);
					u.setRegtime(new Date(System.currentTimeMillis()));
					u.setIsvip("否");
					pst.execute();
					pst.close();
					return u;
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

	public void changePwd(BeanUser user, String oldPwd, String newPwd, String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		if(oldPwd==null||"".equals(oldPwd)) throw new BusinessException("原始密码不能为空");
		if(newPwd==null || "".equals(newPwd) ) throw new BusinessException("新密码不能为空");
		if(!newPwd.equals(newPwd2)) throw new BusinessException("新密码两次输入不同");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select passwd from userinformation where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,BeanUser.currentLoginUser.getUserid());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("登陆账号不 存在");
			if(!BeanUser.currentLoginUser.getPasswd().equals(oldPwd)) throw new BusinessException("原始密码错误");
			rs.close();
			pst.close();
			sql="update userinformation set passwd=? where userid=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, user.getUserid());
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
	public List<BeanUser> loadUser()throws BaseException{
		List<BeanUser> result=new ArrayList<BeanUser>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select userid,username,sex,passwd,phonenum,mail,city,regtime,isvip,vipenddate from userinformation order by userid";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				BeanUser u=new BeanUser();
				u.setUserid(rs.getString(1));
				u.setUsername(rs.getString(2));
				u.setSex(rs.getString(3));
				u.setPasswd(rs.getString(4));
				u.setPhonenum(rs.getString(5));
				u.setMail(rs.getString(6));
				u.setCity(rs.getString(7));
				u.setRegtime(rs.getDate(8));
				u.setIsvip(rs.getString(9));
				u.setVipenddate(rs.getDate(10));
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
	public BeanUser loadUser1()throws BaseException{
		BeanUser u=new BeanUser();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select userid,username,sex,passwd,phonenum,mail,city,regtime,isvip,vipenddate from userinformation order by userid";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			if(rs.next()){
				
				u.setUserid(rs.getString(1));
				u.setUsername(rs.getString(2));
				u.setSex(rs.getString(3));
				u.setPasswd(rs.getString(4));
				u.setPhonenum(rs.getString(5));
				u.setMail(rs.getString(6));
				u.setCity(rs.getString(7));
				u.setRegtime(rs.getDate(8));
				u.setIsvip(rs.getString(9));
				u.setVipenddate(rs.getDate(10));
				
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
		return u;
	}
	public void upvip()throws BaseException{
		Connection conn=null;
		if (BeanUser.currentLoginUser.getIsvip()=="是") {
			throw new BusinessException("已经是会员");
		}
		try {
			conn=DBUtil.getConnection();
			String sql="update `user` set isvip=?,vipenddate=? where userid=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, "是");
			pst.setDate(2, new java.sql.Date(System.currentTimeMillis()+2592000000L));
			pst.setString(3, BeanUser.currentLoginUser.getUserid());
			BeanUser.currentLoginUser.setIsvip("是");
			pst.execute();
		
			
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
}
	


