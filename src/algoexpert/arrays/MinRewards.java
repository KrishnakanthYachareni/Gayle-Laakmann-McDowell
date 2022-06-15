package algoexpert.arrays;

import java.util.Arrays;

public class MinRewards {

    public static void main(String[] args) {
        int[] scores = new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5};
        int reward = minRewards(scores);
        System.out.println(reward);
    }

    public static int minRewards(int[] scores) {
        if (scores == null || scores.length == 0)
            return -1;

        int scoresLength = scores.length;
        if (scoresLength == 1)
            return 1;

        int[] rewards = new int[scoresLength];
        Arrays.fill(rewards, 1);

        // Left to Right find the students scores which are greater than previous.
        for (int i = 1; i < scoresLength; i++) {
            if (scores[i] > scores[i - 1])
                rewards[i] = rewards[i - 1] + 1;
        }

        // Right to Left find the students scores which are less than previous.
        for (int i = scoresLength - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1])
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
        }

        // Sum up the rewards
        return Arrays.stream(rewards).sum();
    }
}
