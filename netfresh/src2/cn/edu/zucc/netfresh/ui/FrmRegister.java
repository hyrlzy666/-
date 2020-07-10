package cn.edu.zucc.netfresh.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FrmRegister extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();	
	
	private Button btnCancel = new Button("ȡ��");
	private Button btnFinish = new Button("���");
		
	private JLabel labelUser = new JLabel("�û�����");
	private JLabel labelPwd = new JLabel("���룺");
	private JLabel labelPwd2 = new JLabel("ȷ�����룺");
	private JLabel labelSex = new JLabel("�Ա�");
	private JLabel labelPhone = new JLabel("�绰����");
	private JLabel labelCity = new JLabel("���ڳ���");
	private JLabel labelEmial = new JLabel("���䣺");
	private JLabel labelName = new JLabel("������");
	
	private JRadioButton RBB = new JRadioButton("��");
	private JRadioButton RBG = new JRadioButton("Ů");
	
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
				JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
	
	
	
}
