package exceptions;

public class CTelNaoExisteException extends Exception{

	public CTelNaoExisteException(){
		super("Nao existe clientes cadastrados com esse telefone.");
	}
}
