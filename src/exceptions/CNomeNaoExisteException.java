package exceptions;

public class CNomeNaoExisteException extends Exception{
	
	public CNomeNaoExisteException() {
		super("Nao existem clientes cadastrados com esse nome.");
	}

}
