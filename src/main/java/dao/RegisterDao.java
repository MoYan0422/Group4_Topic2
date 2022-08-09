package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import bean.MemberBean;
import util.JdbcUtil;


public class RegisterDao {

	public   int registeruser(MemberBean user){
		
		int result=0;
		
		try {
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement prestate=conn.prepareStatement("insert into member(account,password,email) values (?,?,?)");
			prestate.setString(1, user.getAccount());
			prestate.setString(2, user.getPassword());
			prestate.setString(3, user.getEmail());
			
			result=prestate.executeUpdate();
			
			
			
		} catch (Exception e) {
			
		}
		
		return result;
		
		
		
	}
}
