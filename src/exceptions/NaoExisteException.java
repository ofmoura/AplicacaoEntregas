package exceptions;

public class NaoExisteException extends Exception {
	
	public NaoExisteException(String tipo) {
		super("Nao existe um " + tipo+ " com esses dados.");
	}

}
