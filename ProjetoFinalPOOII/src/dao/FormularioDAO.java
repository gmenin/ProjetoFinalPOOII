package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Formulario;
import modelo.Usuario;

public class FormularioDAO {

	private Connection con = null;

	public FormularioDAO() {

	}

	// Me'todo que realiza a insercao dos dados do formulario no banco
	public boolean inserirRequisicao(Formulario formulario, int usuarioId) {
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		if(con != null) {
			String sql = "INSERT INTO requisicao (usuarioId, solicitante, telefone, email, numeroAlunos, atividade, modalidade, curso, equipamentos) VALUES(?,?,?,?,?,?,?,?,?)";	
			PreparedStatement prepareStatement = null; 
			
			try {
				// Argumentos que serao inseridos no banco de dados
				prepareStatement = con.prepareStatement(sql);
				prepareStatement.setInt(1, usuarioId);
				prepareStatement.setString(2, formulario.getSolicitante());
				prepareStatement.setString(3, formulario.getTelefone());
				prepareStatement.setString(4, formulario.getEmail());
				prepareStatement.setInt(5, formulario.getNumeroAlunos());
				prepareStatement.setString(6, formulario.getAtividade());
				prepareStatement.setString(7, formulario.getModalidade());
				prepareStatement.setString(8, formulario.getCurso());
				prepareStatement.setString(9, formulario.getEquipamentos());

				int resultado = prepareStatement.executeUpdate();
				
				// Retorna true se a insercao ocorreu com sucesso e false caso tenha falhado
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

		} // if
		return false;
	} // inserirFormulario()
	
	
}
