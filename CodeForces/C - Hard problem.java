import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import java.text.*;

public class Main {	
	public static String reverse(String str) {
		 return new StringBuilder(str).reverse().toString();
	}
	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
  		int n=in.nextInt();
		String[]s=new String[n+1];
		s[0]="a";
		int cost[]=new int[n+1];
		long dp[][]=new long[n+1][2];
		for(int i=1;i<=n;i++)
			cost[i]=in.nextInt();
		for(int i=1;i<=n;i++)
			s[i]=in.next();
		for(int i=1;i<=n;i++)
		{
			dp[i][0]=dp[i][1]=(long) 1e16;
			
			if(s[i].compareTo(s[i-1])>=0)
				dp[i][0]=dp[i-1][0];
			
			if(s[i].compareTo(reverse(s[i-1]))>=0)
				dp[i][0]=Math.min(dp[i][0],dp[i-1][1]);
			
			if(reverse(s[i]).compareTo(s[i-1])>=0)
				dp[i][1]=dp[i-1][0]+cost[i];
			
			if(reverse(s[i]).compareTo(reverse(s[i-1]))>=0)
					dp[i][1]=Math.min(dp[i][1],dp[i-1][1]+cost[i]);
					
		}
		long res=Math.min(dp[n][0],dp[n][1]);
		out.println(res>=1e16?-1:res);
		
		
		
		
		
		
		
		
		
		
		
		
		
		out.close();

	}

}

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


