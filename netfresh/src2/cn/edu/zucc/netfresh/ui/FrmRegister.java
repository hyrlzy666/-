package cn.edu.zucc.netfresh.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FrmRegister extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();	
	
	private Button btnCancel = new Button("取消");
	private Button btnFinish = new Button("完成");
		
	private JLabel labelUser = new JLabel("用户名：");
	private JLabel labelPwd = new JLabel("密码：");
	private JLabel labelPwd2 = new JLabel("确认密码：");
	private JLabel labelSex = new JLabel("性别");
	private JLabel labelPhone = new JLabel("电话号码");
	private JLabel labelCity = new JLabel("所在城市");
	private JLabel labelEmial = new JLabel("邮箱：");
	private JLabel labelName = new JLabel("姓名：");
	
	private JRadioButton RBB = new JRadioButton("男");
	private JRadioButton RBG = new JRadioButton("女");
	
	private JTextField editUser = new JTextField(20);
	private JTextField editname = new JTextField(20);
	private JTextField editEmail = new JTextField(20);
	private JTextField editCity = new JTextField(20);
	private JTextField editPhone = new JTextField(20);

	private JPasswordField editPwd= new JPasswordField(20);
	private JPasswordField editPwd2= new JPasswordField(20);
	
	public FrmRegister(Dialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnFinish);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelUser);
		workPane.add(editUser);
		workPane.add(labelPwd);
		workPane.add(editPwd);
		workPane.add(labelPwd2);
		workPane.add(editPwd2);
		
		//
		
		
		
		
		
		
		
		
		//
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(300, 180);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setLocation((int) (width - this.getWidth()) / 2,
                (int) (height - this.getHeight()) / 2);

        this.validate();
		btnCancel.addActionListener(this);
		btnFinish.addActionListener(this);
		RBB.addActionListener(this);
		RBG.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnFinish){
			String userid=this.editUser.getText();
			String pwd1=new String(this.editPwd.getPassword());
			String pwd2=new String(this.editPwd2.getPassword());
			String 
			try {
				BeanUser user=PersonPlanUtil.userManager.reg(userid,pwd1,pwd2);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
	
	
	
}
