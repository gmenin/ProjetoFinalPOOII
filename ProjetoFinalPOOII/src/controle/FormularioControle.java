package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

import dao.FormularioDAO;
import modelo.Formulario;
import visao.JanelaPrincipal;

public class FormularioControle implements ActionListener, MouseListener {

	private JanelaPrincipal janelaPrincipal;
	private FormularioDAO formularioDAO;
	private UsuarioControle usuarioControle;

	public FormularioControle(JanelaPrincipal janelaPrincipal, UsuarioControle usuarioControle) {
		this.janelaPrincipal = janelaPrincipal;
		this.usuarioControle = usuarioControle;
		this.formularioDAO = new FormularioDAO();
		this.janelaPrincipal.getButtonFazerReserva().addActionListener(this);
		this.janelaPrincipal.getLabelAvancarPainelInicioFormulario().addMouseListener(this);
		this.janelaPrincipal.getLabelVoltarPainelData().addMouseListener(this);
		this.janelaPrincipal.getLabelAvancarPainelData().addMouseListener(this);
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
		// equipamentos = this.janelaPrincipal
		numeroAlunos = Integer.parseInt(this.janelaPrincipal.getFieldNumeroAlunos().getText());

		for (int i = 0; i < 6; i++) {
//			data[i] = this.janelaPrincipal
//			horaInicial[i] = this.janelaPrincipal.getComboBoxInicioDia()+i;
//			horaFinal[i] = this.janelaPrincipal.getComboBoxFinalDia()+i;	
		}

		// formulario = new Formulario(solicitante, telefone, email, numeroAlunos,
		// atividade, modalidade, curso, equipamentos, data, horaInicial, horaFinal);

//		if(validarCampos()) {
//			//boolean insercao = formularioDAO.inserirRequisicao(formulario, usuarioControle.getUsuarioId());
//			if(insercao) {
//				limparCampos();
//				int requisicaoId = formularioDAO.retornaFormularioId(usuarioControle.getUsuarioId());
//				for(int j=0; j<6; j++) {
//					if(validarReserva(data[j], horaInicial[j], horaFinal[j])) {
//						boolean reserva = formularioDAO.inserirReserva(requisicaoId, data[j], horaInicial[j], horaFinal[j]);
//						if(reserva==false) {
//							this.janelaPrincipal.mensagemRequisicaoErro();
//						}
//					}
//				}
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
		// Co'digo para validar os campos
		return false;
	}

	public boolean validarReserva(Date data, int horaInicial, int horaFinal) {
		// Co'digo para validar os campos do periodo (data, hora de inicio e de fim)
		return false;
	}

	public void limparCampos() {
		// Co'digo para limpar campos da tela
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		if (evento.getActionCommand().equals("Reservar")) {
			trocarPainel("painelInicioFormulario");
		}
		if (evento.getActionCommand().equals("Finalizar")) {
			salvarRequisicao();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == this.janelaPrincipal.getLabelAvancarPainelInicioFormulario()) {
			trocarPainel("painelData");
		}
		if(e.getComponent() == this.janelaPrincipal.getLabelVoltarPainelData()) {
			trocarPainel("painelInicioFormulario");
		}
		if(e.getComponent() == this.janelaPrincipal.getLabelAvancarPainelData()) {
			trocarPainel("painelEquipamentos");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
