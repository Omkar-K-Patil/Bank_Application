package com.Black_Knight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.print.DocFlavor.STRING;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends JFrame implements ActionListener {
	String pinNumber;
	JTextField t1;
	JButton withdraw,back;
	JLabel l1,l2,l3;
	double balance;
	
public Withdraw(String pin) {
	pinNumber = pin;
	    
	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/Black_Knight/atm.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel l3 = new JLabel(i3);
	        l3.setBounds(0, 0, 900, 900);
	        add(l3);
	        
	        l1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
	        l1.setForeground(Color.WHITE);
	        l1.setFont(new Font("System", Font.BOLD, 16));
	        
	        t1 = new JTextField();
	        t1.setFont(new Font("Raleway", Font.BOLD, 22));
	        
	        withdraw = new JButton("WITHDRAW");
	        back = new JButton("BACK");
	        
	        setLayout(null);
	        
	        l1.setBounds(160,350,400,35);
	        l3.add(l1);
	        
	        t1.setBounds(190,420,320,25);
	        l3.add(t1);
	        
	        withdraw.setBounds(355 , 460, 150, 30);
	        l3.add(withdraw);
	        
	        back.setBounds(355 , 495, 150, 30);
	        l3.add(back);
	        
	        withdraw.addActionListener(this);
	        back.addActionListener(this);
	        
	        setSize(900,1080);
	        setUndecorated(true);
	        setLocation(500,0);
	        setVisible(true);
	
}	

	public static void main(String[] args) {
		new Withdraw("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==withdraw) {
		
			DatabaseConnectivity table = new DatabaseConnectivity();
			long accountNumber = Long.parseLong(pinNumber);
			double accountBalence = Double.parseDouble(t1.getText());
			
			try {
				//verification for Account present or not
				String verification = "SELECT * FROM bankdata WHERE accountNumber = ?";
				PreparedStatement pstmt = table.con.prepareStatement(verification);
				pstmt.setLong(1, accountNumber);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
		            DatabaseConnectivity tableTwo = new DatabaseConnectivity();
		            PreparedStatement two = table.con.prepareStatement("SELECT accountBalence FROM `bankdata` WHERE accountNumber = ?");
					two.setLong(1, accountNumber);
					ResultSet balenceRS = two.executeQuery();				
					
		            while (balenceRS.next()) {
		            	//In this method we get double value to sql column 
		            
		            	if ((balance = balenceRS.getDouble("accountBalence")) >= Double.parseDouble(t1.getText())) {
		            		
		            		String deposit ="UPDATE `bankdata` SET `accountBalence`=(SELECT  `accountBalence` FROM `bankdata` WHERE `accountNumber`= ?) - ? WHERE accountNumber = ?";
		            		
		            		table.s1 =table.con.prepareStatement(deposit);
		            		table.s1.setLong(1, accountNumber);
		            		table.s1.setDouble(2, accountBalence);
		            		table.s1.setLong(3, accountNumber);
		            		int row = table.s1.executeUpdate();
		            		if(row!=0) {
		            			MiniStatement m = new MiniStatement(pinNumber);
		            			
		            			LocalDateTime time = LocalDateTime.now();//For Create LocalDateTime veritable 
		            			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); // it is Formatter of dateTime 
		            			String dateTime = time.format(formatter);//LocalDtaeTime to String
		            			
		            			
		            			m.dataInsert(accountNumber, accountBalence, "Withdraw",dateTime );
		            			JOptionPane.showMessageDialog(null, "Rs " + accountBalence + " Withdraw Successfully ");
		            			setVisible(false);
		            			new Transactions(pinNumber).setVisible(true);
		            		}
							
						} else {
							JOptionPane.showMessageDialog(null, " Tranjaction Fail  ");
						}
		            }
					
				}  
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}else if (e.getSource()==back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
			
			
		}
		
		
		
	}

}
