package controle;

import dao.FormularioDAO;
import visao.JanelaPrincipal;

public class FormularioControle {

	private JanelaPrincipal janelaPrincipal;
	private FormularioDAO formularioDAO;

	public FormularioControle(JanelaPrincipal j) {

		this.janelaPrincipal = j;
		this.formularioDAO = new FormularioDAO();
	}

}
