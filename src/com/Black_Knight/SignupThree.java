package com.Black_Knight;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignupThree extends JFrame implements ActionListener{
	

	
	JButton submit,cancel;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JRadioButton accountType1,accountType2,accountType3,accountType4;
	String formno;
	public SignupThree(String formno) {
		setLayout(null);
		
		this.formno = formno;
		setTitle("NEW ACCOUNT APPLICATION - PAGE 3");
		

		
		JLabel additionalDetails = new JLabel("Page 3: Account Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		//////////////////////////////////////////////////////////////
		JLabel type = new JLabel("Account Type :");
		type.setFont(new Font("Raleway",Font.BOLD,20));
		type.setBounds(100, 140, 200, 30);
		add(type);
		
		
		accountType1 = new JRadioButton("Saving Account");
		accountType1.setBackground(Color.WHITE);
		accountType1.setBounds(100, 180, 250, 20);
		add(accountType1);
		
		accountType2 = new JRadioButton("Salary Account");
		accountType2.setBounds(350, 180, 250, 30);
		accountType2.setBackground(Color.WHITE);
		add(accountType2);
		
		accountType3 = new JRadioButton("Current Account");
		accountType3.setBounds(100, 220, 250, 30);
		accountType3.setBackground(Color.WHITE);
		add(accountType3);
		
		accountType4 = new JRadioButton("Loan Account");
		accountType4.setBounds(350, 220, 250, 30);
		accountType4.setBackground(Color.WHITE);
		add(accountType4);
		
		ButtonGroup accountTypeGroup = new ButtonGroup();
		accountTypeGroup.add(accountType1);
		accountTypeGroup.add(accountType2);
		accountTypeGroup.add(accountType3);
		accountTypeGroup.add(accountType4);
		

		
        /////////////////////////////////////////////////////////////		
		JLabel cardNumber = new JLabel("Card Number :");
		cardNumber.setFont(new Font("Raleway",Font.BOLD,20));
		cardNumber.setBounds(100, 300, 200, 30);
		add(cardNumber);
		
		JLabel Number = new JLabel("XXXX-XXXX-XXXX-2312");
		Number.setFont(new Font("Raleway",Font.BOLD,20));
		Number.setBounds(330, 300, 300, 30);
		add(Number);
		
		JLabel info1 = new JLabel("Your 16 Digit Card Number");
		info1.setFont(new Font("Raleway",Font.BOLD,15));
		info1.setBounds(100, 330, 300, 30);
		add(info1);

        /////////////////////////////////////////////////////////////
		
		JLabel pinNumber = new JLabel("PIN :");
		pinNumber.setFont(new Font("Raleway",Font.BOLD,20));
		pinNumber.setBounds(100, 370, 200, 30);
		add(pinNumber);
		
		JLabel cardPinNumber = new JLabel("XXXX");
		cardPinNumber.setFont(new Font("Raleway",Font.BOLD,20));
		cardPinNumber.setBounds(330, 370, 300, 30);
		add(cardPinNumber);
		
		JLabel info2 = new JLabel("Your 4 Digit Password");
		info2.setFont(new Font("Raleway",Font.BOLD,15));
		info2.setBounds(100, 400, 300, 30);
		add(info2);
		

		
		////////////////////////////////////////////////////////////
		JLabel services = new JLabel("Services Required :");
		services.setFont(new Font("Raleway",Font.BOLD,20));
		services.setBounds(100, 450, 400, 30);
		add(services);
		
		c1 = new JCheckBox("ATM Card");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		c1.setBounds(100, 500, 200, 30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		c2.setBounds(350, 500, 200, 30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		c3.setBounds(100, 550, 200, 30);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		c4.setBounds(350, 550, 200, 30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway",Font.BOLD,16));
		c5.setBounds(100, 600, 200, 30);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway",Font.BOLD,16));
		c6.setBounds(350, 500, 200, 30);
		add(c6);
		
		c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway",Font.BOLD,12));
		c7.setBounds(100, 680, 600, 30);
		add(c7);
		
		
        /////////////////////////////////////////////////////////////
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Releway",Font.BOLD,14));
		submit.setBounds(250, 720, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Releway",Font.BOLD,14));
		cancel.setBounds(420, 720, 100, 30);
		cancel.addActionListener(this);
		add(cancel);

		


		
		////////////////////////////////////////////////////////////
		getContentPane().setBackground(Color.WHITE);  
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		if(e.getSource()== submit) {
			String account = null;
			if(accountType1.isSelected()) {
				account = "Saving Account";
			}else if(accountType2.isSelected()) {
				account = "Salary Account";
			}else if(accountType3.isSelected()) {
				account = "Current Account";
			}else if(accountType4.isSelected()) {
				account = "Loan Account";
			}
			
			Random random = new Random();
			String cardNo ="" + Math.abs((random.nextLong() % 90000000L) +5040936000000000L);
			String pinNo ="" + Math.abs((random.nextLong() % 9000L) +1000L);
			
			String facility = "";
			if(c1.isSelected()) {
				facility = facility + "ATM Card";
			}else if(c2.isSelected()) {
				facility = facility + "Internet Banking";
			}else if(c3.isSelected()) {
				facility = facility + "Mobile Banking";
			}else if(c4.isSelected()) {
				facility = facility + "Email & SMS Alerts";
			}else if(c5.isSelected()) {
				facility = facility + "Cheque Book";
			}else if(c6.isSelected()) {
				facility = facility + "E-Statement";
			}
		
		
		/////////////////////////////////////////////////////////
		//JDBC
		try {
			DatabaseConnectivity table2 = new DatabaseConnectivity();
			String insert = "insert into signupthree values (?,?,?,?,?)";
			//		PreparedStatement insertstmt=table1.s.prepareStatement(insert);
			table2.s1 = table2.con.prepareStatement(insert);
			table2.s1.setString(1, this.formno);
			table2.s1.setString(2, account);
			table2.s1.setString(3, cardNo);
			table2.s1.setString(4, pinNo);
			table2.s1.setString(5, facility);
		
			
			table2.s1.executeUpdate();
			DatabaseConnectivity table3 = new DatabaseConnectivity();
			String insert3 = "INSERT INTO `login`(`fromno`, `cardnumber`, `pinnumber`) VALUES (?,?,?)";
			//		PreparedStatement insertstmt=table1.s.prepareStatement(insert);
			table3.s1 = table3.con.prepareStatement(insert3);
			table3.s1.setString(1, this.formno);
			table3.s1.setString(2, cardNo);
			table3.s1.setString(3, pinNo);
	
		
			
			table3.s1.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Card Number : "+cardNo+"\nPIN :"+pinNo);

			setVisible(false);
			new Login().setVisible(true);
//			int updateRowCount=table1.s1.executeUpdate();
//			System.out.println("DataBase Connected "+ updateRowCount);
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
		}
	}
	}

	public static void main(String[] args) {
		new SignupThree("");
		
		
	}


}
