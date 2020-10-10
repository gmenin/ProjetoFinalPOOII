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
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

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

	public JanelaPrincipal() {
		setTitle("Formulario Digital de Reservas de Sala de Aula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		painelLogin = new JPanel();
		painelLogin.setBackground(new Color(51, 102, 153));
		contentPane.add(painelLogin, "name_95302867270400");
		painelLogin.setLayout(new MigLayout("", "[425px][grow]", "[97px]100[40][40]70[][]"));

		JLabel labelTituloPainelLogin = new JLabel("<html><div style=\"text-align: center;\">Formul\u00E1rio Digital para <br />Reserva de Sala de Aula</html>");
		labelTituloPainelLogin.setForeground(new Color(255, 255, 255));
		labelTituloPainelLogin.setFont(new Font("Arial", Font.BOLD, 30));
		painelLogin.add(labelTituloPainelLogin, "cell 0 0,alignx center,growy");

		JLabel labelFoto = new JLabel("");
		labelFoto.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/logo_ufcspa_branco.png")));
		painelLogin.add(labelFoto, "cell 1 0");
		
		labelUsuario = new JLabel("Usu\u00E1rio Institucional");
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setFont(new Font("Arial", Font.PLAIN, 24));
		painelLogin.add(labelUsuario, "flowx,cell 0 1,alignx center");
		
		fieldUsuario = new JTextField();
		painelLogin.add(fieldUsuario, "cell 1 1,grow");
		fieldUsuario.setColumns(10);
		
		labelSenha = new JLabel("Senha");
		labelSenha.setForeground(Color.WHITE);
		labelSenha.setFont(new Font("Arial", Font.PLAIN, 24));
		painelLogin.add(labelSenha, "flowx,cell 0 2,alignx center");
		
		fieldSenha = new JPasswordField();
		painelLogin.add(fieldSenha, "cell 1 2,grow");
		
		buttonEntrar = new JButton("Entrar");
		buttonEntrar.setFont(new Font("Arial", Font.PLAIN, 22));
		painelLogin.add(buttonEntrar, "cell 0 3,alignx right");
		
		buttonInfo = new JButton("");
		buttonInfo.setBackground(new Color(51, 102, 153));
		buttonInfo.setForeground(new Color(51, 102, 153));
		buttonInfo.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/figuras/information_small.png")));
		painelLogin.add(buttonInfo, "cell 1 4");
		
//		graph = painelLogin.getGraphics();
//		graph.drawLine(425, 20, 425, 100);
		
	}

	public JPanel getPainelLogin() {
		return painelLogin;
	}

	public void setPainelLogin(JPanel painelLogin) {
		this.painelLogin = painelLogin;
	}

}
