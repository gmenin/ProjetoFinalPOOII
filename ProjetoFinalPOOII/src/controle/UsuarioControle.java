package controle;

import dao.UsuarioDAO;
import visao.JanelaPrincipal;

public class UsuarioControle {

	private JanelaPrincipal janelaPrincipal;
	private UsuarioDAO usuarioDAO;

	public UsuarioControle(JanelaPrincipal j) {

		this.janelaPrincipal = j;
		this.usuarioDAO = new UsuarioDAO();

	}
}
