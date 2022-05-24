package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dominio.Cliente;

import Repositorio.ClienteRepositorio;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InfoClientes extends JFrame {

	private JPanel contentPane;
	private ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
	private JScrollPane scrollPane;
	private JTable clientesLocalizadosJTable;
	Infofrete FormInfoFrete = new Infofrete();
	GestaoRotas FormgestaoRotas = new GestaoRotas();
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoClientes frame = new InfoClientes();
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
	public InfoClientes() {
		setTitle("INFORMA\u00C7\u00D5ES");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 989, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 27, 742, 282);
		contentPane.add(scrollPane);
		
		JButton btnListarClientes = new JButton("Listar clientes");
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListarClientes();
				
			}
		});
		btnListarClientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListarClientes.setBounds(10, 106, 177, 23);
		contentPane.add(btnListarClientes);
		
		JButton btninfofrete = new JButton("Info Fretes");
		btninfofrete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				FormInfoFrete.setVisible(true);
				
			}
		});
		btninfofrete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btninfofrete.setBounds(10, 137, 177, 23);
		contentPane.add(btninfofrete);
		
		JButton btnRotas = new JButton("Rotas");
		btnRotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				FormgestaoRotas.setVisible(true);
				
			}
		});
		btnRotas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRotas.setBounds(10, 171, 177, 23);
		contentPane.add(btnRotas);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 78, 221, 150);
		contentPane.add(panel);
	}
	
	
	
	
	private void ListarClientes() {
		clientesLocalizadosJTable = clienteRepositorio.ObterClientesJtable();
		clientesLocalizadosJTable.setDefaultEditor(Object.class, null);
		//automoveisLocalizadosJTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		scrollPane.setViewportView(clientesLocalizadosJTable);
		
		clientesLocalizadosJTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					ColocarProdutoEmModoDeEdicao(clientesLocalizadosJTable.getSelectedColumn(),
							clientesLocalizadosJTable.getSelectedRow());
				}
			}
		});

	}
	
	private void ColocarProdutoEmModoDeEdicao(int selectedColumn, int selectedRow) {
		// TODO Auto-generated method stub

		int id = (int) this.clientesLocalizadosJTable.getModel().getValueAt(selectedRow, 0);

		Cliente ClienteASerEditado = clienteRepositorio.ObterClientelPorId(id);

		//PreencherCampos(ClienteASerEditado);
	}
	
	
	/*private void PreencherCampos(Cliente clienteASerEditado) {
		cliente.lblIdentificador.setText(String.valueOf(clienteASerEditado.getId()));
		textBairro.setText(clienteASerEditado.getBairro());
		textCelular.setText(clienteASerEditado.getCelular());
		textCep.setText(clienteASerEditado.getCep());
		textCidade.setText(clienteASerEditado.getCidade());
		textCliente.setText(clienteASerEditado.getCliente());
		textCnpj.setText(clienteASerEditado.getCnpj());
		textEmail.setText(clienteASerEditado.getEmail());
		textEndereco.setText(clienteASerEditado.getEndereco());
		textNum.setText(clienteASerEditado.getNumero());
		textTelefone.setText(clienteASerEditado.getTelefone());
		comboBoxClasse.setSelectedItem(clienteASerEditado.getClasse());
		
	}*/
	
}

