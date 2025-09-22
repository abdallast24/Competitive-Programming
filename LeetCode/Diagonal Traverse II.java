import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public static int[] findDiagonalOrder(List<List<Integer>> nums) {
		int sz = 0, max = -1, idx = 0;
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
		LinkedList<Integer> list;
		for (int i = 0; i < nums.size(); i++) {
			sz += nums.get(i).size();
			max = Math.max(max, i + nums.get(i).size() - 1);
			for (int j = 0; j < nums.get(i).size(); j++) {
				if (map.get(i + j) == null)
					map.put(i + j, new LinkedList<>());
				list = map.get(i + j);
				list.add(0, nums.get(i).get(j));
				map.put(i + j, list);
			}
		}
		int res[] = new int[sz];
		for (int i = 0; i <= max; i++)
			for (Integer val : map.get(i))
				res[idx++] = val;
		return res;
	}
}
