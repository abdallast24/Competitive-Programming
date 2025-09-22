import java.util.ArrayList;

class Solution {
	public int minDominoRotations(int[] tops, int[] bottoms) {
		ArrayList<Integer>[] up = new ArrayList[7], down = new ArrayList[7];
		int i, j, minAns = Integer.MAX_VALUE, funcOne, funcTwo;

		for (i = 0; i < 7; i++) {
			up[i] = new ArrayList<Integer>();
			down[i] = new ArrayList<Integer>();
		}

		for (i = 0; i < tops.length; i++) {
			up[tops[i]].add(i);
			down[bottoms[i]].add(i);
		}

		for (i = 1; i < 7; i++) {

			if (up[i].size() >= down[i].size()) {
				funcOne = dofunc(down[i], tops, i);
				if (funcOne + up[i].size() == tops.length)
					minAns = Math.min(funcOne, minAns);
			} else {
				funcTwo = dofunc(up[i], bottoms, i);
				if (funcTwo + down[i].size() == tops.length)
					minAns = Math.min(funcTwo, minAns);
			}

		}

		return minAns == Integer.MAX_VALUE ? -1 : minAns;

	}

	private int dofunc(ArrayList<Integer> list, int[] arr, int num) {
		int cnt = 0;

		for (int i : list)
			if (arr[i] != num)
				cnt++;
		return cnt;
	}
}
