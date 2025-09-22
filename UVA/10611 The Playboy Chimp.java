import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	public static String doBinarySearch(int[] arr, int target,
			boolean isFirstAns) {
		int left = 0, right = arr.length - 1, mid, ans = -1;
		while (left <= right) {
			mid = (left + right) / 2;

			if (arr[mid] < target || arr[mid] == target && !isFirstAns) {
				
				if (isFirstAns)
					ans = arr[mid];
				left = mid + 1;
				
			}
			else if (arr[mid] > target || arr[mid] == target && isFirstAns) {
				
				if (!isFirstAns)
					ans = arr[mid];
				
				right = mid - 1;
			}

		}

		return ans == -1 ? "X" : ans + "";
	}

	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt(), arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();

		int q = in.nextInt();

		while (q-- > 0) { // q*log(n)
			int target = in.nextInt();
			out.println(doBinarySearch(arr, target, true) + " "
					+ doBinarySearch(arr, target, false));
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
