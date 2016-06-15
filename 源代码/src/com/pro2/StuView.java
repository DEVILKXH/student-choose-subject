/**
 * 学生操作界面
 */

package com.pro2;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.DefaultCellEditor;

import java.util.*;
import java.util.Timer;
import java.awt.event.*;
import java.sql.*;

public class StuView extends JFrame implements ActionListener{
	
	Vector rowData,columnNames;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
		
	JPanel jp1,jp2,jp3,jp4,jp5;
	JButton jb1,jb2,jb3,jb4,jb5,jb7,jb8,jb9;
	JRadioButton jrb1,jrb2,jrb3;
	JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6;
	JTable jtb,jtb2,jtb3,jtb4;
	JScrollPane jsp,jsp2,jsp3,jsp4;
	
	String Sno;
	boolean fail=false;
	
	StuModel sm=null;
	CurModel cm=null;
	RootModel rm=null;
	ChoModel chm=null;
	SCModel scm=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuView st=new StuView("011302104");
	}
	public StuView(String name){
		this.Sno=name;
		jlb6=new JLabel("欢迎你:"+name);
		jlb6.setBounds(20,10,400,30);
		jlb6.setFont(new Font("楷体",Font.BOLD,24));
		jlb6.setForeground(Color.blue);
		
		Font myfont=new Font("楷体",Font.BOLD,15);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		
		jb1=new JButton("个人信息");
		jb1.setFont(myfont);
		jb1.setForeground(Color.BLUE);
		jb1.addActionListener(this);
		jb1.setBounds(50,0,120,28);
		jb2=new JButton("开始选课");
		jb2.setFont(myfont);
		jb2.setForeground(Color.BLUE);
		jb2.addActionListener(this);
		jb2.setBounds(50,100,120,28);
		jb3=new JButton("我的选课");
		jb3.setFont(myfont);
		jb3.setForeground(Color.BLUE);
		jb3.addActionListener(this);
		jb3.setBounds(50,50,120,28);
		
		jb5=new JButton("预选课程");
		jb5.setFont(myfont);
		jb5.setForeground(Color.BLUE);
		jb5.addActionListener(this);
		jb5.setBounds(50,150,120,28);

		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb5);
		
		//个人信息

		String sql="select * from student where 学号='"+this.Sno+"'";
		sm=new StuModel(sql);
		jtb=new JTable(sm);
		jtb.setFont(myfont);
		jtb.setForeground(Color.BLUE);
		jtb.setRowHeight(28);
		jsp=new JScrollPane(jtb);
		jsp.setBounds(0,50,1050,100);
		jlb1=new  JLabel("个人信息表");
		jlb1.setBounds(400,0,500,50);
		jlb1.setFont(new Font("楷体",Font.BOLD,45));
		jlb1.setForeground(Color.blue);

		jb4=new JButton("修改密码");
		jb4.setFont(myfont);
		jb4.setForeground(Color.BLUE);
		jb4.setBounds(0,170,120,28);
		jb4.addActionListener(this);
		
		jp2.add(jsp);
		jp2.add(jb4);
		jp2.add(jlb1);
		
		//开始选课
		sql="select * from choosecourse";
		chm=new ChoModel();
		
		jtb2=new JTable();
		
		jtb2=chm.chooseCur(sql);
		
		
		jtb2.setFont(myfont);
		jtb2.setForeground(Color.blue);
		jtb2.setRowHeight(28);

        
		jsp2=new JScrollPane(jtb2);
		jsp2.setBounds(0,50,1050,400);
		
		jlb5=new JLabel("选课信息表");
		jlb5.setBounds(400,0,500,50);
		jlb5.setFont(new Font("楷体",Font.BOLD,45));
		jlb5.setForeground(Color.blue);
		

		jb8=new JButton("选课");
		jb8.setBounds(400,500,120,28);
		jb8.setFont(new Font("楷体",Font.BOLD,15));
		jb8.setForeground(Color.blue);
		jb8.addActionListener(this);
		jb9=new JButton("重置");
		jb9.setBounds(600,500,120,28);
		jb9.setFont(new Font("楷体",Font.BOLD,15));
		jb9.setForeground(Color.blue);
		jb9.addActionListener(this);
		
		if(jtb2.getRowCount()==0){
			jb8.setEnabled(false);
			fail=false;
		}
		
		jp3.add(jsp2);
		jp3.add(jlb5);
		jp3.add(jb8);
		jp3.add(jb9);
		
		//查看我的选课
		scm=new SCModel("select * from SC where 学号='"+Sno+"'");
		jtb3=new JTable(scm);
		jtb3.setFont(myfont);
		jtb3.setForeground(Color.BLUE);
		jtb3.setRowHeight(28);
		jsp3=new JScrollPane(jtb3);
		jp3.add(jsp3);
		jsp3.setBounds(0,50,1050,500);
		
		jlb3=new JLabel("我的课程表");
		jlb3.setBounds(400,0,500,50);
		jlb3.setFont(new Font("楷体",Font.BOLD,45));
		jlb3.setForeground(Color.blue);

		jp4.add(jsp3);
		jp4.add(jlb3);
		
		//jp5
		scm=new SCModel("select * from SC2 where 学号='"+Sno+"'");
		jtb4=new JTable(scm);
		jtb4.setFont(myfont);
		jtb4.setForeground(Color.BLUE);
		jtb4.setRowHeight(28);
		jsp4=new JScrollPane(jtb4);
		jp4.add(jsp4);
		jsp4.setBounds(0,50,1050,500);
		
		jlb4=new JLabel("预选课程表");
		jlb4.setBounds(400,0,500,50);
		jlb4.setFont(new Font("楷体",Font.BOLD,45));
		jlb4.setForeground(Color.blue);
		
		jb7=new JButton("退选");
		jb7.setBounds(0,570,80,28);
		jb7.setFont(new Font("楷体",Font.BOLD,15));
		jb7.setForeground(Color.blue);
		jb7.addActionListener(this);
		
		jp5.add(jsp4);
		jp5.add(jlb4);
		jp5.add(jb7);
		
		//
		jp1.setLayout(null);
		jp1.setBounds(0,50,200,600);
		
		jp2.setBounds(250,0,1150,600);
		jp2.setLayout(null);
		
		jp3.setBounds(250,0,1150,600);
		jp3.setVisible(false);
		jp3.setLayout(null);
		
		jp4.setBounds(250,0,1150,600);
		jp4.setVisible(false);
		jp4.setLayout(null);
		
		jp5.setBounds(250,0,1150,600);
		jp5.setVisible(false);
		jp5.setLayout(null);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jlb6);
		this.setLayout(null);
		this.setTitle("学生选课管理系统");
		this.setBackground(Color.gray);
		this.setSize(1300,700);
		this.setLocation(50,20);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
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
		if(e.getSource()==jb1){
			if(fail==true){
				int yes=JOptionPane.showConfirmDialog(this,"是否放弃选课");
				if(yes==0){
					fail=false;
					jp2.setVisible(true);
					jp3.setVisible(false);
					jp4.setVisible(false);
					jp5.setVisible(false);
				}
			}else{
				jp2.setVisible(true);
				jp3.setVisible(false);
				jp4.setVisible(false);
				jp5.setVisible(false);
			}
		}else if(e.getSource()==jb2){
			fail=true;
			jp3.setVisible(true);
			jp2.setVisible(false);
			jp4.setVisible(false);
			jp5.setVisible(false);
			if(jtb2.getRowCount()==0){
				JOptionPane.showMessageDialog(this,"现在不是选课时间");
				fail=false;
			}
		}else if(e.getSource()==jb3){
			if(fail==true){
				int yes=JOptionPane.showConfirmDialog(this,"是否放弃选课");
				if(yes==0){
					fail=false;
					jp4.setVisible(true);
					jp3.setVisible(false);
					jp2.setVisible(false);
					jp5.setVisible(false);
				}
			}else{
				jp4.setVisible(true);
				jp3.setVisible(false);
				jp2.setVisible(false);
				jp5.setVisible(false);
			}
		}else if(e.getSource()==jb4){
			rm=new RootModel("select * from student where 学号='"+Sno+"'");
			new updataStuPwd(this,"修改密码",true,rm,0);
		}else if(e.getSource()==jb5){
			if(fail==true){
				int yes=JOptionPane.showConfirmDialog(this,"是否放弃选课");
				if(yes==0){
					fail=false;
					jp5.setVisible(true);
					jp3.setVisible(false);
					jp4.setVisible(false);
					jp2.setVisible(false);
				}
			}else{
				jp5.setVisible(true);
				jp3.setVisible(false);
				jp4.setVisible(false);
				jp2.setVisible(false);
			}
		}else if(e.getSource()==jb7){
			int rowNum=this.jtb4.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"请选择要退选的科目");
			}else{
				int success=JOptionPane.showConfirmDialog(this, "一旦退选无法恢复，是否确认退选");
				if(success==0){
					String sql="update choosecourse set 学生数=学生数-1 where 课程号 in (select 课程号 from sc2)";
					SCModel temp=new SCModel();
					temp.updateSC(sql);
					
					String Cno=(String)jtb4.getValueAt(rowNum,1);
					String Sno=(String)jtb4.getValueAt(rowNum,0);
					sql="delete from SC2 where 学号=? and 课程号=?";
					String[] paras={Sno,Cno};
					temp=new SCModel();
					if(temp.updateSC(sql, paras)!=true){ 
						JOptionPane.showMessageDialog(this,"退选失败");
					}else{
						JOptionPane.showMessageDialog(this,"退选成功");
					}
					scm=new SCModel("select * from SC2 where 学号='"+Sno+"'");
					jtb4.setModel(scm);
				}else{
					
				}
			}
		}else if(e.getSource()==jb8){
			int yes=JOptionPane.showConfirmDialog(this,"确认选课");
			if(yes==0){
				fail=false;
				String sql="update choosecourse set 学生数=学生数-1 where 课程号 in (select 课程号 from sc2)";
				SCModel temp=new SCModel();
				temp.updateSC(sql);
				String []paras1={Sno};
				sql="delete from SC2 where 学号=?";
				temp.updateSC(sql, paras1);
				for(int rowNum=0;rowNum<jtb2.getRowCount();rowNum++){
					if(jtb2.getValueAt(rowNum, 0).equals(true)){
						sql="insert into SC2 values(?,?,?,?,?,?,?,?,?,?);";
						String[] paras={Sno,jtb2.getValueAt(rowNum, 1).toString(),jtb2.getValueAt(rowNum, 2).toString(),jtb2.getValueAt(rowNum, 3).toString(),jtb2.getValueAt(rowNum, 4).toString(),jtb2.getValueAt(rowNum, 5).toString(),jtb2.getValueAt(rowNum, 7).toString(),jtb2.getValueAt(rowNum, 8).toString(),null,null};
						temp=new SCModel();
						temp.updateSC(sql, paras);
					}
				}
				for(int rowNum=0;rowNum<jtb2.getRowCount();rowNum++){
					if(jtb2.getValueAt(rowNum, 0).equals(true)){
						sql="update choosecourse set 学生数=学生数+1 where 课程号=?";
						String[] paras={jtb2.getValueAt(rowNum, 1).toString()};
						temp=new SCModel();
						temp.updateSC(sql, paras);
					}	
				}
			}
			scm=new SCModel("select * from sc2 where 学号='"+Sno+"'");
			jtb4.setModel(scm);
		}else if(e.getSource()==jb9){
			fail=false;
			for(int rowNum=0;rowNum<jtb2.getRowCount();rowNum++){
				jtb2.setValueAt(false,rowNum,0);
			}
		}
	}
}


