import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
	static int h;

	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		h = in.nextInt();
		long n = in.nextLong();
		long res = solve(1, 'L', (long) Math.pow(2, h), n);
		out.println(res);
		out.close();
	}

	public static long solve(int level, char dir, long leafs, long pos) {
		if (level == h + 1)
			return 0;
		char d;
		if (pos > leafs / 2l)
			d = 'R';
		else
			d = 'L';
		long path1 = -1, path2 = -1;
		if (dir == d)
			path1 = 1 + solve(level + 1, dir == 'L' ? 'R' : 'L', leafs / 2l, (d == 'R') ? pos - leafs / 2l : pos);
		else
			path2 = ((long) Math.pow(2, h + 1 - level))
					+ solve(level + 1, dir, leafs / 2l, (d == 'R') ? pos - leafs / 2l : pos);

		return path1 == -1 ? path2 : path1;

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
