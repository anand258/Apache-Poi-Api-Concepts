package apachePoiApi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Developed by Anand Singh on 03/Jul/2021, 12:40 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class driveData {
    public ArrayList<String> getData(String testCaseName) throws IOException {
        ArrayList<String> dataList = new ArrayList<>();
        FileInputStream fin = new FileInputStream("/Users/anasingh/IdeaProjects/Apache-Poi-Api-Concepts/src/main/resources/TestCases.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fin);
        int sheetCounts = workbook.getNumberOfSheets();
        for(int i = 0 ; i < sheetCounts ; i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("testData")){
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> ce = firstRow.cellIterator();
                int k = 0;
                int column = 0;
                while (ce.hasNext()){
                    Cell cellValue = ce.next();
                    if(cellValue.getStringCellValue().equalsIgnoreCase("Testcase")){
                        column = k;
                    }
                    k++;
                }
                while (rows.hasNext()){
                    Row rowData = rows.next();
                    if(rowData.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)){
                        Iterator<Cell> cellDataValue = rowData.cellIterator();
                        while (cellDataValue.hasNext()){
                            Cell cv = cellDataValue.next();
                            if(cv.getCellType()== CellType.STRING){
                                dataList.add(cv.getStringCellValue());
                            } else {
                                 String str= NumberToTextConverter.toText(cv.getNumericCellValue());
                                dataList.add(str);
                            }

                        }
                    }
                }
            }
        }
        return dataList;
    }
}
