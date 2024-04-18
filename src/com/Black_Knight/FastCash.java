package com.Black_Knight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {
	
	String accountNo;
	int accountBalence;
	long accountNumber;
	JButton one,two,five,back;
	public FastCash(String accountNo) {
		this.accountNo = accountNo;
		accountNumber = Long.parseLong(accountNo);
		ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("com/Black_Knight/atm.jpg"));
		Image logo2 = logo.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon logo3 =new ImageIcon(logo2); 
		JLabel image = new JLabel(logo3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Please Select Your Transaction Amout");
		text.setBounds(180, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		one = new JButton("RS. 100");
		one.setBounds(170, 390, 150, 30);
		image.add(one);
		
		two = new JButton("RS. 200");
		two.setBounds(355, 390, 150, 30);
		image.add(two);
		
		five = new JButton("RS. 500");
		five.setBounds(170, 425, 150, 30);
		image.add(five);
		
		back = new JButton("BACK");
		back.setBounds(355, 425, 150, 30);
		image.add(back);
		
		one.addActionListener(this);
		two.addActionListener(this);
		five.addActionListener(this);
		back.addActionListener(this);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new FastCash("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			DatabaseConnectivity table = new DatabaseConnectivity();
			String verification = "SELECT * FROM bankdata WHERE accountNumber = ?";
			PreparedStatement pstmt = table.con.prepareStatement(verification);
			pstmt.setLong(1, accountNumber);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				if (e.getSource() == one) {
					table.s1 = table.con.prepareStatement(
							"UPDATE `bankdata` SET `accountBalence`=(SELECT  `accountBalence` FROM `bankdata` WHERE `accountNumber`= ?) - 100 WHERE accountNumber = ?");
					accountBalence = 100;
				} else if (e.getSource() == two) {
					table.s1 = table.con.prepareStatement(
							"UPDATE `bankdata` SET `accountBalence`=(SELECT  `accountBalence` FROM `bankdata` WHERE `accountNumber`= ?) - 200 WHERE accountNumber = ?");
					accountBalence = 200;
				} else if (e.getSource() == five) {
					table.s1 = table.con.prepareStatement(
							"UPDATE `bankdata` SET `accountBalence`=(SELECT  `accountBalence` FROM `bankdata` WHERE `accountNumber`= ?) - 500 WHERE accountNumber = ?");
					accountBalence = 500;
				} else if (e.getSource() == back) {
					setVisible(false);
					new Transactions(accountNo).setVisible(true);

				}

				table.s1.setLong(1, accountNumber);
				table.s1.setLong(2, accountNumber);
				int row = table.s1.executeUpdate();
				if (row != 0) {
					JOptionPane.showMessageDialog(null, "Rs " + accountBalence + " Withdraw Successfully ");
					setVisible(false);
					new Transactions(accountNo).setVisible(true);
				}
			} 
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		
	}

}
