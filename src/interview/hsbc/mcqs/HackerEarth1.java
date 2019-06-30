/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview.hsbc.mcqs;

import java.io.IOException;
// 72 Ascii of H
public class HackerEarth1 {
    public static void main(String args[])
    {
        int hck;
        try {
            hck = System.in.read();
            System.out.println(hck);
        }
        catch (IOException hack){
            System.out.println("Input not read");
        }
    }
}
