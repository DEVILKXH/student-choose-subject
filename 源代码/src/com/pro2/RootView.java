/*
 * 超级管理员界面
 */
package com.pro2;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import java.util.Timer;
import java.util.TimerTask;


public class RootView extends JFrame implements ActionListener{

	JTabbedPane jtp;
	
	JPanel jp0,jp1,jp2,jp3,jp4,jp5,jp6;
	JTable jtb,jtb2,jtb3,jtb4,jtb5,jtb6;
	JScrollPane jsp,jsp2,jsp3,jsp4,jsp5,jsp6;
	JLabel jlb,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlb8,jlb9,jlb10,jlb11,jlb25,jlb26;
	JLabel jlb12,jlb13,jlb14,jlb15,jlb16,jlb17,jlb18,jlb19,jlb20,jlb21,jlb22,jlb23,jlb24;
	JButton jb0,/*选项卡学生*/jb1,jb2,jb3,jb4,jb5,/*选项卡教师*/jb6,jb7,jb8,jb9,jb10/*选项卡选课*/,jb11,jb12,jb13,jb14,jb15,jb16,jb17,jb18,jb19;
	JButton jb20,jb21,jb22,jb23,jb24,jb25,jb26;
	JTextField jtf,jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11;
	JTextField jtf12,jtf13,jtf14,jtf15,jtf16,jtf17,jtf18,jtf19,jtf20,jtf21,jtf22,jtf23;
	
