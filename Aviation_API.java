/*
 * Copyright (c) 2022.  - All Rights Reserved to Azuga.
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -Satvik @satvikm@gmail.com.
 */

package org.example;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class AVAI {
    /*
     * This class is associated to implement the Aviation Routes API and to generate a Csv file from the Json file.
     * @param args - The main driver is printing the list as an output in form of string.
     */

    public static void main(String[] args) {


        try {

            URL url = new URL("https://api.aviationapi.com/v1/preferred-routes");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            //The above method is to call the API and get the Data from the server.

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                // The Ideal response code is supposed to be 200 ok else the serve issues an error.

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                if (informationString.length() > 2300)
                    System.out.println(informationString.substring(0, 2300)+"\n");

                else
                    System.out.println(informationString);

                try(FileWriter fw = new FileWriter("/Users/azuga/Desktop/aroute.json")){
                    fw.write(informationString.toString());
                    // Creating a new file with .json extension that Stores the data extracted from the API server.

                }catch (Exception e){
                    e.printStackTrace();
                }


                InputStream fil = new FileInputStream("/Users/azuga/Desktop/aroute.json");
                JSONTokener token = new JSONTokener(fil);
                JSONArray Arr = new JSONArray(token);
                StringBuilder csvfile = new StringBuilder();
                csvfile.append(CDL.toString(Arr));
                //With Help of JSONTokener we save the extracted data in Form of array and then append it to csvfile.

                try {

                    Files.write(Path.of("/Users/azuga/Desktop/aroute1.csv"), csvfile.toString().getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("completed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}