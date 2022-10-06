package com.aviation.oops;


import com.itextpdf.text.DocumentException;
import org.apache.log4j.Logger;
import java.io.IOException;


public class fileConvertor {
    private static final Logger logger = Logger.getLogger(fileConvertor.class);
    public static void main(String[] args) throws DocumentException, IOException {
        convertor file = new convertors();
        file.csvfile();
        file.csvtohtml("/Users/azuga/Desktop/result.csv", "/Users/azuga/Desktop/converted.html");
        file.csvtoExcel("/Users/azuga/Desktop/result.csv", "/Users/azuga/Desktop/result1.xlsx");
        file.csvtopdf("/Users/azuga/Desktop/result.csv", "/Users/azuga/Desktop/converted_PDF_File.pdf");

        logger.info("The interface method is implemented.");

    }
}