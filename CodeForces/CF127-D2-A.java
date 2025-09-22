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
		int n = in.nextInt() - 1, k = in.nextInt(), x1 = in.nextInt(), x2, y1 = in
				.nextInt(), y2;
		double distance = 0d;
		while (n-- > 0) {
			x2 = in.nextInt();
			y2 = in.nextInt();
 
			distance += Math.sqrt(Math.pow((x2 - x1) * 1d, 2d)
					+ (Math.pow((y2 - y1) * 1d, 2d)));
			x1 = x2;
			y1 = y2;
		}
 
		double ans = (distance * k) / 50d;
		
		System.out.printf("%.9f\n",ans);
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
