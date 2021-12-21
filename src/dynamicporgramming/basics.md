1. Top-Down Approach: Recursive solution (memoization):
   Top-Down breaks the large problem into multiple sub-problems. If the sub-problem solved already just reuse the
   answer. Otherwise, Solve the sub-problem and store the result. Top-Down uses memoization to avoid recomputing the
   same sub-problem again.

2. Bottom-Up Approach: (Tabulation)
   Start computing result for the sub-problem. Using the sub-problem result solve another sub-problem and finally solve
   the whole problem.

3. Overlapping sub problems: DAG(Directed Acyclic Graph) if more than two parents are pointing to the same child in the
   recurrence tree then the problem has the overlapping sub problems.