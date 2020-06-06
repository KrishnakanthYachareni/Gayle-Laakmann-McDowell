/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package common.interview.hsbc.mcqs;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
H A C K [H, A, C, K]
 */
public class HackerEarth3 {
    static CopyOnWriteArrayList hck = new CopyOnWriteArrayList();

    public void testhack() {
        hck.add("K");
    }

    public static void main(String[] args)
            throws InterruptedException {
        hck.add("H");
        hck.add("A");
        hck.add("C");
        HackerEarth3 t = new HackerEarth3();
        t.testhack();

        Thread.sleep(1000);
        Iterator test1 = hck.iterator();
        while (test1.hasNext()) {
            String s = (String) test1.next();
            System.out.println(s);
            Thread.sleep(1000);
        }
        System.out.println(hck);
    }
}
