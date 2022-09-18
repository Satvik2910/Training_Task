/*
 * Copyright (c) 2022 azuga
 */

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;
import java.text.*;

/*
 * @author @Satvik (satvikm@azuga.com)
 * The following class is a mimic of ls command and its options.
 */
public class Main {

    /*
     * The major functionality of Ls command is to list the elements of directory currently in use.
     * @param path-The absolute path of directory.
     */
    public static void ls_a(String path) {

        /*
         * This method prints the elements of list along with the hidden file.
         * This method takes File path as input access the file and print the tab separated list as an output.
         */

        File dir = new File(path);
        File [] childs= dir.listFiles();
        if (childs != null) {
            for(File child: childs){
                if (dir.isHidden()){
                    System.out.printf(child.getName() + "\t");
                    System.out.printf(child + "\t");
                }
            }
        }

    }

    public static void ls(String path) {

        /*
         * This method prints the elements/files of list.
         * This method takes File path as input access the file and print the tab separated list as an output.
         */

        File dir = new File(path);
        String[] childs = dir.list();
        if (childs != null) {
            for(String child: childs){
                System.out.printf(child + "\t");
            }
        }
    }


    public static void ls_l(String path) throws IOException{

        /*
         * This method takes File path as input access the file and print the line separated list as an output.
         * This method prints the elements of list in detailed format.
         * It throws a IOException to handel the exception.
         */

        File dir = new File(path);

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for (File f : Objects.requireNonNull(dir.listFiles())){
            if(!f.isHidden()){Path p = Path.of(f.getPath());
                PosixFileAttributes f1 = Files.readAttributes(p, PosixFileAttributes.class);

                System.out.println(PosixFilePermissions.toString(f1.permissions())+ "\t");
                System.out.print((f.isFile() ? 1: Objects.requireNonNull(f.list()).length) + " \t");
                System.out.print(f1.owner().getName() + " \t");
                System.out.print(f1.group().getName() + " \t");
                System.out.print(f1.size() + " \t");
                System.out.print(date.format(f.lastModified())+"\t");
                System.out.println(f.getName());
                System.out.println();
            }
        }
    }

    private static void ls_T(String path){
        /*
         * This method takes File path as input access the file and print the line separated list as an output.
         * This method prints the elements of list option flag sorts files/directories list by time/date.
         */
        
        File f = new File(path);
        Map<Long, String> mp = new TreeMap<>(Collections.reverseOrder());
        for (File obj : Objects.requireNonNull(f.listFiles())) {
            mp.put(obj.lastModified(), obj.getName());
        }
        SimpleDateFormat pdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        mp.forEach((key, value) -> System.out.println(pdf.format(key) + " " + value));
    }


    public static void main(String[] args) throws IOException {
        /*
         * The main driver method is used to implement the main class
         * args- Stands for the arguments it is also used to run code via command line argument.
         */

        switch (args[0]) {
            case "ls":
                // Calling the ls method inside main() method

                ls(args[1]);
                break;
            case "-T":
                // Calling the ls_T method inside main() method

                ls_T(args[1]);
                break;
            case "-a":
                // Calling the ls_a method inside main() method

                ls_a(args[1]);
                break;
            case "-l":
                // Calling the ls_l method inside main() method

                ls_l(args[1]);
                break;

            // Setting the default value of switch case.
            default:
                System.out.println("command doesn't match");
        }

    }



}
