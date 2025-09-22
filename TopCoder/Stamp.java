import java.util.Arrays;

public class Stamp {
	int L, n;
	String colors = "RGB", desiredColor;
	int[][][] dp;

	public int getMinimumCost(String desiredColor, int stampCost, int pushCost) {
		int res = (int) (1e9 + 15);
		n = desiredColor.length();
		this.desiredColor = desiredColor;
		dp = new int[n + 1][n + 1][3];
		for (int i = 0; i < dp.length; i++)
			for (int j = 0; j < dp[i].length; j++)
				Arrays.fill(dp[i][j], -1);
		for (int L = 1; L <= n; L++) {
			this.L = L;
			for (int c = 0; c < 3; c++)

				res = Math.min(res, L * stampCost + (solve(0, c) * pushCost));

		}
		return res;
	}

	public int solve(int startIdx, int color) {
		if (startIdx + L > n)
			return 100;
		if (dp[startIdx][L][color] != -1)
			return dp[startIdx][L][color];
		boolean can = can(desiredColor.substring(startIdx, startIdx + L), color);
		if (can && startIdx + L == n)
			return 1;
		int res = 100;

		if (can) {
			for (int i = 1; i < L; i++)
				res = Math.min(res, 1 + solve(startIdx + i, color));

			for (int c = 0; c < 3; c++)
				res = Math.min(res, 1 + solve(startIdx + L, c));
		}
		return dp[startIdx][L][color] = res;

	}

	public boolean can(String substring, int color) {
		for (char s : substring.toCharArray())
			if (s != '*' && colors.charAt(color) != s)
				return false;
		return true;

	}
}
