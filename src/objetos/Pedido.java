package objetos;
import java.math.BigDecimal;
import java.util.Date;


public class Pedido extends Cadastrado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 855805147404984711L;
	private String codigo;
	private Cliente cliente;
	private Produto[] produtos;
	private Date data;
	private int quantidade;
	private BigDecimal valor;
	private Produto produtoMenorPreco;

	public Pedido(String codigo, Cliente cliente, Produto[] produtos,
			Date data, int quantidade) {
		super(data.toString(), codigo);
		this.codigo = codigo;
		this.cliente = cliente;
		this.produtos = produtos;
		this.data = data;
		this.quantidade = quantidade;
		calcularValor();
		produtoMenorPreco = null;
	}
	
	private void calcularValor(){
		BigDecimal valor = null;
		BigDecimal taxa = BigDecimal.valueOf(7.0);
		boolean preencheu = false;
		String bairro = this.cliente.getEndereco().getBairro();
		String[] bairrosBaratos = {"Aflitos", "Gracas", "Espinheiro", "Tamarineira", "Jaqueira",
				"Torre", "Parnamirim", "Casa Forte", "Apipucos", "Casa Amarela", "Hipodromo",
				"Rosarinho", "Campo Grande", "Torroes"};
		for (int i = 0; i < bairrosBaratos.length && !preencheu; i++){
			if (bairro.equalsIgnoreCase(bairrosBaratos[i])){
				taxa = BigDecimal.valueOf(3.5);
				preencheu = true;
			}
		}
		if (this.cliente.atualizaContador()){
			for(int i = 0; i < this.produtos.length; i++) {
				if (produtoMenorPreco.getValor().compareTo(produtos[i].getValor()) == 1){
					produtoMenorPreco = produtos[i];
				}
			}
		}
		for(int i = 0; i < this.produtos.length; i++) {
			if (produtos[i] != produtoMenorPreco){
				valor = valor.add(produtos[i].getValor());
			}
		}
		if(this.produtos.length > 5){
			taxa.multiply(BigDecimal.valueOf(1 - (this.quantidade % 5)/10));
		}
		valor.add(taxa);
		this.valor = valor;
	}

}
