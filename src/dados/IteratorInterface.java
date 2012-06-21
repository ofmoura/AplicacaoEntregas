package dados;

import exceptions.NaoHaElementoException;

public interface IteratorInterface<Gen> {
	
	boolean existeProximo();
	Gen proximo() throws NaoHaElementoException;
	
}
