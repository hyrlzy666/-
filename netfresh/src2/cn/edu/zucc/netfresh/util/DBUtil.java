package cn.edu.zucc.netfresh.util;

import java.sql.Connection;

public class DBUtil {
	private static final String jdbcUrl="jdbc:mysql://localhost:3306/netfresh1";
	private static final String dbUser="root";
	private static final String dbPwd="123456";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws java.sql.SQLException{
		Connection conn= java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
		System.out.println(conn);
		return conn;
	}
}
