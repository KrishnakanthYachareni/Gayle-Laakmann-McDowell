/*
 * Copyright (c) 2020 Krishnakanth Yachareni. All rights reserved.
 */
package hackerrank.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @link https://www.hackerrank.com/challenges/crossword-puzzle/problem
 *       <p>
 *       Input: +-++++++++ +-++++++++ +-++++++++ +-----++++ +-+++-++++
 *       +-+++-++++ +++++-++++ ++------++ +++++-++++ +++++-++++
 *       LONDON;DELHI;ICELAND;ANKARA
 */
public final class CrossWordPuzzle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Character[][] initialMap = new Character[10][10];
		for (int i = 0; i < initialMap.length; i++) {
			String line = in.nextLine();
			for (int j = 0; j < initialMap[0].length; j++) {
				initialMap[i][j] = line.charAt(j);
			}
		}
		String[] mapDict = in.nextLine().split(";");
		Character[][] mapResult = crossword(initialMap, 0, mapDict);
		printMap(mapResult);
	}

	public static Character[][] crossword(Character[][] map, int wordIdx, String[] wordDict) {
		if (wordIdx == wordDict.length) {
			return map;
		} else {
			List<Character[][]> maps = findPossibleMaps(map, wordDict[wordIdx]);
			if (maps.isEmpty()) {
				return null;
			} else {
				for (Character[][] characters : maps) {
					Character[][] mapReturned = crossword(characters, wordIdx + 1, wordDict);
					if (mapReturned != null) {
						return mapReturned;
					}
				}
				return null;
			}
		}
	}

	private static Boolean isValid(int row, int col, Character[][] map, int idx, String str) {
		if (row >= map.length || col >= map.length || row < 0 || col < 0 || map[row][col] == '+') {
			return false;
		} else {
			return map[row][col] == '-' || map[row][col] == str.charAt(idx);
		}
	}

	private static Boolean findPlacement(int y, int x, Character[][] map, int idx, String str, int direction) {
		if (idx == str.length()) {
			return true;
		} else if (isValid(y, x, map, idx, str)) {
			map[y][x] = str.charAt(idx);
			Boolean result = false;
			if (direction == 0) {
				result = findPlacement(y + 1, x, map, idx + 1, str, direction);
			} else if (direction == 1) {
				result = findPlacement(y, x + 1, map, idx + 1, str, direction);
			}
			return result;
		} else {
			return false;
		}
	}

	private static Character[][] deepCopyMatrix(Character[][] input) {
		if (input == null) {
			return null;
		}
		Character[][] result = new Character[input.length][];
		for (int r = 0; r < input.length; r++) {
			result[r] = input[r].clone();
		}
		return result;
	}

	private static List<Character[][]> findPossibleMaps(Character[][] map, String word) {
		List<Character[][]> results = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '-' || map[i][j] == word.charAt(0)) {
					Character[][] newMapHoriz = deepCopyMatrix(map);
					Character[][] newMapVert = deepCopyMatrix(map);
					Boolean foundHoriz = findPlacement(i, j, newMapHoriz, 0, word, 1);
					Boolean foundVert = findPlacement(i, j, newMapVert, 0, word, 0);
					if (foundHoriz) {
						results.add(newMapHoriz);
					}
					if (foundVert) {
						results.add(newMapVert);
					}
				}
			}
		}

		return results;
	}

	private static void printMap(Character[][] map) {
		if (map == null) {
			return;
		}
		for (Character[] characters : map) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(characters[j]);
			}
			System.out.println("");
		}
	}
}