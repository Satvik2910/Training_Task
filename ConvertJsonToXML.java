/*
 * Copyright (c) 2022.  - All Rights Reserved to Azuga.
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -Satvik @satvikm@gmail.com.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class ConvertJsonToXML {
    /*
     * This class converts the json file to XML file.
     * @param args - Parameters act as variables inside the method.
     * @throws JSONException - Thrown to indicate a problem with the JSON API
     */

    public static void main(String[] args) throws JSONException {

        String loc = "/Users/azuga/Desktop/aroute.json";

        String result;
        try {

            result = new String(Files.readAllBytes(Paths.get(loc)));

            String xml = convertToXML(result, "root"); // This method converts json object to xml string  

            FileWriter file = new FileWriter("/Users/azuga/Desktop/XMLData.txt");

            file.write(xml);
            file.flush();
            System.out.println("Your XML data is successfully written into XMLData.txt");

            file.close();

        } catch (IOException e1) {

            e1.printStackTrace();
        }
    }

    public static String convertToXML(String jsonString, String root) throws JSONException {    // handle JSONException
        /*
         * This is a String return type method that return the Xml file foprmat that Stores the Json converted data.
         */

        JSONObject jsonObject = new JSONObject(jsonString);

        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<"+root+">" + XML.toString(jsonObject) + "</"+root+">";

        return xml;
    }
}  