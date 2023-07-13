package com.StudentProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class signUpForm extends JFrame implements ActionListener {

	JFrame signup=new JFrame();
	
	JLabel jlName=new JLabel("Name");
	JLabel jlEmail=new JLabel("Email");
	JLabel jlUsername=new JLabel("Username");
	JLabel jlUserType=new JLabel("UserType");
	JLabel jlPwd=new JLabel("Password");
	
	
	JTextField tfName=new JTextField();
	JTextField tfEmail=new JTextField();
	JTextField tfUsername=new JTextField();
	JTextField tfUserType=new JTextField();
	JPasswordField pfPwd=new JPasswordField();
	
	
	JButton btnRegister=new JButton("Register");
	JButton btnClear=new JButton("Clear");
	
	String name,email,username,userType,password;
	
	signUpForm(){
		setForm();
		mapObj();
		setObj();
		setObAction();
	}
	private void setObAction() {
		btnRegister.addActionListener(this);
		btnClear.addActionListener(this);
		
		
	}
	private void mapObj() {
		signup.add(jlName);
		signup.add(jlEmail);
		signup.add(jlUsername);
		signup.add(jlUserType);
		signup.add(jlPwd);
		
		signup.add(tfName);
		signup.add(tfEmail);
		signup.add(tfUsername);
		signup.add(tfUserType);
		signup.add(pfPwd);
		signup.add(btnRegister);
		signup.add(btnClear);
		
	}
	private void setObj() {
		jlName.setBounds(50,50,100,30);
		jlEmail.setBounds(50,90,100,30);
		jlUsername.setBounds(50,130,100,30);
		jlUserType.setBounds(50,170,100,30);
		jlPwd.setBounds(50,210,100,30);
		
		tfName.setBounds(150,50,200,30);
		tfEmail.setBounds(150,90,200,30);
		tfUsername.setBounds(150,130,200,30);
		tfUserType.setBounds(150,170,200,30);
		pfPwd.setBounds(150,210,200,30);
		btnRegister.setBounds(150,250,95,30);
		btnClear.setBounds(255,250,95,30);
		
		
		
	}
	private void setForm() {
		signup.setTitle("Student SignUp Form");
		signup.setBounds(500,100,400,350);
		signup.setDefaultCloseOperation(3);
		signup.getContentPane().setLayout(null);;
		signup.setVisible(true);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnClear) {
			tfName.setText("");
			tfEmail.setText("");
			tfUsername.setText("");
			tfUserType.setText("");
			pfPwd.setText("");
		}else if(e.getSource()==btnRegister) {
			ConnectDB db= new ConnectDB();
			db.dbConnection();
			
			name=tfName.getText();
			email=tfEmail.getText();
			username=tfUsername.getText();
			userType=tfUserType.getText();
			password=pfPwd.getText();
			
			try {
				db.addUser(name,email,username,userType,password);
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}

}
