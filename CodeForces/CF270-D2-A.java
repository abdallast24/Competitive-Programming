import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt(), angle;
		float f, n;
		boolean hasDecimal = false;
 
		while (t-- > 0) {
			angle = in.nextInt();
			f = angle / 180.0f;
			n = 2.0f / (1.0f - f);
			hasDecimal = (Math.round((n * 100)) % 100) != 0 ? true : false;
 
			if (hasDecimal)
				out.println("NO");
			else
				out.println("YES");
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
