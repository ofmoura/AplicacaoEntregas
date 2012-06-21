package excel;

import negocios.excel.exception.NotDefinedCellException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;


public class ExcelRow {


       private HSSFRow hssfRow;

       public ExcelRow (HSSFRow hssfRow) {
              this.setHSSFRow (hssfRow);
       }

       protected void setHSSFRow (HSSFRow hssfRow) {
            
            if (hssfRow != null) {
                this.hssfRow = hssfRow;
            } else {
            	throw new IllegalArgumentException("A linha passada eh nula");
            }

        }

        public ExcelCell getCell (int cellnum) throws NotDefinedCellException {
            ExcelCell ret = null;
            HSSFCell tmp = this.hssfRow.getCell ((short)cellnum);

            if (tmp != null) {
                ret = new ExcelCell (tmp);
            } else {
            	throw new NotDefinedCellException(String.format("A celula numero %d nao esta definida", cellnum));
            }

            return ret;
        }

}

