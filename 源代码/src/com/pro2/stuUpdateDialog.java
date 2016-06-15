/**
 * 修改学生信息 
 */

package com.pro2;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class stuUpdateDialog extends JDialog implements ActionListener{
	JLabel jbl1,jbl2,jbl3,jbl4,jbl5,jbl6;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPasswordField jpf;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8;
	
	//Frame 他的父窗口
	//title 窗口名字
	//model 模式窗口还是非模式窗口
	public stuUpdateDialog(Frame owner,String title,boolean modal,RootModel rm,int rowNums){
		super(owner,title,modal);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jp6=new JPanel();
		jp7=new JPanel();
		jp8=new JPanel();

		jbl1=new JLabel("　　学号*");
		jbl2=new JLabel("　　姓名*");
		jbl3=new JLabel("　　年龄*");
		jbl4=new JLabel("　宿舍号*");
		jbl5=new JLabel("政治面貌*");
		jbl6=new JLabel("　　学院*");

		jtf1=new JTextField(20);
		jtf1.setText((String)rm.getValueAt(rowNums,0));
		jtf1.setEditable(false);
		jtf2=new JTextField(20);
		jtf2.setText((String)rm.getValueAt(rowNums,1));
		jtf3=new JTextField(20);
		jtf3.setText((String)rm.getValueAt(rowNums,2));
		jtf4=new JTextField(20);
		jtf4.setText(rm.getValueAt(rowNums,7).toString());
		jtf5=new JTextField(20);
		jtf5.setText(rm.getValueAt(rowNums,8).toString());
		jtf6=new JTextField(20);
		jtf6.setText(rm.getValueAt(rowNums,10).toString());

		jb1=new JButton("修改");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);

		jp1.add(jbl1);
		jp1.add(jtf1);

		jp2.add(jbl2);
		jp2.add(jtf2);
		
		jp3.add(jbl3);
		jp3.add(jtf3);
		
		jp4.add(jbl4);
		jp4.add(jtf4);

		jp5.add(jbl5);
		jp5.add(jtf5);
		
		jp6.add(jbl6);
		jp6.add(jtf6);
		
		jp7.add(jb1);
		jp7.add(jb2);

		this.setLayout(new GridLayout(7,1));
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		this.add(jp7);
		
		this.setSize(300,240);
		this.setLocation(400,150);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			if(jtf2.getText().length()!=0 && jtf3.getText().length()!=0 && jtf4.getText().length()!=0){
				
				String sql="update student set 姓名=?,年龄=?,宿舍号=?,政治面貌=?,学院=? where 学号=?";
				String[] paras={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf1.getText()};		
				
				RootModel temp=new RootModel();
				temp.updateStu(sql,paras);
				this.dispose();
			}else{
				if(jtf2.getText().length()==0){
					JOptionPane.showMessageDialog(this,"姓名不能为空");
				}else if(jtf3.getText().length()==0){
					JOptionPane.showMessageDialog(this,"年龄不能为空");
				}else if(jtf4.getText().length()==0){
					JOptionPane.showMessageDialog(this,"宿舍号不能为空");
				}else if(jtf5.getText().length()==0){
					JOptionPane.showMessageDialog(this,"政治面貌不能为空");
				}else{
					JOptionPane.showMessageDialog(this,"学院不能为空");
				}
			}
		}else{
			this.setVisible(false);
		}
	}
}

