package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

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
	} // inserirRequisicao()

	// Me'todo que realiza a insercao das datas da requisicao no banco
	public boolean inserirReserva(int requisicaoId, Date date, int horarioInicial, int horarioFinal) {
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		if(con != null) {
			String sql = "INSERT INTO reserva (requisicaoId, dia, horarioInicial, horarioFinal) VALUES(?,?,?,?)";	
			PreparedStatement prepareStatement = null; 

			try {
				// Argumentos que serao inseridos no banco de dados
				prepareStatement = con.prepareStatement(sql);
				prepareStatement.setInt(1, requisicaoId);
				prepareStatement.setDate(2, date);
				prepareStatement.setInt(3, horarioInicial);
				prepareStatement.setInt(4, horarioFinal);

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
	} // inserirReserva()

	// Me'todo que retorna FormularioId do ultimo formulario inserido
	public int retornaFormularioId(int usuarioId) {
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		String sql = "SELECT id FROM requisicao WHERE usuarioId LIKE ? AND id=(SELECT max(id) FROM requisicao)";

		PreparedStatement prepareStatement;
		try {
			prepareStatement = con.prepareStatement(sql);
			prepareStatement.setInt(1, usuarioId);
			ResultSet resultado = prepareStatement.executeQuery();

			while(resultado.next()) {
				return resultado.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexaoMySQL.fecharConexao();
		return 0;
	} // retornaFormularioId()
	
	// Me'todo que retorna id de todas as requisicoes
	public int[] retornaFormularioIdGeral(int usuarioId) {
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
		int[] listaId = null;
		int i = 0;
		String sql = "SELECT id FROM requisicao WHERE usuarioId LIKE ?";

		PreparedStatement prepareStatement;
		try {
			prepareStatement = con.prepareStatement(sql);
			prepareStatement.setInt(1, usuarioId);
			ResultSet resultado = prepareStatement.executeQuery();

			while(resultado.next()) {
				listaId[i] = resultado.getInt(1);
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexaoMySQL.fecharConexao();
		return listaId;
	} // retornaFormularioIdGeral()
	
	// Me'todo que realiza a exclusao de uma requisicao no banco
	public boolean excluirRequisicao(int requisicaoId) {
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		if(con != null) {
			String sql = "DELETE FROM requisicao WHERE id = ?";	
			PreparedStatement prepareStatement = null; 

			try {
				// Argumentos que serao inseridos no banco de dados
				prepareStatement = con.prepareStatement(sql);
				prepareStatement.setInt(1, requisicaoId);

				int resultado = prepareStatement.executeUpdate();

				// Retorna true se a exclusao ocorreu com sucesso e false caso tenha falhado
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
	} // excluirRequisicao()
		
	// Me'todo que retorna uma requisicao 
		public boolean retornaRequisicao(int requisicaoId, Formulario formulario) {
			int aux = 0;
			String solicitante = null, telefone = null, email = null, atividade = null, modalidade = null, curso = null, equipamentos = null;
			int numeroAlunos = 0;
			
			ConexaoMySQL.abrirConexao();
			con = ConexaoMySQL.getCon();

			String sql = "SELECT solicitante, telefone, email, numeroAlunos, atividade, modalidade, curso, equipamentos "
					+ "FROM requisicao WHERE id = ?";

			PreparedStatement prepareStatement;
			try {
				prepareStatement = con.prepareStatement(sql);
				prepareStatement.setInt(1, requisicaoId);
				ResultSet resultado = prepareStatement.executeQuery();

				while(resultado.next()) {
					aux = 1;
					solicitante = resultado.getString(1);
					telefone = resultado.getString(2);
					email = resultado.getString(3);
					numeroAlunos = resultado.getInt(4);
					atividade = resultado.getString(5);
					modalidade = resultado.getString(6);
					curso = resultado.getString(7);
					equipamentos = resultado.getString(8);
				}
				
				formulario.setSolicitante(solicitante);
				formulario.setTelefone(telefone);
				formulario.setEmail(email);
				formulario.setNumeroAlunos(numeroAlunos);
				formulario.setAtividade(atividade);
				formulario.setModalidade(modalidade);
				formulario.setCurso(curso);
				formulario.setEquipamentos(equipamentos);
				
				if(aux==1) {
					return true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ConexaoMySQL.fecharConexao();
			return false;
		} // retornaRequisicao()
}
