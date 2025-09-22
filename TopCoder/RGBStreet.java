import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RGBStreet{
	
static int r[]=new int[21];
static int g[]=new int[21];
static int b[]=new int[21];
static int n ; 
static int memo[][]=new int[21][4];
public int minCost(int i, int lastColor) {
	
	if(i==n)
		return 0;
	
	if(memo[i][lastColor]!=-1)
		return memo[i][lastColor];
	int max=Integer.MAX_VALUE;
	if(lastColor!=0)
		max=Math.min(max,r[i]+minCost(i+1,0));
	
	if(lastColor!=1)
		max=Math.min(max,g[i]+minCost(i+1,1));
	
	if(lastColor!=2)
		max=Math.min(max,b[i]+minCost(i+1,2));
	
	return memo[i][lastColor]=max;
}
	
public int estimateCost(String[] houses)
{
	n=houses.length;
	for(int i=0;i<houses.length;i++)
	{
		StringTokenizer st=new StringTokenizer(houses[i]);
		r[i]=Integer.parseInt(st.nextToken());
		g[i]=Integer.parseInt(st.nextToken());
		b[i]=Integer.parseInt(st.nextToken());
		
	}

	for(int i=0;i<memo.length;i++)
		Arrays.fill(memo[i],-1);
	return minCost(0,3);
}


	
	
	
	
	
	
}
