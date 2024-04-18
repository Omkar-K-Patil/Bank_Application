package com.Black_Knight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	
	JButton login,clear,sigup;
	JTextField cardBox;
	JPasswordField pinBox;
	
	public Login() {
		setTitle("ATM");
		
		setLayout(null);
		
		ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("com/Black_Knight/bank.png"));
		Image logo2 = logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon logo3 = new ImageIcon(logo2);
		JLabel label = new JLabel(logo3);
		label.setBounds(70,10,100,100);
		add(label);
		
		//this part to crate an a label
		JLabel text = new JLabel("Welcome To ATM");
		text.setBounds(200, 40, 400, 40);
		//set textSytle
		text.setFont(new Font("Osward", Font.BOLD, 38));
		add(text);
		
		getContentPane().setBackground(Color.white);
		//it is Jframe function to create frame &  set size of frame 
		setSize(800,480);
		//Default frame is not visible you make to visible = "true"
		setVisible(true);
		//Default frame are open in top left setLocation to relocate the frame position
		//350 is left to right  200 is top to down
		setLocation(350,200);
		
		
		JLabel cardNumber = new JLabel("Card NO:");
		cardNumber.setFont(new Font("Raleway", Font.BOLD, 28));
		cardNumber.setBounds(120, 150, 150, 30);
		add(cardNumber);
		
		//it is use for textbox
		cardBox = new JTextField();
		cardBox.setBounds(300,150,230,30);
		add(cardBox);
		
	
		JLabel pin = new JLabel("PIN : ");
		pin.setBounds(120, 220, 250, 30);
		pin.setFont(new Font("Releway", Font.BOLD, 28));
		add(pin);
		
		pinBox = new JPasswordField();
		pinBox.setBounds(300,220,230,30);
		add(pinBox);
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("Clear");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		sigup = new JButton("SIGN Up");
		sigup.setBounds(300, 350, 230, 30);
		sigup.setBackground(Color.BLACK);
		sigup.setForeground(Color.WHITE);
		sigup.addActionListener(this);
		add(sigup);
	}
	public static void main(String[] args) {
		
		new Login();
	 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// verification 
		String cardNumber = cardBox.getText();
		String pinNumber = cardBox.getText();
	    if(e.getSource()==clear) {
			cardBox.setText("");
			pinBox.setText("");
		}else if(e.getSource()==login) {
			try {
				DatabaseConnectivity loginTable = new DatabaseConnectivity();
				String cardNo = cardBox.getText();
				String pinNo = pinBox.getText();
				//			String quary1 ="select * from login where cardnumber = '"+cardNo+"' and pinnumber = '"+pinNo+"'";		
				//			String quary ="SELECT * FROM `login` WHERE cardnumber = "?" AND pinnumber = "?"";
//				String query = "SELECT * FROM login WHERE cardnumber = ? AND pinnumber = ?";
//				PreparedStatement pstmt ;
//				ResultSet rs = loginTable.s1.executeQuery(query);
//				pstmt.setString(1, cardNo);
//				pstmt.setString(2, pinNo);
				String query = "SELECT * FROM login WHERE cardnumber = ? AND pinnumber = ?";
				PreparedStatement pstmt = loginTable.con.prepareStatement(query);
				pstmt.setString(1, cardNo);
				pstmt.setString(2, pinNo);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					setVisible(false);
					new Transactions(cardNo).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "please checke cardnumber and pin ");
				}

			} catch (Exception e2) {
				System.out.println(e2);
			}
			

			
		}else if(e.getSource()==sigup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}

}
