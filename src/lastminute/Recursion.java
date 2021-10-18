package lastminute;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        String in = "abc";
        List<String> res = new ArrayList<>();
        permute(in.toCharArray(), 0, res);
        System.out.println(res);
    }

    private static void permute(char[] ch, int index, List<String> res) {
        if (index == ch.length - 1) {
            res.add(String.valueOf(ch));
        }
        for (int i = index; i < ch.length; i++) {
            swap(ch, index, i);
            permute(ch, index + 1, res);
            swap(ch, index, i);
        }
    }

    private static void swap(char[] ch, int index, int i) {
        char temp = ch[index];
        ch[index] = ch[i];
        ch[i] = temp;
    }
}
