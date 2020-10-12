package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.FormularioDAO;
import visao.JanelaPrincipal;

public class FormularioControle implements ActionListener{

	private JanelaPrincipal janelaPrincipal;
	private FormularioDAO formularioDAO;

	public FormularioControle(JanelaPrincipal janelaPrincipal) {
		this.janelaPrincipal = janelaPrincipal;
		this.formularioDAO = new FormularioDAO();
		this.janelaPrincipal.getButtonFazerReserva().addActionListener(this);
	}

	public void iniciarFormulario() {
		this.janelaPrincipal.trocarPainel("painelInicioFormulario");
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		if(evento.getActionCommand().equals("Reservar")) {
			iniciarFormulario();
		}
	}

}
