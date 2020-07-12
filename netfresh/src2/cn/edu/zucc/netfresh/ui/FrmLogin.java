package cn.edu.zucc.netfresh.ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import cn.edu.zucc.netfresh.model.BeanUser;
import cn.edu.zucc.netfresh.ui.FrmRegister;
import cn.edu.zucc.netfresh.util.BaseException;
import cn.edu.zucc.netfresh.util.*;
	public class FrmLogin extends JDialog implements ActionListener {
		private JPanel toolBar = new JPanel();
		private JPanel workPane = new JPanel();
		
		private JButton btnLogin = new JButton("登陆");
		private JButton btnCancel = new JButton("退出");
		private JButton btnRegister = new JButton("注册");
		
		private JLabel labelUser = new JLabel("用户：");
		private JLabel labelPwd = new JLabel("密码：");
		
		private JTextField edtUserId = new JTextField(20);
		private JPasswordField edtPwd = new JPasswordField(20);

		private JRadioButton JrManager = new JRadioButton("管理员");
		private JRadioButton JrUser = new JRadioButton("用户",true);

		private String AcconutType = "用户";
		public FrmLogin(Frame f, String s, boolean b) {
			super(f, s, b);
			
			toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
			toolBar.add(this.btnRegister);
			toolBar.add(btnLogin);
			toolBar.add(btnCancel);
			
			this.getContentPane().add(toolBar, BorderLayout.SOUTH);
			
			workPane.add(labelUser);
			workPane.add(edtUserId);
			workPane.add(labelPwd);
			workPane.add(edtPwd);
			
			this.getContentPane().add(workPane, BorderLayout.CENTER);
			this.setSize(320, 140);
			// 屏幕居中显示
			double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
			this.setLocation((int) (width - this.getWidth()) / 2,
					(int) (height - this.getHeight()) / 2);

			this.validate();

			btnLogin.addActionListener(this);
			btnCancel.addActionListener(this);
			this.btnRegister.addActionListener(this);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.JrUser){	
				this.AcconutType = "用户";
			}
			else if(e.getSource()==this.JrManager) { 
				this.AcconutType = "管理员";
			}			
			else if (e.getSource() == this.btnCancel) {
				System.exit(0);
			}
			else if(e.getSource() == this.btnLogin) {
				String loginId = this.edtUserId.getText();
				String loginPwd =new String(this.edtPwd.getPassword());
				try {
					if(this.AcconutType.equals("用户")) {
						
					}
					else if(this.AcconutType.equals("管理员")) {
						
					}
					else {
						throw new BusinessException("故障");
					}
				} catch (BaseException e1) {
	                JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
	            }
			}
			else if(e.getSource()==this.btnRegister){
					FrmRegister dlg=new FrmRegister(this,"注册",true);
					dlg.setVisible(true);
			}
		}

}
