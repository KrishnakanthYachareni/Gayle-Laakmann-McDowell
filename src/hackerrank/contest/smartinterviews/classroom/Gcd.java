package hackerrank.contest.smartinterviews.classroom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * GCD of a two number using Euclidean Algorithm.
 * <p>
 * TC = O(log(min(a, b)), SC = O(1)
 * <p>
 * Brute Force: TC = O(min(a, b)), SC = O(1)
 * <p>
 * Problem: https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd/problem
 */
public class Gcd {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ar = reader.readLine().trim().split(" ");
        int a = Integer.parseInt(ar[0]);
        int b = Integer.parseInt(ar[1]);
        int ans = gcd(a, b);
        writer.write(ans);
        writer.flush();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
