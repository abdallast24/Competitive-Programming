import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
import java.util.TreeMap;
 
public class Main {
	static long[][] dp=new long[110][25];
	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int S=in.nextInt(),K=in.nextInt();
		for(int i=1;i<=100;i++)
		{
			dp[i][1]=i;
			dp[i][2]=(i/2)*(i-i/2);
		}
		
		for(int k=3;k<=K;++k)
		{
			for(int s=1;s<=S;s++)
			{
				long topush=1;
				for(int a=1;a<=s-k+1;a++)
					topush=Math.max(topush, a*dp[s-a][k-1]);
				
				dp[s][k]=topush;
				
			}
			
		}
		out.println(dp[S][K]);
		
		out.close();

}}
 
class FastReader {
	BufferedReader br;
	StringTokenizer st;
 
	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
 
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
