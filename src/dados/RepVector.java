package dados;

import objetos.*;

import java.util.Vector;

public class RepVector<Gen> implements RepInterface<Gen> {

	private Vector<Gen> repositorio;
	
	public RepVector() {
		this.repositorio = new Vector<Gen>();
	}
	
	public void inserir(Gen objeto) {
		this.repositorio.add(objeto);
	}

	public void remover(String atributo) {
		this.repositorio.remove(procurar(atributo));
	}
	
	private Cadastrado procurar(String atributo){
		Cadastrado cadastrado = null;
		boolean achou = false;
		for (int i = 0; i < repositorio.size() && !achou; i++){
			if (((Cadastrado)this.repositorio.elementAt(i)).getCodigo() == atributo){
				cadastrado = (Cadastrado)this.repositorio.elementAt(i);
				achou = true;
			}
		}
		return cadastrado;
	}
	
	public Iterator<Gen> iteracao(){
		return new Iterator<Gen>(this.repositorio);
	}

	public boolean checaExiste(String atributo) {
		boolean existe = false;
		for(int i = 0; i < this.repositorio.size() && !existe; i++) {
			if((((Cadastrado) this.repositorio.elementAt(i)).getIdentificador()).equalsIgnoreCase(atributo)){
				existe = true;
			}
		}
		return existe;
	}
}