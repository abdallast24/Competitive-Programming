import java.util.Arrays;

public class MaximalProduct {
	static long memo[][] = new long[21][101];
	static int maxK;

	public static long solve(int i, int rem) {

		if (i == maxK && rem != 0 || i < maxK && rem == 0)
			return memo[i][rem] = 0;
		if (i == maxK && rem == 0)
			return memo[i][rem] = 1;

		if (memo[i][rem] != -1)
			return memo[i][rem];

		long ret = 0;
		for (int j = 1; j <= rem; j++)
			ret = memo[i][rem] = Math.max(ret, j * solve(i + 1, rem - j));

		return ret;

	}

	public static long maximalProduct(int s, int k) {

		maxK = k;

		for (int i = 0; i < memo.length; i++)
			Arrays.fill(memo[i], -1);

		return solve(0, s);

	}
}
