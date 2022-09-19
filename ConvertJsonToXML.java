/*
 * Copyright (c) 2022.  - All Rights Reserved to Azuga.
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -Satvik @satvikm@gmail.com.
 */

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertJsonToXML {
    /*
     * This class methods are used to convert json file to xml file.
     * @param args - Parameters act as variables inside the method.
     * @throws JSONException - Thrown to indicate a problem with the JSON API
     */
    public static void main(String[] args) throws JSONException {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n");
        sb.append("<roots>");
        String res;
        try {
            res = new String(Files.readAllBytes(Paths.get("/Users/azuga/Desktop/aroute.json")));
            System.out.println(res);
            String a = res.replace("[","");
            String b = a.replace("//","");



            String[] arr = b.split("},\\{");

            FileWriter file = new FileWriter("/Users/azuga/Desktop/aroute1.xml");
            // By the following method we convert json object into xml string and the data get appends in the xml file .

            for(int i=0;i< arr.length;i++) {
                if(i==0) {
                    sb.append(convertToXML(arr[i] + "}", "root"));
                }
                else if (i==arr.length-1) {
                    res="{"+arr[i];
                    sb.append(convertToXML(res, "root"));
                }
                else{
                    System.out.println(i);
                    res="{"+arr[i]+"}";
                    sb.append(convertToXML(res, "root"));

                }
            }
            sb.append("</roots>");
            file.write(sb.toString());
            file.close();


        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static String format(String xml) {

        try {
            final InputSource src = new InputSource(new StringReader(xml));
            final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
            final Boolean keepDeclaration = xml.startsWith("<?xml");

            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();

            writer.getDomConfig().setParameter("", Boolean.TRUE); 
            // Set this to true if the output needs to be beautified.
            
            writer.getDomConfig().setParameter("", keepDeclaration); 

            return writer.writeToString(document);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertToXML(String jsonString, String root) throws JSONException {

        // This is a String return type method that return the Xml file format that Stores the Json converted data.

        JSONObject jsonObject =new JSONObject(jsonString);
        String unformattedXml =  "<"+root+">" + XML.toString(jsonObject) + "</"+root+">";
        return format(unformattedXml);
    }
}
