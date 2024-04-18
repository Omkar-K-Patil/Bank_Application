package com.Black_Knight;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener{
	

	JTextField aadharTextBox,panTextBox;
	JButton next;
	JComboBox religionCombo,categoryCombo,occupationCombo,educationCombo,incomeCombo;
	JRadioButton cYes,cNo,aYes,aNo;
	String formno;
	public SignupTwo(String formno) {
		setLayout(null);
		
		this.formno = formno;
		setTitle("NEW ACCOUNT APPLICATION - PAGE 2");
		

		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		//////////////////////////////////////////////////////////////
		JLabel religion = new JLabel("Religion :");
		religion.setFont(new Font("Raleway",Font.BOLD,20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);
		
		String religionArray[] = {"Hindu","Muslim","Sikh","Christian","Other"};
		religionCombo = new JComboBox(religionArray);
		religionCombo.setBounds(300, 140, 400, 30);
		religionCombo.setBackground(Color.WHITE);
		add(religionCombo);
		

        /////////////////////////////////////////////////////////////		
		JLabel category = new JLabel("Category :");
		category.setFont(new Font("Raleway",Font.BOLD,20));
		category.setBounds(100, 190, 200, 30);
		add(category);
		
		String categoryArray[] = {"General","OBC","Sc","ST","Other"};
		categoryCombo = new JComboBox(categoryArray);
		categoryCombo.setBounds(300, 190, 400, 30);
		categoryCombo.setBackground(Color.WHITE);
		add(categoryCombo);
        /////////////////////////////////////////////////////////////
		
		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Raleway",Font.BOLD,20));
		income.setBounds(100, 240, 200, 30);
		add(income);
		
		String incomeArray[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","< 8,00,000"};
		incomeCombo = new JComboBox(incomeArray);
		incomeCombo.setBounds(300, 240, 400, 30);
		incomeCombo.setBackground(Color.WHITE);
		add(incomeCombo);
		
		////////////////////////////////////////////////////////////
		JLabel education = new JLabel("Educational ");
		education.setFont(new Font("Raleway",Font.BOLD,20));
		education.setBounds(100, 290, 200, 30);
		add(education);
		
		
		JLabel qualification  = new JLabel("Qualification :");
		qualification.setFont(new Font("Raleway",Font.BOLD,20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);
		
		String educationArray[] = {"Non - Graduation","Graduate","Post - Graduation","Doctrate","Other"};
		educationCombo = new JComboBox(educationArray);
		educationCombo.setBounds(300, 313, 400, 30);
		educationCombo.setBackground(Color.WHITE);
		add(educationCombo);
		

        /////////////////////////////////////////////////////////////
		
		JLabel occupation = new JLabel("Occupation :");
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);
		
		String occupationArray[] = {"Salaried","Self - Employed","Bussiness","Student","Retired","Ohters"};
		occupationCombo = new JComboBox(occupationArray);
		occupationCombo.setBounds(300, 390, 400, 30);
		occupationCombo.setBackground(Color.WHITE);
		add(occupationCombo);
		
		//////////////////////////////////////////////////////////
		
		JLabel panNumber = new JLabel("Pan Card Number :");
		panNumber.setFont(new Font("Raleway",Font.BOLD,20));
		panNumber.setBounds(100, 440, 200, 30);
		add(panNumber);
		
		panTextBox = new JTextField();
		panTextBox.setFont(new Font("Raleway",Font.BOLD,14));
		panTextBox.setBounds(300, 440, 400, 30);
		add(panTextBox);
        /////////////////////////////////////////////////////////////
		
		JLabel aadharNumber = new JLabel("Aadhar Number :");
		aadharNumber.setFont(new Font("Raleway",Font.BOLD,20));
		aadharNumber.setBounds(100, 490, 200, 30);
		add(aadharNumber);
		
		aadharTextBox = new JTextField();
		aadharTextBox.setFont(new Font("Raleway",Font.BOLD,14));
		aadharTextBox.setBounds(300, 490, 400, 30);
		add(aadharTextBox);
        /////////////////////////////////////////////////////////////
		
		JLabel citizen = new JLabel("Senior Citizen :");
		citizen.setFont(new Font("Raleway",Font.BOLD,20));
		citizen.setBounds(100, 540, 200, 30);
		add(citizen);
		
		cYes = new JRadioButton("Yes");
		cYes.setBackground(Color.WHITE);
		cYes.setBounds(300, 540, 60, 30);
		add(cYes);
		
		cNo = new JRadioButton("No");
		cNo.setBounds(450, 540, 120, 30);
		cNo.setBackground(Color.WHITE);
		add(cNo);
		
		ButtonGroup citizengroup = new ButtonGroup();
		citizengroup.add(cYes);
		citizengroup.add(cNo);
		

        /////////////////////////////////////////////////////////////
		
		JLabel exaccount = new JLabel("Exisiting Account :");
		exaccount.setFont(new Font("Raleway",Font.BOLD,20));
		exaccount.setBounds(100, 590, 200, 30);
		add(exaccount);
		
		aYes = new JRadioButton("Yes");
		aYes.setBackground(Color.WHITE);
		aYes.setBounds(300, 590, 60, 30);
		add(aYes);
		
		aNo = new JRadioButton("No");
		aNo.setBounds(450, 590, 120, 30);
		aNo.setBackground(Color.WHITE);
		add(aNo);
		
		ButtonGroup accountgroup = new ButtonGroup();
		accountgroup.add(aYes);
		accountgroup.add(aNo);
		

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
		
		//getselecteditem retrun the object because of this casting with string
		String strReligion = (String) religionCombo.getSelectedItem();
		String strcategory = (String) categoryCombo.getSelectedItem();
		String stroccupation = (String) occupationCombo.getSelectedItem();
		String streducation = (String) educationCombo.getSelectedItem();
		String strincome = (String) incomeCombo.getSelectedItem();
		
		String strcitizen = null;
		if (cYes.isSelected()) {
			strcitizen = "Yes";
		}else {
			strcitizen = "No";
		}
		
		String straccount = null;
		if (aYes.isSelected()) {
			straccount = "Yes";
		}else {
			straccount = "No";
		}
		
		String straadhar = aadharTextBox.getText();
		String strpan = panTextBox.getText();
		
		
		/////////////////////////////////////////////////////////
		//JDBC
		try {
			DatabaseConnectivity table2 = new DatabaseConnectivity();
			String insert = "insert into signuptwo values (?,?,?,?,?,?,?,?,?,?)";
			//		PreparedStatement insertstmt=table1.s.prepareStatement(insert);
			table2.s1 = table2.con.prepareStatement(insert);
			table2.s1.setString(1, this.formno);
			table2.s1.setString(2, strReligion);
			table2.s1.setString(3, strcategory);
			table2.s1.setString(4, strincome);
			table2.s1.setString(5, streducation);
			table2.s1.setString(6, stroccupation);
			table2.s1.setString(7, strpan);
			table2.s1.setString(8, straadhar);
			table2.s1.setString(9, strcitizen);
			table2.s1.setString(10, straccount);
		
			
			table2.s1.executeUpdate();
			
			setVisible(false);
			new SignupThree(this.formno).setVisible(true);

			
//			int updateRowCount=table1.s1.executeUpdate();
//			System.out.println("DataBase Connected "+ updateRowCount);
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
		}
		
	}

	public static void main(String[] args) {
		new SignupTwo("");
		
		
	}


}
