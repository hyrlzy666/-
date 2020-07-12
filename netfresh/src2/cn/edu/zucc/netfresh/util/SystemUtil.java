package cn.edu.zucc.netfresh.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import cn.edu.zucc.netfresh.model.BeanAdmin;
import cn.edu.zucc.netfresh.model.BeanUser;
public class SystemUtil {
	public static String currentLoginType = "";
	public static BeanAdmin currentAdmin = null;
	public static BeanUser currentUser = null;
	public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
}
