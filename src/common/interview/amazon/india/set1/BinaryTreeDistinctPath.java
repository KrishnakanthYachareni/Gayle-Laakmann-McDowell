package common.interview.amazon.india.set1;

import java.util.*;

public class BinaryTreeDistinctPath {

	public static void main(String[] args) {
		// TODO Give input

	}

	static int solution(Tree T, Map<Integer, Integer> distinctNodes) {
		if (T == null) {
			return distinctNodes.size();
		}
		if (distinctNodes.containsKey(T.x)) {
			return distinctNodes.size();
		} else {
			distinctNodes.put(T.x, 1);
		}
		int distinctLongPath = Math.max(solution(T.l, distinctNodes), solution(T.r, distinctNodes));
		if (distinctNodes.containsKey(T.x)) {
			distinctNodes.put(T.x, distinctNodes.get(T.x) - 1);
		}
		if (distinctNodes.get(T.x) == 0) {
			distinctNodes.remove(T.x);
		}
		return distinctLongPath;
	}

	static int solution(Tree T) {
		Map<Integer, Integer> distinctNodes = new HashMap<>();
		return solution(T, distinctNodes);
	}

	static class Tree {
		int x;
		Tree l, r;
	}

}
