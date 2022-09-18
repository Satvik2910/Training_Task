/*
 * Copyright (c) 2022 azuga
 * @author @Satvik (satvikm@azuga.com)
 */

import java.io.*;
/*
 * The following class is a mimic of wc command and its options.
 */

public class Main {
    /*
     *The wc utility displays the number of lines, words, and bytes contained in each input file.
     * @param path-The absolute path of directory.
     */
    public static void main(String[] args)
            throws IOException
    {

        /*
         * The main driver method is used to implement the main class
         * args- Stands for the arguments it is also used to run code via command line argument.
         * This method prints the count of words characters and byte size along with the file implemented on.
         */

        File file = new File(args[1]);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);



        String line;
        int wordCount = 0;
        int characterCount = 0;
        int sentenceCount = 0;

        while ((line = bufferedReader.readLine()) != null)
        // Checking the Case if the value of Buffered-reader is not null.
        {
            characterCount += line.length()+1;
            String[] words = line.split("\\s+");
            wordCount += words.length;
            String[] sentence = line.split("[!?.:]+");
            sentenceCount += sentence.length;

        }

        switch (args[0]){

            case "wc":
                // This case is implemented to get all the counts and file name.

                System.out.println("\t" + sentenceCount + "\t" + wordCount + "\t" + characterCount + " " +
                        file.getName());
                break;

            case "-c":
                // The number of bytes in each input file is written to the standard output.

                System.out.println(file.length()+"    " + args[1]);
                break;

            case "-l":
                // The number of lines in each input file is written to the standard output.

                System.out.println(sentenceCount+"    " + args[1]);
                break;

            case "-w":
                // The number of words in each input file is written to the standard output.

                System.out.println(wordCount+"    " + args[1]);
                break;

            // Setting the default value of switch case.
            default:
                System.out.println("command doesn't match");


        }
    }
}
