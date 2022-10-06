package com.aviation.oops;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.*;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;
import java.util.List;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

/*
 * This class is associated to generate a PDF file from the CSV file.
 * It has a basic functionality of a convertor.
 * @param args - The main driver is printing the Html list as an output while Taking the Csv file as input.
 */

public class csvtopdf {


    public void csvtopdf() throws IOException, DocumentException {
        String inputCSVFile = "/Users/azuga/Desktop/result.csv";
        CSVReader reader = new CSVReader(new FileReader(inputCSVFile));

        String [] nextLine;
        int lnNum = 0;

        Document my_pdf_data = new Document(PageSize.A0);
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
        System.out.println("Pdf File is generated from the result.csv file");

    }

    public void csvtohtml() {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/azuga/Desktop/result.csv"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Setting up the Table format as per desired requirements for the converted HTML file.
        //This includes designing the table and assigning the data values to table rows and coulombs.

        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, "<tr><td>" + lines.get(i) + "</td></tr>");
            lines.set(i, lines.get(i).replaceAll(",", "</td><td>"));
        }

        lines.set(0, "<table border>" + lines.get(0));
        lines.set(lines.size() - 1, lines.get(lines.size() - 1) + "</table>");

        try (FileWriter writer = new FileWriter("/Users/azuga/Desktop/converted.html")) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("html File is generated from the result.csv file");

    }

}
