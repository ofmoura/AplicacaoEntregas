package fachada;

import java.io.*;

import objetos.*;
import dados.RepInterface;

public class Fachada {
	//pegar iterators de todo canto:
	// - dos repostirórios, na hora da busca;
	// - do leitorPlanilha, na hora de inicializar;
	// ...
	// E filtrar ELES TODOS! Pra aí sim poder mandar pro cliente o resultado ou então salvar no repositório
	private RepInterface<Cliente> repCliente;
	private RepInterface<Produto> repProduto;
	private RepInterface<Pedido> repPedido;
	
	public Fachada() {

		

	}
}
