package cn.edu.zucc.netfresh.comtrol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.netfresh.model.BeanAdmin;
import cn.edu.zucc.netfresh.model.BeanFreshCategory;
import cn.edu.zucc.netfresh.util.BaseException;
import cn.edu.zucc.netfresh.util.BusinessException;
import cn.edu.zucc.netfresh.util.DBUtil;

public class FreshCategoryManage {
	public void addFreshCategory(String categoryId)throws BusinessException{
		if("".equals(categoryId)) {
			throw new BusinessException("账户不能为空");
		}
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql ="select * from  where  = ?"//
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, categoryId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				
			}
			rs.close();
			pst.close();
			sql = "insert int  valuses()"//
			pst = conn.prepareStatement(sql);
			pst.setInt(1, insert);
		}catch(SQLException throwables ) {
			throwables.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void deleteFreshCategory(BeanFreshCategory BFC)throw BusinessException{
		
	}
	public List<BeanFreshCategory> loadFreshCategory() throws BaseException{
		Connection conn = null;
		List<BeanFreshCategory> res =new ArrayList<BeanFreshCategory>();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from "
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				BeanFreshCategory BFC =new BeanFreshCategory();
				BFC.setCategoryId(rs.getString(1));
				BFC.setCategortNum(rs.getInt(2));
				BFC.setCategoryName(rs.getString(3));
				BFC.setCategoryDesc(rs.getString(4));
			}
		}catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
		
	}
	
}
