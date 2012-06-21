package exceptions;

public class PNomeNaoExisteException extends Exception{
	
	public PNomeNaoExisteException(){
		super("Não existem produtos cadastrados com esse nome.");
	}

}
