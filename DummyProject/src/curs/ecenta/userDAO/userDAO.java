package curs.ecenta.userDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import curs.ecenta.Database.DatabaseConnection;
import curs.ecenta.userBean.UserBean;

public class userDAO {
	public ArrayList<UserBean> getUser() {
		ArrayList<UserBean> users = new ArrayList<>();
		DatabaseConnection dbCon = new DatabaseConnection();
		Connection con = dbCon.handleConnection();

		Statement stmt = null;

		try {
			stmt = con.createStatement();
			String sql;
			sql = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setIduser(rs.getInt("Iduser"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
