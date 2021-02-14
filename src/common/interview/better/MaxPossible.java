package common.interview.better;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxPossible {
    public static void main(String[] args) {
        System.out.println(new MaxPossible().solution(-999));
    }

    public int solution(int N) {
        // write your code in Java SE 8
        int ind = N >= 0 ? 1 : -1;
        N = Math.abs(N);
        String numStr = N + "";
        String[] splitN = numStr.split("");
        ArrayList<String> output = new ArrayList<>();
        boolean inserted = false;
        for (String tmpStr : splitN) {
            int tmp = Integer.parseInt(tmpStr);
            inserted = ind == 1 ? tmp < 5 : tmp > 5;
            if (inserted) {
                output.add(50 + tmp + "");
                break;
            }
            output.add(tmpStr);
        }
        output.addAll(Arrays.asList(splitN).subList(output.size(), splitN.length));
        if (!inserted) output.add("5");
        return ind * Integer.parseInt(String.join("", output));
    }

}
