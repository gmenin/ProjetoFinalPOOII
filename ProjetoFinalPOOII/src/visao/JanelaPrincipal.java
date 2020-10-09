package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;

	public JanelaPrincipal() {
		setTitle("Formulario Digital para Reservas de Aula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.setVisible(false);
		
		
		JPanel paninelInicial = new JPanel();
		paninelInicial.setVisible(true);
		contentPane.add(paninelInicial, "name_91394305391200");
		
		
	}

}
