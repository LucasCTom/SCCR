package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dominio.Cliente;
import Dominio.Fretes;
import Repositorio.ClienteRepositorio;
import Repositorio.FretesRepositorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestaoFretes extends JFrame {

	private JPanel contentPane;
	private JTextField textMotorista;
	private JTextField textAjudante;
	private JTextField textFilial;
	private JTextField textPlacaveiculo;
	private JTextField textKmini;
	private JTextField textKmfim;
	private JTextField textDatasaida;
	private JTextField textDataChegada;
	private JTextField textHorarioSaida;
	private JTextField textHorarioChegada;
	private JLabel lblIdentificador;
	private FretesRepositorio freteRepositorio = new FretesRepositorio();
	ExibirFretes FormExibirFretes = new ExibirFretes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestaoFretes frame = new GestaoFretes();
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
	public GestaoFretes() {
		setTitle("GESTAO DE FRETE(checklist)");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 661, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMotorista = new JLabel("Motorista:");
		lblMotorista.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMotorista.setBounds(10, 51, 74, 14);
		contentPane.add(lblMotorista);
		
		textMotorista = new JTextField();
		textMotorista.setBounds(94, 48, 222, 20);
		contentPane.add(textMotorista);
		textMotorista.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ajudante:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 86, 74, 14);
		contentPane.add(lblNewLabel);
		
		textAjudante = new JTextField();
		textAjudante.setBounds(94, 79, 222, 20);
		contentPane.add(textAjudante);
		textAjudante.setColumns(10);
		
		JLabel lblCodEquipe = new JLabel("Codigo Equipe");
		lblCodEquipe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodEquipe.setBounds(10, 11, 86, 14);
		contentPane.add(lblCodEquipe);
		
		JLabel lblNewLabel_2 = new JLabel("Filial:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 114, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textFilial = new JTextField();
		textFilial.setBounds(94, 111, 222, 20);
		contentPane.add(textFilial);
		textFilial.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Placa ve\u00EDculo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 175, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		textPlacaveiculo = new JTextField();
		textPlacaveiculo.setBounds(104, 173, 109, 20);
		contentPane.add(textPlacaveiculo);
		textPlacaveiculo.setColumns(10);
		
		JLabel lblKmInicial = new JLabel("KM inicial:");
		lblKmInicial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKmInicial.setBounds(475, 202, 63, 14);
		contentPane.add(lblKmInicial);
		
		textKmini = new JTextField();
		textKmini.setBounds(536, 200, 86, 20);
		contentPane.add(textKmini);
		textKmini.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("KM final:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(473, 231, 63, 14);
		contentPane.add(lblNewLabel_4);
		
		textKmfim = new JTextField();
		textKmfim.setBounds(536, 229, 86, 20);
		contentPane.add(textKmfim);
		textKmfim.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Data sa\u00EDda:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 207, 74, 14);
		contentPane.add(lblNewLabel_5);
		
		textDatasaida = new JTextField();
		textDatasaida.setBounds(104, 201, 109, 20);
		contentPane.add(textDatasaida);
		textDatasaida.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Data Chegada:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 232, 86, 17);
		contentPane.add(lblNewLabel_6);
		
		textDataChegada = new JTextField();
		textDataChegada.setBounds(104, 226, 109, 20);
		contentPane.add(textDataChegada);
		textDataChegada.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Horario Sa\u00EDda:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(251, 207, 109, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Horario Chegada:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(251, 230, 109, 20);
		contentPane.add(lblNewLabel_8);
		
		textHorarioSaida = new JTextField();
		textHorarioSaida.setBounds(358, 200, 107, 20);
		contentPane.add(textHorarioSaida);
		textHorarioSaida.setColumns(10);
		
		textHorarioChegada = new JTextField();
		textHorarioChegada.setBounds(358, 229, 105, 20);
		contentPane.add(textHorarioChegada);
		textHorarioChegada.setColumns(10);
		
		lblIdentificador = new JLabel("");
		lblIdentificador.setBounds(117, 12, 46, 14);
		contentPane.add(lblIdentificador);
		
		JButton btnNewButton = new JButton("Submeter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (lblIdentificador.getText().equals(""))
					InserirFretes();
				else
					AtualizarFrete();
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(168, 298, 115, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exibir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormExibirFretes.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(323, 298, 137, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 37, 645, 111);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(0, 168, 645, 93);
		contentPane.add(panel_1);
	}
	
	private boolean ChecarCampos() {
		if (textAjudante.getText().length() > 100) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo ajudante maior que 100 caracteres!");
			return false;
		}

		if (textDataChegada.getText().length() > 100 || textDataChegada.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo data vazio!");
			return false;
		}
		
		if (textDatasaida.getText().length() > 15 || textDatasaida.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo data vazio!");
			return false;
		}

		if (textFilial.getText().length() > 100 || textFilial.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo filial maior que 100 caracteres!");
			return false;
		}

		if (textHorarioChegada.getText().length() > 15 || textHorarioChegada.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo horario vazio!");
			return false;
		}

		if (textHorarioSaida.getText().length() > 70 || textHorarioSaida.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo horario saida vazio!");
			return false;
		}

		if (textKmfim.getText().length() > 100 || textKmfim.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo km final vazio!");
			return false;
		}

		if (textKmini.getText().length() > 100 || textKmini.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo km inicial vazio!");
			return false;
		}


		if (textMotorista.getText().length() > 100) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo motorista maior que 100 caracteres!");
			return false;
		}
		

		if (textPlacaveiculo.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Tamanho do campo placa vazio!");
			return false;
		}
		return true;
		}
	
	
	private void limparCampos() {
		lblIdentificador.setText("");
		textAjudante.setText("");
		textDataChegada.setText("");
		textDatasaida.setText("");
		textFilial.setText("");
		textHorarioChegada.setText("");
		textHorarioSaida.setText("");
		textKmfim.setText("");
		textKmini.setText("");
		textMotorista.setText("");
		textPlacaveiculo.setText("");
		
	}
	
	
	public void InserirFretes() {
		// Criar um objeto Usuario
		// Depois passar o objeto para o repositório salvar

			if (ChecarCampos()) {
				Fretes frete = new Fretes();
				
				frete.setAjudante(textAjudante.getText());
				frete.setData_chegada(textDataChegada.getText());
				frete.setData_saida(textDatasaida.getText());
				frete.setFilial(textFilial.getText());
				frete.setHorario_chegada(textHorarioChegada.getText());
				frete.setHorario_saida(textHorarioSaida.getText());
				frete.setKm_final(textKmfim.getText());
				frete.setKm_inicial(textKmini.getText());
				frete.setMotorista(textMotorista.getText());
				frete.setPlaca_veiculo(textPlacaveiculo.getText());
				
				frete = freteRepositorio.AdicionarFrete(frete);
			

			
				

				if (frete.getId() == -1)
					JOptionPane.showMessageDialog(null, "Erro ao salvar!");
				else {
					JOptionPane.showMessageDialog(null, "salvo com sucesso!");
					limparCampos();
					
				}
		}
	}
	
	
	public void AtualizarFrete() {
		if (ChecarCampos()) {

			Fretes frete = new Fretes();

			frete.setId(Integer.parseInt(lblIdentificador.getText()));
			frete.setAjudante(textAjudante.getText());
			frete.setData_chegada(textDataChegada.getText());
			frete.setData_saida(textDatasaida.getText());
			frete.setFilial(textFilial.getText());
			frete.setHorario_chegada(textHorarioChegada.getText());
			frete.setHorario_saida(textHorarioSaida.getText());
			frete.setKm_final(textKmfim.getText());
			frete.setKm_inicial(textKmini.getText());
			frete.setMotorista(textMotorista.getText());
			frete.setPlaca_veiculo(textPlacaveiculo.getText());
			
			if (freteRepositorio.AtualizarFretes(frete)) {
				JOptionPane.showMessageDialog(null, " atulizado com sucesso!");
				limparCampos();
			
			
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
			}
		}
	}
	
	
	
	
	
	
	
	
}
