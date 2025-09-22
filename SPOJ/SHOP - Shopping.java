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
	static int sx, sy, dx, dy, r, c, dis[][] = new int[25][25];
	static char arr[][] = new char[25][25];
	static int a[] = { -1, 0, 1, 0 }, b[] = { 0, 1, 0, -1 };

	public static void init() {
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 'S') {
					sx = i;
					sy = j;
				} else if (arr[i][j] == 'D') {
					arr[i][j] = '0';
					dx = i;
					dy = j;
				}
				dis[i][j] = (int) 1e9;
			}
		dis[sx][sy] = 0;
	}

	public static void bfs() {
		init();
		LinkedList<Integer> q = new LinkedList<>();
		q.push(sy);
		q.push(sx);
		while (!q.isEmpty()) {
			int x = q.remove();
			int y = q.remove();
			for (int i = 0; i < 4; i++) {
				int tx = x + a[i];
				int ty = y + b[i];
				if (tx >= 0 && tx < r && ty >= 0 && ty < c && arr[tx][ty] != 'X'
						&& dis[tx][ty] > (dis[x][y] + arr[tx][ty] - 48)) { // '0' = 48 in ascii
					q.push(ty);

					q.push(tx);
					dis[tx][ty] = (dis[x][y] + arr[tx][ty] - 48);
				}

			}
		}

	}

	public static void main(String[] args) throws IOException {

		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			c = in.nextInt();
			r = in.nextInt();
			if (r + c == 0)
				break;
			for (int i = 0; i < r; i++)
				arr[i] = in.next().toCharArray();

			bfs();
			out.println(dis[dx][dy]);

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
