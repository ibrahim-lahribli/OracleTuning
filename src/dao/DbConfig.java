package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConfig {
	public static Connection con; // objet de type connection
	public static ResultSet rs = null; // pour le jeu de resultat
	public static PreparedStatement pst; // pour les requetes parametes
	public static java.sql.Statement st; // pour les requetes simples
	public static java.sql.CallableStatement cl;
	public static String instance="ORACLETN" ;
	
	

	public static String getInstance() {
		return instance;
	}

	public static void setInstance(String instance) {
		DbConfig.instance = instance;
	}

	public static void Connect() throws SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			String url = "jdbc:oracle:thin:@localhost:1521:"+instance; 
			con = (Connection) DriverManager.getConnection(url, "test", "test");
			System.out.println("Connection réussie");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void disconnect() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet select(String sql) {
		try {
			rs = (ResultSet) st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static int update(String sql) {
		int nb = 0;
		try {
			nb = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nb;
	}

}
