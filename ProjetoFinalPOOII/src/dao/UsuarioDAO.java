package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;

public class UsuarioDAO {
	private Connection con = null;

	// Construtor da classe
	public UsuarioDAO() {

	}

	// Me'todo de autenticacao do usua'rio
	public boolean autenticaUsuario(Usuario usuario) {
		int sinal = 0; // Indica se comando sql retornou algo
		
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		String sql = "SELECT * FROM usuario WHERE nomeUsuario LIKE ? AND senha LIKE ?";

		PreparedStatement prepareStatement;
		try {
			prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, usuario.getUsuario());
			prepareStatement.setString(2, usuario.getSenha());
			ResultSet resultado = prepareStatement.executeQuery();

			while(resultado.next()) {
				sinal = 1;
			}

			ConexaoMySQL.fecharConexao();

			if(sinal==1) {
				return true;
			}
			
			return false;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			try {
				con.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			return false;
		}
	} // autenticaUsuario()
} // UsuarioDAO
