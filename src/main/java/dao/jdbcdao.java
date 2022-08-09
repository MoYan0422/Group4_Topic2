package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import memberbean.User;

public class jdbcdao {

	private String url = "jdbc:sqlserver://localhost:1433;databaseName=e-learning;trustServerCertificate=true";
	private String user = "sa";
	private String password = "p@ssw0rd!";

	private static final String insertUser = "insert into member(user_id,nick,account,password,status,name,img,sex,birthday,cellphone,email,joinDate) values (?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String selectUserById = "select * from member where account=?";
	private static final String selectUser = "select * from  member ";
	private static final String deleteuser = "delete from member where account=?;";
	private static final String updateuser = "update member set nick=?,account=?,password=?,status=?,name=?,img=?,sex=?,birthday=?,cellphone=?,email=?,joinDate=? where user_id=?";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	// 新增使用者
	public void insertUser(memberbean.User user) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insertUser);) {
			preparedStatement.setInt(1, user.getUser_id());
			preparedStatement.setString(2, user.getNick());
			preparedStatement.setString(3, user.getAccount());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setInt(5, user.getStatus());
			preparedStatement.setString(6, user.getName());
			preparedStatement.setBytes(7, user.getImg());
			preparedStatement.setString(8, user.getSex());
			preparedStatement.setDate(9, user.getBirthday());
			preparedStatement.setString(10, user.getCellphone());
			preparedStatement.setString(11, user.getEmail());
			preparedStatement.setDate(12, user.getJoinDate());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 修改使用者
//	public boolean updateUser(memberbean.user user) throws SQLException {
//		boolean rowUpdated;
//		try (Connection connection = getConnection();
//			PreparedStatement preparedStatement = connection.prepareStatement(updateuser);) {
//			preparedStatement.setInt(1, user.getUser_id());
//			preparedStatement.setString(2, user.getNick());
//			preparedStatement.setString(3, user.getAccount());
//			preparedStatement.setString(4, user.getPassword());
//			preparedStatement.setInt(5, user.getStatus());
//			preparedStatement.setString(6, user.getName());
//			preparedStatement.setBytes (7, user.getImg());
//			preparedStatement.setString(8, user.getSex());
//			preparedStatement.setDate  (9, user.getBirthday());
//			preparedStatement.setString(10, user.getCellphone());
//			preparedStatement.setString(11, user.getEmail());
//			preparedStatement.setDate(12, user.getJoinDate());
//			preparedStatement.executeUpdate();
//			
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	// 刪除使用者
	public boolean deleteUser(String account) throws SQLException {
		boolean rowDeleted;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(deleteuser);) {
			preparedStatement.setString(1, account);
			preparedStatement.executeUpdate();
		}
		return false;
	}

	// 透過帳號查詢使用者
	public memberbean.User selectUser(String account) throws SQLException {
		User user = new User();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectUserById);) {
			preparedStatement.setString(1, account);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				user.setUser_id(rs.getInt("user_id"));
				user.setNick(rs.getString("nick"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getInt("status"));
				user.setName(rs.getString("name"));
				user.setImg(rs.getBytes("img"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getDate("birthday"));
				user.setCellphone(rs.getString("cellphone"));
				user.setEmail(rs.getString("email"));
				user.setJoinDate(rs.getDate("joinDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	// 查詢所有使用者
	public List<memberbean.User> selectAllUser() {
		List<User> list = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectUser);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				User user2 = new User();

				user2.setUser_id(rs.getInt("user_id"));
				user2.setNick(rs.getString("nick"));
				user2.setAccount(rs.getString("account"));
				user2.setPassword(rs.getString("password"));
				user2.setStatus(rs.getInt("status"));
				user2.setName(rs.getString("name"));
				user2.setImg(rs.getBytes("img"));
				user2.setSex(rs.getString("sex"));
				user2.setBirthday(rs.getDate("birthday"));
				user2.setCellphone(rs.getString("cellphone"));
				user2.setEmail(rs.getString("email"));
				user2.setJoinDate(rs.getDate("joinDate"));
				list.add(user2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	//
	public int updateUser(int user_id, String nick, String account, String password, int status, String name,
			String img, String sex, String birthday, String cellphone, String email, String joinDate) {
			int result=0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(updateuser);) {
				preparedStatement.setString(1, nick);
				preparedStatement.setString(2,account);
				preparedStatement.setString(3, password);
				preparedStatement.setString(4, String.valueOf(status));
				preparedStatement.setString(5,name);
				preparedStatement.setString(6,img);
				preparedStatement.setString(7, sex);
				preparedStatement.setString (8, birthday);
				preparedStatement.setString(9, cellphone);
				preparedStatement.setString(10,email);
				preparedStatement.setString(11,joinDate);
				preparedStatement.setString(12, String.valueOf(user_id));
				result=preparedStatement.executeUpdate();
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		return result;
	}
}
