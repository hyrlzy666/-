package cn.edu.zucc.netfresh.comtrol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zucc.netfresh.model.BeanCommodity;
import cn.edu.zucc.netfresh.util.BaseException;
import cn.edu.zucc.netfresh.util.BusinessException;
import cn.edu.zucc.netfresh.util.DBUtil;
public class commodity {
	public void addcommodity(BeanCommodity BC)throws BusinessException{
		Connection conn =null;
		try{
			conn = DBUtil.getConnection();
			String sql ="";//
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, BC.getCommodityName());
			
		} catch (SQLException  throwables) {
            throwables.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
	}
	public void deleteCommodity (BeanCommodity BC)throws BusinessException{
		Connection conn =null;
		try {
			conn = DBUtil.getConnection();
			String sql;
			
		}
	}
}
