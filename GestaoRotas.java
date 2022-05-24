package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repositorio.ClienteRepositorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class GestaoRotas extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable clientesLocalizadosJTable;
	private ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestaoRotas frame = new GestaoRotas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestaoRotas() {
		setTitle("GESTAO ROTAS");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 995, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Carregar dados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListarClientes();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(219, 11, 168, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 959, 362);
		contentPane.add(scrollPane);
	}

	private void ListarClientes() {
		clientesLocalizadosJTable = clienteRepositorio.ObterClientesJtable();
		clientesLocalizadosJTable.setDefaultEditor(Object.class, null);
		//automoveisLocalizadosJTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		scrollPane.setViewportView(clientesLocalizadosJTable);
		
		clientesLocalizadosJTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					
					JOptionPane.showConfirmDialog(null, "CLIENTE COM PRIORIDADE?");
					
				}
			}
		});

	}
	
	
	
	
	
}
