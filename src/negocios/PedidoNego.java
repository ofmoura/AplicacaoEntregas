package negocios;

import java.io.IOException;

import dados.Iterator;
import dados.RepInterface;

import objetos.Cliente;
import objetos.Pedido;

import exceptions.*;

public class PedidoNego {

	private RepInterface<Pedido> repPedido;

	public PedidoNego(RepInterface<Pedido> repPedido) {
		this.repPedido = repPedido;		
	}

	public void inserir(Pedido pedido) throws JaExisteException, IOException {
		if(!repPedido.checaExiste(pedido.getCodigo())){
			this.repPedido.inserir(pedido);
		} else throw new JaExisteException("pedido");
	}

	public void remover(String atributo) throws NaoExisteException, IOException {
		if(this.repPedido.checaExiste(atributo)) {
			this.repPedido.remover(atributo);
		} else throw new NaoExisteException("pedido");
	}
	
	public Iterator<Pedido> iteracaoRepositorio(){
		return this.repPedido.iteracao();
	}

}
