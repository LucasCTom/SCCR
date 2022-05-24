package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


import Dominio.Cliente;

import Repositorio.ClienteRepositorio;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class GestaoClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textCliente;
	private JTextField textCnpj;
	private JTextField textCep;
	private JTextField textBairro;
	private JTextField textEndereco;
	private JTextField textCidade;
	private JTextField textNum;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JTextField textCelular;
	private JComboBox comboBoxUF;
	private JComboBox comboBoxAbast;
	private JComboBox comboBoxClasse;
	private JTable clientesLocalizadosJTable;
	private JLabel lblIdentificador;
	private ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
	InfoClientes FormInfoClientes = new InfoClientes();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestaoClientes frame = new GestaoClientes();
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
	public GestaoClientes() {
		setTitle("GESTAO CLIENTES");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 814, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 798, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 11, 46, 14);
		panel.add(lblId);
		
		lblIdentificador = new JLabel("");
		lblIdentificador.setBounds(51, 11, 46, 14);
		panel.add(lblIdentificador);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliente.setBounds(10, 50, 46, 14);
		panel.add(lblCliente);
		
		textCliente = new JTextField();
		textCliente.setBounds(66, 47, 218, 20);
		panel.add(textCliente);
		textCliente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cnpj/Cpf:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(346, 47, 72, 17);
		panel.add(lblNewLabel);
		
		textCnpj = new JTextField();
		textCnpj.setBounds(443, 44, 258, 20);
		panel.add(textCnpj);
		textCnpj.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(0, 110, 798, 99);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCep.setBounds(10, 23, 46, 14);
		panel_1.add(lblCep);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBairro.setBounds(10, 64, 46, 14);
		panel_1.add(lblBairro);
		
		textCep = new JTextField();
		textCep.setBounds(47, 20, 157, 20);
		panel_1.add(textCep);
		textCep.setColumns(10);
		
		textBairro = new JTextField();
		textBairro.setBounds(57, 61, 191, 20);
		panel_1.add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(275, 26, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(258, 64, 83, 14);
		panel_1.add(lblNewLabel_2);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(326, 61, 255, 20);
		panel_1.add(textEndereco);
		textEndereco.setColumns(10);
		
		textCidade = new JTextField();
		textCidade.setBounds(331, 23, 250, 20);
		panel_1.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(591, 69, 86, 14);
		panel_1.add(lblNumero);
		
		textNum = new JTextField();
		textNum.setBounds(647, 68, 119, 20);
		panel_1.add(textNum);
		textNum.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUf.setBounds(602, 23, 46, 14);
		panel_1.add(lblUf);
		
		comboBoxUF = new JComboBox();
		comboBoxUF.setModel(new DefaultComboBoxModel(new String[] {"<SELECIONE>", "AC", "AL", "AP", "AM", "BA", "CE", "DF ", "ES", "GO ", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBoxUF.setBounds(625, 22, 127, 20);
		panel_1.add(comboBoxUF);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(0, 224, 798, 54);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textEmail = new JTextField();
		textEmail.setBounds(53, 13, 165, 20);
		panel_2.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 14, 46, 14);
		panel_2.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(248, 16, 70, 14);
		panel_2.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(316, 13, 230, 20);
		panel_2.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(556, 14, 46, 14);
		panel_2.add(lblCelular);
		
		textCelular = new JTextField();
		textCelular.setBounds(612, 13, 176, 20);
		panel_2.add(textCelular);
		textCelular.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(0, 289, 798, 65);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblAbastecimento = new JLabel("Abastecimento:");
		lblAbastecimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAbastecimento.setBounds(10, 22, 116, 14);
		panel_3.add(lblAbastecimento);
		
		comboBoxAbast = new JComboBox();
		comboBoxAbast.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxAbast.setModel(new DefaultComboBoxModel(new String[] {"<SELECIONE>", "Semanal", "Quinzenal", "Mensal"}));
		comboBoxAbast.setBounds(112, 21, 116, 20);
		panel_3.add(comboBoxAbast);
		
		JLabel lblClasseCliente = new JLabel("Classe Cliente:");
		lblClasseCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClasseCliente.setBounds(266, 24, 109, 14);
		panel_3.add(lblClasseCliente);
		
		comboBoxClasse = new JComboBox();
		comboBoxClasse.setModel(new DefaultComboBoxModel(new String[] {"<SELECIONE>", "A", "B", "C", "D"}));
		comboBoxClasse.setBounds(359, 21, 116, 20);
		panel_3.add(comboBoxClasse);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limparCampos();
				
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovo.setBounds(106, 365, 89, 23);
		contentPane.add(btnNovo);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (lblIdentificador.getText().equals(" "))
					InserirCliente();
				else
					AtualizarCliente();

				
				
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setBounds(229, 365, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnInfo = new JButton("MAIS INFORMA\u00C7\u00D5ES");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FormInfoClientes.setVisible(true);
				
			}
		});
		btnInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInfo.setBounds(469, 365, 181, 23);
		contentPane.add(btnInfo);
		
		JButton btnNewButton = new JButton("DELETAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeletarCliente();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(351, 365, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	
	private void PreencherCampos(Cliente clienteASerEditado) {
		lblIdentificador.setText(String.valueOf(clienteASerEditado.getId()));
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
		
	}
	
	
	
	public void AtualizarCliente() {
		if (ChecarCampos()) {

			Cliente cliente = new Cliente();

			cliente.setId(Integer.parseInt(lblIdentificador.getText()));
			cliente.setBairro(textBairro.getText());
			cliente.setCelular(textCelular.getText());
			cliente.setAbastecimento(comboBoxAbast.getSelectedItem().toString());
			cliente.setCep(textCep.getText());
			cliente.setCidade(textCidade.getText());
			cliente.setClasse(comboBoxClasse.getSelectedItem().toString());
			cliente.setCliente(textCliente.getText());
			cliente.setCnpj(textCnpj.getText());
			cliente.setEmail(textEmail.getText());
			cliente.setEndereco(textEndereco.getText());
			cliente.setNumero(textNum.getText());
			cliente.setTelefone(textTelefone.getText());
			cliente.setUf(comboBoxUF.getSelectedItem().toString());
			
			if (clienteRepositorio.AtualizarCliente(cliente)) {
				JOptionPane.showMessageDialog(null, " atulizado com sucesso!");
				limparCampos();
				ListarClientes();
			
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
			}
		}
	}
	
	
	
	
	public void InserirCliente() {
		// Criar um objeto Usuario
		// Depois passar o objeto para o repositório salvar

			if (ChecarCampos()) {
				Cliente cliente = new Cliente();
				
			
				cliente.setBairro(textBairro.getText());
				cliente.setCelular(textCelular.getText());
				cliente.setCep(textCep.getText());
				cliente.setCidade(textCidade.getText());
				cliente.setCliente(textCliente.getText());
				cliente.setCnpj(textCnpj.getText());
				cliente.setEmail(textEmail.getText());
				cliente.setEndereco(textEndereco.getText());
				cliente.setNumero(textNum.getText());
				cliente.setTelefone(textTelefone.getText());
				cliente.setUf(comboBoxUF.getSelectedItem().toString());
				cliente.setAbastecimento(comboBoxAbast.getSelectedItem().toString());
				cliente.setClasse(comboBoxClasse.getSelectedItem().toString());
				
				cliente = clienteRepositorio.AdicionarCliente(cliente);

			
				

				if (cliente.getId() == -1)
					JOptionPane.showMessageDialog(null, "Erro ao salvar!");
				else {
					JOptionPane.showMessageDialog(null, "salvo com sucesso!");
					limparCampos();
					
				}
		}
	}
			
	private boolean ChecarCampos() {
		if (textNum.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo numero vazio!");
			return false;
		}

		if (textBairro.getText().length() > 100 || textBairro.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo Bairro maior que 100 caracteres!");
			return false;
		}
		
		if (textCelular.getText().length() > 15 || textCelular.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo Celular maior que 15 caracteres!");
			return false;
		}

		if (textCliente.getText().length() > 100 || textCidade.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo cliente maior que 100 caracteres!");
			return false;
		}

		if (textCnpj.getText().length() > 15 || textCnpj.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo Cnpj maior que 11 caracteres!");
			return false;
		}

		if (textEmail.getText().length() > 70 || textEmail.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo Email maior que 70 caracteres!");
			return false;
		}

		if (textEndereco.getText().length() > 100 || textEndereco.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo Endereço maior que 100 caracteres!");
			return false;
		}

		if (textBairro.getText().length() > 100 || textBairro.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo Bairro maior que 100 caracteres!");
			return false;
		}


		if (textCep.getText().length() > 9) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo cep maior que 9!");
			return false;
		}
		if(comboBoxUF.getSelectedItem().equals("<SELECIONE>")) {
			
			JOptionPane.showMessageDialog(null, "Selecione um estado!");
		}
		return true;
	}
	
	public void DeletarCliente() {
		if (lblIdentificador.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Favor selecionar um cliente antes de Excluir!");
		} 
		else 
		{
			int resposta = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR?", "CONFIRME ESSA AÇÃO!",
					JOptionPane.YES_NO_OPTION);

			if (resposta == JOptionPane.YES_OPTION) 
			{
				if(clienteRepositorio.DeletarClientePorId(Integer.parseInt(lblIdentificador.getText())))
				{
					JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso!");
					limparCampos();
					//ListarAutomoveis();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erro ao excluir Cliente!");
				}
			} 
			else if (resposta == JOptionPane.NO_OPTION) {
				// Usuário clicou em não. Executar o código correspondente.
			}
		}
	}
	
	
	private void ListarClientes() {
		clientesLocalizadosJTable = clienteRepositorio.ObterClientesJtable();
		clientesLocalizadosJTable.setDefaultEditor(Object.class, null);
		
		};
	
	private void limparCampos() {
		lblIdentificador.setText("");
		textBairro.setText("");
		textCep.setText("");
		textCidade.setText("");
		textCliente.setText("");
		textEmail.setText("");
		textEndereco.setText("");
		textCnpj.setText("");
		textNum.setText("");
		textTelefone.setText("");
		comboBoxAbast.setSelectedItem("<SELECIONE>");
		comboBoxUF.setSelectedItem("<SELECIONE>");
		comboBoxClasse.setSelectedItem("<SELECIONE>");
		
	}

		}
