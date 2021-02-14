package common.interview.better;

import java.util.Arrays;
import java.util.List;

public class WeekDays {
    public static void main(String[] args) {
        System.out.println(new WeekDays().solution("Wed", 2));
    }

    public String solution(String S, int K) {
        // write your code in Java SE 8
        List<String> wDays = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        return wDays.get((wDays.indexOf(S) + K) % 7);
    }
}
