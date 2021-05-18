package hackerrank.contest.smartinterviews.classroom;

/**
 * Program to swap ODD and EVEN bits of a number (Swap adjacent bits)
 * <p>
 * Page No (18).
 */
public class SwapAdjacentBits {
    public static void main(String[] args) {
        int ans = swapBits(5);
        System.out.println(ans);
    }

    private static int swapBits(int a) {
        int oddBits = a & 0xAAAAAAAA; //Hexa decimal value 1010
        int evenBits = a & 0x55555555; //Hexa decimal value 0101
        return (oddBits >> 1) | (evenBits << 1);
    }
}
