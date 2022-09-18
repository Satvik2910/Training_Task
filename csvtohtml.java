/*
 * Copyright (c) 2022.  - All Rights Reserved to Azuga.
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -Satvik @satvikm@gmail.com.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class html {
    /*
    * This class is associated to generate a HTML file from the CSV file.
    * It has a basic functionality of a convertor.
    * @param args - The main driver is printing the Html list as an output while Taking the Csv file as input.
    */

    public static void main(String[] args) {
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
    }
}