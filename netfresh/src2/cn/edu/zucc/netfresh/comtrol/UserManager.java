package cn.edu.zucc.netfresh.comtrol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zucc.netfresh.model.BeanUser;
import cn.edu.zucc.netfresh.util.BaseException;
import cn.edu.zucc.netfresh.util.BusinessException;
import cn.edu.zucc.netfresh.util.DBUtil;
public class UserManager {
	public BeanUsers register(String userName,String userPwd,
			String userPwd2,Boolean userSex,String userPhone,
			String siteCity,String userEmail)throws BusinessException{
		if(userId.length()<=0||userId.length() >= 20) {
			throw new BusinessException("�˺Ÿ�ʽ����!");
		}
		if(userPwd.length()<=0||userPwd.length()>=20) {
			throw new BusinessException("�����ʽ����!");
		}
		if(!userPwd.equals(userPwd2)) {
			throw new BusinessException("������������ͬ����!");
		}
		Connection conn =null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from users where = ? "
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				throw new BusinessException("")
			}
			rs.close();
			pst.close();
			int
		}catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


        return null;
	}
	public BeanUser login (String userName,String userPwd)throws BusinessException{
			if(userName.length()<=0||userName.length()>=20) {
				throw new BusinessException("�˺Ÿ�ʽ����!");
			}
		
			Connection conn = null;
			try {
				conn = DBUtil.getConnection();
				String sql ="select from user where = ?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1,userName);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					if(rs.getString(1).equals(userPwd)) {
						rs.close();
						pst.close();
						BeanUser res = new BeanUsers();
						res.setUserName(userName);
						return res;
					}
					else {
						throw new BusinessException("�����������!");
					}
				}else {
					throw new BusinessException("δ�ҵ����û�!");
				}
			}catch (SQLException throwables) {
	            throwables.printStackTrace();
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }
		return null;
	}
}