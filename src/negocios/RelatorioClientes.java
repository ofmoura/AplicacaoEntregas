package negocios;
import dados.*;
import objetos.*;
import java.util.Date;

public class RelatorioClientes {
	
	private String impresso;
	private String nome;		//Precisa mesmo disso aqui??
	private Date comecoPeriodo;	//Porque isso só vai ser usado uma vez...
	private Date fimPeriodo;	//
	private PedidoNego negociosPedidos;
	
	public RelatorioClientes(){
		Iterator<Pedido> colecaoPedidos = negociosPedidos.iteracaoRepositorio();
		//filtrar(...)
	}
	
	public RelatorioClientes(String nome){
		this.nome = nome;
		//filtrar(...)
	}
	
	public RelatorioClientes(String nome, Date periodo){		//Mas não é um Date, são dois! Começo e fim :P
		
	}
	
	public RelatorioClientes(Date periodo){
		
	}
	
	private void filtrar(){
		//usando this.nome e this.data
	}
	
	
	/*
	 * Campos passados:
	 *     Nome do Cliente.
	 *     Per�odo de Pedidos
	 * 
	 * Fun��o:
	 *  Mostrar todos os pedidos realizados por Clientes que contenham
	 *  em seu nome o mesmo nome fornecido no campo �Nome do Cliente�, no
	 *  per�odo fornecido no campo �Per�odo de Pedidos�
	 *  
	 * Observa��es:
	 * 	 - Caso o campo �Nome do Cliente� esteja vazio, o relat�rio deve mostrar
	 *   todas as compras de todos os clientes no per�odo fornecido no campo �Per�odo de Pedidos�.
	 *   - Caso o campo �Per�odo de Pedidos� esteja vazio o relat�rio deve mostrar
	 *   todas as compras dos Clientes que contenham em seu nome o mesmo nome fornecido
	 *   no campo �Nome do Cliente� em qualquer per�odo.
	 *   - Caso os dois campos estejam vazios o relat�rio deve mostrar todos os pedidos realizados. 
	 */
}
