package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	private static Connection con;
	private static String status;
	
	public ConexaoMySQL() {
			
	}
	
	public static void abrirConexao() {
		String servername = "localhost";
		String database = "pooIITrabalhoFinal";
		String url =  "jdbc:mysql://"+servername+":3306/"+database+"?useTimezone=true&serverTimezone=UTC";
		String username = "admUser";
		String password = "admPassword";
		
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(con != null) {
			status = "Status-------> Conectado com sucesso!";
		} else {
			status = "Status-------> Não foi possível realizar a conexão";
		}
	}
	
	public static boolean fecharConexao() {
		try {
			con.close();
			System.out.println("Conexão encerrada!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void statusConexao() {
		System.out.println(status);
	}
	
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ConexaoMySQL.con = con;
	}

	public static void main(String[] args) {
		ConexaoMySQL.abrirConexao();
		ConexaoMySQL.statusConexao();
		ConexaoMySQL.fecharConexao();
	}
}
