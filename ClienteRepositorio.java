package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;


import Dominio.Cliente;

public class ClienteRepositorio {

		// CRUD NO BANCO DE DADOS

		// C - CREATE
		public  Cliente AdicionarCliente(Cliente cliente) {
			String queryInsert = "INSERT INTO clientes " + "(abastecimento, bairro, celular, cep, cidade, classe_cliente, cliente, cnpj_cpf, email, endereco, numero, telefone, uf) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			int idRetorno = -1;

			try {
				// estabelecer conecxão
				Connection conn = DbConnect.establishConnection();

				// Sentença preparada
				PreparedStatement prepStmt = (PreparedStatement) conn.prepareStatement(queryInsert,
						Statement.RETURN_GENERATED_KEYS);

				// parâmetros
			
				prepStmt.setString(1, cliente.getAbastecimento());
				prepStmt.setString(2, cliente.getBairro());
				prepStmt.setString(3, cliente.getCelular());
				prepStmt.setString(4, cliente.getCep());
				prepStmt.setString(5, cliente.getCidade());
				prepStmt.setString(6, cliente.getClasse());
				prepStmt.setString(7, cliente.getCliente());
				prepStmt.setString(8, cliente.getCnpj());
				prepStmt.setString(9, cliente.getEmail());
				prepStmt.setString(10, cliente.getEndereco());
				prepStmt.setString(11, cliente.getNumero());
				prepStmt.setString(12, cliente.getTelefone());
				prepStmt.setString(13, cliente.getUf());
				
				// Executar
				prepStmt.execute();

				// Buscar o ID gerado
				ResultSet rs = prepStmt.getGeneratedKeys();

				if (rs.next()) {
					idRetorno = rs.getInt(1);
				}

				// Fechar statement
				prepStmt.close();
				// fechar a conexão
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
				idRetorno = -1;
			}

			cliente.setId(idRetorno);
			return cliente;

		}


//U - UPDATE
		public boolean AtualizarCliente(Cliente cliente) {
			String queryUpdate = "UPDATE cliente SET abastecimento = ?, bairro = ?, celular = ?, cep = ?, cidade = ?, classe_cliente = ?, cliente = ?, cnpj_cpf = ?, email = ?, endereco = ?, numero = ?, telefone = ?, uf = ? WHERE id = ?";
			Connection conn;
			PreparedStatement prepStmt;

			try {
				// estabelecer conecxão
				conn = DbConnect.establishConnection();
				// Preparando o insert
				prepStmt = (PreparedStatement) conn.prepareStatement(queryUpdate);
				// parametros
		
				prepStmt.setString(1, cliente.getAbastecimento());
				prepStmt.setString(2, cliente.getBairro());
				prepStmt.setString(3, cliente.getCelular());
				prepStmt.setString(4, cliente.getCep());
				prepStmt.setString(5, cliente.getCidade());
				prepStmt.setString(6, cliente.getClasse());
				prepStmt.setString(7, cliente.getCliente());
				prepStmt.setString(8, cliente.getCnpj());
				prepStmt.setString(9, cliente.getEmail());
				prepStmt.setString(10, cliente.getEndereco());
				prepStmt.setString(11, cliente.getNumero());
				prepStmt.setString(12, cliente.getTelefone());
				prepStmt.setString(13, cliente.getUf());

				prepStmt.execute();
				prepStmt.close();
				conn.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}



//D - Delete
		public boolean DeletarClientePorId(int id) {
			String queryDelete = "delete from clientes where id = ?";
			Connection conn;
			PreparedStatement prepStmt;
			try 
			{
				conn = DbConnect.establishConnection();
				prepStmt = (PreparedStatement) conn.prepareStatement(queryDelete);
				prepStmt.setInt(1, id);
				prepStmt.execute();
				prepStmt.close();
				conn.close();
				return true;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return true;
			}
		}
		
		// R - Read
		public Cliente ObterClientelPorId(int id) {

					Cliente cliente = new Cliente();

					try {
						Connection conn = DbConnect.establishConnection();
						String queryConsulta = "select * from clientes where id = ?";
						PreparedStatement prepStmt = (PreparedStatement) conn.prepareStatement(queryConsulta);
						prepStmt.setString(1, String.valueOf(id));
						ResultSet resultSet = prepStmt.executeQuery();

						// Transformar o resultSet em objeto
						while (resultSet.next()) {
							cliente.setId(resultSet.getInt("id"));
							cliente.setAbastecimento(resultSet.getString("abastecimento"));
							cliente.setBairro(resultSet.getString("bairro"));
							cliente.setCelular(resultSet.getString("celular"));
							cliente.setCep(resultSet.getString("cep"));
							cliente.setCidade(resultSet.getString("cidade"));
							cliente.setClasse(resultSet.getString("classe_cliente"));
							cliente.setCliente(resultSet.getString("cliente"));
							cliente.setCnpj(resultSet.getString("cnpj_cpf"));
							cliente.setEmail(resultSet.getString("email"));
							cliente.setEndereco(resultSet.getString("endereco"));
							cliente.setNumero(resultSet.getString("numero"));
							cliente.setTelefone(resultSet.getString("celular"));
							cliente.setUf(resultSet.getString("uf"));
						
						}

						resultSet.close();
						conn.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return cliente;
				}
		
		
		
		private void resultSetToCliente(List<Cliente> listaDeClientes, ResultSet query) throws SQLException {
			while (query.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(query.getInt("id"));
				cliente.setBairro(query.getString("bairro"));
				cliente.setCelular(query.getString("celular"));
				cliente.setCep(query.getString("cep"));
				cliente.setCidade(query.getString("cidade"));
				cliente.setClasse(query.getString("classe_cliente"));
				cliente.setCliente(query.getString("cliente"));
				cliente.setCnpj(query.getString("cnpj"));
				cliente.setEmail(query.getString("email"));
				cliente.setEndereco(query.getString("endereco"));
				cliente.setNumero(query.getString("numero"));
				cliente.setTelefone(query.getString("Telefone"));
				cliente.setUf(query.getString("uf"));
				
				
				listaDeClientes.add(cliente);
			}
		}	
		
		public List<Cliente> ObterClientes() {
			// aqui montar e executar o cmd select do sql

			List<Cliente> listaDeClientes = new ArrayList<Cliente>();

			try {
				Connection conn = DbConnect.establishConnection();
				Statement stmt = conn.createStatement();
				ResultSet query = stmt.executeQuery("select * from clientes");

				resultSetToCliente(listaDeClientes, query);

				query.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return listaDeClientes;
		}

		public JTable ObterClientesJtable() {
			List<Cliente> listaDeClientes = ObterClientes();
			return listaDeClientesParaJtable(listaDeClientes);
		}
		

		private JTable listaDeClientesParaJtable(List<Cliente> listaDeCliente) {

			String[] columns = new String[] { "abastecimento", "bairro", "celular", "cep", "cidade", "classe_cliente", "cliente", "cnpj_cpf", "email", "endereco", "numero", "telefone", "uf"};
			Object[][] data = new Object[listaDeCliente.size()][14];

			for (int i = 0; i < listaDeCliente.size(); i++) {
				data[i][0] = listaDeCliente.get(i).getId();
				data[i][1] = listaDeCliente.get(i).getAbastecimento();
				data[i][2] = listaDeCliente.get(i).getBairro();
				data[i][3] = listaDeCliente.get(i).getCelular();
				data[i][4] = listaDeCliente.get(i).getCep();
				data[i][5] = listaDeCliente.get(i).getCidade();
				data[i][6] = listaDeCliente.get(i).getClasse();
				data[i][7] = listaDeCliente.get(i).getCliente();
				data[i][8] = listaDeCliente.get(i).getCnpj();
				data[i][9] = listaDeCliente.get(i).getEmail();
				data[i][10] = listaDeCliente.get(i).getEndereco();
				data[i][11] = listaDeCliente.get(i).getNumero();
				data[i][12] = listaDeCliente.get(i).getTelefone();
				data[i][13] = listaDeCliente.get(i).getUf();
		
			}

			return new JTable(data, columns);
		}
		
}


