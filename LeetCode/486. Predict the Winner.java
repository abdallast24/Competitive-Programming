class Solution {
	int nums[];
	Integer[][] memo = new Integer[20][20];

	public boolean PredictTheWinner(int[] nums) {
		this.nums = nums;
		return recur(0, nums.length - 1, true) >= 0 ? true : false;
	}

	private int recur(int i, int j, boolean p) {
		if (i == j)
			return p ? nums[i] : -nums[i];

		if (memo[i][j] != null)
			return memo[i][j];

		return memo[i][j] = p ? Math.max(nums[i] + recur(i + 1, j, !p), nums[j] + recur(i, j - 1, !p))
				: Math.min(-nums[i] + recur(i + 1, j, !p), -nums[j] + recur(i, j - 1, !p));

	}

}
