package cn.edu.zucc.netfresh.ui;
import java.awt.event.*;

import javax.swing.*;
import cn.edu.zucc.netfresh.ui.FrmLogin;
import cn.edu.zucc.netfresh.util.SystemUtil;

public class FrmMain extends JFrame implements ActionListener{
	private JPanel mainPanel = new JPanel();
	private JPanel orderPanel = new JPanel();

	
	private JMenu Admin = new JMenu("����Աά��");
	private JMenuItem FreshManage =new JMenuItem("����������");
	private JMenuItem CommodityManage =new JMenuItem("��Ʒ����");
	private JMenuItem MenuManage =new JMenuItem("���׹���");
	private JMenuItem DisManage =new JMenuItem("�Ż�ȯ����");
	
	
	
	public FrmMain() {
        this.setExtendedState(FrmMain.MAXIMIZED_BOTH);
        this.setTitle("��������");
        if(SystemUtil.currentLoginType.equals("����Ա")) {
        	
        }else {
        	
        }
        	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
