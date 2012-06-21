package negocios.excel;

import negocios.excel.exception.NotDefinedRowException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;


public class ExcelSheet {


       private HSSFSheet hssfSheet;

       public ExcelSheet (HSSFSheet hssfSheet) {
              this.setHSSFSheet (hssfSheet);
       }

       protected void setHSSFSheet (HSSFSheet hssfSheet) {
            
            if (hssfSheet != null) {
                this.hssfSheet = hssfSheet;
            } else {
            	throw new IllegalArgumentException("A planilha passada eh nula");
            }
            
        }

        public ExcelRow getRow (int rownum) throws NotDefinedRowException {
            ExcelRow ret = null;
            HSSFRow tmp = this.hssfSheet.getRow (rownum);

            if (tmp != null) {
                ret = new ExcelRow (tmp);
            } else {
            	throw new NotDefinedRowException(String.format("A linha(numero %d) nao esta definida", rownum));
            }
            return ret;
        }

}

