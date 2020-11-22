package com.example.demo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {


    private static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "products";

    public static boolean hasExcelFormat(MultipartFile file){

        if(!file.getContentType().equals(TYPE))
        {
          return  false;
        }
        return  true;
    }

    public static List<Product> excelToProduct(InputStream inputStream) {

        try {

             Workbook workbook = new XSSFWorkbook(inputStream);
             Sheet sheet =  workbook.getSheet(SHEET);
             Iterator<Row>  rows = sheet.iterator();
             List<Product> productList = new ArrayList<Product>();

             int rowNumber = 0;
             while(rows.hasNext()){
                 Row currentRow = rows.next();

                 if(rowNumber == 0){
                     rowNumber++;
                     continue;
                 }


                 Iterator<Cell> cellsInRow = currentRow.iterator();
                 Product product = new Product();
                 int cellIdx =0;

                 while(cellsInRow.hasNext()){
                     Cell currentCell = cellsInRow.next();

                     switch (cellIdx){

                         case 0 :
                               product.setId((int)currentCell.getNumericCellValue());
                             break;
                         case 1 :
                             product.setProductType(currentCell.getStringCellValue());
                             break;

                         case 2:
                             product.setPrice(BigDecimal.valueOf(currentCell.getNumericCellValue()));

                         default:
                             break;
                     }
            cellIdx++;
                 }
               productList.add(product);
             }

             workbook.close();
             return  productList;




        }catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }

    }
}