	RootModel rm=null;
	TeacherModel tm=null;
	CurModel cm=null;
	SCModel scm=null;
	ChoModel chm=null;
	
	
	String Rno;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RootView rootv=new RootView("admin");
	}
	public RootView(String name){
		this.Rno=name;
		jlb26=new JLabel("欢迎你:"+name);
		jlb26.setBounds(20,30,200,30);
		jlb26.setFont(new Font("楷体",Font.BOLD,24));
		jlb26.setForeground(Color.blue);
		
		//选项卡学生管理
		jp0=new JPanel();
		jp0.setLayout(null);
		
		jtf=new JTextField(10);
		jtf.setBounds(550,10,180,28);
		
		jb1=new JButton("查询");
		jb1.setBounds(740,10,80,28);
		jb1.setFont(new Font("楷体",Font.BOLD,15));
		jb1.setForeground(Color.blue);
		jb1.addActionListener(this);
		
		jlb=new JLabel("请输入学号");
		jlb.setBounds(450,10,80,28);
		jlb.setFont(new Font("楷体",Font.BOLD,15));
		jlb.setForeground(Color.blue);

		rm=new RootModel();
		
		jtb=new JTable(rm);
		jtb.setFont(new Font("楷体",Font.BOLD,18));
		jtb.setForeground(Color.blue);
		jtb.setRowHeight(20);
		jsp=new JScrollPane(jtb);
		jsp.setBounds(0,50,1300,500);
		
		
		
		jb2=new JButton("添加");
		jb2.setFont(new Font("楷体",Font.BOLD,15));
		jb2.setForeground(Color.blue);
		jb2.setBounds(370,600,120,28);
		jb2.addActionListener(this);
		
		jb3=new JButton("修改");
		jb3.setFont(new Font("楷体",Font.BOLD,15));
		jb3.setForeground(Color.blue);
		jb3.addActionListener(this);
		jb3.setBounds(500,600,120,28);
		
		jb4=new JButton("删除");
		jb4.setFont(new Font("楷体",Font.BOLD,15));
		jb4.setForeground(Color.blue);
		jb4.addActionListener(this);
		jb4.setBounds(630,600,120,28);
		
		jb5=new JButton("修改密码");
		jb5.setFont(new Font("楷体",Font.BOLD,15));
		jb5.setForeground(Color.blue);
		jb5.addActionListener(this);
		jb5.setBounds(760,600,120,28);
		
		jp0.add(jtf);
		jp0.add(jb1);
		jp0.add(jlb);
		jp0.add(jsp);
		jp0.add(jb2);
		jp0.add(jb3);
		jp0.add(jb4);
		jp0.add(jb5);
		
		//教师选项卡
		jp1=new JPanel();
		jp1.setLayout(null);
		
		jtf1=new JTextField(10);
		jtf1.setBounds(690,10,200,28);
		
		jb6=new JButton("查询");
		jb6.setBounds(900,10,80,28);
		jb6.setFont(new Font("楷体",Font.BOLD,15));
		jb6.setForeground(Color.blue);
		jb6.addActionListener(this);
		
		jlb2=new JLabel("请输入教师号");
		jlb2.setBounds(560,10,120,28);
		jlb2.setFont(new Font("楷体",Font.BOLD,15));
		jlb2.setForeground(Color.blue);

		tm=new TeacherModel();
		
		jtb2=new JTable(tm);
		jtb2.setFont(new Font("楷体",Font.BOLD,15));
		jtb2.setForeground(Color.blue);
		jtb2.setRowHeight(24);
		jsp2=new JScrollPane(jtb2);
		jsp2.setBounds(200,50,1100,550);
		
		jb7=new JButton("添加");
		jb7.setFont(new Font("楷体",Font.BOLD,15));
		jb7.setForeground(Color.blue);
		jb7.setBounds(40,50,120,28);
		jb7.addActionListener(this);
		
		jb8=new JButton("修改");
		jb8.setFont(new Font("楷体",Font.BOLD,15));
		jb8.setForeground(Color.blue);
		jb8.addActionListener(this);
		jb8.setBounds(40,100,120,28);
		
		jb9=new JButton("删除");
		jb9.setFont(new Font("楷体",Font.BOLD,15));
		jb9.setForeground(Color.blue);
		jb9.addActionListener(this);
		jb9.setBounds(40,150,120,28);
		
		jb10=new JButton("修改密码");
		jb10.setFont(new Font("楷体",Font.BOLD,15));
		jb10.setForeground(Color.blue);
		jb10.addActionListener(this);
		jb10.setBounds(40,200,120,28);
		
		jp1.add(jtf1);
		jp1.add(jb6);
		jp1.add(jlb2);
		jp1.add(jsp2);
		jp1.add(jb7);
		jp1.add(jb8);
		jp1.add(jb9);
		jp1.add(jb10);
		
		
		//选课管理选项卡
		jp2=new JPanel();
		jp2.setLayout(null);	
		
		jp3=new JPanel();		
		jp4=new JPanel();		
		jp5=new JPanel();		
		jp6=new JPanel();
		
		jp3.setBounds(200,0,1100,700);
		jp4.setBounds(200,0,1100,700);
		jp5.setBounds(200,0,1100,700);
		jp6.setBounds(200,0,1100,700);
		
		
		jb11=new JButton("学生选课表");
		jb11.setFont(new Font("楷体",Font.BOLD,15));
		jb11.setForeground(Color.blue);
		jb11.setBounds(40,50,120,28);
		jb11.addActionListener(this);
		
		jb12=new JButton("查看课程");
		jb12.setFont(new Font("楷体",Font.BOLD,15));
		jb12.setForeground(Color.blue);
		jb12.setBounds(40,100,120,28);
		jb12.addActionListener(this);

		jb13=new JButton("发布选课");
		jb13.setFont(new Font("楷体",Font.BOLD,15));
		jb13.setForeground(Color.blue);
		jb13.setBounds(40,150,120,28);
		jb13.addActionListener(this);
		
		jb0=new JButton("选课管理");
		jb0.setFont(new Font("楷体",Font.BOLD,15));
		jb0.setForeground(Color.blue);
		jb0.setBounds(40,200,120,28);
		jb0.addActionListener(this);
		

		scm=new SCModel();
		jtb3=new JTable(scm);
		jtb3.setRowHeight(24);
		jtb3.setFont(new Font("楷体",Font.BOLD,15));
		jtb3.setForeground(Color.blue);
		jsp3=new JScrollPane(jtb3);
		jsp3.setBounds(0,50,1100,500);
		
		jlb9=new JLabel("请输入学号");
		jtf22=new JTextField(20);
		jlb9.setBounds(0,560,80,28);
		jlb9.setFont(new Font("楷体",Font.BOLD,15));
		jlb9.setForeground(Color.blue);
		
		jtf22.setBounds(90,560,160,24);
		jtf22.setFont(new Font("楷体",Font.BOLD,15));
		jtf22.setForeground(Color.blue);
		
		jb15=new JButton("查询");
		jb15.addActionListener(this);
		jb15.setBounds(255,560,80,26);
		jb15.setFont(new Font("楷体",Font.BOLD,15));
		jb15.setForeground(Color.blue);
		
		
		jlb10=new JLabel("请输入课程号");
		jtf23=new JTextField(20);
		jb20=new JButton("查询");
		jb20.addActionListener(this);
		jlb10.setBounds(360,560,100,28);
		jlb10.setFont(new Font("楷体",Font.BOLD,15));
		jlb10.setForeground(Color.blue);
		
		jtf23.setBounds(460,560,160,28);
		jtf23.setFont(new Font("楷体",Font.BOLD,15));
		jtf23.setForeground(Color.blue);
		
		jb20.setBounds(625,560,80,28);
		jb20.setFont(new Font("楷体",Font.BOLD,15));
		jb20.setForeground(Color.blue);
		
		
		jlb25=new JLabel("请输入教师号");
		jtf21=new JTextField(20);
		jb25=new JButton("查询");
		jb25.addActionListener(this);
		jlb25.setBounds(720,560,100,28);
		jlb25.setFont(new Font("楷体",Font.BOLD,15));
		jlb25.setForeground(Color.blue);
		
		jtf21.setBounds(820,560,160,28);
		jtf21.setFont(new Font("楷体",Font.BOLD,15));
		jtf21.setForeground(Color.blue);
		
		jb25.setBounds(985,560,80,28);
		jb25.setFont(new Font("楷体",Font.BOLD,15));
		jb25.setForeground(Color.blue);
		
		
		jb17=new JButton("退选");
		jb17.setBounds(220,600,120,26);
		jb17.setFont(new Font("楷体",Font.BOLD,15));
		jb17.setForeground(Color.blue);
		jb17.addActionListener(this);
		
		jb18=new JButton("考试时间修改");
		jb18.setBounds(350,600,180,26);
		jb18.setFont(new Font("楷体",Font.BOLD,15));
		jb18.setForeground(Color.blue);
		jb18.addActionListener(this);
		
		jb19=new JButton("成绩修改");
		jb19.setBounds(540,600,120,26);
		jb19.setFont(new Font("楷体",Font.BOLD,15));
		jb19.setForeground(Color.blue);
		jb19.addActionListener(this);

		jp3.setLayout(null);
		
		jlb18=new JLabel("学生选课表");
		jlb18.setBounds(400,0,500,50);
		jlb18.setFont(new Font("楷体",Font.BOLD,50));
		jlb18.setForeground(Color.blue);
		

		jp3.add(jlb10);
		jp3.add(jtf23);
		jp3.add(jb20);
		jp3.add(jlb25);
		jp3.add(jtf21);
		jp3.add(jb25);
		jp3.add(jsp3);
		jp3.add(jlb9);
		jp3.add(jlb18);
		jp3.add(jtf22);
		jp3.add(jb15);
		jp3.add(jb17);
		jp3.add(jb18);
		jp3.add(jb19);

		//jp4
		
		jlb22=new JLabel("请输入教师号");
		jtf18=new JTextField(20);
		jb22=new JButton("查询");
		jb22.addActionListener(this);
		jlb22.setBounds(160,580,100,28);
		jlb22.setFont(new Font("楷体",Font.BOLD,15));
		jlb22.setForeground(Color.blue);
		
		jtf18.setBounds(260,580,160,28);
		jtf18.setFont(new Font("楷体",Font.BOLD,15));
		jtf18.setForeground(Color.blue);
		
		jb22.setBounds(425,580,80,28);
		jb22.setFont(new Font("楷体",Font.BOLD,15));
		jb22.setForeground(Color.blue);
		
		jlb23=new JLabel("请输入课程号");
		jtf19=new JTextField(20);
		jb23=new JButton("查询");
		jb23.addActionListener(this);
		jlb23.setBounds(530,580,100,28);
		jlb23.setFont(new Font("楷体",Font.BOLD,15));
		jlb23.setForeground(Color.blue);
		
		jtf19.setBounds(630,580,160,28);
		jtf19.setFont(new Font("楷体",Font.BOLD,15));
		jtf19.setForeground(Color.blue);
		
		jb23.setBounds(795,580,80,28);
		jb23.setFont(new Font("楷体",Font.BOLD,15));
		jb23.setForeground(Color.blue);
			
		jp4.setLayout(null);
		cm=new CurModel();
		jtb4=new JTable(cm);
		jtb4.setRowHeight(24);
		jtb4.setFont(new Font("楷体",Font.BOLD,15));
		jtb4.setForeground(Color.blue);
		jsp4=new JScrollPane(jtb4);
		jsp4.setBounds(0,50,1100,500);
		
		jlb19=new JLabel("课程表");
		jlb19.setBounds(500,0,500,50);
		jlb19.setFont(new Font("楷体",Font.BOLD,50));
		jlb19.setForeground(Color.blue);
		
		jp4.add(jsp4);
		jp4.add(jlb19);
		jp4.add(jlb22);
		jp4.add(jtf18);
		jp4.add(jb22);
		jp4.add(jlb23);
		jp4.add(jtf19);
		jp4.add(jb23);
		jp4.setVisible(false);
		
		//jp5
		jp5.setLayout(null);
		
		jlb2=new JLabel("　课程编号");
		jlb2.setFont(new Font("楷体",Font.BOLD,15));
		jlb2.setForeground(Color.blue);
		jlb2.setBounds(10,50,100,28);
		
		jlb3=new JLabel("课程名称");
		jlb3.setFont(new Font("楷体",Font.BOLD,15));
		jlb3.setForeground(Color.blue);
		jlb3.setBounds(360,50,100,28);
		
		jlb4=new JLabel("任课教师号");
		jlb4.setFont(new Font("楷体",Font.BOLD,15));
		jlb4.setForeground(Color.blue);
		jlb4.setBounds(700,50,100,28);
		
		jlb5=new JLabel("任课教师名");
		jlb5.setFont(new Font("楷体",Font.BOLD,15));
		jlb5.setForeground(Color.blue);
		jlb5.setBounds(10,100,100,28);
		
		jlb6=new JLabel("　　学分");
		jlb6.setFont(new Font("楷体",Font.BOLD,15));
		jlb6.setForeground(Color.blue);
		jlb6.setBounds(360,100,100,28);
		
		jlb7=new JLabel("　是否选修");
		jlb7.setFont(new Font("楷体",Font.BOLD,15));
		jlb7.setBounds(700,100,100,28);
		jlb7.setForeground(Color.blue);

		jlb8=new JLabel("　上课时间");
		jlb8.setFont(new Font("楷体",Font.BOLD,15));
		jlb8.setBounds(10,150,100,28);
		jlb8.setForeground(Color.blue);

		jlb9=new JLabel("上课地点");
		jlb9.setFont(new Font("楷体",Font.BOLD,15));
		jlb9.setBounds(360,150,100,28);
		jlb9.setForeground(Color.blue);

		jlb10=new JLabel("　截止时间");
		jlb10.setFont(new Font("楷体",Font.BOLD,15));
		jlb10.setBounds(700,150,100,28);
		jlb10.setForeground(Color.blue);
		
		jlb16=new JLabel("-");
		jlb16.setFont(new Font("楷体",Font.BOLD,20));
		jlb16.setBounds(845,150,45,28);
		jlb16.setForeground(Color.blue);
		
		jlb17=new JLabel("-");
		jlb17.setFont(new Font("楷体",Font.BOLD,20));
		jlb17.setBounds(920,150,45,28);
		jlb17.setForeground(Color.blue);
		
		jtf2=new JTextField(20);
		jtf2.setBounds(100,52,200,24);
		jtf2.setFont(new Font("楷体",Font.BOLD,15));
		jtf2.setForeground(Color.blue);
		
		jtf3=new JTextField(20);
		jtf3.setBounds(440,52,200,24);
		jtf3.setFont(new Font("楷体",Font.BOLD,15));
		jtf3.setForeground(Color.blue);
		
		jtf4=new JTextField(20);
		jtf4.setBounds(790,52,200,24);
		jtf4.setFont(new Font("楷体",Font.BOLD,15));
		jtf4.setForeground(Color.blue);
		
		jtf5=new JTextField(20);
		jtf5.setBounds(100,102,200,24);
		jtf5.setFont(new Font("楷体",Font.BOLD,15));
		jtf5.setForeground(Color.blue);
		
		jtf6=new JTextField(20);
		jtf6.setBounds(440,102,200,24);
		jtf6.setFont(new Font("楷体",Font.BOLD,15));
		jtf6.setForeground(Color.blue);
		
		jtf7=new JTextField(20);
		jtf7.setBounds(790,102,200,24);
		jtf7.setFont(new Font("楷体",Font.BOLD,15));
		jtf7.setForeground(Color.blue);
		
		jtf8=new JTextField(20);
		jtf8.setBounds(100,152,200,24);
		jtf8.setFont(new Font("楷体",Font.BOLD,15));
		jtf8.setForeground(Color.blue);
		
		jtf9=new JTextField(20);
		jtf9.setBounds(440,152,200,24);
		jtf9.setFont(new Font("楷体",Font.BOLD,15));
		jtf9.setForeground(Color.blue);
		
		jtf10=new JTextField(20);
		jtf10.setBounds(790,152,50,24);
		jtf10.setFont(new Font("楷体",Font.BOLD,15));
		jtf10.setForeground(Color.blue);
		
		jtf16=new JTextField(20);
		jtf16.setBounds(865,152,50,24);
		jtf16.setFont(new Font("楷体",Font.BOLD,15));
		jtf16.setForeground(Color.blue);
		
		jtf17=new JTextField(20);
		jtf17.setBounds(940,152,50,24);
		jtf17.setFont(new Font("楷体",Font.BOLD,15));
		jtf17.setForeground(Color.blue);	
		
		jb14=new JButton("发布选课");
		jb14.setFont(new Font("楷体",Font.BOLD,15));
		jb14.setForeground(Color.blue);
		jb14.setBounds(10,200,120,28);
		jb14.addActionListener(this);
		
		jb16=new JButton("重置");
		jb16.setFont(new Font("楷体",Font.BOLD,15));
		jb16.setForeground(Color.blue);
		jb16.setBounds(135,200,120,28);
		jb16.addActionListener(this);

		jp5.add(jlb2);
		jp5.add(jtf2);
		jp5.add(jlb3);
		jp5.add(jtf3);
		jp5.add(jlb4);
		jp5.add(jtf4);
		jp5.add(jlb5);
		jp5.add(jlb6);
		jp5.add(jlb7);
		jp5.add(jlb8);
		jp5.add(jlb9);
		jp5.add(jlb10);
		jp5.add(jlb16);
		jp5.add(jlb17);
		jp5.add(jtf5);
		jp5.add(jtf6);
		jp5.add(jtf7);
		jp5.add(jtf8);
		jp5.add(jtf9);
		jp5.add(jtf10);
		jp5.add(jtf16);
		jp5.add(jtf17);
		jp5.add(jb14);
		jp5.add(jb16);
		jp5.setVisible(false);
		
		//jp6
		
		jlb11=new JLabel("请输入课程号");
		jtf11=new JTextField(20);
		jb21=new JButton("查询");
		jb21.addActionListener(this);
		jlb11.setBounds(380,10,120,28);
		jlb11.setFont(new Font("楷体",Font.BOLD,15));
		jlb11.setForeground(Color.blue);
		
		jtf11.setBounds(490,10,200,24);
		jtf11.setFont(new Font("楷体",Font.BOLD,15));
		jtf11.setForeground(Color.blue);
		
		jb21.setBounds(700,10,80,26);
		jb21.setFont(new Font("楷体",Font.BOLD,15));
		jb21.setForeground(Color.blue);
		
		
		jp6.setLayout(null);
		chm=new ChoModel();
		jtb6=new JTable(chm);
		jtb6.setRowHeight(24);
		jtb6.setFont(new Font("楷体",Font.BOLD,15));
		jtb6.setForeground(Color.blue);
		jsp6=new JScrollPane(jtb6);
		jsp6.setBounds(0,50,1100,500);

		
		jb26=new JButton("删除待选课程");
		jb26.setBounds(0,600,200,30);
		jb26.setFont(new Font("楷体",Font.BOLD,20));
		jb26.setForeground(Color.blue);
		jb26.addActionListener(this);
		
		jlb20=new JLabel("待选课程表");
		jlb20.setBounds(10,20,120,28);
		jlb20.setFont(new Font("楷体",Font.BOLD,20));
		jlb20.setForeground(Color.blue);

		
		
		jp6.add(jsp6);
		jp6.add(jlb11);
		jp6.add(jlb20);
		jp6.add(jtf11);
		jp6.add(jb21);
		jp6.add(jb26);
		jp6.setVisible(false);
		
		//
		
		jp2.add(jb11);
		jp2.add(jb12);
		jp2.add(jb13);
		jp2.add(jb0);
		jp2.add(jp3);
		jp2.add(jp4);
		jp2.add(jp5);
		jp2.add(jp6);
		//
		jtp=new JTabbedPane();
		jtp.add("学生管理",jp0);
		jtp.add("教师管理",jp1);
		jtp.add("选课管理",jp2);
		
		this.add(jlb26);
		this.add(jtp);
		this.setTitle("学生选课管理系统");
		this.setBackground(Color.gray);
		this.setResizable(false);
		this.setLocation(60,10);
		this.setSize(1300,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		Timer timer=new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new AddAuto();
			}
		}, 500);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		/*学生按钮*/
		String sql;
		if(e.getSource()==jb1){
			String name=this.jtf.getText().trim();
			if(name.length()==0){
				sql="select * from student";
			}else{
				sql="select * from student where 学号  like '%"+name+"%'";
			}
			rm=new RootModel(sql);
			jtb.setModel(rm);
		}else if(e.getSource()==jb2){
			stuAddDialog sad=new stuAddDialog(this,"添加学生信息",true);
			rm=new RootModel();
			jtb.setModel(rm);
		}else if(e.getSource()==jb3){
			int rowNum=this.jtb.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择中一行");
			}else{
				new stuUpdateDialog(this,"修改学生信息",true,rm,rowNum);
			}
			rm=new RootModel();
			jtb.setModel(rm);
		}else if(e.getSource()==jb4){
			int rowNum=this.jtb.getSelectedRow(); //返回用户点中的行，如果一行没选，则返回-1
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"请选择一行");
				//return ;
			}else{
				String stuId=(String)rm.getValueAt(rowNum,0);
				sql="delete from student where 学号=?;delete from SC where 学号=?";
				String[] paras={stuId,stuId};
				RootModel temp=new RootModel();
				temp.updateStu(sql,paras);
			}
			rm=new RootModel();
			jtb.setModel(rm);
		}else if(e.getSource()==jb5){
			int rowNum=this.jtb.getSelectedRow(); //返回用户点中的行，如果一行没选，则返回-1
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"请选择一行");
				//return ;
			}else{
				new updataStuPwd(this,"修改学生密码",true,rm,rowNum);
				rm=new RootModel();
				jtb.setModel(rm);
			}
		}
		/*教师按钮*/
		else if(e.getSource()==jb6){
			String name=this.jtf1.getText().trim();
			if(name.length()==0){
				sql="select * from teacher";
			}else{
				sql="select * from teacher where 教师号  like '%"+name+"%'";
			}
			tm=new TeacherModel(sql);
			jtb2.setModel(tm);
		}else if(e.getSource()==jb7){
			new teaAddDialog(this,"添加教师信息",true);
			tm=new TeacherModel();
			jtb2.setModel(tm);
		}else if(e.getSource()==jb8){
			int rowNum=this.jtb2.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择中一行");
			}else{
				new teaUpdateDialog(this,"修改教师信息",true,tm,rowNum);
			}
			tm=new TeacherModel();
			jtb2.setModel(tm);
		}
		else if(e.getSource()==jb9){
			int rowNum=this.jtb2.getSelectedRow(); //返回用户点中的行，如果一行没选，则返回-1
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"请选择一行");
				//return ;
			}else{
				String teaId=(String)tm.getValueAt(rowNum,0);
				sql="delete from teacher where 教师号=?;delete from course where 任课教师号=?";
				String[] paras={teaId,teaId};
				TeacherModel temp=new TeacherModel();
				temp.updateTea(sql,paras);
			}
			tm=new TeacherModel();
			jtb2.setModel(tm);
		}else if(e.getSource()==jb10){
			int rowNum=this.jtb2.getSelectedRow(); //返回用户点中的行，如果一行没选，则返回-1
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"请选择一行");
				//return ;
			}else{
				new updataTeaPwd(this,"修改教师密码",true,tm,rowNum);
				tm=new TeacherModel();
				jtb2.setModel(tm);
			}
		}
		/*选课按钮*/
		else if(e.getSource()==jb11){
			jp3.setVisible(true);
			jp4.setVisible(false);
			jp5.setVisible(false);
			jp6.setVisible(false);
			
			scm=new SCModel();
			jtb3.setModel(scm);
		}else if(e.getSource()==jb12){
			jp4.setVisible(true);
			jp5.setVisible(false);
			jp3.setVisible(false);
			jp6.setVisible(false);
			cm=new CurModel();
			jtb4.setModel(cm);
			
		}else if(e.getSource()==jb13){
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
			jtf5.setText("");
			jtf6.setText("");
			jtf7.setText("");
			jtf8.setText("");
			jtf9.setText("");
			jtf10.setText("");
			jtf16.setText("");
			jtf17.setText("");
			
			jp5.setVisible(true);
			jp4.setVisible(false);
			jp3.setVisible(false);
			jp6.setVisible(false);
		}else if(e.getSource()==jb0){
			jp6.setVisible(true);
			jp4.setVisible(false);
			jp3.setVisible(false);
			jp5.setVisible(false);
			
			chm=new ChoModel();
			jtb6.setModel(chm);
			
		}else if(e.getSource()==jb14){	
			if(jtf8.getText().length()!=0 && jtf2.getText().length()!=0 && jtf3.getText().length()!=0 && jtf4.getText().length()!=0 && jtf5.getText().length()!=0 && jtf6.getText().length()!=0 && jtf7.getText().length()!=0 && jtf9.getText().length()!=0 && jtf10.getText().length()!=0 && jtf16.getText().length()!=0 && jtf17.getText().length()!=0){
				
				if(jtf7.getText().equals("1") && Float.parseFloat(jtf6.getText())<1){
						JOptionPane.showMessageDialog(this,"选修课程学分不得低于1学分");
				}else{
					sql="insert into choosecourse values(?,?,?,?,?,?,?,?,?,?)";
					String Time=jtf10.getText().trim()+"-"+jtf16.getText().trim()+"-"+jtf17.getText().trim();
					String[] paras={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText(),jtf8.getText(),jtf9.getText(),Time,"0"};
					chm=new ChoModel();
					if(chm.updateCourse(sql, paras)!=true){
						JOptionPane.showMessageDialog(this, "发布失败");
					}else{
						JOptionPane.showMessageDialog(this, "发布成功");
						jtf2.setText("");
						jtf3.setText("");
						jtf4.setText("");
						jtf5.setText("");
						jtf6.setText("");
						jtf7.setText("");
						jtf8.setText("");
						jtf9.setText("");
						jtf10.setText("");
						jtf16.setText("");
						jtf17.setText("");
						
						jtb6.setModel(chm);
					}
				}
			}else{
				if(jtf2.getText().length()==0){
					JOptionPane.showMessageDialog(this,"课程号不能为空");
				}else if(jtf3.getText().length()==0){
					JOptionPane.showMessageDialog(this,"课程名不能为空");
				}else if(jtf4.getText().length()==0){
					JOptionPane.showMessageDialog(this,"任课教师号不能为空");
				}else if(jtf5.getText().length()==0){
					JOptionPane.showMessageDialog(this,"任课教师不能为空");
				}else if(jtf6.getText().length()==0){
					JOptionPane.showMessageDialog(this,"学分不能为空");
				}else if(jtf7.getText().length()==0){
					JOptionPane.showMessageDialog(this,"是否选修不能为空");
				}else if(jtf8.getText().length()==0){
					JOptionPane.showMessageDialog(this,"上课时间不能为空");
				}else if(jtf9.getText().length()==0){
					JOptionPane.showMessageDialog(this,"上课地点不能为空");
				}else if(jtf10.getText().length()==0){
					JOptionPane.showMessageDialog(this,"截止日期不能为空");
				}else{
					JOptionPane.showMessageDialog(this,"时间不正确");
				}
			}
		}else if(e.getSource()==jb16){
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
			jtf5.setText("");
			jtf6.setText("");
			jtf7.setText("");
			jtf8.setText("");
			jtf9.setText("");
			jtf10.setText("");
			jtf16.setText("");
			jtf17.setText("");
		}else if(e.getSource()==jb17){
			int rowNum=this.jtb3.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
			}else{
				String SnoId=(String)scm.getValueAt(rowNum,0);
				String CnoId=(String)scm.getValueAt(rowNum,1);
				sql="delete from SC where 学号=? and 课程号=?";
				String[] paras={SnoId,CnoId};
				SCModel temp=new SCModel();
				temp.updateSC(sql, paras);
				scm=new SCModel();
				jtb3.setModel(scm);
			}
		}else if(e.getSource()==jb18){
			int rowNum=this.jtb3.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
			}else{
				new updateTime(this,"考试时间修改",true,scm,rowNum);
				scm=new SCModel();
				jtb3.setModel(scm);
			}
		}else if(e.getSource()==jb19){
			int rowNum=this.jtb3.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
			}else{
				new updataGrade(this,"成绩修改",true,scm,rowNum);
				scm=new SCModel();
				jtb3.setModel(scm);
			}
		}else if(e.getSource()==jb23){
			String mysql=null;
			if(jtf18.getText().length()==0 && jtf19.getText().length()==0){
				mysql="select * from course";
			}else if(jtf18.getText().length()==0 && jtf19.getText().length()!=0){
				mysql="select * from course where 课程号 like'%"+jtf19.getText()+"%'";
			}
			else if(jtf18.getText().length()!=0 && jtf19.getText().length()!=0){
				mysql="select * from course where 课程号 like'%"+jtf19.getText()+"%' and 任课教师号 like '%"+jtf18.getText()+"%'";
			}
			
			cm=new CurModel(mysql);
			jtb4.setModel(cm);
		}else if(e.getSource()==jb22){
			String mysql=null;
			if(jtf18.getText().length()==0 && jtf19.getText().length()==0){
				mysql="select * from course";
			}else if(jtf18.getText().length()!=0 && jtf19.getText().length()==0){
				mysql="select * from course where 任课教师号 like'%"+jtf18.getText()+"%'";
			}
			else if(jtf18.getText().length()!=0 && jtf19.getText().length()!=0){
				mysql="select * from course where 课程号 like'%"+jtf19.getText()+"%' and 任课教师号 like '%"+jtf18.getText()+"%'";
			}
			cm=new CurModel(mysql);
			jtb4.setModel(cm);
		}else if(e.getSource()==jb21){
			if(jtf11.getText().length()==0){
				sql="select * from choosecourse";
			}else {
				sql="select * from choosecourse where 课程号 like'%"+jtf11.getText()+"%'";
			}
			chm=new ChoModel(sql);
			jtb6.setModel(chm);
		}else if(e.getSource()==jb15){
			String mysql=null;
			if(jtf22.getText().length()==0 && jtf23.getText().length()==0 && jtf21.getText().length()==0){
				mysql="select * from SC";
			}else if(jtf22.getText().length()!=0 && jtf23.getText().length()==0 && jtf21.getText().length()==0){
				mysql="select * from SC where 学号 like '%"+jtf22.getText()+"%'";
			}else if(jtf22.getText().length()!=0 && jtf23.getText().length()!=0 && jtf21.getText().length()==0){
				mysql="select * from SC where 学号 like '%"+jtf22.getText()+"%' and 课程号 like '%"+jtf23.getText()+"%'";
			}else if(jtf22.getText().length()!=0 && jtf23.getText().length()==0 && jtf21.getText().length()!=0){
				mysql="select * from SC where 学号 like '%"+jtf22.getText()+"%'and 任课教师号 like'%"+jtf21.getText()+"%'";
			}else if(jtf22.getText().length()!=0 && jtf23.getText().length()!=0 && jtf21.getText().length()!=0){
				mysql="select * from SC where 学号 like '%"+jtf22.getText()+"%' and 课程号 like '%"+jtf23.getText()+"%' and 任课教师号 like'%"+jtf21.getText()+"%'";
			}
			scm=new SCModel(mysql);
			jtb3.setModel(scm);
		}else if(e.getSource()==jb20){
			String mysql=null;
			if(jtf22.getText().length()==0 && jtf23.getText().length()==0 && jtf21.getText().length()==0){
				mysql="select * from SC";
			}else if(jtf22.getText().length()==0 && jtf23.getText().length()!=0 && jtf21.getText().length()==0){
				mysql="select * from SC where 课程号 like '%"+jtf23.getText()+"%'";
			}else if(jtf22.getText().length()!=0 && jtf23.getText().length()!=0 && jtf21.getText().length()==0){
				mysql="select * from SC where 课程号 like '%"+jtf23.getText()+"%' and 学号 like '%"+jtf22.getText()+"%'";
			}else if(jtf22.getText().length()==0 && jtf23.getText().length()!=0 && jtf21.getText().length()!=0){
				mysql="select * from SC where 课程号 like '%"+jtf23.getText()+"%'and 任课教师号 like'%"+jtf21.getText()+"%'";
			}else if(jtf22.getText().length()!=0 && jtf23.getText().length()!=0 && jtf21.getText().length()!=0){
				mysql="select * from SC where 课程号 like '%"+jtf23.getText()+"%' and 学号 like '%"+jtf22.getText()+"%' and 任课教师号 like'%"+jtf21.getText()+"%'";
			}
			scm=new SCModel(mysql);
			jtb3.setModel(scm);
		}else if(e.getSource()==jb25){
			String mysql=null;
			if(jtf22.getText().length()==0 && jtf23.getText().length()==0 && jtf21.getText().length()==0){
				mysql="select * from SC";
			}else if(jtf22.getText().length()==0 && jtf23.getText().length()==0 && jtf21.getText().length()!=0){
				mysql="select * from SC where 任课教师号 like '%"+jtf21.getText()+"%'";
			}else if(jtf22.getText().length()!=0 && jtf23.getText().length()==0 && jtf21.getText().length()!=0){
				mysql="select * from SC where 学号 like '%"+jtf22.getText()+"%' and 任课教师号 like '%"+jtf21.getText()+"%'";
			}else if(jtf22.getText().length()==0 && jtf23.getText().length()!=0 && jtf21.getText().length()!=0){
				mysql="select * from SC where 课程号 like '%"+jtf23.getText()+"%'and 任课教师号 like'%"+jtf21.getText()+"%'";
			}else if(jtf22.getText().length()!=0 && jtf23.getText().length()!=0 && jtf21.getText().length()!=0){
				mysql="select * from SC where 课程号 like '%"+jtf23.getText()+"%' and 学号 like '%"+jtf22.getText()+"%' and 任课教师号 like'%"+jtf21.getText()+"%'";
			}
			scm=new SCModel(mysql);
			jtb3.setModel(scm);
		}else if(e.getSource()==jb26){
			int rowNum=this.jtb6.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"请选择删除的课程");
			}else{
				String CnoId=(String)chm.getValueAt(rowNum,0);
				String TnoId=(String)chm.getValueAt(rowNum,2);
				sql="delete from choosecourse where 课程号=? and 任课教师号=?";
				String[] paras={CnoId,TnoId};
				CurModel temp=new CurModel();
				temp.updateCourse(sql, paras);
				chm=new ChoModel();
				jtb6.setModel(chm);
			}
		}
	}
}