import java.util.Arrays;

class Solution {
	private int k, target, memo[][];

	public int numRollsToTarget(int n, int k, int target) {
		memo = new int[n + 1][target + 1];
		this.k = k;
		this.target = target;

		for (int i = 0; i < memo.length; i++)
			Arrays.fill(memo[i], -1);

		return doMemo(n, 0);

	}

	private int doMemo(int n, int sum) {
		if (n == 0 && sum == target)
			return 1;

		if (n == 0 || sum > target)
			return 0;

		if (memo[n][sum] != -1)
			return memo[n][sum];

		memo[n][sum] = 0;

		for (int i = 1; i <= k; i++)
			memo[n][sum] = (memo[n][sum] + (doMemo(n - 1, sum + i) % 1000000007)) % 1000000007;

		return memo[n][sum];
	}
}
