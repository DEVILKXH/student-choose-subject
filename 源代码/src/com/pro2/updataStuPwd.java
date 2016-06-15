package com.pro2;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class updataStuPwd extends JDialog implements ActionListener{
	JLabel jbl1,jbl2;
	JTextField jtf1;
	JPasswordField jpf;
	JButton jb1,jb2;
	
	JPanel jp1,jp2,jp3;

	
	//Frame 他的父窗口
	//title 窗口名字
	//model 模式窗口还是非模式窗口
	public updataStuPwd(Frame owner,String title,boolean modal,RootModel rm,int rowNums){
		super(owner,title,modal);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();

		jbl1=new JLabel("姓名* 　");
		jbl2=new JLabel("新密码*");

		jtf1=new JTextField(20);
		jtf1.setText((String)rm.getValueAt(rowNums,0));
		jtf1.setEditable(false);
		jpf=new JPasswordField(20);
		
		jb1=new JButton("确定");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);

		jp1.add(jbl1);
		jp1.add(jtf1);

		jp2.add(jbl2);
		jp2.add(jpf);
		
		jp3.add(jb1);
		jp3.add(jb2);

		this.setLayout(new GridLayout(3,1));
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setSize(300,120);
		this.setLocation(400,150);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			
			char[] jpfp=jpf.getPassword();
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<jpfp.length;i++){
				sb.append(jpfp[i]);
			}
			String Jpf=sb.toString();
			RootModel temp=new RootModel();
			String sql="update student set 密码=? where 学号=?";
			String[] paras={Jpf,jtf1.getText()};
			if(temp.updateStu(sql, paras)!=true){
				JOptionPane.showMessageDialog(this,"修改失败");
			}else{
				JOptionPane.showMessageDialog(this,"修改成功");
			}
			this.dispose();
		}else{
			this.dispose();
		}
	}
}
