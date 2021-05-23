package rad.jdbc.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import rad.jdbc.util.JDBCUtil;

public class Account {
int balance ;
int dabal ,sabal ,danbal ,sanbal;

public void transfer(int sa,int da,int amt) {
	PreparedStatement ps,ps2=null;
	ResultSet rs1 , rs2 = null;
	try(Connection con =JDBCUtil.getMySqlConnection();){
		con.setAutoCommit(false);
		//operation to check the destination account
		ps = con.prepareStatement("select bal from account where accno =?");
		ps.setInt(1, da);
		 rs1 = ps.executeQuery();
		if(rs1.next()) {
			dabal = rs1.getInt(1);
		}
		else {
			throw new InValidAccountNumberException(da);
		}
		danbal = dabal+amt;
		
		// operation 2 -> destination account update 
		ps2=con.prepareStatement("update account set bal=? where accno =?");
		ps2.setInt(1, danbal);
		ps2.setInt(2, da);
		ps2.executeUpdate();
		
		System.out.println("**"+da+" updated");
		
		// operation 3 --> checking the source account 
		ps.setInt(1,sa);
		rs2 =ps.executeQuery();
		if(rs2.next()) {
			sabal = rs2.getInt(1);
		}
		else {
			throw new InValidAccountNumberException(sa);
		}
		if(sabal >=amt) {
			sanbal = sabal-amt;
		}
		else {
			throw new InSufficientFundsException("Sufficient Funds not available");
		}
		
		//operation 4 updating the sa account 
		ps2.setInt(1, sanbal);
		ps2.setInt(2, sa);
		ps2.executeUpdate();
		con.commit();
		System.out.println("** "+sa+" updated");
		System.out.println("**Fund Transfered");
	} catch (SQLException | InValidAccountNumberException |InSufficientFundsException e) {
		System.out.println(e.getMessage());
	}
}
}
