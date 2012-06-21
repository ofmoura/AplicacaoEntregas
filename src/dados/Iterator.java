package dados;

import java.util.Vector;

import exceptions.NaoHaElementoException;

public class Iterator<Gen> implements IteratorInterface<Gen> {
	
	private Vector<Gen> colecao;
	private int cursor;
	
	public Iterator(Vector<Gen> colecao) {
		this.colecao = colecao;
		this.cursor = 0;
	}

	public boolean existeProximo() {
		return (this.cursor < this.colecao.size());
	}

	public Gen proximo() throws NaoHaElementoException {
		if (!existeProximo()){
			throw new NaoHaElementoException();
		} else {
			return colecao.elementAt(this.cursor++);
		}
	}
}
