/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package collection;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * IdentityHashMap when comparing keys (and values) performs reference-equality in place of object-equality. In an IdentityHashMap,
 * two keys k1 and k2 are equal if and only if (k1==k2). (In normal Map implementations (like HashMap) two keys k1 and k2 are considered equal if and only if (k1==null ? k2==null : k1.equals(k2)).)
 */

public class IdentityHashMap1 {
    public static void main(String[] args) {
        Map<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(new String("a"), "audi");
        identityHashMap.put(new String("a"), "ferrari");
        System.out.println(identityHashMap);
    }
}
