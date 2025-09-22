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
 
		int d = in.nextInt(), h = in.nextInt(), v = in.nextInt(), e = in
				.nextInt();
 
		double volume = (Math.PI * d * d * e) / 4.0d;
 
		if (v > volume) {
			double time = ((Math.PI * d * d * h) / 4.0d) / (v - volume);
			out.println("YES");
			out.printf("%.12f", time);
		} else
			out.println("NO");
 
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
