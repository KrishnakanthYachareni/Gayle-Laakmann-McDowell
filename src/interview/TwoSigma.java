package interview;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TwoSigma {


    private static final char YES = 'Y';

    public static int friendCircles(List<String> friends) {
        char[][] matrix = deriveMatrixFromString(friends.toArray(new String[0]));
        int n = matrix.length;
        if (n == 1)
            return 1;
        boolean[] occupied = new boolean[n];
        for (int i = 0; i < n; i++)
            occupied[i] = false;
        int circles = 0;
        for (int i = 0; i < n; i++) {
            if (occupied[i])
                continue;
            occupied[i] = true;
            updateFriendsPlace(matrix, occupied, i);
            circles++;
        }
        return circles;

    }

    private static void updateFriendsPlace(char[][] friends, boolean[] occupied, int pos) {
        for (int j = 0; j < friends.length; j++) {
            if (occupied[j])
                continue;
            if (pos == j)
                continue;
            if (friends[pos][j] == YES) {
                occupied[j] = true;
                updateFriendsPlace(friends, occupied, j);
            }
        }
    }

    private static char[][] deriveMatrixFromString(String[] a) {
        int n = a.length;
        char[][] r = new char[n][n];
        for (int i = 0; i < n; i++) {
            r[i] = a[i].toCharArray();
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int friendsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> friends = new ArrayList<>();

        IntStream.range(0, friendsCount).forEach(i -> {
            try {
                friends.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = friendCircles(friends);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
