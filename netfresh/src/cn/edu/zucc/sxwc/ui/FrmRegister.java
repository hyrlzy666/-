package cn.edu.zucc.sxwc.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.sxwc.comtrol.example.ExampleUserManager;
import cn.edu.zucc.sxwc.model.BeanUser;
import cn.edu.zucc.sxwc.util.BaseException;

public class FrmRegister extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField edtUserId = new JTextField(50);
	private JPasswordField edtPwd = new JPasswordField(50);
	private JPasswordField edtPwd2 = new JPasswordField(50);
	private JPanel buttonPane = new JPanel();
	private JButton okButton = new JButton("注册");
	private JButton cancelButton = new JButton("取消");
	private JTextField edtname = new JTextField(20);
	private JTextField edtphonenum=new JTextField(50);
	private JTextField edtmail=new JTextField(50);
	private JTextField edtcity=new JTextField(50);
	private String[] sexs={"男","女","保密"};
	private JComboBox NewRadio=new JComboBox(sexs);
	/**注册
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmRegister dialog = new FrmRegister();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmRegister() {
		this.setModal(true);
		setBounds(100, 100, 556, 552);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号:");
		lblNewLabel.setBounds(40, 46, 72, 18);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("姓名");
		lblNewLabel_3.setBounds(40, 86, 150, 18);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_7 = new JLabel("性别:");
		lblNewLabel_7.setBounds(40, 120, 72, 18);
		contentPanel.add(lblNewLabel_7);

		JLabel lblNewLabel_1 = new JLabel("密码:");
		lblNewLabel_1.setBounds(40, 160, 72, 18);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("重复密码:");
		lblNewLabel_2.setBounds(40, 200, 72, 18);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("手机号码");
		lblNewLabel_4.setBounds(40, 240, 72, 18);
		contentPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("邮箱");
		lblNewLabel_5.setBounds(40, 290, 72, 18);
		contentPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("所在城市");
		lblNewLabel_6.setBounds(40, 330, 72, 18);
		contentPanel.add(lblNewLabel_6);

		edtUserId.setBounds(188, 42, 180, 24);
		contentPanel.add(edtUserId);
		edtUserId.setColumns(10);

		edtname.setBounds(188, 82, 180, 24);
		contentPanel.add(edtname);
		edtname.setColumns(10);
		NewRadio.setBounds(188,122,120,24);
		contentPanel.add(NewRadio);

		edtPwd.setBounds(188, 162, 180, 24);
		contentPanel.add(edtPwd);

		edtPwd2.setBounds(188, 202, 180, 24);
		contentPanel.add(edtPwd2);

		edtphonenum = new JTextField();
		edtphonenum.setBounds(188, 242, 180, 24);
		contentPanel.add(edtphonenum);
		edtphonenum.setColumns(10);
		
		edtmail = new JTextField();
		edtmail.setBounds(188, 292, 180, 24);
		contentPanel.add(edtmail);
		edtmail.setColumns(10);
		
		edtcity = new JTextField();
		edtcity.setBounds(188, 332, 180, 24);
		contentPanel.add(edtcity);
		edtcity.setColumns(10);
		{
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.cancelButton.addActionListener(this);
		this.okButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.cancelButton)
			this.setVisible(false);
		else if(e.getSource()==this.okButton){
			String userid=this.edtUserId.getText();
			String username=this.edtname.getText();
			String passwd1=new String(this.edtPwd.getPassword());
			String passwd2=new String(this.edtPwd2.getPassword());
			String phonenum=this.edtphonenum.getText();
			String  sex= (String) this.NewRadio.getSelectedItem();
			String mail=this.edtmail.getText();
			String city=this.edtcity.getText();
			ExampleUserManager userManager = new ExampleUserManager();
			try {
				BeanUser user=userManager.reg(userid,username,passwd1, passwd2,sex,phonenum,mail,city);
				this.setVisible(false);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				return;
			}

			
			
		}
	}
}
