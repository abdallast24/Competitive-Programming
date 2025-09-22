import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import java.text.*;

public class Main {
	static String str;
	static boolean vis[][];
	static int memo[][];

	static int solve(int left, int right) {
		if (left > right)
			return 0;
		if (vis[left][right])
			return memo[left][right];
		vis[left][right] = true;
		int min = 0;
		if (str.charAt(left) == str.charAt(right))
			min = solve(left + 1, right - 1);
		else {
			int min1, min2, min3;
			min1 = min2 = min3 = Integer.MAX_VALUE;
			min1 = 1 + solve(left + 1, right - 1);// change
			min2 = 1 + solve(left, right - 1);// delete
			min3 = 1 + solve(left + 1, right);// add

			return memo[left][right] = Math.min(Math.min(min1, min2), min3);
		}

		return memo[left][right] = min;

	}

	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			vis = new boolean[1001][1001];
			memo = new int[1001][1001];
			str = in.next();
			int res = solve(0, str.length() - 1);
			out.println("Case " + (i + 1) + ": " + res);

		}

		out.close();

	}

}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));

	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return st.nextToken();

	}

	int nextInt() {

		return Integer.parseInt(next());
	}

	double nextDouble() {

		return Double.parseDouble(next());
	}

	long nextLong() {

		return Long.parseLong(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return str;

	}
}
