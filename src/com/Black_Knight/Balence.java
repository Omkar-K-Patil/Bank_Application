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
import javax.swing.JTextField;

public class Balence extends JFrame implements ActionListener {
	

	JButton back;
	JLabel l1, l2, l3;
	long accountNumber;
	String accountNo;
	public Balence(String accountNo) {
			this.accountNo = accountNo;
	        accountNumber = Long.parseLong(accountNo) ;

	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/Black_Knight/atm.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel l3 = new JLabel(i3);
	        l3.setBounds(0, 0, 960, 1080);
	        add(l3);

	        l1 = new JLabel();
	        l1.setForeground(Color.WHITE);
	        l1.setFont(new Font("System", Font.BOLD, 16));

	        back = new JButton("BACK");

	        setLayout(null);

	        l1.setBounds(190, 350, 400, 35);
	        l3.add(l1);

	        back.setBounds(390, 633, 150, 35);
	        l3.add(back);
	        double balance = 0;
	        try{
	            DatabaseConnectivity table = new DatabaseConnectivity();
	            PreparedStatement pstmt = table.con.prepareStatement("SELECT accountBalence FROM `bankdata` WHERE accountNumber = ?");
				pstmt.setLong(1, accountNumber);
				ResultSet rs = pstmt.executeQuery();
				
				
				
	            while (rs.next()) {
	            	//In this method we get double value to sql column 
	            	balance = rs.getDouble("accountBalence");
	            }
	        }catch(Exception e){}
	        
	        l1.setText("Your Current Account Balance is Rs "+balance);

	        back.addActionListener(this);

	        setSize(960, 1080);
	        setUndecorated(true);
	        setLocation(500, 0);
	        setVisible(true);

		
	}

	public static void main(String[] args) {
		new Balence("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			setVisible(false);
			new Transactions(accountNo).setVisible(true);
		}
		
	}

}
