import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt(), ans = 0;
		while (t-- > 0) {
			int n = in.nextInt(), c = in.nextInt(), mid, left = 1, right = (int) (1e9 + 2), arr[] = new int[n], cows, stall;
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();
			Arrays.sort(arr);
 
			while (left <= right) {
				mid = (left + right) / 2;
				cows = c - 1;
				stall = arr[0] + mid;
				for (int i = 1; i < n && cows != 0; i++) {
					if (arr[i] >= stall) {
						cows--;
						stall = arr[i] + mid;
					}
				}
				if (cows == 0) {
					ans = mid;
					left = mid + 1;
				} else
					right = mid - 1;
			}
			out.println(ans);
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
