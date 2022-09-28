package algoexpert.arrays;

import java.util.Arrays;

/*
    Time Complexity: O(n*log(log(n)))
    Space Complexity: O(n)
 */
public class SieveEratosthenes {
    public static void main(String[] args) {
        boolean[] primes = primes(1000);

        int lineCount = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                lineCount++;
                System.out.print(i + " ");
            }

            if (lineCount == 15) {
                System.out.println();
                lineCount = 0;
            }
        }
    }

    private static boolean[] primes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}
