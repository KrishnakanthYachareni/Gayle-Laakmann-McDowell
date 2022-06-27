package algoexpert.others;

/*
    https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    /*
       We need to look at the max value of int which is 2147483647 (2^31 - 1). We can   then see that when we are adding the 10th digit and the first 9 exceed 214748364, then no matter what the 10th digit will be, the number will be larger than the max int value. But if the first 9 digits are no more than 214748364, then the 10th digit can be in the range [0, 7].
       Tc  = O(log(x)). There are roughly log (x) base 10 digits in x
       Sc = O(1)
    */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // Avoiding the overflow
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10)
                return 0;

            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}
