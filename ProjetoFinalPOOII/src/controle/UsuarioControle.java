package controle;

import dao.UsuarioDAO;
import visao.JanelaPrincipal;

public class UsuarioControle {

	private JanelaPrincipal jan;
	private UsuarioDAO usuarioDAO;

	public UsuarioControle(JanelaPrincipal j) {

		this.jan = j;
		this.usuarioDAO = new UsuarioDAO();

	}
}
