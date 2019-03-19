package com.application.organization.portsandadapters.shipments.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PoiWork {
    public static void main(String[] args) {
        Workbook workbook = new HSSFWorkbook();

        DocumentStyles documentStyles = new DocumentStyles();
        generateDocument(workbook, documentStyles);

        Sheet sheet = workbook.createSheet();

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        CellStyle cellStyle = workbook.createCellStyle();

        Font font = workbook.createFont();
        font.setBold(true);
        font.setItalic(true);
        font.setFontHeightInPoints((short) 24);
        font.setFontName("Arial");

        cellStyle.setFont(font);

        cell.setCellValue("This is a value!");
        cell.setCellStyle(cellStyle);

        try {
            URL resource = PoiWork.class.getClassLoader().getResource("");
            System.out.println(resource);
            File file = new File(resource.getFile() + "/file.xlsx");
            ((HSSFWorkbook) workbook).write(file);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateDocument(Workbook workbook, DocumentStyles cellStyles) {

    }
}
