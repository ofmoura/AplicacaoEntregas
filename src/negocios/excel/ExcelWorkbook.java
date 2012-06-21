package negocios.excel;

import java.io.FileInputStream;
import java.io.IOException;

import negocios.excel.exception.IOExcelException;
import negocios.excel.exception.SheetNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelWorkbook {


       private HSSFWorkbook hssfWorkbook;
       
       public ExcelWorkbook ( String nomeDoArquivo ) throws IOExcelException{
           try{
               FileInputStream fis = new FileInputStream(nomeDoArquivo);
               HSSFWorkbook tmp = new HSSFWorkbook (fis);
               this.setHSSFWorkbook (tmp);
           } catch (IOException e) {
        	   throw new IOExcelException(String.format("Erro ao ler um arquivo. verifique se o arquivo(%s) existe", nomeDoArquivo));
	       } 
       }  

       protected void setHSSFWorkbook (HSSFWorkbook hssfWorkbook) {
            
            if (hssfWorkbook != null) {
                this.hssfWorkbook = hssfWorkbook;
            } else {
            	throw new IllegalArgumentException("O valor passado eh nulo");
            }
            
        }

        public ExcelSheet getSheet (String name) throws SheetNotFoundException {
            ExcelSheet ret = null;
            HSSFSheet tmp = this.hssfWorkbook.getSheet (name);

            if (tmp != null) {
                ret = new ExcelSheet (tmp);
            } else {
            	throw new SheetNotFoundException(String.format("A planilha(%s) nao existe", name));
            }

            return ret;
        }

}

