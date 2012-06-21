package exceptions;

public class JaExisteException extends Exception {
	
	public JaExisteException(String tipo) {
		super("Ja existe um " + tipo + " com esses dados");
	}

}
