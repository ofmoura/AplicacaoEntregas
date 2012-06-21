package teste;

import java.io.IOException;

import java.util.Vector;
import negocios.*;

import dados.*;
import exceptions.NaoHaElementoException;
import objetos.*;

public class teste {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException, NaoHaElementoException {
		/*
		RepArquivo repArquivo;
		repArquivo = new RepArquivo("ARQUIVO");
		Cliente cliente;
		Endereco endereco;
		endereco = new Endereco("logradouro", "numero", "bairro", "cidade");
		cliente = new Cliente("415487712", "9222-5487", "Eriveltu", endereco);
		repArquivo.inserir(cliente);
		repArquivo.checaExiste("9222-5487");
		System.out.println(cliente.getCodigo());
		*/
		Vector<String> creu = new Vector<String>();
		creu.add("lalal");
		creu.add("abugabuga");
		creu.add("lol");
		Iterator<String> colecao = new Iterator<String>(creu);
		while(colecao.existeProximo()){
			System.out.println(colecao.proximo());
		}
	}

}
