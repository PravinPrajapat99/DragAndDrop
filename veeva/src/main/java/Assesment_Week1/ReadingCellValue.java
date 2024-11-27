package Assesment_Week1;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Program to read cell value by sheet name
 */
public class ReadingCellValue {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        Scanner sc = new Scanner(System.in);
        File f = new File("/Users/Pravin KumarPrajapat/Downloads/Copy of 30 day topics.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(OPCPackage.open(f));
        System.out.println("Enter the name of the sheet");
        String sheetName = sc.nextLine();  // Read the sheet name
        System.out.println("Enter the row number");
        int row1 = sc.nextInt();
        System.out.println("Enter the column number");
        int col = sc.nextInt();

        XSSFSheet sheet = wb.getSheet(sheetName);

        // Get the row and cell values
        Row row = sheet.getRow(row1);
        if (row == null) {
            System.out.println("Row " + row1 + " does not exist in sheet '" + sheetName + "'.");
            return;
        }

        Cell cell = row.getCell(col);
        if (cell == null) {
            System.out.println("Cell at row " + row1 + " and column " + col + " does not exist.");
            return;
        }

        // Output the cell value
        System.out.println("Cell value: " + cell.getStringCellValue());
    }
}
