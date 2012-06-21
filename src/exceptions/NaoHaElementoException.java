package exceptions;

public class NaoHaElementoException extends Exception {
	
	public NaoHaElementoException() {
		super("Nao existe um proximo elemento.");
	}

}
