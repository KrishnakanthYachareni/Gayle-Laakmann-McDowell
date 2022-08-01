package algoexpert.famous;


import java.util.ArrayList;
import java.util.List;

/*
 * A group of students is sitting in a circle. The teacher is electing a new class president.
 * The teacher does this by singing a song while walking around the circle. After the song is
 * finished the student at which the teacher stopped is removed from the circle.
 * <p>
 * Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
 * After the teacher is done singing, the next student is removed. The teacher repeats this until only one student is left.
 * <p>
 * A song of length k will result in the teacher walking past k students on each round. The students are numbered 1 to n. The teacher starts at student 1.
 * <p>
 * For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4). The first
 * student to go would be `2`, after that `4`, and after that `3`. Student `1` would be the next president in this example.
 *
 *
 * Link: https://www.interviewbit.com/blog/josephus-problem/
 */
public class JosephusProblem {

    public static void main(String[] args) {
        int ans = josephus(6, 2);
        System.out.println(ans);
    }

    /*
        Given N persons, and skipping K persons during their deletion, N – 1 persons will be left.
        Therefore, we need to call the recursive function for N – 1 and K for the next iteration.

        Now, for each remaining circle after execution, we need to find the last remaining person present i.e.
        if Kth person is executed, K+1 th will be the next starting safe point the recursive call

        josephus(N, K) = (josephus(N – 1 , K) + K – 1) % N + 1

        Here: 1. K - 1 is to add the first non-dead elements to end of the list
         2. +1 is at the end is kth element will be killed
         3. % N is to make list circular
     */
    static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        else
            return (josephus(n - 1, k) + k - 1) % n + 1;
    }

    /**
     * using an additional array list
     */
    public static void approach2(int n, int k) {
        List<Integer> persons = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            persons.add(i);

        recursion(persons, k - 1, 0);
    }

    static void recursion(List<Integer> persons, int k, int index) {
        if (persons.size() == 1) {
            System.out.println(persons.get(0));
            return;
        }
        index = ((index + k) % persons.size());
        persons.remove(index);
        recursion(persons, k, index);
    }
}
