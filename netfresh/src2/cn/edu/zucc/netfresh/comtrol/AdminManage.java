package cn.edu.zucc.netfresh.comtrol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zucc.netfresh.model.BeanAdmin;
import cn.edu.zucc.netfresh.util.BaseException;
import cn.edu.zucc.netfresh.util.BusinessException;
import cn.edu.zucc.netfresh.util.DBUtil;

public class AdminManage {
	public BeanAdmin login(String adminID, String adminPwd)throws BaseException{
		if(adminID.length()<=0||adminID.length()>=20) {
			throw new BusinessException("��������ȷ��ʽ���˺�");
		}
		if(adminPwd.length()<=0||adminPwd.length()>=20) {
			throw new BusinessException("��������ȷ��ʽ������");
		}
		Connection conn =null;
		try {
			conn = DBUtil.getConnection();
			String sql ="select from admin where =?";//
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, adminID);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(adminPwd)) {
					BeanAdmin fin = new BeanAdmin();
					fin.setAdminID(adminID);
					return fin;
				}
				else {
					throw new BusinessException("�������!");
				}	
			}else {
				throw new BusinessException("δ�ҵ����˻�");
			}
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return null;
	}
}
