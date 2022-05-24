package Dominio;

public class InfoFrete {
	
	private int id;
	
	private String equipe;
	private String filial;
	private String item_venda;
	private String tipo_frete;
	private String quantidade;
	private Double preco_unitario;
	private String total_orden;
	private String tipo_veiculo;
	private String data;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	public String getFilial() {
		return filial;
	}
	public void setFilial(String filial) {
		this.filial = filial;
	}
	public String getItem_venda() {
		return item_venda;
	}
	public void setItem_venda(String item_venda) {
		this.item_venda = item_venda;
	}
	public String getTipo_frete() {
		return tipo_frete;
	}
	public void setTipo_frete(String tipo_frete) {
		this.tipo_frete = tipo_frete;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getTotal_orden() {
		return total_orden;
	}
	public void setTotal_orden(String total_orden) {
		this.total_orden = total_orden;
	}
	public String getTipo_veiculo() {
		return tipo_veiculo;
	}
	public void setTipo_veiculo(String tipo_veiculo) {
		this.tipo_veiculo = tipo_veiculo;
	}
	public Double getPreco_unitario() {
		return preco_unitario;
	}
	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

}
