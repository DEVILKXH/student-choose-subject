package com.pro2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class AddAuto extends JOptionPane{

	CurModel cm=null;
	SCModel scm=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddAuto aao=new AddAuto();
	}
	public AddAuto(){
		int year=Calendar.getInstance().get(Calendar.YEAR);
		int month=Calendar.getInstance().get(Calendar.MONTH)+1;
		int date=Calendar.getInstance().get(Calendar.DATE);
		String insdate=year+"-"+month+"-"+date;
		
		String sql="delete from sc2 where 课程号 in (select 课程号 from choosecourse where 截止时间<'"+insdate+"' and 学生数<60)";
		String sql2="delete from choosecourse where 截止时间<'"+insdate+"' and 学生数<60";
		String sql3="select 课程号,课程名 from choosecourse where 截止时间<'"+insdate+"' and 学生数<60";
		
		String JDriver= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pro2";
		String user="root";
		String password="root";
		try{
			Class.forName(JDriver);
		}catch (ClassNotFoundException e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog( null , "数据库连接错误" ,"提示" , JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			Connection con=DriverManager.getConnection(connectDB,user,password);
			PreparedStatement ps=con.prepareStatement(sql3);
			ResultSet rs=ps.executeQuery();
			ResultSet rs2=null;
			while(rs.next()){
				String message="课程号: "+rs.getString(1)+"　课程名: "+rs.getString(2)+" 由于学生人数少于60人，不予开课";
				JOptionPane.showMessageDialog(this,message);
			}
			
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			ps=con.prepareStatement(sql2);
			ps.executeUpdate();
			
			
			String mysql="select count(*) from choosecourse";
			ps=con.prepareStatement(mysql);
			rs2=ps.executeQuery();
			if(rs2!=null){
				String sql4="insert into course values(?,?,?,?,?,?,?,?)";
				String sql5="select * from choosecourse where 截止时间<'"+insdate+"' and 学生数>60";	
				
				ps=con.prepareStatement(sql5);
				rs=ps.executeQuery();
				while(rs.next()){
					String[] paras={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
					cm=new CurModel();
					cm.updateCourse(sql4, paras);
				}
			}
			
			
			String mysql2="select count(*) from SC2";
			ps=con.prepareStatement(mysql);
			rs2=ps.executeQuery();
			if(rs2!=null){				
				String sql8="insert into SC values(?,?,?,?,?,?,?,?,?,?)";
				String sql7="select * from SC2";
				
				ps=con.prepareStatement(sql7);
				rs=ps.executeQuery();
				while(rs.next()){
					String[] paras={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
					scm=new SCModel();
					scm.updateSC(sql8, paras);
				}
				String sql9="delete from sc2";
				ps=con.prepareStatement(sql9);
				ps.executeUpdate();
			}
			
			String sql6="delete from choosecourse where 截止时间<'"+insdate+"' and 学生数>60";
			ps=con.prepareStatement(sql6);
			ps.executeUpdate();
			
			
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog( null , "数据库连接错误" ,"提示" , JOptionPane.ERROR_MESSAGE);
		}
	}
}
