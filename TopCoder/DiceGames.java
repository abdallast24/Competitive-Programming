import java.util.Arrays;

public class DiceGames {
	int arr[];
	long memo[][] = new long[35][35];
	boolean vis[][] = new boolean[35][35];

	public long solve(int i, int start) {
		if (i == arr.length)
			return 1;

		if (start > arr[i])
			return 0;

		if (vis[i][start])
			return memo[i][start];

		vis[i][start] = true;

		long res = 0;

		for (int j = start; j <= arr[i]; j++)
			res += solve(i + 1, j);

		return memo[i][start] = res;

	}

	public long countFormations(int[] sides) {
		arr = sides;
		Arrays.sort(arr);
		return solve(0, 1);

	}

}
