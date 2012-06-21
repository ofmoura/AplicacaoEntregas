package negocios;

import java.io.IOException;

import dados.Iterator;
import dados.RepInterface;

import objetos.Pedido;
import objetos.Produto;

import exceptions.*;

public class ProdutoNego {

	private RepInterface<Produto> repProduto;

	public ProdutoNego(RepInterface<Produto> repProduto) {
		this.repProduto = repProduto;
	}

	public void inserir(Produto produto) throws JaExisteException, IOException {
		if(!this.repProduto.checaExiste(produto.getCodigo())) {
			this.repProduto.inserir(produto);
		} else throw new JaExisteException("produto");
	}

	public void remover(String atributo) throws NaoExisteException, IOException {
		if(this.repProduto.checaExiste(atributo)) {
			this.repProduto.remover(atributo);
		} else throw new NaoExisteException("produto");
	}
	
	public Iterator<Produto> iteracaoRepositorio(){
		return this.repProduto.iteracao();
	}
}