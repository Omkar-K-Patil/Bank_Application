package com.Black_Knight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Transactions extends JFrame implements ActionListener{

	String cardNumber;
	JButton deposit,withdraw,fastCash,miniStatement,pinChange,balence,exit;
	public Transactions(String cradNo) {
		cardNumber = cradNo;
		ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("com/Black_Knight/atm.jpg"));
		Image logo2 = logo.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon logo3 =new ImageIcon(logo2); 
		JLabel image = new JLabel(logo3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(210, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 390, 150, 30);
		image.add(deposit);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355, 390, 150, 30);
		image.add(withdraw);
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(170, 425, 150, 30);
		image.add(fastCash);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(355, 425, 150, 30);
		image.add(miniStatement);
		
		 pinChange = new JButton("PIN Change");
		 pinChange .setBounds(170, 460, 150, 30);
		image.add( pinChange );
		
		balence = new JButton("Checke Balence");
		balence .setBounds(355 , 460, 150, 30);
		image.add( balence );
		
		exit = new JButton("Exit");
		exit .setBounds(355 , 495, 150, 30);
		image.add( exit );
		
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
		/////////////////////////////////////////////////////////////////////
		
		deposit.addActionListener(this);
		withdraw.addActionListener(this);
		fastCash.addActionListener(this);
		miniStatement.addActionListener(this);
		pinChange.addActionListener(this);
		balence.addActionListener(this);
		exit.addActionListener(this);
		  
		
		
	}
	
	public static void main(String[] args) {
		
		new Transactions("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==deposit) {
		
			setVisible(false);
			new Deposit(cardNumber).setVisible(true);
			
		} else if(e.getSource()==withdraw) {
			setVisible(false);
			new Withdraw(cardNumber).setVisible(true);
		
		} else if (e.getSource()==fastCash) {
			setVisible(false);
			new FastCash(cardNumber).setVisible(true);
		} else if(e.getSource()==miniStatement) {
			
		}else if (e.getSource()==pinChange) {
			setVisible(false);
			new PinChange(cardNumber).setVisible(true);
			
			
		}else if(e.getSource()==balence) {
			setVisible(false);
			new Balence(cardNumber).setVisible(true);
			
		}else if(e.getSource()==exit) {
			
			setVisible(false);
			new Login().setVisible(true);
			
		}
	}

}
