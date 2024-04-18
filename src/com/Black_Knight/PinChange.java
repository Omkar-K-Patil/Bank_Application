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
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener {

	String cardNo;
	JTextField pinBox;
	JButton sumit,back;
	JLabel l1,l2,l3;
	public PinChange(String cardNumber) {
		cardNo =cardNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/Black_Knight/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 900);
        add(l3);
        
        l1 = new JLabel("ENTER THE NEW PIN NUMBER ");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        pinBox = new JTextField();
        pinBox.setFont(new Font("Raleway", Font.BOLD, 22));
        
        sumit = new JButton("SUBMIT");
        back = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(190,350,400,35);
        l3.add(l1);
        
        pinBox.setBounds(190,420,320,25);
        l3.add(pinBox);
        
        sumit.setBounds(355 , 460, 150, 30);
        l3.add(sumit);
        
        back.setBounds(355 , 495, 150, 30);
        l3.add(back);
        
        sumit.addActionListener(this);
        back.addActionListener(this);
        
        setSize(900,1080);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
        
       
		
	}
	public static void main(String[] args) {
	new PinChange("");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource()==back) {
			setVisible(false);
			new Transactions(cardNo).setVisible(true);
			
		}else if(e.getSource()==sumit) {
		
			
			try {
				DatabaseConnectivity Table = new DatabaseConnectivity();
				String newPinNo = pinBox.getText();
				String update = "update login set pinnumber = ? where cardnumber = ? ";
				String update1 = "update signupthree set pinnumber = ? where cardnumber = ? ";
				Table.s1 = Table.con.prepareStatement(update);
				Table.s1.setString(1, newPinNo);
				Table.s1.setString(2, cardNo);
//				Table.s1 = Table.con.prepareStatement(update1);
//				Table.s1.setString(1, newPinNo);
//				Table.s1.setString(2, cardNo);
				int row =Table.s1.executeUpdate();
				if(row!=0) {
					
					JOptionPane.showMessageDialog(null, "PIN Change Successfully"+row);
					setVisible(false);
					new Transactions(cardNo).setVisible(true);
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	
		
	}

}
