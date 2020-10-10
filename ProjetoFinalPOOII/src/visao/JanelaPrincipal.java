package visao;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private Graphics graph;
	private JPanel painelLogin;
	private JLabel labelUsuario;
	private JLabel labelSenha;
	private JTextField fieldUsuario;
	private JPasswordField fieldSenha;
	private JButton buttonEntrar;
	private JButton buttonInfo;
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
	private JTextField fieldSolicitante;
	private JComboBox comboBoxModalidade;
	private JComboBox comboBoxCurso;

	@SuppressWarnings("unchecked")
	public JanelaPrincipal() {
		setTitle("Formulario Digital de Reservas de Sala de Aula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//-------------------------------------------------------------------------------------------------
		// Implementacao do Painel de Login
		painelLogin = new JPanel();
		painelLogin.setBackground(new Color(30, 76, 118));
		contentPane.add(painelLogin, "name_95302867270400");
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
		painelLogin.add(buttonEntrar, "cell 0 3 2 1,alignx center");

		buttonInfo = new JButton("");
		buttonInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(painelInicioFormulario);
				contentPane.repaint();
				contentPane.revalidate();
				System.out.println("Teste");
				
			}
		});
		buttonInfo.setBackground(new Color(30, 76, 118));
		buttonInfo.setForeground(new Color(30, 76, 118));
		buttonInfo.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/informatiom_smaller.png")));
		painelLogin.add(buttonInfo, "cell 1 4,alignx right");

		// Imlementacao do Painel Inicial
		painelInicial = new JPanel();
		painelInicial.setBackground(new Color(51, 102, 153));
		contentPane.add(painelInicial, "name_147314382581700");
		painelInicial.setLayout(new MigLayout("", "40[grow]40", "70[][]150[]70[]"));

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
		painelInicial.add(buttonVerReservas, "flowx,cell 0 3,alignx center");

		buttonFazerReserva = new JButton("Reservar");
		buttonFazerReserva.setFont(new Font("Arial", Font.PLAIN, 20));
		painelInicial.add(buttonFazerReserva, "cell 0 3,alignx center");

		// Implementacao do Painel que da inicio ao formulario
		painelInicioFormulario = new JPanel();
		painelInicioFormulario.setBackground(new Color(51, 102, 153));
		contentPane.add(painelInicioFormulario, "name_148859187392200");
		painelInicioFormulario.setLayout(new MigLayout("", "[][grow][][]", "20[]50[]40[]40[]40[]40[][]"));

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
		fieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 25));
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

		radioButtonAula = new JRadioButton("Aula");
		radioButtonAula.setForeground(Color.WHITE);
		radioButtonAula.setBackground(new Color(51, 102, 153));
		radioButtonAula.setFont(new Font("Tahoma", Font.PLAIN, 23));
		painelInicioFormulario.add(radioButtonAula, "flowx,cell 1 5,alignx left");

		fieldSolicitante = new JTextField();
		fieldSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 25));
		painelInicioFormulario.add(fieldSolicitante, "cell 1 1 3 1,growx");
		fieldSolicitante.setColumns(10);

		String[] modalidades = { "Graduação", "Pós-Educação" };
		comboBoxModalidade = new JComboBox(modalidades);
		comboBoxModalidade.setRenderer(new MyComboBoxRenderer("Selecione a modalidade"));
		comboBoxModalidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxModalidade.setSelectedIndex(-1);
		painelInicioFormulario.add(comboBoxModalidade, "flowx,cell 1 6 3 1,grow");

		String[] cursos = { "Biomedicina", "Biomedicina - nortuno", "Enfermagem", "Farmácia", "Física Médica",
				"Fisioterapia", "Fonoaudiologia", "Gastronomia", "Gestão em Saúde", "Informática Biomédica", "Medicina",
				"Nutrição", "Psicologia", "Química Médica", "Tecnologia em Alimentos", "Toxicologia Analítica" };
		comboBoxCurso = new JComboBox(cursos);
		comboBoxCurso.setRenderer(new MyComboBoxRenderer("Selecione o curso"));
		comboBoxCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxCurso.setSelectedIndex(-1);
		painelInicioFormulario.add(comboBoxCurso, "cell 2 6,grow");
		
				radioButtonSeminario = new JRadioButton("Seminario");
				radioButtonSeminario.setForeground(Color.WHITE);
				radioButtonSeminario.setBackground(new Color(51, 102, 153));
				radioButtonSeminario.setFont(new Font("Tahoma", Font.PLAIN, 23));
				painelInicioFormulario.add(radioButtonSeminario, "cell 1 5,alignx center");
				
						radioButtonProva = new JRadioButton("Prova");
						radioButtonProva.setForeground(Color.WHITE);
						radioButtonProva.setFont(new Font("Tahoma", Font.PLAIN, 23));
						radioButtonProva.setBackground(new Color(51, 102, 153));
						painelInicioFormulario.add(radioButtonProva, "cell 1 5,alignx right");

//		graph = painelLogin.getGraphics();
//		graph.drawLine(425, 20, 425, 100);

	}

	public JPanel getPainelLogin() {
		return painelLogin;
	}

	public void setPainelLogin(JPanel painelLogin) {
		this.painelLogin = painelLogin;
	}

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
}
