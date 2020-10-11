package controle;

import visao.JanelaPrincipal;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JanelaPrincipal janela = new JanelaPrincipal();
		janela.setVisible(true);
		UsuarioControle usuarioControle = new UsuarioControle(janela);
		FormularioControle formularioControle = new FormularioControle(janela);
		
		// 
	}

}
