package negocios;

import negocios.excel.exception.*;
import negocios.excel.*;
import dados.Iterator;
import java.io.FileNotFoundException;
import java.util.Vector;
import objetos.Cliente;
import objetos.Endereco;

public class LeitorClientesPlanilha {

	private ExcelWorkbook documento;
	private Vector<Cliente> informacaoPlanilha;

	public LeitorClientesPlanilha() throws FileNotFoundException, IOExcelException, SheetNotFoundException, NotDefinedRowException {
		informacaoPlanilha = new Vector<Cliente>();
		lerPlanila();
	}

	private void lerPlanila() throws FileNotFoundException, IOExcelException, SheetNotFoundException, NotDefinedRowException {
		this.documento = new ExcelWorkbook ("Delivery.xls");
		ExcelSheet planilha = this.documento.getSheet("Clientes");
		String nome, cpf, logradouro, numero, complemento, bairro, cidade, telefone, observacoes;
		Endereco endereco;
		for (int c = 1; c < 32; c++){
			try {
				nome = planilha.getRow(c).getCell(0).getStringCellValue();
				cpf = planilha.getRow(c).getCell(1).getStringCellValue();
				logradouro = planilha.getRow(c).getCell(2).getStringCellValue();
				numero = planilha.getRow(c).getCell(3).getStringCellValue();
				complemento = planilha.getRow(c).getCell(4).getStringCellValue();
				bairro = planilha.getRow(c).getCell(5).getStringCellValue();
				cidade = planilha.getRow(c).getCell(6).getStringCellValue();
				telefone = planilha.getRow(c).getCell(7).getStringCellValue();
				observacoes = planilha.getRow(c).getCell(8).getStringCellValue();
				endereco = new Endereco(logradouro, numero, complemento, bairro, cidade);
				informacaoPlanilha.add(new Cliente(cpf, telefone, nome, endereco, observacoes));
			} catch (CellStringFormatException e) {
				e.printStackTrace();
			} catch (NotDefinedCellException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Iterator<Cliente> enviaClientes(){
		return new Iterator<Cliente>(informacaoPlanilha);
	}
}


/*
 * O arquivo Delivery.xls deve ser lido para a inicializa��o do sistema.
 * Por exemplo, os clientes inicialmente dispon�veis no sistema devem ser lidos do
 * arquivo, e assim sucessivamente. Atente para a ordem de leitura das planilhas.
 * 
 * Para a leitura das planilhas Excel, deve ser utilizado o conjunto de classes
 * ExcelWorkbook, ExcelSheet, ExcelRow e ExcelCell, dispon�veis no arquivo excel.zip.
 * Estas classes s�o baseadas no projeto Apache POI HSSF, que deve ter sua biblioteca
 * inclu�da no build path do projeto.
 *
 * 
 * ExcelWorkbook = um arquivo Excel
 * ExcelSheet = uma planilha do arquivo
 * ExcelRow = uma linha em uma planilha
 * ExcelCell = uma linha em uma célula
 * 
 * Os objetos das classes ExcelWorkbook, ExcelSheet, ExcelRow e ExcelCell representam,
 * respectivamente, um arquivo Excel, uma planilha do arquivo, uma linha em uma planilha,
 * e uma linha em uma c�lula.
 * 
 * Assim, para ler um arquivo Excel, devemos primeiro criar um
 * objeto ExcelWorkbook, passando o caminho do arquivo como par�metro. Atrav�s deste objeto,
 * podemos obter uma planilha chamando o m�todo getSheet, que recebe o nome da planilha
 * desejada como par�metro. Com a planilha, podemos acessar uma linha chamando o m�todo getRow,
 * que recebe o n�mero da linha a ser lida. Do mesmo modo, dada uma planilha, podemos acessar
 * uma de suas c�lulas com o m�todo getCell, que recebe o n�mero da c�lula. Finalmente, podemos
 * ler o conte�do de uma c�lula chamando os m�todos getNumericCellValue (que retorna um double)
 * ou getStringCellValue (que retorna uma String).
 * 
 * Leia o conte�do na planilha e insira os
 * clientes, produtos ou compras a partir deles. Antes, por�m, teste as classes para leitura
 * do arquivo isoladamente, para verificar se elas funcionam adequadamente. Isto deve ser
 * feito sempre que usamos uma API implementada por terceiros. Verifique tamb�m poss�veis erros
 * que podem ocorrer quando chamamos estes m�todos. Por exemplo, getNumericCellValue pode ser
 * chamado apenas para c�lulas que armazenam valores num�ricos. Observe tamb�m que diversos
 * erros podem ocorrer no momento da inser��o dos clientes, produtos ou compras da planilha.
 * Podemos ter cadastros incompletos, sem dados obrigat�rios ou compras com clientes produtos
 * n�o cadastrados. Como no restante da aplica��o, sinalize estes erros com exce��es e reporte-os
 * ao usu�rio na inicializa��o da aplica��o. 
 */
//}
