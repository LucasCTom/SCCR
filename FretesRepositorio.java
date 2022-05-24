package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;


import Dominio.Fretes;


public class FretesRepositorio {

	// CRUD NO BANCO DE DADOS

			// C - CREATE
			public  Fretes AdicionarFrete(Fretes frete) {
				
			String queryInsert = "INSERT INTO gestao_fretes " + "(motorista, ajudante, filial, placa_veiculo, km_inical, km_final, data_saida, data_chegada, horario_saida, horario_chegada)"  +  "VALUES (?,?,?,?,?,?,?,?,?,?)";

				int idRetorno = -1;

				try {
					// estabelecer conecxão
					Connection conn = DbConnect.establishConnection();

					// Sentença preparada
					PreparedStatement prepStmt = (PreparedStatement) conn.prepareStatement(queryInsert,
							Statement.RETURN_GENERATED_KEYS);

					// parâmetros
				
					prepStmt.setString(1, frete.getMotorista());
					prepStmt.setString(2, frete.getAjudante());
					prepStmt.setString(3, frete.getFilial());
					prepStmt.setString(4, frete.getPlaca_veiculo());
					prepStmt.setString(5, frete.getKm_inicial());
					prepStmt.setString(6, frete.getKm_final());
					prepStmt.setString(7, frete.getData_saida());
					prepStmt.setString(8, frete.getData_chegada());
					prepStmt.setString(9, frete.getHorario_saida());
					prepStmt.setString(10, frete.getHorario_chegada());
					
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

				frete.setId(idRetorno);
				return frete;

			}
	
			//U - UPDATE
			public boolean AtualizarFretes(Fretes frete) {
				String queryUpdate = "UPDATE gestao_fretes SET   motorista = ?, ajudante = ?, filial = ?, placa_veiculo = ?, km_inicial = ?, km_final = ?, data_saida = ?, data_chegada = ?, horario_saida = ?, horario_chegada = ? WHERE id = ?";
				Connection conn;
				PreparedStatement prepStmt;

				try {
					// estabelecer conecxão
					conn = DbConnect.establishConnection();
					// Preparando o insert
					prepStmt = (PreparedStatement) conn.prepareStatement(queryUpdate);
					// parametros
			
					prepStmt.setString(1, frete.getMotorista());
					prepStmt.setString(2, frete.getAjudante());
					prepStmt.setString(3, frete.getFilial());
					prepStmt.setString(4, frete.getPlaca_veiculo());
					prepStmt.setString(5, frete.getKm_inicial());
					prepStmt.setString(6, frete.getKm_final());
					prepStmt.setString(7, frete.getData_saida());
					prepStmt.setString(8, frete.getData_chegada());
					prepStmt.setString(9, frete.getHorario_saida());
					prepStmt.setString(10, frete.getHorario_chegada());

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
			public boolean DeletarFretesPorId(int id) {
				String queryDelete = "delete from gestao_fretes where id = ?";
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
			public Fretes ObterFretesPorId(int id) {

						Fretes frete = new Fretes();

						try {
							Connection conn = DbConnect.establishConnection();
							String queryConsulta = "select * from gestao_fretes where id = ?";
							PreparedStatement prepStmt = (PreparedStatement) conn.prepareStatement(queryConsulta);
							prepStmt.setString(1, String.valueOf(id));
							ResultSet resultSet = prepStmt.executeQuery();

							// Transformar o resultSet em objeto
							while (resultSet.next()) {
								frete.setId(resultSet.getInt("id"));
								frete.setMotorista(resultSet.getString("motorista"));
								frete.setAjudante(resultSet.getString("ajudante"));
								frete.setFilial(resultSet.getString("filial"));
								frete.setPlaca_veiculo(resultSet.getString("placa_veiculo"));
								frete.setKm_inicial(resultSet.getString("km_inicial"));
								frete.setKm_final(resultSet.getString("km_final"));
								frete.setData_saida(resultSet.getString("data_saida"));
								frete.setData_chegada(resultSet.getString("data_chegada"));
								frete.setHorario_saida(resultSet.getString("horario_saida"));
								frete.setData_chegada(resultSet.getString("data_chegada"));
							}

							resultSet.close();
							conn.close();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						return frete;
					}

			
			
			
			private void resultSetToFretes(List<Fretes> listaDeFretes, ResultSet query) throws SQLException {
				while (query.next()) {
					Fretes frete = new Fretes();
					
					frete.setId(query.getInt("id"));
					frete.setMotorista(query.getString("motorista"));
					frete.setAjudante(query.getString("ajudante"));
					frete.setFilial(query.getString("filial"));
					frete.setPlaca_veiculo(query.getString("placa_veiculo"));
					frete.setKm_inicial(query.getString("km_inicial"));
					frete.setKm_final(query.getString("km_final"));
					frete.setData_saida(query.getString("data_saida"));
					frete.setData_chegada(query.getString("data_chegada"));
					frete.setHorario_saida(query.getString("horario_saida"));
					frete.setData_chegada(query.getString("data_chegada"));
					
					
					listaDeFretes.add(frete);
				}
			}
			
			public List<Fretes> ObterFretes() {
				// aqui montar e executar o cmd select do sql

				List<Fretes> listaDeFretes = new ArrayList<Fretes>();

				try {
					Connection conn = DbConnect.establishConnection();
					Statement stmt = conn.createStatement();
					ResultSet query = stmt.executeQuery("select * from gestao_fretes");

					resultSetToFretes(listaDeFretes, query);

					query.close();
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return listaDeFretes;
			}
			
			public JTable ObterFretesJtable() {
				List<Fretes> listaDeFretes = ObterFretes();
				return listaDeFretesParaJtable(listaDeFretes);
			}
			
			
			private JTable listaDeFretesParaJtable(List<Fretes> listaDeFretes) {

				String[] columns = new String[] { "motorista", "ajudante", "filial", "placa_veiculo", "km_inical", "km_final", "data_saida", "data_chegada", "horario_saida", "horario_chegada"};
				Object[][] data = new Object[listaDeFretes.size()][10];

				for (int i = 0; i < listaDeFretes.size(); i++) {
					data[i][0] = listaDeFretes.get(i).getId();
					data[i][1] = listaDeFretes.get(i).getMotorista();
					data[i][2] = listaDeFretes.get(i).getAjudante();
					data[i][3] = listaDeFretes.get(i).getFilial();
					data[i][4] = listaDeFretes.get(i).getPlaca_veiculo();
					data[i][5] = listaDeFretes.get(i).getKm_inicial();
					data[i][6] = listaDeFretes.get(i).getKm_final();
					data[i][7] = listaDeFretes.get(i).getData_saida();
					data[i][8] = listaDeFretes.get(i).getData_chegada();
					data[i][9] = listaDeFretes.get(i).getHorario_saida();
					data[i][10] = listaDeFretes.get(i).getHorario_chegada();
			
				}

				return new JTable(data, columns);
			}
			
}
