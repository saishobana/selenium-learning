package com.demo.test.yahoo.pages;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Shobana on 9/14/2016.
 */
public  class SheetReader {
    private static HSSFSheet workSheet;
    private static HSSFWorkbook workBook;

    private HashMap<String, Integer> columnIndexes = new HashMap();

    public SheetReader(String fileName, String sheetName) throws Exception {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            workBook = new HSSFWorkbook(fileInputStream);
            workSheet = workBook.getSheet(sheetName);
            // String RowListCount= getRowIndexForTestName(testName);
            setColumnIndexes();
        } catch (java.io.IOException e) {//e.printStackTrace();
            System.out.print("error" + e);
        }
    }

    public <T> List<T> getData(Class<T> classToFill, String testName) throws IllegalAccessException, InstantiationException {



        List<T> resultObjects = new ArrayList<T>();
        List<Integer> rowIndices = getRowIndexForTestName(testName);
        for (Integer rowIndex : rowIndices) {
            Field[] allFields = classToFill.getDeclaredFields();
            Object obj = classToFill.newInstance();
            for (Field field : allFields) {
                int colIndex = columnIndexes.get(field.getName());
                field.set(obj, workSheet.getRow(rowIndex).getCell(colIndex).getStringCellValue());
            }
            resultObjects.add((T) obj);

        }
        return resultObjects;
    }
        /*read row inxes
                for each row read column indexes matching the field names
                create the object and set field with xl value
                add it to the list
                return the list*/


    private List<Integer> getRowIndexForTestName(String testName) {
        Iterator rows = workSheet.rowIterator();
        int rowIndex = 0;
        List rowList = new ArrayList();
        while (rows.hasNext()) {
            HSSFRow row = (HSSFRow) rows.next();
            String testCaseName = row.cellIterator().next().getStringCellValue();
            if (testCaseName.equalsIgnoreCase(testName)) {
                rowList.add(rowIndex);
            }
            rowIndex += 1;
        }
        return rowList;
    }


    private void setColumnIndexes() {
        HSSFRow colHeader = workSheet.getRow(0);
        Iterator<Cell> cellIterator = colHeader.cellIterator();
        int cellIndex = 0;
        while (cellIterator.hasNext()) {
            columnIndexes.put(cellIterator.next().getStringCellValue(), cellIndex++);
        }

        //  read row1
        //check for column name method if not exists then read first row and store each cell value with column index


    }


    public static void main(String[] args) throws Exception {
        SheetReader sReader = new SheetReader("D:\\Selenium\\sampleprj\\src\\test\\resources\\data1.xls", "homePage");
        sReader.getData(SearchDataObject.class, "testYahooSearch");
    }
}
   /* public String read() {
        FileInputStream fileInputStream = null;
        // String a1Val="",a2Val="",path="C:/Users/gomathiselvi_2/Desktop/selenium/SheetReader.xls";
        String a1Val = "", a2Val = "", path = "D:/Selenium/ReadDataFromExcel/src/test/Resource/data.xls";

        try {
            fileInputStream = new FileInputStream(path);
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet worksheet = workbook.getSheet("DataSample");
            HSSFRow row1 = worksheet.getRow(1);
            HSSFCell cellA1 = row1.getCell((short) 0);
            a1Val = cellA1.getStringCellValue();
            HSSFRow row2 = worksheet.getRow(2);
            HSSFCell cellA2 = row2.getCell((short) 0);
            a2Val = cellA2.getStringCellValue();
            System.out.println(a1Val);
            System.out.println(a2Val);



        } catch (java.io.IOException e) {//e.printStackTrace();
            System.out.print("error" + e);
        }return (a1Val);
    }*/


