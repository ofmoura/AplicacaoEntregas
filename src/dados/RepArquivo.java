package dados;

import objetos.*;
import java.io.*;
import java.util.Vector;

public class RepArquivo<Gen> implements RepInterface<Gen> {

	private File repositorio;
	private Vector<Gen> conteudo;

	@SuppressWarnings("unchecked")
	public RepArquivo(String nomeArquivo) throws IOException, ClassNotFoundException {
		this.conteudo = new Vector<Gen>();
		this.repositorio = new File(nomeArquivo + ".txt");
		this.repositorio.createNewFile();
		try {
			ObjectInputStream oit = new ObjectInputStream(new FileInputStream(this.repositorio));
			Cadastrado objeto = null;
			objeto = (Cadastrado)oit.readObject();
			while (objeto != null){
				this.conteudo.add((Gen)objeto);
				objeto = (Cadastrado)oit.readObject();
			}
			oit.close();
		} catch (EOFException e) {
		}
	}

	//http://www.javadb.com/reading-objects-from-file-using-objectinputstream

	public void inserir(Gen objeto) throws IOException {
		this.conteudo.add(objeto);
		salvarMudancas();
	}

	public void remover(String atributo) throws IOException {
		for (int i = 0; i < this.conteudo.size(); i++){
			if(((Cadastrado) this.conteudo.elementAt(i)).getCodigo() == atributo){
				this.conteudo.remove((Cadastrado) this.conteudo.elementAt(i));
			}
		}
		salvarMudancas();
	}

	private void salvarMudancas() throws IOException {
		FileOutputStream fot = new FileOutputStream(this.repositorio);
		ObjectOutputStream oot = new ObjectOutputStream(fot);
		for (int i = 0; i < this.conteudo.size(); i++){
			oot.writeObject((Object) this.conteudo.elementAt(i));
		}
		oot.close();
	}

	public Iterator<Gen> iteracao(){
		return new Iterator<Gen>(this.conteudo);
	}

	public boolean checaExiste(String atributo) {
		boolean existe = false;
		for(int i = 0; i < this.conteudo.size() && !existe; i++) {
			if((((Cadastrado) this.conteudo.elementAt(i)).getIdentificador()).equalsIgnoreCase(atributo)){
				existe = true;
			}
		}
		return existe;
	}

	//RepositorioArray<Cliente> clientes = new RepositorioArray<Cliente>();
}