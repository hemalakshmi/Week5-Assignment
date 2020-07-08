package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcelData(String excelFileName) throws IOException {
		// TODO Auto-generated method stub
XSSFWorkbook book =new XSSFWorkbook("./data/"+excelFileName+".xlsx");
XSSFSheet sheet = book.getSheetAt(0);
int rowCount = sheet.getLastRowNum();
System.out.println("Row size:"+ rowCount);
XSSFRow headerRow = sheet.getRow(0);
short colCount = headerRow.getLastCellNum();
System.out.println("coulmn size:"+ colCount);
String[][] array=new String[rowCount][colCount];
for(int i=1;i<=rowCount;i++) {
	XSSFRow row = sheet.getRow(i);
	for(int j=0;j<colCount;j++) {
		XSSFCell cell = row.getCell(j);
		String data = cell.getStringCellValue();
		array[i-1][j]=data;
		System.out.println(data);
	}
}
book.close();
return array;
	}

}
