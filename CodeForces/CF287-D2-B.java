import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		long n = in.nextLong(), k = in.nextLong(), sum, curSum = k * (k + 1)
				/ 2, z = 0, mid, left = 2, right = k, ans = -1;

		while (left <= right) { // log(k)
			mid = (left + right) / 2;
			sum = curSum - ((mid - 1) * mid / 2) - (k - mid + 1);

			if (sum == n - 1) // found it
			{
				ans = k - mid + 1;
				break;
			} else if (sum < n) {
				right = mid - 1;
				z = n - sum;
				if (z < mid && z > 1) // found it
					ans = k - mid + 2;
			} else
				left = mid + 1;
		}

		out.println(n == 1 ? 0 : ans);
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
