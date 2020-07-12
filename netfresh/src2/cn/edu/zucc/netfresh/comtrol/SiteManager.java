package cn.edu.zucc.netfresh.comtrol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import cn.edu.zucc.netfresh.model.BeanSite;
import cn.edu.zucc.netfresh.util.BaseException;
import cn.edu.zucc.netfresh.util.BusinessException;
import cn.edu.zucc.netfresh.util.DBUtil;
public class SiteManager {
	public void AddSite(BeanSite Bs1)throws BusinessException{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql =;
		    PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1)
		}catch (SQLException throwables) {
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
	public void DeleteSite(BeanSite Bs2)throws BusinessException{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
		}catch (SQLException throwables) {
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
	public List<BeanSite> loadSite(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
		}catch (SQLException throwables) {
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
	}



}
