/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package common.interview.cognizent;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class MultipleRequestAtTime {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String filname = "E:\\GitHub\\Gayle-Laakmann-McDowell\\src\\interview\\cognizent\\hosts_access_log_00.txt";
        HashMap<String, Integer> timeStampMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filname));
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\GitHub\\Gayle-Laakmann-McDowell\\src\\interview\\cognizent\\req_hosts_access_log_00.txt"));
        String currentLine = reader.readLine();
        while (currentLine != null) {
            String[] words = currentLine.toLowerCase().split(" ");
            String timeStamp = words[3].substring(1);
            if (timeStampMap.containsKey(timeStamp)) {
                timeStampMap.put(timeStamp, timeStampMap.get(timeStamp) + 1);
                if (2 == timeStampMap.get(timeStamp)) {
                    writer.write(timeStamp.substring(0, 3) + timeStamp.substring(3, 4).toUpperCase() + timeStamp.substring(4) + "\n");
                }
            } else {
                timeStampMap.put(timeStamp, 1);
            }
            currentLine = reader.readLine();
        }
        reader.close();
        writer.close();
    }

    /**
     *  String filename;
     *         filename = scan.nextLine();
     *         HashMap<String, Integer> timeStampMap = new HashMap<>();
     *         BufferedReader reader = new BufferedReader(new FileReader(filename));
     *         BufferedWriter writer = new BufferedWriter(new FileWriter("req_"+filename));
     *         String currentLine = reader.readLine();
     *         while (currentLine != null) {
     *             String[] words = currentLine.toLowerCase().split(" ");
     *             String timeStamp = words[3].substring(1);
     *             if (timeStampMap.containsKey(timeStamp)) {
     *                 timeStampMap.put(timeStamp, timeStampMap.get(timeStamp) + 1);
     *                 if (2 == timeStampMap.get(timeStamp)) {
     *                     writer.write(timeStamp.substring(0, 3) + timeStamp.substring(3, 4).toUpperCase() + timeStamp.substring(4) + "\n");
     *                 }
     *             } else {
     *                 timeStampMap.put(timeStamp, 1);
     *             }
     *             currentLine = reader.readLine();
     *         }
     *         reader.close();
     *         writer.close();
     */
}
