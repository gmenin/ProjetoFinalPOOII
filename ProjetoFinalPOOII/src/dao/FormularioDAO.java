package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Formulario;

public class FormularioDAO {

	private Connection con = null;

	public FormularioDAO() {
		
	}
	
	//Me'todo que realiza a insercao do formulario no banco
		public boolean inserirFormulario(Formulario formulario) {
			ConexaoMySQL.abrirConexao();
			con = ConexaoMySQL.getCon();

			if(con != null) {
				String sql = "INSERT INTO VALUES(?,?,?,?,?,?)";

				PreparedStatement prepareStatement = null; //had to fix
				try {
					prepareStatement = con.prepareStatement(sql);
					prepareStatement.setString(1, formulario.getSolicitante());
					prepareStatement.setString(2, formulario.getTelefone());
					prepareStatement.setString(3, formulario.getEmail());
					prepareStatement.setInt(4, formulario.getNumeroAlunos());
					prepareStatement.setString(5, formulario.getAtividade());
					prepareStatement.setString(5, formulario.getCurso());
					prepareStatement.setString(5, formulario.getEquipamentos());

					int resultado = prepareStatement.executeUpdate();

					if(resultado == 1) {
						ConexaoMySQL.fecharConexao();
						return true;
					}else {
						ConexaoMySQL.fecharConexao();
						return false;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			return false;
		}
}
