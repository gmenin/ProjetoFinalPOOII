package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.UsuarioDAO;
import modelo.Usuario;
import visao.JanelaPrincipal;

public class UsuarioControle implements ActionListener{

	private JanelaPrincipal janelaPrincipal;
	private UsuarioDAO usuarioDAO;

	public UsuarioControle(JanelaPrincipal j) {
		this.janelaPrincipal = j;
		this.janelaPrincipal.getButtonEntrar().addActionListener(this);
		this.usuarioDAO = new UsuarioDAO();
	}
	
	//Me'todo que autentica o usu'ario para entrar no sistema
	public void autenticarUsuario() {
		//Chamar DAO
		String nomeUsuario = this.janelaPrincipal.getFieldUsuario().getText();
		String senha = this.janelaPrincipal.getFieldSenha().getText();
		Usuario usuario = new Usuario(nomeUsuario, senha);
		boolean autentica = usuarioDAO.autenticaUsuario(usuario);
		
		if(autentica) {
			this.janelaPrincipal.getCard().next(this.janelaPrincipal.getContentPane());
			limparCamposLogin();
		}else {
			//this.janelaPrincipal.exibirMensagemErroAutenticacao();
		}
	}
	
	//Me'todo que limpa os campos na tela de login
	public void limparCamposLogin() {
		this.janelaPrincipal.getFieldUsuario().setText("");
		this.janelaPrincipal.getFieldSenha().setText("");
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		if(evento.getActionCommand().equals("Entrar")) {
			autenticarUsuario();
		}
	}
}
