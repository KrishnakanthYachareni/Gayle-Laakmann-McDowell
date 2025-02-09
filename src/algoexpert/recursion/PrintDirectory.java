package algoexpert.recursion;

import java.io.File;

/*
        Print all nested directories and files in a given directory using Recursion
 */
public class PrintDirectory {

    public static void main(String[] args) {
        String path = "/Users/krishna/Documents/Projects/Gayle-Laakmann-McDowell/src";
        printFiles(path);
    }

    public static void printFiles(String filePath) {
        File file = new File(filePath);
        printUtil(file, "");
    }

    public static void printUtil(File file, String tabs) {
        if (file.isDirectory()) {
            System.out.println(tabs + "[" + file.getName() + "]");

            File[] subFiles = file.listFiles();
            for (File subFile : subFiles) {
                printUtil(subFile, tabs + "\t");
            }
        } else {
            System.out.println(tabs + "[" + file.getName() + "]");
        }
    }
}

