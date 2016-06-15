/**
 * 功能：登陆界面
 */
package com.pro2;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogIn extends JFrame implements ActionListener{
	
	JPanel jp1,jp2,jp3,jp4,jp5;//面板
	JLabel jbl1,jbl2,jbl3;//标签
	JTextField jtf;//文本框
	JPasswordField jpf;//密码框
	JButton jb1,jb2;
	//JTable JScrollPane;
	JRadioButton jrb1,jrb2,jrb3,jrb;//单选
	ButtonGroup bg;//按钮组
	
	JOptionPane jop;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogIn login=new LogIn();
	}
	public LogIn(){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		

		jbl1=new JLabel("学生选课管理系统");
		jbl1.setFont(new Font("楷体",Font.BOLD,30));
		jbl1.setForeground(Color.BLUE);
		jbl2=new JLabel("用户名");
		jbl2.setFont(new Font("楷体",Font.BOLD,15));
		jbl2.setForeground(Color.BLUE);
		jbl3=new JLabel("密码　");
		jbl3.setFont(new Font("楷体",Font.BOLD,15));
		jbl3.setForeground(Color.BLUE);
		jb1=new JButton("login");
		jb1.setForeground(Color.BLUE);
		jb2=new JButton("cancel");
		jb2.setForeground(Color.BLUE);
		jtf=new JTextField(15);
		jpf=new JPasswordField(15);
		jrb1=new JRadioButton("超级管理员");
		jrb1.setFont(new Font("楷体",Font.BOLD,15));
		jrb1.setForeground(Color.BLUE);
		jrb2=new JRadioButton("教师");
		jrb2.setFont(new Font("楷体",Font.BOLD,15));
		jrb2.setForeground(Color.BLUE);
		jrb3=new JRadioButton("学生");
		jrb3.setFont(new Font("楷体",Font.BOLD,15));
		jrb3.setForeground(Color.BLUE);
		
		bg=new ButtonGroup();
		bg.add(jrb1);
		jrb1.setSelected(true);
		bg.add(jrb2);
		bg.add(jrb3);
		
		this.setLayout(new GridLayout(5,1));
		jp1.add(jbl1);
		
		
		jp2.add(jbl2);
		jp2.add(jtf);
		
		jp3.add(jbl3);
		jp3.add(jpf);
		
		jp4.add(jrb1);
		jp4.add(jrb2);
		jp4.add(jrb3);
		
		jp5.add(jb1);
		jp5.add(jb2);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		
		this.setBackground(Color.gray);
		this.setTitle("欢迎进入学生选课系统");
		//this.setIconImage((new ImageIcon("images/xiuxiu.jpg")).getImage());
		this.setSize(400,250);
		this.setLocation(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		jb1.addActionListener(this);//事件监听
		jb1.setActionCommand("login");//命令
		jb2.addActionListener(this);
		jb2.setActionCommand("close");		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getActionCommand().equals("close")){
			System.exit(0);
		}else{
			if(jrb1.isSelected()==true){
				jrb=jrb1;
			}else if(jrb2.isSelected()==true){
				jrb=jrb2;
			}else if(jrb3.isSelected()==true){
				jrb=jrb3;
			}else{
				jrb=null;
			}
			
			if(jtf.getText().length()!=0 && jpf.getPassword().length!=0 && jrb!=null){
				char[] jpfp=jpf.getPassword();
				StringBuffer sb=new StringBuffer();
				for(int i=0;i<jpfp.length;i++){
					sb.append(jpfp[i]);
				}
				String Jpf=sb.toString();
				String JRB=jrb.getText();
				String JDriver= "com.microsoft.sqlserver.jdbc.SQLServerDriver";//加载驱动
				String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pro2";//数据库路径
				String user="root";//账号
				String password="root";//密码
				try{
					Class.forName(JDriver);
				}catch (ClassNotFoundException e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog( null , "数据库连接错误" ,"提示" , JOptionPane.ERROR_MESSAGE);
				}
				
				try {
					Connection con=DriverManager.getConnection(connectDB,user,password);
					Statement stmt=con.createStatement();
					ResultSet rs=null;
					if(JRB.equals("超级管理员")){
						rs=stmt.executeQuery("SELECT * FROM ROOTMAN where 姓名='"+jtf.getText() +"' and 密码='"+Jpf+"'");
					}else if(JRB.equals("教师")){
						rs=stmt.executeQuery("SELECT * FROM TEACHER where 教师号='"+jtf.getText() +"' and 密码='"+Jpf+"'");
					}else{
						rs=stmt.executeQuery("SELECT * FROM student where 学号='"+jtf.getText() +"' and 密码='"+Jpf+"'");
					}
					
					if(rs.next()){
						if(JRB.equals("超级管理员")){
							new RootView(jtf.getText());
						}else if(JRB.equals("教师")){
							new TeacherView(jtf.getText());
						}else{
							new StuView(jtf.getText());
						}
						this.dispose();
					}else{
						JOptionPane.showMessageDialog(null,"用户名或密码错误","提示",JOptionPane.ERROR_MESSAGE);
					}
					stmt.close();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog( null , "数据库连接错误" ,"提示" , JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				if(jtf.getText().length()==0){
					JOptionPane.showMessageDialog( null , "请输入用户名");
				}else if(jpf.getPassword().length==0){
					JOptionPane.showMessageDialog( null , "请输入密码");
				}else{
					JOptionPane.showMessageDialog( null , "请选择角色");
				}
			}
		}
	}

}