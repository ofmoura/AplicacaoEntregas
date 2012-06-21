package objetos;

import java.io.Serializable;

public class Cliente extends Cadastrado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1913654899557103281L;
	private String cpf;
	private String telefone;
	private String nome;
	private Endereco endereco;
	private String observacoes;
	private int contadorPedidos;
	
	public Cliente(String cpf, String telefone, String nome, Endereco endereco) {
		super(telefone, cpf);
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Cliente(String cpf, String telefone, String nome, Endereco endereco, String observacoes) {
		super(telefone, cpf);
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
		this.observacoes = observacoes;
	}
	
	protected boolean atualizaContador(){
		boolean atingiu = false;
		if (contadorPedidos < 5){
			this.contadorPedidos++;
		}
		else{
			atingiu = true;
			this.contadorPedidos = 0;
		}
		return atingiu;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public int getContadorPedidos(){
		return this.contadorPedidos;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getNome() {
		return nome;
	}
}
