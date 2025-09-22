import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) { //O(n)
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt(), k = in.nextInt() - 1, arr[] = new int[n];
		arr[0] = in.nextInt();
		for (int i = 1; i < n; i++)
			arr[i] = in.nextInt() + arr[i - 1];
		int minSum = arr[k], ans = 0;
		for (int i = 1; i + k < n; i++)
			if (arr[i + k] - arr[i - 1] < minSum) {
				ans = i;
				minSum = arr[i + k] - arr[i - 1];
			}
		out.println(ans + 1);
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
