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

		String s1, s2;
		int mul, nzeros, rem = 0, cur, sum;
		StringBuilder sb = new StringBuilder();
		while ((s1 = in.nextLine()) != null) { //O(n*m)
			s2 = in.next();
			if (s1.equals("0") || s2.equals("0")) // special case 
			{
				out.println(0);
				continue;
			}
			sb.setLength(0);
			sb.append((s1.charAt(0) - '0') * (s2.charAt(0) - '0'));
			for (int i = 0; i < s1.length() + s2.length() - 2; i++)
				sb.append(0);
			for (int i = 0; i < s1.length(); i++) {
				for (int j = (i == 0) ? 1 : 0; j < s2.length(); j++) {
					mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
					nzeros = (s1.length() - i - 1) + (s2.length() - j - 1);
					for (int k = sb.length() - nzeros - 1; k > -1
							&& (rem > 0 || mul > 0); k--) {
						cur = mul % 10;
						mul /= 10;
						sum = cur + (sb.charAt(k) - '0') + rem;
						sb.replace(k, k + 1, (sum % 10) + "");
						rem = sum / 10;
					}
					if (rem > 0) {
						sb.insert(0, rem);
						rem = 0;
					}
				}
			}
			out.println(sb);
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
