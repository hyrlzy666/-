package cn.edu.zucc.sxwc.ui;

import cn.edu.zucc.sxwc.comtrol.example.Address;
import cn.edu.zucc.sxwc.model.BeanAddress;
import cn.edu.zucc.sxwc.util.BaseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmdGoods_add extends JDialog implements ActionListener {


        private BeanAddress ad=null;
        private final JPanel contentPanel = new JPanel();
        private JTextField textField;
        private JTextField textField_3=new JTextField(60);
        private JTextField textField_4;
        private JTextField textField_5;
        private JTextField textField_6;
        private JTextField textField_7=new JTextField(60);
        private JButton okButton = new JButton("提交");
        private JButton cancelButton = new JButton("取消");
        private JComboBox Provine=new JComboBox(Address.getAllProvince());



	public FrmdGoods_add(FrmManagerMain f, String s, boolean b) {
            super(f,s,b);
            setTitle("配送地址");
            setBounds(100, 100, 526, 471);
            getContentPane().setLayout(null);
            contentPanel.setBounds(0, 0, 464, 318);
            contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            getContentPane().add(contentPanel);
            contentPanel.setLayout(null);
            {
                JLabel lblNewLabel = new JLabel("商品编号");
                lblNewLabel.setBounds(28, 13, 72, 18);
                contentPanel.add(lblNewLabel);
            }
        {
            JLabel lblNewLabel = new JLabel("组");
            lblNewLabel.setBounds(28, 55, 72, 18);
            contentPanel.add(lblNewLabel);
        }

        {
                JLabel lblNewLabel_1 = new JLabel("商品名:");
                lblNewLabel_1.setBounds(28, 95, 72, 18);
                contentPanel.add(lblNewLabel_1);
            }
            {
                JLabel lblNewLabel_2 = new JLabel("价格:");
                lblNewLabel_2.setBounds(28, 135, 72, 18);
                contentPanel.add(lblNewLabel_2);
            }

            {
                JLabel lblNewLabel_4 = new JLabel("会员价格");
                lblNewLabel_4.setBounds(28, 175, 72, 18);
                contentPanel.add(lblNewLabel_4);
            }
            {
                JLabel lblNewLabel_5 = new JLabel("数量:");
                lblNewLabel_5.setBounds(28, 215, 72, 18);
                contentPanel.add(lblNewLabel_5);
            }
            {
                JLabel lblNewLabel_6 = new JLabel("规格:");
                lblNewLabel_6.setBounds(28, 255, 72, 18);
                contentPanel.add(lblNewLabel_6);
            }
        {
            JLabel lblNewLabel_7= new JLabel("描述:");
            lblNewLabel_7.setBounds(28, 255, 72, 18);

            contentPanel.add(lblNewLabel_7);
        }
            textField = new JTextField();
            textField.setBounds(207, 10, 107, 24);
            contentPanel.add(textField);
            textField.setColumns(10);

            Provine.setBounds(207,52,100,24);
            contentPanel.add(Provine);


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

            // TODO Auto-generated method stub
            if(e.getSource()==this.cancelButton) {
                this.setVisible(false);
                return;
            }
            else if(e.getSource()==this.okButton) {
                String addid=this.textField.getText();

                String address=this.textField_4.getText();
                String contacts=this.textField_5.getText();
                String phonenum=this.textField_6.getText();

                ad=new BeanAddress();
                ad.setAddid(addid);
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



