package com.Black_Knight;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nameTextBox,fnameTextBox,addressTextBox,stateTextBox,cityTextBox,pincodeTextBox,emailTextBox;
	JButton next;
	JRadioButton male,female,married,unmarried;
	
	public SignupOne() {
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L)+ 1000L);
		
		setTitle("NEW ACCOUNT APPLICATION - PAGE 1");
		JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);
		//////////////////////////////////////////////////////////////
		JLabel name = new JLabel("Name :");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextBox = new JTextField();
		nameTextBox.setFont(new Font("Raleway",Font.BOLD,14));
		nameTextBox.setBounds(300, 140, 400, 30);
		add(nameTextBox);
        /////////////////////////////////////////////////////////////		
		JLabel fname = new JLabel("Father's Name :");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		fnameTextBox = new JTextField();
		fnameTextBox.setFont(new Font("Raleway",Font.BOLD,14));
		fnameTextBox.setBounds(300, 190, 400, 30);
		add(fnameTextBox);
        /////////////////////////////////////////////////////////////
		
		JLabel dob = new JLabel("Date Of Birth :");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
//		JDateChooser date = new JDateChooser();
//		date.setBounds(300, 240, 200, 30);
//		date.setForeground(Color.BLACK);
		
		////////////////////////////////////////////////////////////
		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBackground(Color.WHITE);
		male.setBounds(300, 290, 60, 30);
		add(male);
		
		female = new JRadioButton("female");
		female.setBounds(450, 290, 120, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		//////////////////////////////////////////////////////////
		
		JLabel email = new JLabel("Email Address :");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailTextBox = new JTextField();
		emailTextBox.setFont(new Font("Raleway",Font.BOLD,14));
		emailTextBox.setBounds(300, 340, 400, 30);
		add(emailTextBox);
        /////////////////////////////////////////////////////////////
		
		JLabel marital = new JLabel("Marital Status :");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBackground(Color.WHITE);
		married.setBounds(300, 390, 80, 30);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBackground(Color.WHITE);
		unmarried.setBounds(450, 390, 120, 30);
		add(unmarried);
		
		ButtonGroup stutas = new ButtonGroup();
		stutas.add(married);
		stutas.add(unmarried);
		//////////////////////////////////////////////////////////
		
		JLabel address = new JLabel("Address :");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		addressTextBox = new JTextField();
		addressTextBox.setFont(new Font("Raleway",Font.BOLD,14));
		addressTextBox.setBounds(300, 440, 400, 30);
		add(addressTextBox);
        /////////////////////////////////////////////////////////////
		
		JLabel city = new JLabel("City :");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		cityTextBox = new JTextField();
		cityTextBox.setFont(new Font("Raleway",Font.BOLD,14));
		cityTextBox.setBounds(300, 490, 400, 30);
		add(cityTextBox);
        /////////////////////////////////////////////////////////////
		
		JLabel state = new JLabel("State :");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		stateTextBox = new JTextField();
		stateTextBox .setFont(new Font("Raleway",Font.BOLD,14));
		stateTextBox .setBounds(300, 540, 400, 30);
		add(stateTextBox );
        /////////////////////////////////////////////////////////////
		
		JLabel pincode = new JLabel("Pincode :");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		pincodeTextBox = new JTextField();
		pincodeTextBox.setFont(new Font("Raleway",Font.BOLD,14));
		pincodeTextBox.setBounds(300, 590, 400, 30);
		add(pincodeTextBox);
        /////////////////////////////////////////////////////////////
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Relway",Font.BOLD,14));
		next.setBounds(620,660 , 80, 30);
		next.addActionListener(this);
		add(next);
		
		////////////////////////////////////////////////////////////
		getContentPane().setBackground(Color.WHITE);  
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String formno = ""+random;//long concat into string
		String name = nameTextBox.getText();
		String fname = fnameTextBox.getText();
		String dob = "12-12-12";
//		String dob = ((JTextField)JDateChooser.getDateEditor.getUiComponent()).getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		}else {
			gender = "Female";
		}
		String email = emailTextBox.getText();
		String marital =null;
		if (married.isSelected()) {
			marital = "Married";
			
		}else {
			marital = "Unmarried";
		}
		String address = addressTextBox.getText();
		String city = cityTextBox.getText();
		String state = stateTextBox.getText();
		String pin = pincodeTextBox.getText();
		/////////////////////////////////////////////////////////
		//JDBC
		try {
			DatabaseConnectivity table1 = new DatabaseConnectivity();
			String insert = "insert into signup values (?,?,?,?,?,?,?,?,?,?,?)";
			//		PreparedStatement insertstmt=table1.s.prepareStatement(insert);
			table1.s1 = table1.con.prepareStatement(insert);
			table1.s1.setString(1, formno);
			table1.s1.setString(2, name);
			table1.s1.setString(3, fname);
			table1.s1.setString(4, dob);
			table1.s1.setString(5, gender);
			table1.s1.setString(6, email);
			table1.s1.setString(7, marital);
			table1.s1.setString(8, address);
			table1.s1.setString(9, city);
			table1.s1.setString(10, state);
			table1.s1.setString(11, pin);
			
			table1.s1.executeUpdate();
			
			setVisible(false);
			new SignupTwo(formno).setVisible(true);  

			
//			int updateRowCount=table1.s1.executeUpdate();
//			System.out.println("DataBase Connected "+ updateRowCount);
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
		}
		
	}

	public static void main(String[] args) {
		new SignupOne();
		
		
	}


}
