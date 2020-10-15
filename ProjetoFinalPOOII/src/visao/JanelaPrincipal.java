package visao;

import java.awt.BasicStroke;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private Graphics graph;
	private JPanel painelLogin;
	private JLabel labelUsuario;
	private JLabel labelSenha;
	private JTextField fieldUsuario;
	private JPasswordField fieldSenha;
	private JButton buttonEntrar;
	private JPanel painelInicial;
	private JLabel labelMensagemNome;
	private JLabel labelMensagem;
	private JLabel labelMensagemEscolha;
	private JButton buttonVerReservas;
	private JButton buttonFazerReserva;
	private JPanel painelInicioFormulario;
	private JLabel labelTituloPainelInicial;
	private JLabel labelSolicitante;
	private JLabel labelTelefone;
	private JTextField fieldTelefone;
	private JTextField fieldEmail;
	private JLabel labelNumeroAlunos;
	private JTextField fieldNumeroAlunos;
	private JLabel labelAtividade;
	private JRadioButton radioButtonAula;
	private JRadioButton radioButtonSeminario;
	private JRadioButton radioButtonProva;
	private ButtonGroup buttonGroupAtividade;
	private JTextField fieldSolicitante;
	private JComboBox comboBoxModalidade;
	private JComboBox comboBoxCurso;
	private JLabel labelAvancarPainelInicioFormulario;
	private JLabel labelInfo;
	private CardLayout card;
	private JPanel painelData;
	private JComboBox comboBoxQtdDias;
	private JButton buttonVerificaQtd;
	private JComboBox comboBoxInicioDia1;
	private JComboBox comboBoxInicioDia2;
	private JComboBox comboBoxInicioDia3;
	private JComboBox comboBoxInicioDia4;
	private JComboBox comboBoxInicioDia5;
	private JComboBox comboBoxInicioDia6;
	private JComboBox comboBoxFimDia1;
	private JComboBox comboBoxFimDia2;
	private JComboBox comboBoxFimDia3;
	private JComboBox comboBoxFimDia4;
	private JComboBox comboBoxFimDia5;
	private JComboBox comboBoxFimDia6;
	private JPanel painelEquipamentos;
	private JLabel labelAvisoEquipamento;
	private JLabel labelOutrosEquipamentos;
	private JCheckBox checkBoxProjetorDeSlides;
	private JCheckBox checkBoxRetroprojetor;
	private JCheckBox checkBoxOutroEspecificar;
	private JCheckBox checkBoxEquipamentoDeAudio;
	private JCheckBox checkBoxEquipamentoDvd;
	private JTextField fieldEspecificacao;
	private JLabel labelVoltarequipamentos;
	private JLabel labelProximoequipamentos;
	private JLabel labelAvancarPainelData;
	private JLabel labelVoltarPainelData;
	private JDateChooser dataPanelDia1;
	private JDateChooser dataPanelDia2;
	private JDateChooser dataPanelDia3;
	private JDateChooser dataPanelDia4;
	private JDateChooser dataPanelDia5;
	private JDateChooser dataPanelDia6;
	private JPanel painelConfirmarReserva;
	private JLabel labelMensagemPainelConfirmarReserva;
	private JButton buttonRevisar;
	private JButton buttonFinalizar;

	@SuppressWarnings("unchecked")
	public JanelaPrincipal() {
		setResizable(false);
		setTitle("Formulario Digital de Reservas de Sala de Aula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		card = new CardLayout();
		contentPane.setLayout(card);

		// ----------------------------------
		// Implementacao do Painel de Login
		// ----------------------------------
		painelLogin = new JPanel();
		painelLogin.setBackground(new Color(30, 76, 118));
		contentPane.add(painelLogin, "painelLogin");
		painelLogin.setLayout(new MigLayout("", "40[425px]20[grow]40", "30[97px]100[]10[]70[]60[]"));

		JLabel labelTituloPainelLogin = new JLabel(
				"<html><div style=\"text-align: center;\">Formul\u00E1rio Digital para <br />Reserva de Sala de Aula</html>");
		labelTituloPainelLogin.setForeground(new Color(255, 255, 255));
		labelTituloPainelLogin.setFont(new Font("Arial", Font.BOLD, 30));
		painelLogin.add(labelTituloPainelLogin, "cell 0 0,growy");

		JLabel labelFoto = new JLabel("");
		labelFoto.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/logo_ufcspa_branco.png")));
		painelLogin.add(labelFoto, "cell 1 0 2 1,alignx left");

		labelUsuario = new JLabel("Usu\u00E1rio Institucional");
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setFont(new Font("Arial", Font.PLAIN, 24));
		painelLogin.add(labelUsuario, "flowx,cell 0 1,alignx right");

		fieldUsuario = new JTextField();
		fieldUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		painelLogin.add(fieldUsuario, "cell 1 1,growx,aligny center");
		fieldUsuario.setColumns(10);

		labelSenha = new JLabel("Senha");
		labelSenha.setForeground(Color.WHITE);
		labelSenha.setFont(new Font("Arial", Font.PLAIN, 24));
		painelLogin.add(labelSenha, "flowx,cell 0 2,alignx right");

		fieldSenha = new JPasswordField();
		fieldSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		painelLogin.add(fieldSenha, "cell 1 2,growx,aligny center");

		buttonEntrar = new JButton("Entrar");
		buttonEntrar.setFont(new Font("Arial", Font.PLAIN, 22));
		buttonEntrar.setPreferredSize(new Dimension(200, 10));
		painelLogin.add(buttonEntrar, "cell 0 3 2 1,alignx center");

		labelInfo = new JLabel("");
		labelInfo.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/informatiom_smaller.png")));
		painelLogin.add(labelInfo, "flowx,cell 1 4,alignx right");

		// ----------------------------------
		// Imlementacao do Painel Inicial
		// ----------------------------------
		painelInicial = new JPanel();
		painelInicial.setBackground(new Color(30, 76, 118));
		contentPane.add(painelInicial, "painelInicial");
		painelInicial.setLayout(new MigLayout("", "40[grow]40", "70[][]160[]40[]"));

		labelMensagemNome = new JLabel("Ol\u00E1, ");
		labelMensagemNome.setForeground(new Color(255, 255, 255));
		labelMensagemNome.setFont(new Font("Arial", Font.BOLD, 45));
		painelInicial.add(labelMensagemNome, "cell 0 0");

		labelMensagem = new JLabel("Seja bem-vindo!");
		labelMensagem.setForeground(new Color(255, 255, 255));
		labelMensagem.setFont(new Font("Arial", Font.BOLD, 45));
		painelInicial.add(labelMensagem, "cell 0 1");

		labelMensagemEscolha = new JLabel("Escolha o que deseja fazer");
		labelMensagemEscolha.setForeground(new Color(255, 255, 255));
		labelMensagemEscolha.setFont(new Font("Arial", Font.PLAIN, 25));
		painelInicial.add(labelMensagemEscolha, "cell 0 2 2097051 1,alignx center");

		buttonVerReservas = new JButton("Ver reservas");
		buttonVerReservas.setFont(new Font("Arial", Font.PLAIN, 20));
		buttonVerReservas.setPreferredSize(new Dimension(200, 10));
		painelInicial.add(buttonVerReservas, "flowx,cell 0 3,alignx center");

		buttonFazerReserva = new JButton("Reservar");
		buttonFazerReserva.setFont(new Font("Arial", Font.PLAIN, 20));
		buttonFazerReserva.setPreferredSize(new Dimension(200, 10));
		painelInicial.add(buttonFazerReserva, "cell 0 3,alignx center");

		// -----------------------------------------------------
		// Implementacao do Painel que da inicio ao formulario
		// -----------------------------------------------------
		painelInicioFormulario = new JPanel();
		painelInicioFormulario.setBackground(new Color(30, 76, 118));
		contentPane.add(painelInicioFormulario, "painelInicioFormulario");
		painelInicioFormulario.setLayout(new MigLayout("", "40[][grow]40", "40[]30[]40[]40[]40[]40[]20[]15[30]5"));

		labelTituloPainelInicial = new JLabel("Formul\u00E1rio Digital de Reserva de Sala de Aula");
		labelTituloPainelInicial.setForeground(new Color(255, 255, 255));
		labelTituloPainelInicial.setFont(new Font("Arial", Font.BOLD, 30));
		painelInicioFormulario.add(labelTituloPainelInicial, "cell 0 0 4 1,alignx center");

		labelSolicitante = new JLabel("Solicitante");
		labelSolicitante.setForeground(new Color(255, 255, 255));
		labelSolicitante.setFont(new Font("Arial", Font.PLAIN, 25));
		painelInicioFormulario.add(labelSolicitante, "cell 0 1,alignx left");

		labelTelefone = new JLabel("Telefone");
		labelTelefone.setForeground(new Color(255, 255, 255));
		labelTelefone.setFont(new Font("Arial", Font.PLAIN, 25));
		painelInicioFormulario.add(labelTelefone, "cell 0 2");

		fieldTelefone = new JTextField();
		fieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painelInicioFormulario.add(fieldTelefone, "cell 1 2 3 1,grow");
		fieldTelefone.setColumns(10);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setForeground(new Color(255, 255, 255));
		labelEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		painelInicioFormulario.add(labelEmail, "cell 0 3,alignx left,aligny baseline");

		fieldEmail = new JTextField();
		fieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		painelInicioFormulario.add(fieldEmail, "cell 1 3 3 1,grow");
		fieldEmail.setColumns(10);

		labelNumeroAlunos = new JLabel("N\u00BA de alunos");
		labelNumeroAlunos.setForeground(new Color(255, 255, 255));
		labelNumeroAlunos.setFont(new Font("Arial", Font.PLAIN, 25));
		painelInicioFormulario.add(labelNumeroAlunos, "cell 0 4,alignx left,aligny bottom");

		fieldNumeroAlunos = new JTextField();
		fieldNumeroAlunos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		painelInicioFormulario.add(fieldNumeroAlunos, "cell 1 4 3 1,alignx left,growy");
		fieldNumeroAlunos.setColumns(10);

		labelAtividade = new JLabel("Atividade");
		labelAtividade.setForeground(new Color(255, 255, 255));
		labelAtividade.setFont(new Font("Arial", Font.PLAIN, 25));
		painelInicioFormulario.add(labelAtividade, "cell 0 5");

		radioButtonAula = new JRadioButton("Aula    \r\n");
		radioButtonAula.setActionCommand("Aula");
		radioButtonAula.setForeground(Color.WHITE);
		radioButtonAula.setBackground(new Color(30, 76, 118));
		radioButtonAula.setFont(new Font("Tahoma", Font.PLAIN, 23));
		painelInicioFormulario.add(radioButtonAula, "flowx,cell 1 5,alignx left");

		fieldSolicitante = new JTextField();
		fieldSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 25));
		painelInicioFormulario.add(fieldSolicitante, "cell 1 1 3 1,growx");
		fieldSolicitante.setColumns(10);

		String[] modalidades = { "Graduação", "Pós-Graduação (M ou D)", "Especialização", "Residência Médica" };
		comboBoxModalidade = new JComboBox(modalidades);
		comboBoxModalidade.setRenderer(new MyComboBoxRenderer("Selecione a modalidade"));
		comboBoxModalidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxModalidade.setSelectedIndex(-1);
		painelInicioFormulario.add(comboBoxModalidade, "cell 1 6,growx");

		String[] cursos = { "Biomedicina", "Biomedicina - noturno", "Enfermagem", "Farmácia", "Física Médica",
				"Fisioterapia", "Fonoaudiologia", "Gastronomia", "Gestão em Saúde", "Informática Biomédica", "Medicina",
				"Nutrição", "Psicologia", "Química Médica", "Tecnologia em Alimentos", "Toxicologia Analítica",
				" - Nenhum listado - " };
		comboBoxCurso = new JComboBox(cursos);
		comboBoxCurso.setRenderer(new MyComboBoxRenderer("Selecione o curso"));
		comboBoxCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxCurso.setSelectedIndex(-1);
		painelInicioFormulario.add(comboBoxCurso, "cell 1 6,growx");

		radioButtonSeminario = new JRadioButton("Seminario    ");
		radioButtonSeminario.setActionCommand("Seminário");
		radioButtonSeminario.setForeground(Color.WHITE);
		radioButtonSeminario.setBackground(new Color(30, 76, 118));
		radioButtonSeminario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		painelInicioFormulario.add(radioButtonSeminario, "cell 1 5,alignx center");

		radioButtonProva = new JRadioButton("Prova");
		radioButtonProva.setActionCommand("Prova");
		radioButtonProva.setForeground(Color.WHITE);
		radioButtonProva.setFont(new Font("Tahoma", Font.PLAIN, 23));
		radioButtonProva.setBackground(new Color(30, 76, 118));
		painelInicioFormulario.add(radioButtonProva, "cell 1 5,alignx right");

		buttonGroupAtividade = new ButtonGroup();
		buttonGroupAtividade.add(radioButtonAula);
		buttonGroupAtividade.add(radioButtonProva);
		buttonGroupAtividade.add(radioButtonSeminario);

		labelAvancarPainelInicioFormulario = new JLabel("");
		labelAvancarPainelInicioFormulario.setFont(new Font("Tahoma", Font.PLAIN, 6));
		labelAvancarPainelInicioFormulario
				.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/right-arrow.png")));
		painelInicioFormulario.add(labelAvancarPainelInicioFormulario, "cell 1 7,alignx right");

		// --------------------------------------------
		// Implementacao do Painel de seleção de data
		// --------------------------------------------
		painelData = new JPanel();
		contentPane.add(painelData, "painelData");
		painelData.setBackground(new Color(30, 76, 118));
		painelData.setLayout(new MigLayout("", "40[grow]30[220]30[220]40", "35[]43[]40[]40[]40[]40[]40[]33[30]5"));

		String[] numeroDias = { "1 Dia", "2 Dias", "3 Dias", "4 Dias", "5 Dias", "6 Dias" };
		comboBoxQtdDias = new JComboBox(numeroDias);
		comboBoxQtdDias.setRenderer(new MyComboBoxRenderer("Selecione o Nº de dias"));
		comboBoxQtdDias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxQtdDias.setSelectedIndex(-1);
		painelData.add(comboBoxQtdDias, "flowx,cell 0 0,growx");

		buttonVerificaQtd = new JButton("OK");
		buttonVerificaQtd.setActionCommand("OKdias");
		buttonVerificaQtd.setFont(new Font("Arial", Font.PLAIN, 16));
		buttonVerificaQtd.setPreferredSize(new Dimension(100, 10));
		painelData.add(buttonVerificaQtd, "cell 1 0");

		String[] horaInicial = { "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
				"22" };

		dataPanelDia1 = new JDateChooser();
		painelData.add(dataPanelDia1, "cell 0 1,grow");
		dataPanelDia1.setVisible(false);
		dataPanelDia1.setEnabled(false);

		comboBoxInicioDia1 = new JComboBox(horaInicial);
		comboBoxInicioDia1.setRenderer(new MyComboBoxRenderer("Selecione o horário inicial"));
		comboBoxInicioDia1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInicioDia1.setSelectedIndex(-1);
		painelData.add(comboBoxInicioDia1, "cell 1 1,growx");
		comboBoxInicioDia1.setVisible(false);
		comboBoxInicioDia1.setEnabled(false);

		dataPanelDia2 = new JDateChooser();
		painelData.add(dataPanelDia2, "cell 0 2,grow");
		dataPanelDia2.setVisible(false);
		dataPanelDia2.setEnabled(false);

		comboBoxInicioDia2 = new JComboBox(horaInicial);
		comboBoxInicioDia2.setRenderer(new MyComboBoxRenderer("Selecione o horário inicial"));
		comboBoxInicioDia2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInicioDia2.setSelectedIndex(-1);
		painelData.add(comboBoxInicioDia2, "cell 1 2,growx");
		comboBoxInicioDia2.setVisible(false);
		comboBoxInicioDia2.setEnabled(false);

		dataPanelDia3 = new JDateChooser();
		painelData.add(dataPanelDia3, "cell 0 3,grow");
		dataPanelDia3.setVisible(false);
		dataPanelDia3.setEnabled(false);

		comboBoxInicioDia3 = new JComboBox(horaInicial);
		comboBoxInicioDia3.setRenderer(new MyComboBoxRenderer("Selecione o horário inicial"));
		comboBoxInicioDia3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInicioDia3.setSelectedIndex(-1);
		painelData.add(comboBoxInicioDia3, "cell 1 3,growx");
		comboBoxInicioDia3.setVisible(false);
		comboBoxInicioDia3.setEnabled(false);

		dataPanelDia4 = new JDateChooser();
		painelData.add(dataPanelDia4, "cell 0 4,grow");
		dataPanelDia4.setVisible(false);
		dataPanelDia4.setEnabled(false);

		comboBoxInicioDia4 = new JComboBox(horaInicial);
		comboBoxInicioDia4.setRenderer(new MyComboBoxRenderer("Selecione o horário inicial"));
		comboBoxInicioDia4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInicioDia4.setSelectedIndex(-1);
		painelData.add(comboBoxInicioDia4, "cell 1 4,growx");
		comboBoxInicioDia4.setVisible(false);
		comboBoxInicioDia4.setEnabled(false);

		dataPanelDia5 = new JDateChooser();
		painelData.add(dataPanelDia5, "cell 0 5,grow");
		dataPanelDia5.setVisible(false);
		dataPanelDia5.setEnabled(false);

		comboBoxInicioDia5 = new JComboBox(horaInicial);
		comboBoxInicioDia5.setRenderer(new MyComboBoxRenderer("Selecione o horário inicial"));
		comboBoxInicioDia5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInicioDia5.setSelectedIndex(-1);
		painelData.add(comboBoxInicioDia5, "cell 1 5,growx");
		comboBoxInicioDia5.setVisible(false);
		comboBoxInicioDia5.setEnabled(false);

		dataPanelDia6 = new JDateChooser();
		painelData.add(dataPanelDia6, "cell 0 6,grow");
		dataPanelDia6.setVisible(false);
		dataPanelDia6.setEnabled(false);

		comboBoxInicioDia6 = new JComboBox(horaInicial);
		comboBoxInicioDia6.setRenderer(new MyComboBoxRenderer("Selecione o horário inicial"));
		comboBoxInicioDia6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInicioDia6.setSelectedIndex(-1);
		painelData.add(comboBoxInicioDia6, "cell 1 6,growx");
		comboBoxInicioDia6.setVisible(false);
		comboBoxInicioDia6.setEnabled(false);

		String[] horaFinal = { "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23" };

		comboBoxFimDia1 = new JComboBox(horaFinal);
		comboBoxFimDia1.setRenderer(new MyComboBoxRenderer("Selecione o horário final"));
		comboBoxFimDia1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFimDia1.setSelectedIndex(-1);
		painelData.add(comboBoxFimDia1, "cell 2 1,growx");
		comboBoxFimDia1.setVisible(false);
		comboBoxFimDia1.setEnabled(false);

		comboBoxFimDia2 = new JComboBox(horaFinal);
		comboBoxFimDia2.setRenderer(new MyComboBoxRenderer("Selecione o horário final"));
		comboBoxFimDia2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFimDia2.setSelectedIndex(-1);
		painelData.add(comboBoxFimDia2, "cell 2 2,growx");
		comboBoxFimDia2.setVisible(false);
		comboBoxFimDia2.setEnabled(false);

		comboBoxFimDia3 = new JComboBox(horaFinal);
		comboBoxFimDia3.setRenderer(new MyComboBoxRenderer("Selecione o horário final"));
		comboBoxFimDia3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFimDia3.setSelectedIndex(-1);
		painelData.add(comboBoxFimDia3, "cell 2 3,growx");
		comboBoxFimDia3.setVisible(false);
		comboBoxFimDia3.setEnabled(false);

		comboBoxFimDia4 = new JComboBox(horaFinal);
		comboBoxFimDia4.setRenderer(new MyComboBoxRenderer("Selecione o horário final"));
		comboBoxFimDia4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFimDia4.setSelectedIndex(-1);
		painelData.add(comboBoxFimDia4, "cell 2 4,growx");
		comboBoxFimDia4.setVisible(false);
		comboBoxFimDia4.setEnabled(false);

		comboBoxFimDia5 = new JComboBox(horaFinal);
		comboBoxFimDia5.setRenderer(new MyComboBoxRenderer("Selecione o horário final"));
		comboBoxFimDia5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFimDia5.setSelectedIndex(-1);
		painelData.add(comboBoxFimDia5, "cell 2 5,growx");
		comboBoxFimDia5.setVisible(false);
		comboBoxFimDia5.setEnabled(false);

		comboBoxFimDia6 = new JComboBox(horaFinal);
		comboBoxFimDia6.setRenderer(new MyComboBoxRenderer("Selecione o horário final"));
		comboBoxFimDia6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFimDia6.setSelectedIndex(-1);
		painelData.add(comboBoxFimDia6, "cell 2 6,growx");
		comboBoxFimDia6.setVisible(false);
		comboBoxFimDia6.setEnabled(false);

		labelVoltarPainelData = new JLabel("");
		labelVoltarPainelData.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/left-arrow.png")));
		painelData.add(labelVoltarPainelData, "cell 0 7");

		labelAvancarPainelData = new JLabel("");
		labelAvancarPainelData.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/right-arrow.png")));
		painelData.add(labelAvancarPainelData, "cell 2 7,alignx right");

		// -----------------------------------------------------
		// Implementacao do Painel de seleção de equipamentos
		// -----------------------------------------------------
		painelEquipamentos = new JPanel();
		contentPane.add(painelEquipamentos, "painelEquipamentos");
		painelEquipamentos.setBackground(new Color(30, 76, 118));
		painelEquipamentos.setLayout(new MigLayout("", "40[grow]30[grow]40", "40[]60[]20[]20[]20[]40[]36[30]4"));

		labelAvisoEquipamento = new JLabel(
				"<html><div style=\\\"text-align: center;\\\"><br /> Obs.: Todas as salas possuem computador e equipamento multim\u00EDdia.   Outros <br />equipamentos devem ser solicitados com anteced\u00EAncia m\u00EDnima de 24 horas ao <br />Setor de Apoio \u00E0s Salas de Aula.   Reserva para eventos devre\u00E3o ser realizados no <br />protocolo, com no m\u00EDnimo 45 dias de anteced\u00EAncia, conforme normas institucionais.</html>");
		labelAvisoEquipamento.setForeground(Color.WHITE);
		labelAvisoEquipamento.setFont(new Font("Arial", Font.PLAIN, 20));
		painelEquipamentos.add(labelAvisoEquipamento, "cell 0 0 2 1");

		labelOutrosEquipamentos = new JLabel("Outros Equipamentos");
		labelOutrosEquipamentos.setForeground(Color.WHITE);
		labelOutrosEquipamentos.setFont(new Font("Arial", Font.PLAIN, 30));
		painelEquipamentos.add(labelOutrosEquipamentos, "cell 0 1,alignx left");

		checkBoxProjetorDeSlides = new JCheckBox("     Projetor de Slides");
		checkBoxProjetorDeSlides.setFont(new Font("Arial", Font.PLAIN, 24));
		checkBoxProjetorDeSlides.setBackground(new Color(30, 76, 118));
		checkBoxProjetorDeSlides.setForeground(Color.WHITE);
		painelEquipamentos.add(checkBoxProjetorDeSlides, "cell 0 2");

		checkBoxEquipamentoDeAudio = new JCheckBox("     Equipamento de Audio");
		checkBoxEquipamentoDeAudio.setFont(new Font("Arial", Font.PLAIN, 24));
		checkBoxEquipamentoDeAudio.setBackground(new Color(30, 76, 118));
		checkBoxEquipamentoDeAudio.setForeground(Color.WHITE);
		painelEquipamentos.add(checkBoxEquipamentoDeAudio, "cell 1 2");

		checkBoxRetroprojetor = new JCheckBox("     Retroprojetor");
		checkBoxRetroprojetor.setFont(new Font("Arial", Font.PLAIN, 24));
		checkBoxRetroprojetor.setBackground(new Color(30, 76, 118));
		checkBoxRetroprojetor.setForeground(Color.WHITE);
		painelEquipamentos.add(checkBoxRetroprojetor, "cell 0 3");

		checkBoxEquipamentoDvd = new JCheckBox("     Equipamento DVD");
		checkBoxEquipamentoDvd.setFont(new Font("Arial", Font.PLAIN, 24));
		checkBoxEquipamentoDvd.setBackground(new Color(30, 76, 118));
		checkBoxEquipamentoDvd.setForeground(Color.WHITE);
		painelEquipamentos.add(checkBoxEquipamentoDvd, "cell 1 3");

		checkBoxOutroEspecificar = new JCheckBox("     Outro. Especificar: ");
		checkBoxOutroEspecificar.setFont(new Font("Arial", Font.PLAIN, 24));
		checkBoxOutroEspecificar.setBackground(new Color(30, 76, 118));
		checkBoxOutroEspecificar.setForeground(Color.WHITE);
		painelEquipamentos.add(checkBoxOutroEspecificar, "cell 0 4");

		fieldEspecificacao = new JTextField();
		fieldEspecificacao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painelEquipamentos.add(fieldEspecificacao, "cell 1 4,growx");
		fieldEspecificacao.setColumns(10);

		labelVoltarequipamentos = new JLabel("");
		labelVoltarequipamentos.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/left-arrow.png")));
		painelEquipamentos.add(labelVoltarequipamentos, "cell 0 6");

		labelProximoequipamentos = new JLabel("");
		labelProximoequipamentos.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/right-arrow.png")));
		painelEquipamentos.add(labelProximoequipamentos, "cell 1 6,alignx right");
		
		painelConfirmarReserva = new JPanel();
		contentPane.add(painelConfirmarReserva, "name_119666830671800");
		painelConfirmarReserva.setBackground(new Color(30, 76, 118));
		painelConfirmarReserva.setLayout(new MigLayout("", "40[grow]40", "280[]40[]"));
		
		labelMensagemPainelConfirmarReserva = new JLabel("Deseja finalizar a solicita\u00E7\u00E3o?");
		labelMensagemPainelConfirmarReserva.setForeground(Color.WHITE);
		labelMensagemPainelConfirmarReserva.setFont(new Font("Arial", Font.PLAIN, 25));
		painelConfirmarReserva.add(labelMensagemPainelConfirmarReserva, "cell 0 0,alignx center");
		
		buttonRevisar = new JButton("Revisar");
		buttonRevisar.setFont(new Font("Arial", Font.PLAIN, 20));
		buttonRevisar.setPreferredSize(new Dimension(200, 10));
		painelConfirmarReserva.add(buttonRevisar, "flowx,cell 0 1,alignx center");
		
		buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setFont(new Font("Arial", Font.PLAIN, 20));
		buttonFinalizar.setPreferredSize(new Dimension(200, 10));
		painelConfirmarReserva.add(buttonFinalizar, "cell 0 1,alignx center");

	}
	
	//-----------------------------------------------
	//------Rotina para inicialização de formas------ 
	//-----------------------------------------------
	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		Line2D li = new Line2D.Double(415, 90, 415, 265);
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(4));
		g2.draw(li);

		g2.dispose();
	}
	
	//-----------------------------------------------
	//----------Texto de Getters e Setters-----------
	//-----------------------------------------------
	public JCheckBox getCheckBoxProjetorDeSlides() {
		return checkBoxProjetorDeSlides;
	}

	public void setCheckBoxProjetorDeSlides(JCheckBox checkBoxProjetorDeSlides) {
		this.checkBoxProjetorDeSlides = checkBoxProjetorDeSlides;
	}

	public JCheckBox getCheckBoxRetroprojetor() {
		return checkBoxRetroprojetor;
	}

	public void setCheckBoxRetroprojetor(JCheckBox checkBoxRetroprojetor) {
		this.checkBoxRetroprojetor = checkBoxRetroprojetor;
	}

	public JCheckBox getCheckBoxOutroEspecificar() {
		return checkBoxOutroEspecificar;
	}

	public void setCheckBoxOutroEspecificar(JCheckBox checkBoxOutroEspecificar) {
		this.checkBoxOutroEspecificar = checkBoxOutroEspecificar;
	}

	public JCheckBox getCheckBoxEquipamentoDeAudio() {
		return checkBoxEquipamentoDeAudio;
	}

	public void setCheckBoxEquipamentoDeAudio(JCheckBox checkBoxEquipamentoDeAudio) {
		this.checkBoxEquipamentoDeAudio = checkBoxEquipamentoDeAudio;
	}

	public JCheckBox getCheckBoxEquipamentoDvd() {
		return checkBoxEquipamentoDvd;
	}

	public void setCheckBoxEquipamentoDvd(JCheckBox checkBoxEquipamentoDvd) {
		this.checkBoxEquipamentoDvd = checkBoxEquipamentoDvd;
	}

	public JTextField getFieldEspecificacao() {
		return fieldEspecificacao;
	}

	public void setFieldEspecificacao(JTextField fieldEspecificacao) {
		this.fieldEspecificacao = fieldEspecificacao;
	}

	public JButton getButtonVerificaQtd() {
		return buttonVerificaQtd;
	}

	public void setButtonVerificaQtd(JButton buttonVerificaQtd) {
		this.buttonVerificaQtd = buttonVerificaQtd;
	}

	public JDateChooser getDataPanelDia1() {
		return dataPanelDia1;
	}

	public void setDataPanelDia1(JDateChooser dataPanelDia1) {
		this.dataPanelDia1 = dataPanelDia1;
	}

	public JDateChooser getDataPanelDia2() {
		return dataPanelDia2;
	}

	public void setDataPanelDia2(JDateChooser dataPanelDia2) {
		this.dataPanelDia2 = dataPanelDia2;
	}

	public JDateChooser getDataPanelDia3() {
		return dataPanelDia3;
	}

	public void setDataPanelDia3(JDateChooser dataPanelDia3) {
		this.dataPanelDia3 = dataPanelDia3;
	}

	public JDateChooser getDataPanelDia4() {
		return dataPanelDia4;
	}

	public void setDataPanelDia4(JDateChooser dataPanelDia4) {
		this.dataPanelDia4 = dataPanelDia4;
	}

	public JDateChooser getDataPanelDia5() {
		return dataPanelDia5;
	}

	public void setDataPanelDia5(JDateChooser dataPanelDia5) {
		this.dataPanelDia5 = dataPanelDia5;
	}

	public JDateChooser getDataPanelDia6() {
		return dataPanelDia6;
	}

	public void setDataPanelDia6(JDateChooser dataPanelDia6) {
		this.dataPanelDia6 = dataPanelDia6;
	}

	public JLabel getLabelInfo() {
		return labelInfo;
	}

	public void setLabelInfo(JLabel labelInfo) {
		this.labelInfo = labelInfo;
	}

	public JPanel getPainelLogin() {
		return painelLogin;
	}

	public void setPainelLogin(JPanel painelLogin) {
		this.painelLogin = painelLogin;
	}

	public JTextField getFieldUsuario() {
		return fieldUsuario;
	}

	public void setFieldUsuario(JTextField fieldUsuario) {
		this.fieldUsuario = fieldUsuario;
	}

	public JComboBox getComboBoxQtdDias() {
		return comboBoxQtdDias;
	}

	public void setComboBoxQtdDias(JComboBox comboBoxQtdDias) {
		this.comboBoxQtdDias = comboBoxQtdDias;
	}

	public JComboBox getComboBoxInicioDia1() {
		return comboBoxInicioDia1;
	}

	public void setComboBoxInicioDia1(JComboBox comboBoxInicioDia1) {
		this.comboBoxInicioDia1 = comboBoxInicioDia1;
	}

	public JComboBox getComboBoxInicioDia2() {
		return comboBoxInicioDia2;
	}

	public void setComboBoxInicioDia2(JComboBox comboBoxInicioDia2) {
		this.comboBoxInicioDia2 = comboBoxInicioDia2;
	}

	public JComboBox getComboBoxInicioDia3() {
		return comboBoxInicioDia3;
	}

	public void setComboBoxInicioDia3(JComboBox comboBoxInicioDia3) {
		this.comboBoxInicioDia3 = comboBoxInicioDia3;
	}

	public JComboBox getComboBoxInicioDia4() {
		return comboBoxInicioDia4;
	}

	public void setComboBoxInicioDia4(JComboBox comboBoxInicioDia4) {
		this.comboBoxInicioDia4 = comboBoxInicioDia4;
	}

	public JComboBox getComboBoxInicioDia5() {
		return comboBoxInicioDia5;
	}

	public void setComboBoxInicioDia5(JComboBox comboBoxInicioDia5) {
		this.comboBoxInicioDia5 = comboBoxInicioDia5;
	}

	public JComboBox getComboBoxInicioDia6() {
		return comboBoxInicioDia6;
	}

	public JLabel getLabelProximoequipamentos() {
		return labelProximoequipamentos;
	}

	public void setLabelProximoequipamentos(JLabel labelProximoequipamentos) {
		this.labelProximoequipamentos = labelProximoequipamentos;
	}

	public void setComboBoxInicioDia6(JComboBox comboBoxInicioDia6) {
		this.comboBoxInicioDia6 = comboBoxInicioDia6;
	}

	public JComboBox getComboBoxFimDia1() {
		return comboBoxFimDia1;
	}

	public void setComboBoxFimDia1(JComboBox comboBoxFimDia1) {
		this.comboBoxFimDia1 = comboBoxFimDia1;
	}

	public JComboBox getComboBoxFimDia2() {
		return comboBoxFimDia2;
	}

	public void setComboBoxFimDia2(JComboBox comboBoxFimDia2) {
		this.comboBoxFimDia2 = comboBoxFimDia2;
	}

	public JComboBox getComboBoxFimDia3() {
		return comboBoxFimDia3;
	}

	public void setComboBoxFimDia3(JComboBox comboBoxFimDia3) {
		this.comboBoxFimDia3 = comboBoxFimDia3;
	}

	public JComboBox getComboBoxFimDia4() {
		return comboBoxFimDia4;
	}

	public void setComboBoxFimDia4(JComboBox comboBoxFimDia4) {
		this.comboBoxFimDia4 = comboBoxFimDia4;
	}

	public JComboBox getComboBoxFimDia5() {
		return comboBoxFimDia5;
	}

	public void setComboBoxFimDia5(JComboBox comboBoxFimDia5) {
		this.comboBoxFimDia5 = comboBoxFimDia5;
	}

	public JComboBox getComboBoxFimDia6() {
		return comboBoxFimDia6;
	}

	public void setComboBoxFimDia6(JComboBox comboBoxFimDia6) {
		this.comboBoxFimDia6 = comboBoxFimDia6;
	}

	public JTextField getFieldSenha() {
		return fieldSenha;
	}

	public void setFieldSenha(JPasswordField fieldSenha) {
		this.fieldSenha = fieldSenha;
	}

	public JButton getButtonEntrar() {
		return buttonEntrar;
	}

	public void setButtonEntrar(JButton buttonEntrar) {
		this.buttonEntrar = buttonEntrar;
	}

	public JLabel getLabelMensagemNome() {
		return labelMensagemNome;
	}

	public void setLabelMensagemNome(JLabel labelMensagemNome) {
		this.labelMensagemNome = labelMensagemNome;
	}

	public JButton getButtonVerReservas() {
		return buttonVerReservas;
	}

	public void setButtonVerReservas(JButton buttonVerReservas) {
		this.buttonVerReservas = buttonVerReservas;
	}

	public JButton getButtonFazerReserva() {
		return buttonFazerReserva;
	}

	public void setButtonFazerReserva(JButton buttonFazerReserva) {
		this.buttonFazerReserva = buttonFazerReserva;
	}

	public JTextField getFieldTelefone() {
		return fieldTelefone;
	}

	public void setFieldTelefone(JTextField fieldTelefone) {
		this.fieldTelefone = fieldTelefone;
	}

	public JTextField getFieldEmail() {
		return fieldEmail;
	}

	public void setFieldEmail(JTextField fieldEmail) {
		this.fieldEmail = fieldEmail;
	}

	public JTextField getFieldNumeroAlunos() {
		return fieldNumeroAlunos;
	}

	public void setFieldNumeroAlunos(JTextField fieldNumeroAlunos) {
		this.fieldNumeroAlunos = fieldNumeroAlunos;
	}

	public JRadioButton getRadioButtonAula() {
		return radioButtonAula;
	}

	public void setRadioButtonAula(JRadioButton radioButtonAula) {
		this.radioButtonAula = radioButtonAula;
	}

	public JRadioButton getRadioButtonSeminario() {
		return radioButtonSeminario;
	}

	public void setRadioButtonSeminario(JRadioButton radioButtonSeminario) {
		this.radioButtonSeminario = radioButtonSeminario;
	}

	public JRadioButton getRadioButtonProva() {
		return radioButtonProva;
	}

	public void setRadioButtonProva(JRadioButton radioButtonProva) {
		this.radioButtonProva = radioButtonProva;
	}

	public JTextField getFieldSolicitante() {
		return fieldSolicitante;
	}

	public void setFieldSolicitante(JTextField fieldSolicitante) {
		this.fieldSolicitante = fieldSolicitante;
	}

	public JComboBox getComboBoxModalidade() {
		return comboBoxModalidade;
	}

	public void setComboBoxModalidade(JComboBox comboBoxModalidade) {
		this.comboBoxModalidade = comboBoxModalidade;
	}

	public JComboBox getComboBoxCurso() {
		return comboBoxCurso;
	}

	public void setComboBoxCurso(JComboBox comboBoxCurso) {
		this.comboBoxCurso = comboBoxCurso;
	}

	public JLabel getLabelAvancarPainelInicioFormulario() {
		return labelAvancarPainelInicioFormulario;
	}

	public void setLabelAvancarPainelInicioFormulario(JLabel labelAvancarPainelInicioFormulario) {
		this.labelAvancarPainelInicioFormulario = labelAvancarPainelInicioFormulario;
	}

	public JLabel getLabelVoltarPainelData() {
		return labelVoltarPainelData;
	}

	public void setLabelVoltarPainelData(JLabel labelVoltarPainelData) {
		this.labelVoltarPainelData = labelVoltarPainelData;
	}

	public JLabel getLabelAvancarPainelData() {
		return labelAvancarPainelData;
	}

	public void setLabelAvancarPainelData(JLabel labelAvancarPainelData) {
		this.labelAvancarPainelData = labelAvancarPainelData;
	}

	public ButtonGroup getButtonGroupAtividade() {
		return buttonGroupAtividade;
	}

	public JLabel getLabelVoltarequipamentos() {
		return labelVoltarequipamentos;
	}

	public void setLabelVoltarequipamentos(JLabel labelVoltarequipamentos) {
		this.labelVoltarequipamentos = labelVoltarequipamentos;
	}

	public void setButtonGroupAtividade(ButtonGroup buttonGroupAtividade) {
		this.buttonGroupAtividade = buttonGroupAtividade;
	}

	public JButton getButtonRevisar() {
		return buttonRevisar;
	}

	public void setButtonRevisar(JButton buttonRevisar) {
		this.buttonRevisar = buttonRevisar;
	}

	public JButton getButtonFinalizar() {
		return buttonFinalizar;
	}

	public void setButtonFinalizar(JButton buttonFinalizar) {
		this.buttonFinalizar = buttonFinalizar;
	}

	// Classe para fixar mensagens não selecionaveis nos JComboBox presentes no
	// painelInicioFormulario
	class MyComboBoxRenderer extends JLabel implements ListCellRenderer {
		private String _title;

		public MyComboBoxRenderer(String title) {
			_title = title;
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean hasFocus) {
			if (index == -1 && value == null)
				setText(_title);
			else
				setText(value.toString());
			return this;
		}
	}

	// Me´todo que troca de painel
	public void trocarPainel(String nomePainel) {
		card.show(contentPane, nomePainel);
	}

	// Métodos que quando chamados exibem mensagens
	// Mensagem de erro
	public void mensagemErroAutenticacao() {
		JOptionPane.showMessageDialog(this, "Usuário ou senha incorreto! Por favor, verifique os dados inseridos.",
				null, JOptionPane.ERROR_MESSAGE, null);
	}
}
