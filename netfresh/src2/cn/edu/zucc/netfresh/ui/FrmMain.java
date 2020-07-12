package cn.edu.zucc.netfresh.ui;
import java.awt.event.*;

import javax.swing.*;
import cn.edu.zucc.netfresh.ui.FrmLogin;
import cn.edu.zucc.netfresh.util.SystemUtil;

public class FrmMain extends JFrame implements ActionListener{
	private JPanel mainPanel = new JPanel();
	private JPanel orderPanel = new JPanel();

	
	private JMenu Admin = new JMenu("管理员维护");
	private JMenuItem FreshManage =new JMenuItem("生鲜类别管理");
	private JMenuItem CommodityManage =new JMenuItem("商品管理");
	private JMenuItem MenuManage =new JMenuItem("菜谱管理");
	private JMenuItem DisManage =new JMenuItem("优惠券管理");
	
	
	
	public FrmMain() {
        this.setExtendedState(FrmMain.MAXIMIZED_BOTH);
        this.setTitle("生鲜网超");
        if(SystemUtil.currentLoginType.equals("管理员")) {
        	
        }else {
        	
        }
        	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
