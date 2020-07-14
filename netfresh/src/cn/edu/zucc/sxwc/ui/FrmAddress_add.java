package cn.edu.zucc.sxwc.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.sxwc.comtrol.example.Address;
import cn.edu.zucc.sxwc.comtrol.example.ExampleEmployeeManager;
import cn.edu.zucc.sxwc.model.BeanAddress;
import cn.edu.zucc.sxwc.model.BeanManager;
import cn.edu.zucc.sxwc.util.BaseException;

public class FrmAddress_add extends JDialog implements ActionListener{
	private BeanAddress ad=null;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField=new JTextField(60);
	private JTextField textField_3=new JTextField(60);
	private JTextField textField_4=new JTextField(60);
	private JTextField textField_5=new JTextField(60);
	private JTextField textField_6=new JTextField(60);
	private JButton okButton = new JButton("确定");
	private JButton cancelButton = new JButton("取消");
	private JComboBox Provine=new JComboBox(Address.getAllProvince());
	private  int index=1;
	private  String[] name={"北京市"};
	private JComboBox NewRadio=new JComboBox(name);


	public FrmAddress_add(JDialog f, String s, boolean b) {
		super(f,s,b);
		setTitle("配送地址");
		setBounds(100, 100, 526, 471);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 464, 318);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("地址编号");
			lblNewLabel.setBounds(28, 13, 72, 18);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("省");
			lblNewLabel_1.setBounds(28, 55, 72, 18);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("市");
			lblNewLabel_2.setBounds(28, 95, 72, 18);
			contentPanel.add(lblNewLabel_2);
		}

		{
			JLabel lblNewLabel_4 = new JLabel("地址");
			lblNewLabel_4.setBounds(28, 135, 72, 18);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("联系人");
			lblNewLabel_5.setBounds(28, 175, 72, 18);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("电话");
			lblNewLabel_6.setBounds(28, 215, 72, 18);
			contentPanel.add(lblNewLabel_6);
		}
		
		textField = new JTextField();
		textField.setBounds(207, 10, 107, 24);
		contentPanel.add(textField);
		textField.setColumns(10);

		Provine.setBounds(207,52,100,24);
		contentPanel.add(Provine);


		NewRadio.setBounds(207,95,100,24);
		contentPanel.add(NewRadio);


		textField_4 = new JTextField();
		textField_4.setBounds(207, 138, 107, 24);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(207, 178, 107, 24);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(207, 218, 107, 24);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(31, 375, 471, 37);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.cancelButton.addActionListener(this);
		this.okButton.addActionListener(this);
		this.Provine.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.Provine){
			String name= (String) this.Provine.getSelectedItem();
			this.index=Address.getOneProvince(name);
			this.name=Address.getAllCity(index);
			this.NewRadio=new JComboBox(this.name);
			contentPanel.add(this.NewRadio);
			return;
		}
		// TODO Auto-generated method stub
		if(e.getSource()==this.cancelButton) {
			this.setVisible(false);
			return;
		}
		else if(e.getSource()==this.okButton) {
			String addid=this.textField.getText();
			String province=index+"";

			String city=Address.getOneCity((String)NewRadio.getSelectedItem())+"";

			String address=this.textField_4.getText();
			String contacts=this.textField_5.getText();
			String phonenum=this.textField_6.getText();
			
			ad=new BeanAddress();
			ad.setAddid(addid);
			ad.setProvince(province);
			ad.setCity(city);
			ad.setAddress(address);
			ad.setContact(contacts);
			ad.setPhonenum(phonenum);
			
			try {
				(new Address()).createManager(ad);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.ad=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public BeanAddress getaddress(){
		return ad;
	}
}
