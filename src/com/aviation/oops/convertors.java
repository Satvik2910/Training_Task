/*
 * Copyright (c) 2022.  - All Rights Reserved to Azuga.
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -Satvik @satvikm@gmail.com.
 */

package com.aviation.oops;

import au.com.bytecode.opencsv.CSVReader;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spire.xls.ExcelVersion;
import com.spire.xls.IgnoreErrorType;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;


/**
 * This class is associated to convert csv file Extracted from the Aviation api into different extension(i.e .pdf,.html,.xlsx) file.
 * It has a basic functionality of a convertor.
 * The main driver is printing the various file as an output while Taking the Csv file as input.
 */
public class convertors implements convertor {
    private static final Logger logger = Logger.getLogger(convertors.class);

    public void csvfile() {
        try {
            logger.info("Csvfile method is executed");

            URL url = new URL("https://api.aviationapi.com/v1/preferred-routes");
            logger.trace("Calling Aviation api data through " + url);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            logger.info("Getting aviation routes data from Aviation API server.");

            conn.connect();
            //The above method is to call the API and get the Data from the server.

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                logger.info("Response code = " + responseCode);

            } else {
                // The Ideal response code is supposed to be 200 ok else the serve issues an error.

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                logger.debug("The response from the server is stored in informationString");

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();

                try (FileWriter fw = new FileWriter("/Users/azuga/Desktop/aroute.json")) {
                    fw.write(informationString.toString());
                    // Creating a new file with .json extension that Stores the data extracted from the API server.
                    logger.info("Source file Created to Store Json data at : \"/Users/azuga/Desktop/aroute.json\" ");

                } catch (IOException e) {
                    logger.error("IOException", e);
                }


                InputStream file = new FileInputStream("/Users/azuga/Desktop/aroute.json");
                JSONTokener token = new JSONTokener(file);
                JSONArray Arr = new JSONArray(token);
                //With Help of JSONTokener we save the extracted data in Form of array and then append it to csvfile.

                Files.write(Path.of("/Users/azuga/Desktop/result1.csv"), CDL.toString(Arr)
                        //With Help of JSONTokener we save the extracted data in Form of array and then append it to csvfile.
                        .getBytes());
                logger.info("The destination file for Storing Csv data is created at: \"/Users/azuga/Desktop/result1.csv\" ");


            }
        } catch (IOException e) {
            logger.error("IOException", e);
        }
    }

    @Override
    public void csvtopdf(String inputCSVFile, String destinationFile) throws IOException, DocumentException {
        /*
         * This class is associated to generate a PDF file from the CSV file.
         * It has a basic functionality of a convertor.
         * @param args - The main driver is printing the Html list as an output while Taking the Csv file as input.
         */

        logger.info("The Source file: \"/Users/azuga/Desktop/result1.csv\" is taken as input for converting into Pdf file.");

        CSVReader reader = new CSVReader(new FileReader(inputCSVFile));

        String[] nextLine;

        Document my_pdf_data = new Document(PageSize.A0);
        PdfWriter.getInstance(my_pdf_data, new FileOutputStream(destinationFile));
        logger.info("The Pdf file Storing csv data from aviation API is created at: \"/Users/azuga/Desktop/converted_PDF_File.pdf\" ");

        my_pdf_data.open();
        PdfPTable my_first_table = new PdfPTable(14);
        PdfPCell table_cell;

        while ((nextLine = reader.readNext()) != null) {

            int i = 0;
            while (i <= 13) {
                table_cell = new PdfPCell(new Phrase(nextLine[i]));
                my_first_table.addCell(table_cell);
                i++;
            }
        }

        my_pdf_data.add(my_first_table);
        logger.debug("The pdf table format is stored in my_first_table");

        my_pdf_data.close();
        logger.info("csvtopdf method is executed");


    }

    @Override
    public void csvtohtml(String inputCSVFile, String destinationFile) {
        /*
         * This class is associated to generate an HTML file from the CSV file.
         * It has a basic functionality of a convertor.
         * @param args - The main driver is printing the Html list as an output while Taking the Csv file as input.
         */

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputCSVFile))) {
            logger.info("The Source file: \"/Users/azuga/Desktop/result1.csv\" is taken as input for converting into HTML file.");

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
            }
        } catch (IOException e) {
            logger.error("IOException", e);
        }

        //Setting up the Table format as per desired requirements for the converted HTML file.
        //This includes designing the table and assigning the data values to table rows and coulombs.

        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, "<tr><td>" + lines.get(i) + "</td></tr>");
            lines.set(i, lines.get(i).replaceAll(",", "</td><td>"));
        }

        lines.set(0, "<table border>" + lines.get(0));
        lines.set(lines.size() - 1, lines.get(lines.size() - 1) + "</table>");

        try (FileWriter writer = new FileWriter(destinationFile)) {
            logger.info("The html file Storing csv data from aviation API is created at: \"/Users/azuga/Desktop/converted.html.pdf\" ");

            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            logger.error("IOException", e);
        }
        logger.info("csvtohtml method is executed");


    }

    @Override
    public void csvtoExcel(String inputCSVFile, String destinationFile) {
        /*
         * This class is associated to generate an Excel file from the CSV file.
         * It has a basic functionality of a convertor.
         * @param args - The main driver is printing the Excel table as an output while Taking the Csv file as input.
         */

        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputCSVFile, ",", 1, 1);
        logger.info("The Source file: \"/Users/azuga/Desktop/result1.csv\" is taken as input for converting into Excel file.");


        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.getCellRange("A1:D6").setIgnoreErrorOptions(EnumSet.of(IgnoreErrorType.NumberAsText));
        sheet.getAllocatedRange().autoFitColumns();
        sheet.getAllocatedRange().autoFitRows();
        workbook.saveToFile(destinationFile, ExcelVersion.Version2013);
        logger.info("The Excel file Storing csv data from aviation API is created at: \"/Users/azuga/Desktop/result1.xlsx\" ");


        logger.info("csvtoExcel method is executed");


    }


}
