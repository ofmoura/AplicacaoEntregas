package dados;

import java.io.IOException;
import java.util.Vector;

public interface RepInterface<Gen> {
	
	  void inserir(Gen objeto) throws IOException;
	  void remover(String atributo) throws IOException;
	  boolean checaExiste(String atributo);
	  Iterator<Gen> iteracao();//adicionei

	  //fica faltando a gente fazer os mecaninsmos de busca... levando em 
	  //conta que ele pode pedir qualquer tipo de atributo e a gente tem 
	  //que retornar as buscas pra ele escolher e tudo mais... :P
	  //Vector<Cadastrado> getCadastrado(String atributo);
}