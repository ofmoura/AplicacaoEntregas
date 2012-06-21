package negocios;

import objetos.Cliente;
import dados.RepInterface;

public class ControlCli {
	
	private RepInterface<Cliente> repCli;
	
	public ControlCli(RepInterface<Cliente> repCli) {
		this.repCli = repCli;
	}
	
	public boolean checaExiste(String telefone) {
		return repCli.checaExiste(telefone);
	}

}
