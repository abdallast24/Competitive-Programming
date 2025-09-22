import java.util.Arrays;

public class Main {
	long memo[][] = new long[33][13];

	public long countPasswords(int N) {
		for (int i = 0; i < memo.length; i++)
			Arrays.fill(memo[i], -1);
		long res = 0;
		for (int i = 1; i <= 10; i++)
			res += solve(N - 1, i);

		return res;

	}

	public long solve(int n, int c) {

		if (n == 0)
			return memo[n][c] = 1;
		
		if (memo[n][c] != -1)
			return memo[n][c];

		long res = 0;

		if ((c - 1) % 3 != 0)// left
			res += solve(n - 1, c - 1);

		if (c % 3 != 0 && c != 10) // right
			res += solve(n - 1, c + 1);

		if (c - 3 > 0) // up
			res += solve(n - 1, c - 3);

		if (c + 3 < 11) // down
			res += solve(n - 1, c + 3);

		return memo[n][c] = res;

	}
}
