package algoexpert.arrays;

import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {

    /*
     * Take each two pairs of given points and check if they form two diagonal points exist
     *  in the given array, if yes they can form a rectangle.
     *
     * TC = O(N), SC = O(N)
     */
    public static int minimumAreaRectangle(int[][] points) {
        int numberOfPoints = points.length;
        int minimumAreaOfRectangle = Integer.MAX_VALUE;

        Set<String> pointSet = createPointSet(points);

        for (int i = 0; i < numberOfPoints - 1; i++) {
            int p1x = points[i][0];
            int p1y = points[i][1];

            for (int j = i + 1; j < numberOfPoints; j++) {
                int p2x = points[j][0];
                int p2y = points[j][1];

                if (p1x == p2x || p1y == p2y) // Point on the same line can't make diagonal
                    continue;

                boolean isPoint1OnOppositeDiagonalExists = pointSet.contains(convertPointToString(p1x, p2y));
                boolean isPoint2OnOppositeDiagonalExists = pointSet.contains(convertPointToString(p2x, p1y));

                boolean isOppositeDiagonalEdgeExists = isPoint1OnOppositeDiagonalExists && isPoint2OnOppositeDiagonalExists;

                if (isOppositeDiagonalEdgeExists) {
                    int currentArea = Math.abs(p1x - p2x) * Math.abs(p1y - p2y);
                    minimumAreaOfRectangle = Math.min(currentArea, minimumAreaOfRectangle);
                }
            }
        }
        return minimumAreaOfRectangle != Integer.MAX_VALUE ? 0 : minimumAreaOfRectangle;
    }

    private static Set<String> createPointSet(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            String pointAsString = convertPointToString(x, y);

            pointSet.add(pointAsString);
        }
        return pointSet;
    }

    private static String convertPointToString(int x, int y) {
        return x + ":" + y;
    }
}
