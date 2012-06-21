package dados;
import java.io.*;
import java.util.Vector;

import objetos.*;

public class RepArray<Gen> implements RepInterface<Gen> {

	private Cadastrado[] repositorio;
	private int tamanho;
	private int indice;

	public RepArray() {
		this.tamanho = 50;
		this.repositorio = new Cadastrado[this.tamanho];
		this.indice = 0;
	}
	
	private void aumentar() {
		this.tamanho += 20;
		Cadastrado[] arrayMaior = new Cadastrado[this.tamanho];
		for(int i = 0; i < this.repositorio.length; i++) {
			arrayMaior[i] = this.repositorio[i];
		}
		this.repositorio = arrayMaior;
	}

	private int getIndice(String atributo) {
		int indice = -1;
		boolean achou = false;
		for(int i = 0; i < this.indice && !achou; i++) {
			if(this.repositorio[i].getCodigo() == atributo) {
				indice = i;
				achou = true;
			}
		}
		return indice;
	}

	public void inserir(Gen objeto) {
		this.repositorio[this.indice] = (Cliente) objeto;
		this.indice++;
		if(this.indice == this.repositorio.length) aumentar();
	}

	public void remover(String atributo) throws IOException {
		int indice = getIndice(atributo);
		if (indice > -1 && indice < this.indice-1){
			for (int i = indice; i < this.indice-1; i++){
				this.repositorio[i] = this.repositorio[i+1];
			}
		}
		this.repositorio[this.indice] = null;
		this.indice--;
	}
	
	@SuppressWarnings("unchecked")
	public Iterator<Gen> iteracao(){
		Vector<Gen> conteudo = new Vector<Gen>();
		for (int i = 0; i < this.indice; i++){
			conteudo.add((Gen)this.repositorio[i]);
		}
		return new Iterator<Gen>(conteudo);
	}

	public boolean checaExiste(String atributo) {
		boolean achou = true;
		if (getIndice(atributo) == -1){
			achou = false;
		}
		return achou;
	}
}