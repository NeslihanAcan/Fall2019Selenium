package com.automation.tests.day25_excel_io;

import com.automation.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws Exception{

        //We need to get a file as an object
        File file=new File("VytrackTestUsers.xlsx");

        //Object that represents excel file
        Workbook workbook= WorkbookFactory.create(file);

        //get QA1-short
        Sheet workSheet=workbook.getSheet("QA1-short");

        //get 1st row
        Row firstRow=workSheet.getRow(0);

        //get 1st cell
        Cell firstCell=firstRow.getCell(0);

        String value=firstCell.getStringCellValue();

        System.out.println(value);

        String secondCellValue=firstRow.getCell(1).getStringCellValue();
        System.out.println(secondCellValue);
        System.out.println("//////////////////////////");
        int lastCell=firstRow.getLastCellNum();

        for(int i=0;i<lastCell; i++){
            System.out.print(firstRow.getCell(i)+ " | ");
        }
        //last row is 16. Index is 15
        int numOfRows=workSheet.getLastRowNum();
        int numOfRow2=workSheet.getPhysicalNumberOfRows();


        System.out.println("\nNumber of rows ="+numOfRows);
        System.out.println("Numbers of rows= "+numOfRow2);


        for (int row = 0; row <numOfRow2 ; row++) {

            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue=workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue+ " | ");
            }
            System.out.println();
        }

    }
    @Test
    public void excelUtilityTest(){

        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA1-all";

        ExcelUtil excelUtil=new ExcelUtil(path,spreadSheet);

        excelUtil.getDataList().forEach(System.out::println);
    }
    @Test
    public void getColumnNamesTest(){
        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA1-short";

        ExcelUtil excelUtil=new ExcelUtil(path,spreadSheet);

        System.out.println(excelUtil.getColumnsNames());
    }
}
