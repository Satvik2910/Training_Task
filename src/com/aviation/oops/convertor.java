package com.aviation.oops;

import com.itextpdf.text.DocumentException;
import java.io.IOException;

public interface convertor {
    void csvfile() throws IOException;
    void csvtopdf(String inputCSVFile, String destinationFile) throws IOException, DocumentException;
    void csvtohtml(String inputCSVFile, String destinationFile);

    void csvtoExcel(String inputCSVFile, String destinationFile);
}
