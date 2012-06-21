package negocios;

import java.io.IOException;

import dados.*;

import objetos.Cliente;

import exceptions.*;

public class ClienteNego {
	
private RepInterface<Cliente> repCliente;
	
	public ClienteNego(RepInterface<Cliente> repCliente) {
		this.repCliente = repCliente;
	}
	
	public void inserir(Cliente cliente) throws JaExisteException, IOException {
		if(!this.repCliente.checaExiste(cliente.getCodigo())) {
			this.repCliente.inserir(cliente);
		} else throw new JaExisteException("cliente");
	}
	
	public void remover(String atributo) throws NaoExisteException, IOException {
		if(this.repCliente.checaExiste(atributo)) {
			this.repCliente.remover(atributo);
		} else throw new NaoExisteException("cliente");
	}
	
	public Iterator<Cliente> iteracaoRepositorio(){
		return this.repCliente.iteracao();
	}
}
