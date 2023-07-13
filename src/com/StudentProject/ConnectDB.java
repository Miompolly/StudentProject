package com.StudentProject;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectDB {

	String dburl= "jdbc:mysql://localhost:3306/StudentsDB";
	String dbuser="root";
	String dbpwd="";
	Connection cnx;
	public Connection dbConnection() {
	try {
		cnx = DriverManager.getConnection(dburl,dbuser,dbpwd);
		if(cnx!=null) {
			JOptionPane.showMessageDialog(null,"Db connected Successfully","Db found",1);
		}
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return cnx;

}
	public void addUser(String name,String email,String username,String userType,String password ) throws SQLException {
		String sql="INSERT INTO users(Name,Email,Username,UserType,Password) VALUES (?,?,?,?,?)";
		PreparedStatement st = cnx.prepareStatement(sql);
		st.setString(1,name);
		st.setString(2,email);
		st.setString(3,username);
		st.setString(4,userType);
		st.setString(5,password);
		int row=st.executeUpdate();
		if(row>0) {
			JOptionPane.showMessageDialog(null, "Record insterted successfully");
		}
		
	}
	public ResultSet getUser(String username,String password) {
		String sql="SELECT * FROM users WHERE Username=? AND Password=?";
		try {
			PreparedStatement st=cnx.prepareStatement(sql);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet row = st.executeQuery();
			if(row.next()) {
				JOptionPane.showMessageDialog(null, "Access granted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return row;
	}
	
	
	
	
	
	
	
	
}