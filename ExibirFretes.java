package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repositorio.ClienteRepositorio;
import Repositorio.FretesRepositorio;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ExibirFretes extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable fretesLocalizadosJTable;
	private FretesRepositorio fretesRepositorio = new FretesRepositorio();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirFretes frame = new ExibirFretes();
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
	public ExibirFretes() {
		setTitle("CHECKLIST");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 629, 262);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("EXIBIR CHECKLIST");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListarFretes();
				
			}
		});
		btnNewButton.setBounds(200, 284, 201, 23);
		contentPane.add(btnNewButton);
	}
	
	
	private void ListarFretes() {
		fretesLocalizadosJTable = fretesRepositorio.ObterFretesJtable();
		fretesLocalizadosJTable.setDefaultEditor(Object.class, null);
		//automoveisLocalizadosJTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		scrollPane.setViewportView(fretesLocalizadosJTable);

	}
	
	
	
}
