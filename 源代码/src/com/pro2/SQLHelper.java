package com.pro2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLHelper {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stmt=null;
	String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=pro2";
	String user="root";
	String pwd="root";
	//把增删改和在一起
	
	//关闭数据资源
	public void  close(){
		try{
			if(rs!=null) rs.close();
			if(con!=null) con.close();
			if(ps!=null) ps.close();
		}catch(Exception e){ 
			e.printStackTrace();
		}
	}
	
	//查询数据库操作
	public ResultSet QueryExecute(String sql,String []paras){
		try{
			Class.forName(JDriver);
			con=DriverManager.getConnection(url,user,pwd);
			ps=con.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			rs=ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return rs;
	}
	
	
	
	public boolean updExecute(String sql,String[] paras){
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
			}
		}catch(Exception e){
			b=false;
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
}
