/*
 * Copyright (c) 2022.  - All Rights Reserved to Azuga.
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -Satvik @satvikm@gmail.com.
 */

import com.spire.xls.*;
import java.util.EnumSet;

public class csvtoExcel {
    /*
     * This class is associated to generate an Excel file from the CSV file.
     * It has a basic functionality of a convertor.
     * @param args - The main driver is printing the Excel table as an output while Taking the Csv file as input.
     */

    public static void main(String[] args) {

        Workbook workbook = new Workbook();
        workbook.loadFromFile("/Users/azuga/Desktop/result.csv", ",", 1, 1);
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.getCellRange("A1:D6").setIgnoreErrorOptions(EnumSet.of(IgnoreErrorType.NumberAsText));
        sheet.getAllocatedRange().autoFitColumns();
        sheet.getAllocatedRange().autoFitRows();
        workbook.saveToFile("/Users/azuga/Desktop/result1.xlsx", ExcelVersion.Version2013);

    }
}