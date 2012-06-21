package excel;

import negocios.excel.exception.CellNumberFormatException;
import negocios.excel.exception.CellStringFormatException;

import org.apache.poi.hssf.usermodel.HSSFCell;


public class ExcelCell {


       private HSSFCell hssfCell;

       public ExcelCell (HSSFCell hssfCell) {
              this.setHSSFCell (hssfCell);
       }

       protected void setHSSFCell (HSSFCell hssfCell) {
            
            if (hssfCell != null) {
                this.hssfCell = hssfCell;
            } else {
            	throw new IllegalArgumentException("A celula passada eh nula");
            }
            
        }

        public double getNumericCellValue () throws CellNumberFormatException {
            double ret = 0.0;

            try {
                ret = this.hssfCell.getNumericCellValue ();
            } catch (Exception e) {
            	throw new CellNumberFormatException(String.format("O conte�do da c�lula n� %d n�o pode ser convertida em um numero", this.hssfCell.getCellNum()));
            }

            return ret;
        }

        public String getStringCellValue () throws CellStringFormatException{
            String ret = "";

            try {
                ret = this.hssfCell.getRichStringCellValue().getString();
            } catch (Exception e) {
                throw new CellStringFormatException(String.format("O conte�do da c�lula n� %d n�o pode ser convertida em String", this.hssfCell.getCellNum()));
            }

            return ret;
        }

}

