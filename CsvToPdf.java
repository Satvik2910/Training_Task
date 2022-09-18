/*
 * Copyright (c) 2022.  - All Rights Reserved to Azuga.
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -Satvik @satvikm@gmail.com.
 */

import java.io.FileOutputStream;
import java.io.*;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class CsvToPdf {
    /*
     * This class is associated to generate a PDF file from the CSV file.
     * It has a basic functionality of a convertor.
     * @param args - The main driver is printing the Html list as an output while Taking the Csv file as input.
     */

    public static void main(String[] args) throws IOException, DocumentException {

        String inputCSVFile = "/Users/azuga/Desktop/result.csv";
        CSVReader reader = new CSVReader(new FileReader(inputCSVFile));

        String [] nextLine;
        int lnNum = 0;

        Document my_pdf_data = new Document();
        PdfWriter.getInstance(my_pdf_data, new FileOutputStream("/Users/azuga/Desktop/converted_PDF_File.pdf"));
        my_pdf_data.open();
        PdfPTable my_first_table = new PdfPTable(14);
        PdfPCell table_cell;

        while ((nextLine = reader.readNext()) != null) {
            lnNum++;
            int i=0;
            while(i<=13) {
                table_cell = new PdfPCell(new Phrase(nextLine[i]));
                my_first_table.addCell(table_cell);
                i++;
            }
        }

        my_pdf_data.add(my_first_table);
        my_pdf_data.close();
    }
}