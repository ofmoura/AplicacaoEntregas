package objetos;

import java.io.Serializable;

public class Cadastrado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3817189800868924267L;
	private String identificador;
	private String codigo;
	
	public Cadastrado(String identificador, String codigo) {
		this.identificador = identificador;
		this.codigo = codigo;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
