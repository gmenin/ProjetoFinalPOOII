package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

import dao.FormularioDAO;
import modelo.Formulario;
import visao.JanelaPrincipal;

public class FormularioControle implements ActionListener, MouseListener{

	private JanelaPrincipal janelaPrincipal;
	private FormularioDAO formularioDAO;
	private UsuarioControle usuarioControle;

	public FormularioControle(JanelaPrincipal janelaPrincipal, UsuarioControle usuarioControle) {
		this.janelaPrincipal = janelaPrincipal;
		this.usuarioControle = usuarioControle;
		this.formularioDAO = new FormularioDAO();
		this.janelaPrincipal.getButtonFazerReserva().addActionListener(this);
		this.janelaPrincipal.getLabelAvancarPainelInicioFormulario().addMouseListener(this);
	}
	
	public void salvarRequisicao() {
		String solicitante, telefone, email, atividade, modalidade, curso, equipamentos;
		Date[] data;
		int numeroAlunos;
		int[] horaInicial, horaFinal;
		Formulario formulario;
		
		solicitante = this.janelaPrincipal.getFieldSolicitante().getText();
		telefone = this.janelaPrincipal.getFieldTelefone().getText();
		email = this.janelaPrincipal.getFieldEmail().getText();
		atividade = this.janelaPrincipal.getButtonGroupAtividade().getSelection().getActionCommand();
		modalidade = this.janelaPrincipal.getComboBoxModalidade().getSelectedItem().toString();
		curso = this.janelaPrincipal.getComboBoxCurso().getSelectedItem().toString();
		equipamentos = "teste";
		//equipamentos = this.janelaPrincipal
		numeroAlunos = Integer.parseInt(this.janelaPrincipal.getFieldNumeroAlunos().getText());
		
		for(int i = 0; i<6; i++) {
//			data[i] = this.janelaPrincipal
//			horaInicial[i] = this.janelaPrincipal.getComboBoxInicioDia()+i;
//			horaFinal[i] = this.janelaPrincipal.getComboBoxFinalDia()+i;	
		}
		
		//formulario = new Formulario(solicitante, telefone, email, numeroAlunos, atividade, modalidade, curso, equipamentos, data, horaInicial, horaFinal);
		
//		if(validarCampos()) {
//			//boolean insercao = formularioDAO.inserirRequisicao(formulario, usuarioControle.getUsuarioId());
//			if(insercao) {
//				limparCampos();
//				//Implementar co'digo para inserir datas na tabela a partir das datas
//				this.janelaPrincipal.mensagemRequisicaoSucesso();
//			}else {
//				this.janelaPrincipal.mensagemRequisicaoErro();
//			}	
//		}
		
	}

	public void trocarPainel(String nomePainel) {
		this.janelaPrincipal.trocarPainel(nomePainel);
	}
	
	public boolean validarCampos() {
		//Co'digo para validar os campos
		return false;
	}
	
	public void limparCampos() {
		//Co'digo para limpar campos da tela
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		if(evento.getActionCommand().equals("Reservar")) {
			trocarPainel("painelInicioFormulario");
		}
		if(evento.getActionCommand().equals("Finalizar")) {
			salvarRequisicao();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getComponent() == this.janelaPrincipal.getLabelAvancarPainelInicioFormulario()) {
			trocarPainel("painelInicial");
			System.out.println(this.janelaPrincipal.getButtonGroupAtividade().getSelection().getActionCommand());
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
