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
		this.janelaPrincipal.getLabelVoltarequipamentos().addMouseListener(this);
		this.janelaPrincipal.getLabelProximoequipamentos().addMouseListener(this);
		this.janelaPrincipal.getButtonVerificaQtd().addActionListener(this);
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

		this.janelaPrincipal.getFieldTelefone().setText("");
		this.janelaPrincipal.getFieldEmail().setText("");
		this.janelaPrincipal.getFieldNumeroAlunos().setText("");
		this.janelaPrincipal.getFieldSolicitante().setText("");
		this.janelaPrincipal.getRadioButtonAula().setSelected(false);
		this.janelaPrincipal.getRadioButtonProva().setSelected(false);
		this.janelaPrincipal.getRadioButtonSeminario().setSelected(false);
		this.janelaPrincipal.getComboBoxModalidade().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxCurso().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxQtdDias().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxFimDia1().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxFimDia2().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxFimDia3().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxFimDia4().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxFimDia5().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxFimDia6().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxInicioDia1().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxInicioDia2().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxInicioDia3().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxInicioDia4().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxInicioDia5().setSelectedIndex(-1);
		this.janelaPrincipal.getComboBoxInicioDia6().setSelectedIndex(-1);
		this.janelaPrincipal.getCheckBoxEquipamentoDeAudio().setSelected(false);
		this.janelaPrincipal.getCheckBoxEquipamentoDvd().setSelected(false);
		this.janelaPrincipal.getCheckBoxOutroEspecificar().setSelected(false);
		this.janelaPrincipal.getCheckBoxProjetorDeSlides().setSelected(false);
		this.janelaPrincipal.getCheckBoxRetroprojetor().setSelected(false);
		this.janelaPrincipal.getFieldEspecificacao().setText("");

	}

	public void mostrarCamposDatas() {
		if (this.janelaPrincipal.getComboBoxQtdDias().getSelectedItem().equals("1 Dia")) {

			this.janelaPrincipal.getComboBoxInicioDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia2().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia2().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxInicioDia3().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia3().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia3().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxInicioDia4().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia4().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia4().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxInicioDia5().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia5().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia5().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxInicioDia6().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia6().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia6().setSelectedIndex(-1);
			this.janelaPrincipal.getDataPanelDia1().setVisible(true);
			this.janelaPrincipal.getDataPanelDia1().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia2().setVisible(false);
			this.janelaPrincipal.getDataPanelDia2().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia2().getDateEditor().setDate(null);
			this.janelaPrincipal.getDataPanelDia3().setVisible(false);
			this.janelaPrincipal.getDataPanelDia3().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia3().getDateEditor().setDate(null);
			this.janelaPrincipal.getDataPanelDia4().setVisible(false);
			this.janelaPrincipal.getDataPanelDia4().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia4().getDateEditor().setDate(null);
			this.janelaPrincipal.getDataPanelDia5().setVisible(false);
			this.janelaPrincipal.getDataPanelDia5().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia5().getDateEditor().setDate(null);
			this.janelaPrincipal.getDataPanelDia6().setVisible(false);
			this.janelaPrincipal.getDataPanelDia6().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia6().getDateEditor().setDate(null);
			this.janelaPrincipal.getComboBoxFimDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia2().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia2().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia2().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxFimDia3().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia3().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia3().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxFimDia4().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia4().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia4().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxFimDia5().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia5().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia5().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxFimDia6().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia6().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia6().setSelectedIndex(-1);
		}

		else if (this.janelaPrincipal.getComboBoxQtdDias().getSelectedItem().equals("2 Dias")) {

			this.janelaPrincipal.getComboBoxInicioDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia3().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia3().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia3().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxInicioDia4().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia4().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia4().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxInicioDia5().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia5().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia5().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxInicioDia6().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia6().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia6().setSelectedIndex(-1);
			this.janelaPrincipal.getDataPanelDia1().setVisible(true);
			this.janelaPrincipal.getDataPanelDia1().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia2().setVisible(true);
			this.janelaPrincipal.getDataPanelDia2().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia3().setVisible(false);
			this.janelaPrincipal.getDataPanelDia3().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia3().getDateEditor().setDate(null);
			this.janelaPrincipal.getDataPanelDia4().setVisible(false);
			this.janelaPrincipal.getDataPanelDia4().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia4().getDateEditor().setDate(null);
			this.janelaPrincipal.getDataPanelDia5().setVisible(false);
			this.janelaPrincipal.getDataPanelDia5().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia5().getDateEditor().setDate(null);
			this.janelaPrincipal.getDataPanelDia6().setVisible(false);
			this.janelaPrincipal.getDataPanelDia6().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia6().getDateEditor().setDate(null);
			this.janelaPrincipal.getComboBoxFimDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia2().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia2().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia3().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia3().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia3().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxFimDia4().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia4().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia4().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxFimDia5().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia5().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia5().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxFimDia6().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia6().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia6().setSelectedIndex(-1);
		}

		else if (this.janelaPrincipal.getComboBoxQtdDias().getSelectedItem().equals("3 Dias")) {

			this.janelaPrincipal.getComboBoxInicioDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia3().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia3().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia4().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia4().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia4().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxInicioDia5().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia5().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia5().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxInicioDia6().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia6().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia6().setSelectedIndex(-1);
			this.janelaPrincipal.getDataPanelDia1().setVisible(true);
			this.janelaPrincipal.getDataPanelDia1().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia2().setVisible(true);
			this.janelaPrincipal.getDataPanelDia2().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia3().setVisible(true);
			this.janelaPrincipal.getDataPanelDia3().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia4().setVisible(false);
			this.janelaPrincipal.getDataPanelDia4().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia4().getDateEditor().setDate(null);
			this.janelaPrincipal.getDataPanelDia5().setVisible(false);
			this.janelaPrincipal.getDataPanelDia5().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia5().getDateEditor().setDate(null);
			this.janelaPrincipal.getDataPanelDia6().setVisible(false);
			this.janelaPrincipal.getDataPanelDia6().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia6().getDateEditor().setDate(null);
			this.janelaPrincipal.getComboBoxFimDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia2().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia2().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia3().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia3().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia4().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia4().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia4().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxFimDia5().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia5().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia5().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxFimDia6().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia6().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia6().setSelectedIndex(-1);

		} else if (this.janelaPrincipal.getComboBoxQtdDias().getSelectedItem().equals("4 Dias")) {

			this.janelaPrincipal.getComboBoxInicioDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia3().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia3().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia4().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia4().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia5().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia5().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia5().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxInicioDia6().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia6().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia6().setSelectedIndex(-1);
			this.janelaPrincipal.getDataPanelDia1().setVisible(true);
			this.janelaPrincipal.getDataPanelDia1().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia2().setVisible(true);
			this.janelaPrincipal.getDataPanelDia2().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia3().setVisible(true);
			this.janelaPrincipal.getDataPanelDia3().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia4().setVisible(true);
			this.janelaPrincipal.getDataPanelDia4().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia5().setVisible(false);
			this.janelaPrincipal.getDataPanelDia5().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia5().getDateEditor().setDate(null);
			this.janelaPrincipal.getDataPanelDia6().setVisible(false);
			this.janelaPrincipal.getDataPanelDia6().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia6().getDateEditor().setDate(null);
			this.janelaPrincipal.getComboBoxFimDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia2().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia2().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia3().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia3().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia4().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia4().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia5().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia5().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia5().setSelectedIndex(-1);
			this.janelaPrincipal.getComboBoxFimDia6().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia6().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia6().setSelectedIndex(-1);

		} else if (this.janelaPrincipal.getComboBoxQtdDias().getSelectedItem().equals("5 Dias")) {

			this.janelaPrincipal.getComboBoxInicioDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia3().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia3().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia4().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia4().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia5().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia5().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia6().setVisible(false);
			this.janelaPrincipal.getComboBoxInicioDia6().setEnabled(false);
			this.janelaPrincipal.getComboBoxInicioDia6().setSelectedIndex(-1);
			this.janelaPrincipal.getDataPanelDia1().setVisible(true);
			this.janelaPrincipal.getDataPanelDia1().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia2().setVisible(true);
			this.janelaPrincipal.getDataPanelDia2().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia3().setVisible(true);
			this.janelaPrincipal.getDataPanelDia3().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia4().setVisible(true);
			this.janelaPrincipal.getDataPanelDia4().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia5().setVisible(true);
			this.janelaPrincipal.getDataPanelDia5().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia6().setVisible(false);
			this.janelaPrincipal.getDataPanelDia6().setEnabled(false);
			this.janelaPrincipal.getDataPanelDia6().getDateEditor().setDate(null);
			this.janelaPrincipal.getComboBoxFimDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia2().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia2().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia3().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia3().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia4().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia4().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia5().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia5().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia6().setVisible(false);
			this.janelaPrincipal.getComboBoxFimDia6().setEnabled(false);
			this.janelaPrincipal.getComboBoxFimDia6().setSelectedIndex(-1);

		} else if (this.janelaPrincipal.getComboBoxQtdDias().getSelectedItem().equals("6 Dias")) {
			this.janelaPrincipal.getComboBoxInicioDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia2().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia3().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia3().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia4().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia4().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia5().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia5().setEnabled(true);
			this.janelaPrincipal.getComboBoxInicioDia6().setVisible(true);
			this.janelaPrincipal.getComboBoxInicioDia6().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia1().setVisible(true);
			this.janelaPrincipal.getDataPanelDia1().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia2().setVisible(true);
			this.janelaPrincipal.getDataPanelDia2().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia3().setVisible(true);
			this.janelaPrincipal.getDataPanelDia3().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia4().setVisible(true);
			this.janelaPrincipal.getDataPanelDia4().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia5().setVisible(true);
			this.janelaPrincipal.getDataPanelDia5().setEnabled(true);
			this.janelaPrincipal.getDataPanelDia6().setVisible(true);
			this.janelaPrincipal.getDataPanelDia6().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia1().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia1().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia2().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia2().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia3().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia3().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia4().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia4().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia5().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia5().setEnabled(true);
			this.janelaPrincipal.getComboBoxFimDia6().setVisible(true);
			this.janelaPrincipal.getComboBoxFimDia6().setEnabled(true);
		}
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
		if (evento.getActionCommand().equals("OKdias")) {
			mostrarCamposDatas();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getComponent() == this.janelaPrincipal.getLabelAvancarPainelInicioFormulario()) {
			trocarPainel("painelData");

		}
		if (e.getComponent() == this.janelaPrincipal.getLabelVoltarPainelData()) {
			trocarPainel("painelInicioFormulario");

		}
		if (e.getComponent() == this.janelaPrincipal.getLabelAvancarPainelData()) {
			trocarPainel("painelEquipamentos");
		}
		if (e.getComponent() == this.janelaPrincipal.getLabelVoltarequipamentos()) {

			trocarPainel("painelData");

		}
		if (e.getComponent() == this.janelaPrincipal.getLabelProximoequipamentos()) {

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
