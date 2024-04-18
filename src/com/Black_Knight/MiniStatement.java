package com.Black_Knight;

public class MiniStatement {
	
	String accountNo;
	long accountNumber;
	
	public MiniStatement(String accountNo) {
		accountNumber = Long.parseLong(accountNo);
		this.accountNo = accountNo;
		
		
		
	}
	
	public void dataInsert(long accountNumber,double amount,String activity,String activityTime) {
		
		try {
			DatabaseConnectivity table = new DatabaseConnectivity();
			table.s1 = table.con.prepareStatement(
					"INSERT INTO `ministatement`(`accountNumber`, `amout`, `activity`, `activityTime`) VALUES (?,?,?,?)");
			table.s1.setLong(1, accountNumber);
			table.s1.setDouble(2, amount);
			table.s1.setString(3, activity);
			table.s1.setString(4, activityTime);
			table.s1.executeUpdate();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		
		new MiniStatement("");
	}

}
