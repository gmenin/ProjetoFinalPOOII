package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dao.UsuarioDAO;
import modelo.Usuario;
import visao.JanelaPrincipal;

public class UsuarioControle implements ActionListener, MouseListener{

	private JanelaPrincipal janelaPrincipal;
	private UsuarioDAO usuarioDAO;
	private int usuarioId;

	public UsuarioControle(JanelaPrincipal j) {
		this.janelaPrincipal = j;
		this.janelaPrincipal.getButtonEntrar().addActionListener(this);
		this.usuarioDAO = new UsuarioDAO();
		this.janelaPrincipal.getLabelInfo().addMouseListener(this);
	}
	
	//Me'todo que autentica o usu'ario para entrar no sistema
	public void autenticarUsuario() {
		//Criacao de um novo objeto Usuario e passagem dos valores recebidos na janelaPrincipal
		String nomeUsuario = this.janelaPrincipal.getFieldUsuario().getText();
		String senha = this.janelaPrincipal.getFieldSenha().getText();
		Usuario usuario = new Usuario(nomeUsuario, senha);
		
		//Chama o me'todo da classe usuarioDAO passando o objeto usuario para autenticacao do usua'rio
		boolean autentica = usuarioDAO.autenticaUsuario(usuario);
		
		//Caso o usua'rio esteja cadastrado, envia-o para a tela inicial da aplicacao
		if(autentica) {
			this.janelaPrincipal.trocarPainel("painelInicial");
			usuarioId = usuarioDAO.retornaUsuarioId(usuario);
			limparCamposLogin();
		}else {
			this.janelaPrincipal.mensagemErroAutenticacao();
			limparCamposLogin();
		}
		
	}
	
	//Me'todo que limpa os campos na tela de login
	public void limparCamposLogin() {
		this.janelaPrincipal.getFieldUsuario().setText("");
		this.janelaPrincipal.getFieldSenha().setText("");
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		if(evento.getActionCommand().equals("Entrar")) {
			autenticarUsuario();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent()==this.janelaPrincipal.getLabelInfo()) {
			
			this.janelaPrincipal.informacoes();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
