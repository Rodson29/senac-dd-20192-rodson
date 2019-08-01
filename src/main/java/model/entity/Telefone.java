package model.entity;

public class Telefone {
    private int id;
    private Cliente cliente;
	private String codigoPais;
	private String ddd;
	private String numero;
	private String tipo;
	private boolean ativo;
	
	public Telefone(int id,Cliente cliente, String codigoPais, String ddd, String numero, String tipo, boolean ativo) {
		super();
		this.id =id;
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.cliente = cliente;
		this.ativo = ativo;
	}
	
	public Telefone(Cliente cliente, String codigoPais, String ddd, String numero, String tipo, boolean ativo) {
		super();
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.cliente = cliente;
		this.ativo = ativo;
	}
	
	public Telefone() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", cliente=" + cliente + ", codigoPais=" + codigoPais + ", ddd=" + ddd
				+ ", numero=" + numero + ", tipo=" + tipo + ", ativo=" + ativo + "]";
	}
}