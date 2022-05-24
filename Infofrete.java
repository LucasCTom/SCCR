package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dominio.Fretes;
import Dominio.InfoFrete;
import Repositorio.FretesRepositorio;
import Repositorio.InformacaoFreteRepositorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Infofrete extends JFrame {

	private JPanel contentPane;
	private JTextField textQntd;
	private JTextField textPreçouni;
	private JTextField textFilial;
	private JComboBox comboBoxEquipe;
	private JComboBox comboBoxItemVenda;
	private JComboBox comboBoxTipoFrete;
	private JComboBox comboBoxTipoVeiculo;
	private JTextField textData;
	private JLabel lblidentificador;
	private InformacaoFreteRepositorio infofreteRepositorio = new InformacaoFreteRepositorio();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Infofrete frame = new Infofrete();
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
	public Infofrete() {
		setTitle("INFO FRETE");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 645, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentificador = new JLabel("");
		lblIdentificador.setBounds(49, 11, 46, 14);
		contentPane.add(lblIdentificador);
		
		JLabel lblCodigo = new JLabel("Codigo Equipe:");
		lblCodigo.setBounds(10, 49, 101, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblItemVenda = new JLabel("Item de venda:");
		lblItemVenda.setBounds(10, 109, 117, 14);
		contentPane.add(lblItemVenda);
		
		JLabel lblTipoFrete = new JLabel("Tipo de frete:");
		lblTipoFrete.setBounds(10, 163, 85, 14);
		contentPane.add(lblTipoFrete);
		
		comboBoxItemVenda = new JComboBox();
		comboBoxItemVenda.setModel(new DefaultComboBoxModel(new String[] {"<SELECIONE>", "P2", "P5", "P13", "P20", "P45", "P90", "GRANEL"}));
		comboBoxItemVenda.setBounds(100, 106, 135, 20);
		contentPane.add(comboBoxItemVenda);
		
		comboBoxTipoFrete = new JComboBox();
		comboBoxTipoFrete.setModel(new DefaultComboBoxModel(new String[] {"<SELECIONE>", "TERCEIRO", "PR\u00D3PRIO"}));
		comboBoxTipoFrete.setBounds(100, 160, 135, 20);
		contentPane.add(comboBoxTipoFrete);
		
		JLabel lblQntd = new JLabel("Quantidade/KG:");
		lblQntd.setBounds(10, 191, 117, 14);
		contentPane.add(lblQntd);
		
		textQntd = new JTextField();
		textQntd.setBounds(100, 188, 135, 20);
		contentPane.add(textQntd);
		textQntd.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("tipo ve\u00EDculo:");
		lblNewLabel_4.setBounds(10, 219, 101, 14);
		contentPane.add(lblNewLabel_4);
		
		comboBoxTipoVeiculo = new JComboBox();
		comboBoxTipoVeiculo.setModel(new DefaultComboBoxModel(new String[] {"<SELECIONE>", "caminhao leve(7 ton)", "caminhao m\u00E9dio(16 ton)", "caminhao pesada( acima 20 ton)"}));
		comboBoxTipoVeiculo.setBounds(100, 216, 135, 20);
		contentPane.add(comboBoxTipoVeiculo);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o unit\u00E1rio:");
		lblPreco.setBounds(260, 188, 181, 14);
		contentPane.add(lblPreco);
		
		textPreçouni = new JTextField();
		textPreçouni.setBounds(350, 188, 101, 20);
		contentPane.add(textPreçouni);
		textPreçouni.setColumns(10);
		
		JLabel lblFilial = new JLabel("Filial:");
		lblFilial.setBounds(10, 74, 46, 14);
		contentPane.add(lblFilial);
		
		textFilial = new JTextField();
		textFilial.setBounds(90, 74, 134, 20);
		contentPane.add(textFilial);
		textFilial.setColumns(10);
		
		comboBoxEquipe = new JComboBox();
		comboBoxEquipe.setModel(new DefaultComboBoxModel(new String[] {"<SELECIONE>", "012\t", "014"}));
		comboBoxEquipe.setBounds(89, 46, 135, 20);
		contentPane.add(comboBoxEquipe);
		
		JButton btnSubmeter = new JButton("Submeter");
		btnSubmeter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				InserirFretes();
				
			}
		});
		btnSubmeter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmeter.setBounds(226, 293, 135, 23);
		contentPane.add(btnSubmeter);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(269, 74, 46, 14);
		contentPane.add(lblData);
		
		textData = new JTextField();
		textData.setBounds(340, 71, 101, 20);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID da ordem:");
		lblNewLabel.setBounds(10, 11, 79, 14);
		contentPane.add(lblNewLabel);
		
		lblidentificador = new JLabel("");
		lblidentificador.setBounds(89, 11, 46, 14);
		contentPane.add(lblidentificador);
	}
	
	
	private boolean ChecarCampos() {
		if (textFilial.getText().length() > 100) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo filial maior que 100 caracteres!");
			return false;
		}

		if (textPreçouni.getText().length() > 100 || textPreçouni.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo preço vazio!");
			return false;
		}
		
		if (textQntd.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do quantidade data vazio!");
			return false;
		}

		
		if(comboBoxEquipe.getSelectedItem().equals("<SELECIONE>")) {
			
			JOptionPane.showMessageDialog(null, "Selecione uma equipe!");
			return false;
		}
	
		if(comboBoxItemVenda.getSelectedItem().equals("<SELECIONE>")) {
			
			JOptionPane.showMessageDialog(null, "Selecione o item de venda!");
			return false;
		}
		
		if(comboBoxTipoFrete.getSelectedItem().equals("<SELECIONE>")) {
			
			JOptionPane.showMessageDialog(null, "Selecione o tipo de frete!");
			return false;
		}
	
		if(comboBoxTipoVeiculo.getSelectedItem().equals("<SELECIONE>")) {
			
			JOptionPane.showMessageDialog(null, "Selecione o tipo de veiculo!");
			return false;
		}
		
		return true;
	}
	
	
	public void InserirFretes() {
		// Criar um objeto Usuario
		// Depois passar o objeto para o repositório salvar

			if (ChecarCampos()) {
				InfoFrete fretes = new InfoFrete();
				
				
				fretes.setEquipe(comboBoxEquipe.getSelectedItem().toString());
				fretes.setFilial(textFilial.getText());
				fretes.setData(textData.getText());
				fretes.setItem_venda(comboBoxItemVenda.getSelectedItem().toString());
				fretes.setPreco_unitario(Double.parseDouble(textPreçouni.getText()));
				fretes.setQuantidade(textQntd.getText());
				fretes.setTipo_frete(comboBoxTipoFrete.getSelectedItem().toString());
				fretes.setTipo_veiculo(comboBoxTipoVeiculo.getSelectedItem().toString());
				
				
				fretes = infofreteRepositorio.Adicionar_infoFrete(fretes);
			

			
				

				if (fretes.getId() == -1)
					JOptionPane.showMessageDialog(null, "Erro ao salvar!");
				else {
					JOptionPane.showMessageDialog(null, "ordem registrada!");
					limparCampos();
					
				}
		}
	}
	

	private void limparCampos() {
		lblidentificador.setText("");
		textFilial.setText("");
		textData.setText("");
		textPreçouni.setText("");
		textQntd.setText("");
		comboBoxItemVenda.setSelectedItem("<SELECIONE>");
		comboBoxEquipe.setSelectedItem("<SELECIONE>");
		comboBoxTipoFrete.setSelectedItem("<SELECIONE>");
		comboBoxTipoVeiculo.setSelectedItem("<SELECIONE>");
		
		
	}
	
	
	
}
