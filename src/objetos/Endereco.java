package objetos;

import java.io.Serializable;

public class Endereco implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7173506249210017736L;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	
	public Endereco(String logradouro, String numero, String bairro, String cidade) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;	
	}
	
	public Endereco(String logradouro, String numero, String complemento, String bairro, String cidade) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	protected String getLogradouro() {
		return logradouro;
	}

	protected void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	protected String getNumero() {
		return numero;
	}

	protected void setNumero(String numero) {
		this.numero = numero;
	}

	protected String getComplemento() {
		return complemento;
	}

	protected void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	protected String getBairro() {
		return bairro;
	}

	protected void setBairro(String bairro) {
		this.bairro = bairro;
	}

	protected String getCidade() {
		return cidade;
	}

	protected void setCidade(String cidade) {
		this.cidade = cidade;
	}
 
	
}
