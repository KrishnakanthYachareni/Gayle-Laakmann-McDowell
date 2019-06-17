/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap does not allow duplicate keys. HashMap when comparing keys (and values) performs object-equality not reference-equality.
 * In an HashMap, two keys k1 and k2 are equal if and only if (k1==null ? k2==null : k1.equals(k2))
 */
public class HasMap1 {
    public static void main(String args[]) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(new String("a"), "audi");
        hashMap.put(new String("a"), "ferrari");
        System.out.println(hashMap); // {a=ferrari}
    }
}
