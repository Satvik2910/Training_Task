/*
 * Copyright (c) 2022 @Satvik (satvikm@azuga.com)
 */

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.Arrays;

/**
 * @author azuga
 * The following class is a mimic of Pipe command and its implementations.
 */

public class Main{
    /*
     *The major functionality of  command is to list the elements of directory currently in use
     * @param path-The absolute path of directory.
     * @throws IOException - The IOException is handled in the following method.
     */
    public static String cat(String path) throws IOException
    {
        /*
         *The cat utility reads files sequentially, writing them to the standard output.
         *The above method implements the functionality of cat command.
         * It is a return type method
         */

        Path fileName= Path.of(System.getProperty("user.dir")+"/"+path);
        String str = Files.readString(fileName);
        return str;

    }
    // Return type String for the "cat" method.

    public static void wc(String string) {
        // Declaring the required Variables that are going to be utilised in the code.
        /*
         * The above method implements the functionality of wc command.
         * This method is used to count the sentence,words and character present in the text file.
         */

        String[] line = string.split("\n");

        int wordCount = 0;
        int characterCount = 0;
        int sentenceCount = 0;

        while(wordCount<line.length){
            for(String str:line[wordCount].split(" ")){
                characterCount++;
            }
            wordCount++;
        }
        for(char str:string.toCharArray()){
            sentenceCount++;
        }

        System.out.print("\t"+(wordCount+1)+"\t"+characterCount+"\t"+sentenceCount);

    }

    public static void ls(String string) {
        /*
         * This method prints the elements/files of list.
         * This method takes File path as input access the file and print the tab separated list as an output.
         */

        String[] childs = string.split("/n");
        for(String child: childs){
            System.out.println(child);
        }
    }


    public static void sort(String string){
        /*
         * The above method implements the functionality of sort command.
         *The sort utility sorts text and binary files by lines.
         */

        String[] array = string.split("\n");
        Arrays.sort(array);
        for(String child:array){
            System.out.println(child);
        }
    }


    public static String grep(String string, String str) {
        /*
          * The above method implements the functionality of grep command.
          *The grep utility searches any given input files, selecting lines that match
           one or more patterns.
          *It is a return type method which return String as an output and is implemented at switch-case.
         */

        String[] line = string.split("\n");
        String ele=" ";
        for (String element : line) {
            if (element.contains(str)){
                ele += (element+"\n");
            }
        }
        return ele;

    }

    public static String head(String string, int i){
        /*
         * The above method implements the functionality of head command.
         *This filter displays the first count lines or bytes of each of the specified files, or of the standard input if no files are specified.
         */

        ArrayList<String> line = new ArrayList<>(Arrays.asList(string.split("\n")));
        String hd="";
        for(int j =0;j<(i);j++){
            hd+=line.get(j)+"\n";
        }
        return hd;
    }

    public static String tail(String string, int i){
        /*
         * The above method implements the functionality of head command.
         *This command is used to display the last part of a file
        */

        ArrayList<String> line = new ArrayList<>(Arrays.asList(string.split("\n")));
        String tl="";
        for(int j =line.size()-i;j<=line.size();j++){
            tl+=line.get(j)+"\n";
        }
        return tl;
    }


    public static void main(String[] args) throws IOException {.
        /*
         * The main driver method is used to implement the main class
         * args- Stands for the arguments it is also used to run code via command line argument.
         */

        String str = args[0];
        String[] s = str.split(" ");
        if (s[0].equals("cat") && s.length <= 2) {


            System.out.println(cat(s[1]));
        }else if (s.length >= 3) {


            switch (s[3]) {
                // Implementing the switch case for the Main class.

                case "wc":
                    // Calling the wc method inside main() method as a switch case condition.

                    wc(cat(s[1]));
                    break;
                case "sort":
                    // Calling the sort method inside main() method as a switch case condition.

                    sort(cat(s[1]));
                    break;
                case "grep":
                    // Calling the grep method inside main() method as a switch case condition.

                    if(s.length>=4)
                        System.out.println(grep(cat(s[1]), s[4]));
                    else
                        System.out.println("keyword cannot be empty");
                    break;
                case "ls":
                    // Calling the ls method inside main() method as a switch case condition.

                    ls(cat(s[1]));
                    break;
                case "head":
                    // Calling the head method inside main() method as a switch case condition.

                    String value1 = s[4];
                    int a = Character.getNumericValue(value1.charAt(1));
                    System.out.println(head(cat(s[1]),a));
                    break;
                case "tail":
                    // Calling the tail method inside main() method as a switch case condition.

                    String value2 = s[4];
                    int b = Character.getNumericValue(value2.charAt(1));
                    System.out.println(tail(cat(s[1]),b));
                    break;

                default:
                    System.out.println("command doesn't match");
            }

        }
    }
}