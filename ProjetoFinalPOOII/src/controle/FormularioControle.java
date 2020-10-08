package controle;

import dao.FormularioDAO;
import visao.JanelaPrincipal;

public class FormularioControle {

	private JanelaPrincipal jan;
	private FormularioDAO formDAO;

	public FormularioControle(JanelaPrincipal j) {

		this.jan = j;
		formDAO = new FormularioDAO();
	}

}
