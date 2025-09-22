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
	static int n ; 
	static int memo[][][]=new int[100000][2][2];
	static boolean visited[][][]=new boolean[100000][2][2];
	static boolean vis[]=new boolean[100000];
	static char arr[];
	public static int solve(int idx , int prev,int change)
	{
		if(idx==n)
			return 0 ; 
		if(visited[idx][prev][change])
			return memo[idx][prev][change];
		visited[idx][prev][change]=true;
		int max=Integer.MIN_VALUE;
		if((arr[idx]-'0')!=prev)
			max=1+solve(idx+1,arr[idx]-'0',change);
		else 
		{
			int max1=solve(idx+1,prev,change),max2=Integer.MIN_VALUE;
		
			 if(vis[idx-1]||change==0)
			 {
				 vis[idx]=true;
			 max2=(arr[idx]-'0'==prev?1:0)+solve(idx+1,(arr[idx]=='0')?1:0,1);
			 vis[idx]=false;
			 }
			 return memo[idx][prev][change]=Math.max(max1,max2);
			
			
		}
		
		return memo[idx][prev][change]=max;
		
			}
	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		n=in.nextInt();
		arr=in.next().toCharArray();
	
		int res=1+solve(1,arr[0]-'0',0);
		System.out.println(res);
		
		
		
		
		
		
		
		
		
		
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

