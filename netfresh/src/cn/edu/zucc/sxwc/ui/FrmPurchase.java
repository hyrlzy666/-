package cn.edu.zucc.sxwc.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.sxwc.model.BeanGoods;
import cn.edu.zucc.sxwc.model.BeanShoppingCart;

public class FrmPurchase extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Object tblTitle[]=BeanShoppingCart.CartTitles;
	private Object tblcartData[][];
	DefaultTableModel tabcartmod=new DefaultTableModel();
	private JTable carttable=new JTable(tabcartmod);
	List<BeanShoppingCart> allcart=null;
	private List<BeanGoods> goods;
	private BeanShoppingCart cart1=null;
	
	public FrmPurchase(JFrame f,String s,boolean b) {
		super(f,s,b);
		setTitle("已有商品");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 400, 217);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
