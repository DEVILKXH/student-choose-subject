/**
 * 这是我的一个SC表的模型
 */
package com.pro2;
import javax.swing.table.*;

import java.sql.*;
import java.util.*;

public class SCModel2 extends AbstractTableModel{

	Vector rowData,columnNames;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stmt=null;
	String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=pro2";
	String user="root";
	String pwd="root";

	String Tno;
	
	public void init(String sql){
		if(sql.equals("null")){
			sql="select * from SC2 where 教师号='"+Tno+"' Order by 学号 ASC";
		}
		if(sql.equals("")){
			sql="select * from SC Order by 学号  ASC";
		}
		columnNames=new Vector();
		columnNames.add("学号");
		columnNames.add("课程号");
		columnNames.add("课程名");
		columnNames.add("任课教师号");
		columnNames.add("任课教师");
		columnNames.add("学分");
		columnNames.add("上课时间");
		columnNames.add("上课地点");
		columnNames.add("考试时间");
		columnNames.add("成绩");
		rowData=new Vector();
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pro2","root","root");
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getString(7));
				hang.add(rs.getString(8));
				hang.add(rs.getString(9));
				hang.add(rs.getString(10));
				
				rowData.add(hang);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null) rs.close();
				if(con!=null) con.close();
				if(ps!=null) ps.close();
			}catch(Exception e){ 
				e.printStackTrace();
			}
		}
	}
	
	
	public boolean updateSC(String sql,String []paras){
		boolean b=true;
		try{
			Class.forName(JDriver);
			con=DriverManager.getConnection(url,user,pwd);
			ps=con.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			if(ps.executeUpdate()!=1){
				b=false;
				//System.out.println("out");
			}
		}catch(Exception e){
			b=false;
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null) rs.close();
				if(con!=null) con.close();
				if(ps!=null) ps.close();
			}catch(Exception e){ 
				e.printStackTrace();
			}
		}
		return b;
	}
	
	public SCModel2(String sql){
		this.init(sql);
	}
	
	
	public SCModel2(String ctrl,String Tno){
		this.Tno=Tno;
		this.init(ctrl);
	}
	
	public SCModel2(){
		this.init("");
	}
	

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(row)).get(column);
	}
	
}
