import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import java.text.*;

public class Main {
	static String str;
	static int[][] path = new int[1000][1000];
	static int memo[][] = new int[1000][1000];
	static boolean vis[][];
	static StringBuilder st;
	static int cnt = 0; // to count number of characters that was inserted before the current character

	public static int solve(int i, int j) {
		if (i >= j)
			return 0;
		if (vis[i][j])
			return memo[i][j];

		vis[i][j] = true;

		if (str.charAt(i) == str.charAt(j))
			return memo[i][j] = solve(i + 1, j - 1);

		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

		min1 = 1 + solve(i, j - 1);

		min2 = 1 + solve(i + 1, j);

		if (min1 < min2)
			path[i][j] = 1;
		else
			path[i][j] = 2;

		return memo[i][j] = Math.min(min1, min2);

	}

	private static void buildOutput(int i, int j) {
		if (i >= j)
			return;

		if (str.charAt(i) == str.charAt(j)) {
			buildOutput(i + 1, j - 1);
			return;
		}

		if (path[i][j] == 1) {
			st.insert((cnt++) + i, str.charAt(j));
			buildOutput(i, j - 1);
		} else if (path[i][j] == 2) {
			st.insert(j + cnt + 1, str.charAt(i));
			buildOutput(i + 1, j);
		}

	}

	public static void main(String[] args) {
		FastReader in = new FastReader();
		while ((str = in.nextLine()) != null) {
			vis = new boolean[1000][1000];
			System.out.print(solve(0, str.length() - 1) + " ");
			st = new StringBuilder(str);
			cnt = 0;
			buildOutput(0, str.length() - 1);
			System.out.println(st);

		}
	}

}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));

	}

	public FastReader(File f) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(f));
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
