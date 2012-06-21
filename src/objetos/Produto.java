package objetos;
import java.math.BigDecimal;

public class Produto extends Cadastrado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5098238024140750888L;
	private String codigo;
	private String nome;
	private String descricao;
	private String tamanho;
	private BigDecimal valor;
	
	public Produto(String codigo, String nome, String tamanho, BigDecimal valor) {
		super(null, codigo);
		this.codigo = codigo;
		this.nome = nome;
		this.tamanho = tamanho;
		this.valor = valor;
	}
	
	public Produto(String codigo, String nome, String descricao, String tamanho, BigDecimal valor) {
		super(null, codigo);
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.tamanho = tamanho;
		this.valor = valor;
	}

	protected BigDecimal getValor() {
		return valor;
	}

	protected void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTamanho() {
		return tamanho;
	}

}
