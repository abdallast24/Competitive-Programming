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
	static boolean vis[][];
	static pair memo[][] = new pair[1000][1000];
	static String str;

	static pair best(pair a, pair b) {
		if (a.first > b.first)
			return a;
		if (a.first < b.first)
			return b;
		if (a.second.compareTo(b.second) < 0)
			return a;
		return b;

	}

	static pair dp(int i, int j) {
		if (i == j)
			return new pair(1, str.charAt(i) + "");
		if (i > j)
			return new pair(0, "");
		if (vis[i][j])
			return memo[i][j];
		vis[i][j] = true;
		if (str.charAt(i) == str.charAt(j)) {
			memo[i][j] = new pair();
			memo[i][j].first = 2 + dp(i + 1, j - 1).first;
			memo[i][j].second = str.charAt(i) + dp(i + 1, j - 1).second + str.charAt(j);
			return memo[i][j];
		}
		return memo[i][j] = best(dp(i, j - 1), dp(i + 1, j));

	}

	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		while(in.ready())
		{
			str=in.next();
			vis = new boolean[1000][1000];
			System.out.println(dp(0, str.length() - 1).second);

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

	boolean ready() throws IOException {
		return br.ready();
	}
}

class pair {
	int first;
	String second;

	pair() {
	}

	pair(int first, String second) {
		this.first = first;
		this.second = second;
	}

}
