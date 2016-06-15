package com.pro2;


import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class TeacherView extends JFrame implements ActionListener{
	
	JPanel[] jp;
	JPanel jp1;
	JButton jb0,jb1,jb2,jb3,/*jp1*/jb4,/*jp[0]*/jb5,jb6,jb7,jb8,jb10,jb11/*jp[2]*/,jb12;
	JButton jb13,jb14,jb15,jb16;
	JTable jtb0,jtb1,jtb2;
	JScrollPane jsp0,jsp1,jsp2,jsp3;
	JLabel jlb,jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlb8,jlb9,jlb10,jlb11,jlb12,jlb13;
	JLabel jlb14,jlb15,jlb16,jlb17,jlb18;
	JTextField jtf,jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11,jtf12,jtf13,jtf14;
	
	String Tno=null;
	boolean mysno=false;
	boolean mycno=false;
	boolean mygrade=false;
	TeacherModel tm=null;
	SCModel scm=null;
	CurModel cm=null;
	ChoModel chm=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeacherView tv=new TeacherView("T011302102");	
	}

	public TeacherView(String name){
		this.Tno=name;
		jlb18=new JLabel("欢迎你:"+name);
		jlb18.setBounds(20,10,400,30);
		jlb18.setFont(new Font("楷体",Font.BOLD,24));
		jlb18.setForeground(Color.blue);
		
		
		jp=new JPanel[4];
		jp1=new JPanel();
		
		for(int i=0;i<jp.length;i++){
			jp[i]=new JPanel();
		}


		jlb11=new JLabel("选课表");
		jlb13=new JLabel("我的课程表");
		jlb12=new JLabel("个人信息表");
		
		jlb11.setBounds(700,10,500,40);
		jlb11.setForeground(Color.blue);
		jlb11.setFont(new Font("楷体",Font.BOLD,28));
		jlb12.setBounds(700,10,500,40);
		jlb12.setForeground(Color.blue);
		jlb12.setFont(new Font("楷体",Font.BOLD,28));
		jlb13.setBounds(700,10,500,40);
		jlb13.setForeground(Color.blue);
		jlb13.setFont(new Font("楷体",Font.BOLD,28));
		
		//jp1组件
		jp1.setLayout(null);
		jb0=new JButton("查看选课");
		jb0.setFont(new Font("楷体",Font.BOLD,15));
		jb0.setForeground(Color.blue);
		jb0.addActionListener(this);
		jb0.setBounds(50,50,100,28);
		jb1=new JButton("个人信息");
		jb1.setFont(new Font("楷体",Font.BOLD,15));
		jb1.setForeground(Color.blue);
		jb1.addActionListener(this);

		jb1.setBounds(50,0,100,28);
		
		jb2=new JButton("我的选课");
		jb2.setFont(new Font("楷体",Font.BOLD,15));
		jb2.setForeground(Color.blue);
		jb2.addActionListener(this);

		jb2.setBounds(50,100,100,28);
		
		jb3=new JButton("发布选课");
		jb3.addActionListener(this);
		jb3.setFont(new Font("楷体",Font.BOLD,15));
		jb3.setForeground(Color.blue);
		jb3.setBounds(50,150,100,28);
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb0);
		
		//jp[0]组件
		jb4=new JButton("修改密码");
		jb4.setFont(new Font("楷体",Font.BOLD,15));
		jb4.setForeground(Color.blue);
		jb4.addActionListener(this);
		jb4.setBounds(0,220,120,28);
		String sql="select * from teacher where 教师号='"+this.Tno+"'";
		tm=new TeacherModel(sql);
		jtb1=new JTable();
		jtb1.setModel(tm);
		jtb1.setFont(new Font("楷体",Font.BOLD,15));
		jtb1.setForeground(Color.blue);
		jsp1=new JScrollPane(jtb1);
		jsp1.setBounds(0,0,1050,200);
		jp[0].add(jsp1);
		jp[0].add(jb4);
		
		//jp[1]组件
		jb11=new JButton("成绩修改");
		jb11.setFont(new Font("楷体",Font.BOLD,15));
		jb11.setForeground(Color.blue);
		jb11.setBounds(130,470,130,28);
		jb11.addActionListener(this);
		jb6=new JButton("按学号排序");
		jb6.setFont(new Font("楷体",Font.BOLD,15));
		jb6.setForeground(Color.blue);
		jb6.setBounds(300,470,130,28);
		jb6.addActionListener(this);
		jb7=new JButton("按课程号排序");
		jb7.setFont(new Font("楷体",Font.BOLD,15));
		jb7.setForeground(Color.blue);
		jb7.setBounds(470,470,130,28);
		jb7.addActionListener(this);
		jb8=new JButton("按成绩排序");
		jb8.setFont(new Font("楷体",Font.BOLD,15));
		jb8.setForeground(Color.blue);
		jb8.setBounds(640,470,130,28);
		jb8.addActionListener(this);
		String sql2="select * from SC where 任课教师号='"+this.Tno+"'order by 学号 ASC";
		scm=new SCModel(sql2);
		jtb2=new JTable();
		jtb2.setModel(scm);
		jtb2.setFont(new Font("楷体",Font.BOLD,15));
		jtb2.setForeground(Color.blue);
		jsp2=new JScrollPane(jtb2);
		jsp2.setBounds(0,0,1050,400);
		
		jlb=new JLabel("请输入学号");
		jlb.setFont(new Font("楷体",Font.BOLD,15));
		jlb.setForeground(Color.blue);
		jtf=new JTextField(20);
		jb5=new JButton("查询");
		jb5.setFont(new Font("楷体",Font.BOLD,15));
		jb5.setForeground(Color.blue);
		jb5.addActionListener(this);

		jlb.setBounds(90,420,120,28);
		jtf.setBounds(180,420,170,24);
		jb5.setBounds(355,420,80,24);
		
		
		jlb8=new JLabel("请输入课程号");
		jlb8.setFont(new Font("楷体",Font.BOLD,15));
		jlb8.setForeground(Color.blue);
		jtf8=new JTextField(20);
		jb13=new JButton("查询");
		jb13.setFont(new Font("楷体",Font.BOLD,15));
		jb13.setForeground(Color.blue);
		jb13.addActionListener(this);

		jlb8.setBounds(535,420,130,28);
		jtf8.setBounds(635,420,170,24);
		jb13.setBounds(815,420,80,24);
		
		jp[1].add(jsp2);
		jp[1].add(jb11);
		jp[1].add(jb6);
		jp[1].add(jb7);
		jp[1].add(jb8);
		jp[1].add(jlb);
		jp[1].add(jtf);
		jp[1].add(jb5);
		jp[1].add(jlb8);
		jp[1].add(jtf8);
		jp[1].add(jb13);
		//jp[2]组件
		jp[2].setLayout(null);
		jlb1=new JLabel("　课程编号");
		jlb1.setFont(new Font("楷体",Font.BOLD,15));
		jlb1.setForeground(Color.blue);
		jlb1.setBounds(10,0,100,28);
		
		jlb2=new JLabel("课程名称");
		jlb2.setFont(new Font("楷体",Font.BOLD,15));
		jlb2.setForeground(Color.blue);
		jlb2.setBounds(360,0,100,28);
		
		jlb3=new JLabel("任课教师号");
		jlb3.setFont(new Font("楷体",Font.BOLD,15));
		jlb3.setForeground(Color.blue);
		jlb3.setBounds(700,0,100,28);
		
		jlb4=new JLabel("任课教师名");
		jlb4.setFont(new Font("楷体",Font.BOLD,15));
		jlb4.setForeground(Color.blue);
		jlb4.setBounds(10,50,100,28);
		
		jlb5=new JLabel("　　学分");
		jlb5.setFont(new Font("楷体",Font.BOLD,15));
		jlb5.setForeground(Color.blue);
		jlb5.setBounds(360,50,100,28);
		
		jlb6=new JLabel("　是否选修");
		jlb6.setFont(new Font("楷体",Font.BOLD,15));
		jlb6.setBounds(700,50,100,28);
		jlb6.setForeground(Color.blue);

		jlb7=new JLabel("　上课时间");
		jlb7.setFont(new Font("楷体",Font.BOLD,15));
		jlb7.setBounds(10,100,100,28);
		jlb7.setForeground(Color.blue);

		jlb14=new JLabel("上课地点");
		jlb14.setFont(new Font("楷体",Font.BOLD,15));
		jlb14.setBounds(360,100,100,28);
		jlb14.setForeground(Color.blue);

		jlb15=new JLabel("　截止时间");
		jlb15.setFont(new Font("楷体",Font.BOLD,15));
		jlb15.setBounds(700,100,100,28);
		jlb15.setForeground(Color.blue);
		
		jlb16=new JLabel("-");
		jlb16.setFont(new Font("楷体",Font.BOLD,20));
		jlb16.setBounds(845,100,45,28);
		jlb16.setForeground(Color.blue);
		
		jlb17=new JLabel("-");
		jlb17.setFont(new Font("楷体",Font.BOLD,20));
		jlb17.setBounds(920,100,45,28);
		jlb17.setForeground(Color.blue);
		
		jtf1=new JTextField(20);
		jtf1.setBounds(100,2,200,24);
		jtf1.setFont(new Font("楷体",Font.BOLD,15));
		jtf1.setForeground(Color.blue);
		
		jtf2=new JTextField(20);
		jtf2.setBounds(440,2,200,24);
		jtf2.setFont(new Font("楷体",Font.BOLD,15));
		jtf2.setForeground(Color.blue);
		
		sql="select * from teacher where 教师号='"+Tno+"'";
		tm=new TeacherModel(sql);
		
		jtf3=new JTextField(20);
		jtf3.setBounds(790,2,200,24);
		jtf3.setFont(new Font("楷体",Font.BOLD,15));
		jtf3.setForeground(Color.blue);
		jtf3.setText(tm.getValueAt(0,0).toString());
		jtf3.setEditable(false);
		
		jtf4=new JTextField(20);
		jtf4.setBounds(100,52,200,24);
		jtf4.setFont(new Font("楷体",Font.BOLD,15));
		jtf4.setForeground(Color.blue);
		jtf4.setText(tm.getValueAt(0,1).toString());
		jtf4.setEditable(false);
		
		jtf5=new JTextField(20);
		jtf5.setBounds(440,52,200,24);
		jtf5.setFont(new Font("楷体",Font.BOLD,15));
		jtf5.setForeground(Color.blue);
		
		jtf6=new JTextField(20);
		jtf6.setBounds(790,52,200,24);
		jtf6.setFont(new Font("楷体",Font.BOLD,15));
		jtf6.setForeground(Color.blue);
		
		jtf7=new JTextField(20);
		jtf7.setBounds(100,102,200,24);
		jtf7.setFont(new Font("楷体",Font.BOLD,15));
		jtf7.setForeground(Color.blue);
		
		jtf11=new JTextField(20);
		jtf11.setBounds(440,102,200,24);
		jtf11.setFont(new Font("楷体",Font.BOLD,15));
		jtf11.setForeground(Color.blue);
		
		jtf12=new JTextField(20);
		jtf12.setBounds(790,102,50,24);
		jtf12.setFont(new Font("楷体",Font.BOLD,15));
		jtf12.setForeground(Color.blue);
		
		jtf13=new JTextField(20);
		jtf13.setBounds(865,102,50,24);
		jtf13.setFont(new Font("楷体",Font.BOLD,15));
		jtf13.setForeground(Color.blue);
		
		jtf14=new JTextField(20);
		jtf14.setBounds(940,102,50,24);
		jtf14.setFont(new Font("楷体",Font.BOLD,15));
		jtf14.setForeground(Color.blue);	
		
		jb12=new JButton("发布选课");
		jb12.setFont(new Font("楷体",Font.BOLD,15));
		jb12.setForeground(Color.blue);
		jb12.setBounds(10,150,120,28);
		jb12.addActionListener(this);
		
		jb16=new JButton("重置");
		jb16.setFont(new Font("楷体",Font.BOLD,15));
		jb16.setForeground(Color.blue);
		jb16.setBounds(135,150,120,28);
		jb16.addActionListener(this);
		

		jp[2].add(jlb1);
		jp[2].add(jtf1);
		jp[2].add(jlb2);
		jp[2].add(jtf2);
		jp[2].add(jlb3);
		jp[2].add(jtf3);
		jp[2].add(jlb4);
		jp[2].add(jlb5);
		jp[2].add(jlb6);
		jp[2].add(jlb7);
		jp[2].add(jlb14);
		jp[2].add(jlb15);
		jp[2].add(jlb16);
		jp[2].add(jlb17);
		jp[2].add(jtf4);
		jp[2].add(jtf5);
		jp[2].add(jtf6);
		jp[2].add(jtf7);
		jp[2].add(jtf11);
		jp[2].add(jtf12);
		jp[2].add(jtf13);
		jp[2].add(jtf14);
		
		jp[2].add(jb12);
		jp[2].add(jb16);
		
		//jp[4]
		jp[3].setLayout(null);
		
		jlb9=new JLabel("请输入任课教师号");
		jlb9.setFont(new Font("楷体",Font.BOLD,15));
		jlb9.setForeground(Color.blue);
		jtf9=new JTextField(20);
		jb14=new JButton("查询");
		jb14.setFont(new Font("楷体",Font.BOLD,15));
		jb14.setForeground(Color.blue);
		jb14.addActionListener(this);

		jlb9.setBounds(50,520,160,28);
		jtf9.setBounds(180,520,170,24);
		jb14.setBounds(355,520,80,24);
		
		
		jlb10=new JLabel("请输入课程号");
		jlb10.setFont(new Font("楷体",Font.BOLD,15));
		jlb10.setForeground(Color.blue);
		jtf10=new JTextField(20);
		jb15=new JButton("查询");
		jb15.setFont(new Font("楷体",Font.BOLD,15));
		jb15.setForeground(Color.blue);
		jb15.addActionListener(this);

		jlb10.setBounds(535,520,130,28);
		jtf10.setBounds(635,520,170,24);
		jb15.setBounds(815,520,80,24);
		
		
		
		sql="select * from choosecourse where 任课教师号='"+Tno+"'";
		//System.out.println(sql);
		chm=new ChoModel(sql);
		jtb0=new JTable();
		jtb0.setModel(chm);
		jtb0.setFont(new Font("楷体",Font.BOLD,15));
		jtb0.setForeground(Color.blue);
		jsp0=new JScrollPane(jtb0);
		jsp0.setBounds(0,0,1050,400);

		jp[3].add(jlb9);
		jp[3].add(jlb10);
		jp[3].add(jtf9);
		jp[3].add(jtf10);
		jp[3].add(jb14);
		jp[3].add(jb15);
		jp[3].add(jsp0);
		
		//总布局
		jtb0.setRowHeight(28);
		jtb1.setRowHeight(28);
		jtb2.setRowHeight(28);
		jp1.setBounds(20,50,200,600);
		for(int i=0;i<jp.length;i++){
			jp[i].setBounds(250,50,1050,600);
			jp[i].setLayout(null);
			jp[i].setVisible(false);
		}
		
		jp[0].setVisible(true);
		this.add(jlb11);
		this.add(jlb12);
		jlb12.setVisible(false);
		jlb13.setVisible(false);
		this.add(jlb13);
		this.setLayout(null);
		this.add(jp1);
		for(int i=0;i<jp.length;i++){
			this.add(jp[i]);
		}
		this.add(jlb18);
		this.setSize(1300,700);
		this.setResizable(false);
		this.setTitle("学生选课管理系统");this.setBackground(Color.gray);
		this.setLocation(50,30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		Timer timer=new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				DeleteAuto da=new DeleteAuto(Tno);
			}
			
		},500);
		
		Timer timer2=new Timer();
		timer2.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new AddAuto();
			}
		},1000);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sql=null;
		if(e.getSource()==jb0){
			for(int i=0;i<jp.length;i++){
				jp[i].setVisible(false);
			}
			jp[3].setVisible(true);
			jlb11.setVisible(true);
			jlb12.setVisible(false);
			jlb13.setVisible(false);
			sql="select * from choosecourse where 任课教师号='"+Tno+"'";
			chm=new ChoModel(sql);
			jtb0.setModel(chm);
		}else if(e.getSource()==jb1){
			for(int i=0;i<jp.length;i++){
				jp[i].setVisible(false);
			}
			jp[0].setVisible(true);
			jlb12.setVisible(true);
			jlb11.setVisible(false);
			jlb13.setVisible(false);
		}else if(e.getSource()==jb2){
			for(int i=0;i<jp.length;i++){
				jp[i].setVisible(false);
			}
			jtf.setText("");
			jp[1].setVisible(true);
			jlb13.setVisible(true);
			jlb12.setVisible(false);
			jlb11.setVisible(false);
		}else if(e.getSource()==jb3){
			jtf1.setText("");
			jtf2.setText("");
			jtf5.setText("");
			jtf6.setText("");
			jtf7.setText("");
			jtf11.setText("");
			jtf12.setText("");
			jtf13.setText("");
			jtf14.setText("");
			for(int i=0;i<jp.length;i++){
				jp[i].setVisible(false);
			}
			jp[2].setVisible(true);
			jlb11.setVisible(false);
			jlb12.setVisible(false);
			jlb13.setVisible(false);
			cm=new CurModel();
			jtb0.setModel(cm);
		}else if(e.getSource()==jb4){
			new updataTeaPwd(this,"修改密码",true,tm,0);
		}else if(e.getSource()==jb5){
			String name=this.jtf.getText().trim();
			if(name.length()==0 && jtf8.getText().length()==0){
				sql="select * from SC where 任课教师号='"+this.Tno+"'";
			}else if(name.length()!=0 && jtf8.getText().length()==0){
				sql="select * from SC where 学号 like '%"+name+"%' and 任课教师号='"+this.Tno+"'";
			}else if(name.length()!=0 && jtf8.getText().length()!=0){
				sql="select * from SC where 学号 like '%"+name+"%' and 课程号 like'%"+jtf8.getText().trim()+"%' and 任课教师号='"+this.Tno+"'";
			}
			scm=new SCModel(sql);
			jtb2.setModel(scm);
		}else if(e.getSource()==jb13){
			String name=this.jtf8.getText().trim();
			if(name.length()==0 && jtf.getText().length()==0){
				sql="select * from SC where 任课教师号='"+this.Tno+"'";
			}else if(name.length()!=0 && jtf.getText().length()==0){
				sql="select * from SC where 课程号 like '%"+name+"%' and 任课教师号='"+this.Tno+"'";
			}else if(name.length()!=0 && jtf.getText().length()!=0){
				sql="select * from SC where 课程号 like '%"+name+"%' and 学号 like'%"+jtf.getText().trim()+"%' and 任课教师号='"+this.Tno+"'";
			}
			scm=new SCModel(sql);
			jtb2.setModel(scm);
		}else if(e.getSource()==jb14){
			String name=this.jtf9.getText().trim();
			if(name.length()==0 && jtf10.getText().length()==0){
				sql="select * from choosecourse";
			}else if(name.length()!=0 && jtf10.getText().length()==0){
				sql="select * from choosecourse where 任课教师号 like '%"+name+"%'";
			}else if(name.length()!=0 && jtf10.getText().length()!=0){
				sql="select * from choosecourse where 任课教师号 like '%"+name+"%' and 课程号 like'%"+jtf10.getText().trim()+"%'";
			}
			chm=new ChoModel(sql);
			jtb0.setModel(chm);
		}else if(e.getSource()==jb15){
			String name=this.jtf10.getText().trim();
			if(name.length()==0 && jtf9.getText().length()==0){
				sql="select * from choosecourse";
			}else if(name.length()!=0 && jtf9.getText().length()==0){
				sql="select * from choosecourse where 课程号 like '%"+name+"%'";
			}else if(name.length()!=0 && jtf9.getText().length()!=0){
				sql="select * from choosecourse where 课程号 like '%"+name+"%' and 任课教师号 like'%"+jtf9.getText().trim()+"%'";
			}
			chm=new ChoModel(sql);
			jtb0.setModel(chm);
		}else if(e.getSource()==jb6){
			if(mysno){
				sql="select * from SC where 任课教师号='"+this.Tno+"'order by 学号 ASC";
			}else{
				sql="select * from SC where 任课教师号='"+this.Tno+"'order by 学号 DESC";
			}
			mysno=!mysno;
			scm=new SCModel(sql);
			jtb2.setModel(scm);
			
		}else if(e.getSource()==jb7){
			if(mycno){
				sql="select * from SC where 任课教师号='"+this.Tno+"'order by 课程号 ASC";
			}else{
				sql="select * from SC where 任课教师号='"+this.Tno+"'order by 课程号 DESC";
			}
			mycno=!mycno;
			scm=new SCModel(sql);
			jtb2.setModel(scm);
		}else if(e.getSource()==jb8){
			if(mygrade){
				sql="select * from SC where 任课教师号='"+this.Tno+"' order by 成绩,课程号 DESC";
			}else{
				sql="select * from SC where 任课教师号='"+this.Tno+"' order by 成绩,课程号 ASC";
			}
			mygrade=!mygrade;
			scm=new SCModel(sql);
			jtb2.setModel(scm);
		}else if(e.getSource()==jb11){
			int rowNum=this.jtb2.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"请选择一行");
			}else{
				new updataGrade(this,"成绩修改",true,scm,rowNum);
				scm=new SCModel("null",Tno);
				jtb2.setModel(scm);
			}
		}else if(e.getSource()==jb12){
			if(jtf1.getText().length()!=0 && jtf2.getText().length()!=0 && jtf5.getText().length()!=0 && jtf6.getText().length()!=0 && jtf7.getText().length()!=0 && jtf11.getText().length()!=0 && jtf12.getText().length()!=0 && jtf13.getText().length()!=0 && jtf14.getText().length()!=0){
				
				if(jtf6.getText().equals("1") && Float.parseFloat(jtf5.getText())<1){
						JOptionPane.showMessageDialog(this,"选修课程学分不得低于1学分");
				}else{
					sql="insert into choosecourse values(?,?,?,?,?,?,?,?,?,?)";
					String Time=jtf12.getText().trim()+"-"+jtf13.getText().trim()+"-"+jtf14.getText().trim();
					String[] paras={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText(),jtf11.getText(),Time,"0"};
					chm=new ChoModel();
					if(cm.updateCourse(sql, paras)!=true){
						JOptionPane.showMessageDialog(this, "发布失败");
					}else{
						jtb0.setModel(chm);
						JOptionPane.showMessageDialog(this, "发布成功");
						jtf1.setText("");
						jtf2.setText("");
						jtf5.setText("");
						jtf6.setText("");
						jtf7.setText("");
						jtf11.setText("");
						jtf12.setText("");
						jtf13.setText("");
						jtf14.setText("");
					}
				}
			}else{
				if(jtf1.getText().length()==0){
					JOptionPane.showMessageDialog(this,"课程号不能为空");
				}else if(jtf2.getText().length()==0){
					JOptionPane.showMessageDialog(this,"课程名不能为空");
				}else if(jtf3.getText().length()==0){
					JOptionPane.showMessageDialog(this,"任课教师号不能为空");
				}else if(jtf4.getText().length()==0){
					JOptionPane.showMessageDialog(this,"任课教师不能为空");
				}else if(jtf5.getText().length()==0){
					JOptionPane.showMessageDialog(this,"学分不能为空");
				}else if(jtf6.getText().length()==0){
					JOptionPane.showMessageDialog(this,"是否选修不能为空");
				}else if(jtf7.getText().length()==0){
					JOptionPane.showMessageDialog(this,"上课时间不能为空");
				}else if(jtf11.getText().length()==0){
					JOptionPane.showMessageDialog(this,"上课地点不能为空");
				}else{
					JOptionPane.showMessageDialog(this,"时间不正确");
				}
			}
		}else if(e.getSource()==jb16){
			jtf1.setText("");
			jtf2.setText("");
			jtf5.setText("");
			jtf6.setText("");
			jtf7.setText("");
			jtf11.setText("");
			jtf12.setText("");
			jtf13.setText("");
			jtf14.setText("");
		}
	}

	private boolean parseFloat(String text) {
		// TODO Auto-generated method stub
		return false;
	}	
}