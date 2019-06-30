/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview.hsbc.mcqs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User {
    private String name;
    private String pass;
}

class Author implements Comparable{
    private String name;
    private String pass;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

public class Question1 {
    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();
        Collections.sort(authors, (a1, a2) -> a1.compareTo(a2));
    }
}
