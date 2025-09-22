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
	static int n;
	static Pair pair[];
	static int memo[][];
	public static int solve(int idx , int prev) 
	{
		if(idx>=n-1)
			return 0 ;
		if(memo[idx][prev]!=-1)
			return memo[idx][prev];
		int max1=0,max2=0,max3=0;
		max3=solve(idx+1,0); //leave it
		if(pair[idx].position+pair[idx].height<pair[idx+1].position) //fell right
			max1=1+solve(idx+1,1);
		int nprev = 0;
		if(prev==1)
			nprev=pair[idx-1].position+pair[idx-1].height;
		else if(prev==0)
			nprev=pair[idx-1].position;
		
		if(pair[idx].position-pair[idx].height>nprev) //fell left
			 max2=1+solve(idx+1,0);
		
		return memo[idx][prev]=Math.max(max2, Math.max(max1, max3));
			
	}
	public static void main(String[] args){
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		n = in.nextInt();
		pair = new Pair[n];
		memo=new int[n][2];
		for(int i=0;i<n;i++)
		{
			pair[i]=new Pair();
			pair[i].position=in.nextInt();
			pair[i].height=in.nextInt();
		}
		
		for(int i=0;i<n;i++)
			Arrays.fill(memo[i],-1);
		int res=((n==1)?1:2)+solve(1,0);
		out.println(res);
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
 
class Pair {
	int position, height;
	public Pair() {}
	
}
