package com.pro2;
import javax.swing.JOptionPane;
import javax.swing.table.*;

import java.sql.*;
import java.util.*;


public class DeleteAuto extends JOptionPane{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteAuto da=new DeleteAuto("T011302103");
	}
	public DeleteAuto(String Tno){
		int year=Calendar.getInstance().get(Calendar.YEAR);
		int month=Calendar.getInstance().get(Calendar.MONTH)+1;
		int date=Calendar.getInstance().get(Calendar.DATE);
		String insdate=year+"-"+month+"-"+date;
		
		String sql="delete from sc2 where 课程号 in (select 课程号 from choosecourse where 截止时间<'"+insdate+"' and 学生数<60 and 任课教师号='"+Tno+"')";
		String sql2="delete from choosecourse where 截止时间<'"+insdate+"' and 学生数<60 and 任课教师号='"+Tno+"'";
		String sql3="select 课程号,课程名 from choosecourse where 截止时间<'"+insdate+"' and 学生数<60 and 任课教师号='"+Tno+"'";
	
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
			while(rs.next()){
				String message="课程号: "+rs.getString(1)+"　课程名: "+rs.getString(2)+" 由于学生人数少于60人，不予开课";
				JOptionPane.showMessageDialog(this,message);
			}

			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			ps=con.prepareStatement(sql2);
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
