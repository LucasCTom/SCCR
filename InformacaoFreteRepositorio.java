package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;


import Dominio.InfoFrete;;

public class InformacaoFreteRepositorio {
	
	
	// C - CREATE
				public  InfoFrete Adicionar_infoFrete(InfoFrete fretes) {
					
				String queryInsert = "INSERT INTO info_fretes " + "(equipe, filial, item_venda, tipo_frete, quantidade, preco_unitario,  tipo_veiculo, data)"  +  "VALUES (?,?,?,?,?,?,?,?,)";

					int idRetorno = -1;

					try {
						// estabelecer conecxão
						Connection conn = DbConnect.establishConnection();

						// Sentença preparada
						PreparedStatement prepStmt = (PreparedStatement) conn.prepareStatement(queryInsert,
								Statement.RETURN_GENERATED_KEYS);

						// parâmetros
					
						prepStmt.setString(1, fretes.getEquipe());
						prepStmt.setString(2, fretes.getFilial());
						prepStmt.setString(3, fretes.getItem_venda());
						prepStmt.setString(4, fretes.getTipo_frete());
						prepStmt.setString(5, fretes.getQuantidade());
						prepStmt.setDouble(6, fretes.getPreco_unitario());
						prepStmt.setString(7, fretes.getTipo_veiculo());
						prepStmt.setString(8, fretes.getData());
						
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

					fretes.setId(idRetorno);
					return fretes;

				}
				
				
				// R - Read
				public InfoFrete Obter_infoFretesPorId(int id) {

							InfoFrete frete = new InfoFrete();

							try {
								Connection conn = DbConnect.establishConnection();
								String queryConsulta = "select * from info_fretes where id = ?";
								PreparedStatement prepStmt = (PreparedStatement) conn.prepareStatement(queryConsulta);
								prepStmt.setString(1, String.valueOf(id));
								ResultSet resultSet = prepStmt.executeQuery();

								// Transformar o resultSet em objeto
								while (resultSet.next()) {
									frete.setId(resultSet.getInt("id"));
									frete.setEquipe(resultSet.getString("equipe"));
									frete.setEquipe(resultSet.getString("filial"));
									frete.setEquipe(resultSet.getString("item_venda"));
									frete.setEquipe(resultSet.getString("tipo_frete"));
									frete.setEquipe(resultSet.getString("quantidade"));
									frete.setEquipe(resultSet.getString("preco_unitario"));
									frete.setEquipe(resultSet.getString("tipo_veiculo"));
									frete.setEquipe(resultSet.getString("data"));
								}

								resultSet.close();
								conn.close();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							return frete;
						}
				
				
				private void resultSetToinfoFretes(List<InfoFrete> listaDeInfoFretes, ResultSet query) throws SQLException {
					while (query.next()) {
						
						InfoFrete fretes = new InfoFrete();
						
						fretes.setId(query.getInt("id"));
						fretes.setEquipe(query.getString("equipe"));
						fretes.setFilial(query.getString("filial"));
						fretes.setItem_venda(query.getString("item_venda"));
						fretes.setTipo_frete(query.getString("tipo_frete"));
						fretes.setQuantidade(query.getString("quantidade"));
						fretes.setPreco_unitario(Double.parseDouble(query.getString("preco_unitario")));
						fretes.setTipo_veiculo(query.getString("tipo_veiculo"));
						fretes.setData(query.getString("data"));
						
						
						listaDeInfoFretes.add(fretes);
					}
				}


				public List<InfoFrete> Obter_infoFretes() {
					

					List<InfoFrete> listaDeInfoFretes = new ArrayList<InfoFrete>();

					try {
						Connection conn = DbConnect.establishConnection();
						Statement stmt = conn.createStatement();
						ResultSet query = stmt.executeQuery("select * from info_fretes");

						resultSetToinfoFretes(listaDeInfoFretes, query);

						query.close();
						conn.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return listaDeInfoFretes;
				}
				
				public JTable Obter_infoFretesJtable() {
					List<InfoFrete> listaDeInfoFretes = Obter_infoFretes();
					return listaDeinfoFretesParaJtable(listaDeInfoFretes);
				}
				
				private JTable listaDeinfoFretesParaJtable(List<InfoFrete> listaDeInfoFretes) {

					String[] columns = new String[] { "equipe", "filial", "item_venda", "tipo_frete", "quantidade", "preco_unitario", "total_ordem", "tipo_veiculo", "data"};
					Object[][] data = new Object[listaDeInfoFretes.size()][10];

					for (int i = 0; i < listaDeInfoFretes.size(); i++) {
						data[i][0] = listaDeInfoFretes.get(i).getId();
						data[i][1] = listaDeInfoFretes.get(i).getEquipe();
						data[i][2] = listaDeInfoFretes.get(i).getFilial();
						data[i][3] = listaDeInfoFretes.get(i).getItem_venda();
						data[i][4] = listaDeInfoFretes.get(i).getTipo_frete();
						data[i][5] = listaDeInfoFretes.get(i).getQuantidade();
						data[i][6] = listaDeInfoFretes.get(i).getPreco_unitario();
						data[i][7] = listaDeInfoFretes.get(i).getTipo_veiculo();
						data[i][8] = listaDeInfoFretes.get(i).getData();
				
					}

					return new JTable(data, columns);
				}
				
}
