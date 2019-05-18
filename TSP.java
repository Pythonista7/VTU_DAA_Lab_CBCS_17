/*
Traveling Sales Person Problem using Dynamic Programming
========================================================
Exapmple Graph:
==============
			0, 10, 15, 20 
                        10, 0, 35, 25 
                        15, 35, 0, 30  
                        20, 25, 30, 0 

Example output:
==============
No of vertices
4
Enter cost matrix
0 10 15 20 
10 0 35 25
15 35 0 30
20 25 30 0
1
2
4
3
Cost=80
========================================================
*/

import java.io.*;
import java.util.*;

class TSP
{

	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);		

		//Input no of vertices
		System.out.println("No of vertices");
		int n=s.nextInt();

		//Input Cost matrix
		int c[][]=new int[n+1][n+1];
			System.out.println("Enter cost matrix");
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				c[i][j]=s.nextInt();

		//create tour matrix		
		int tour[]=new int [n+1];

		for(int i=1;i<=n;i++)
			tour[i]=i;

		//call the tspdp()
		int cost=tspdp(c,tour,1,n);

		//print tour arr
		for(int i=1;i<=n;i++)
			System.out.println(tour[i]);
		
		//print final cost
		System.out.println("Cost="+cost);
	
	}

	static int tspdp(int c[][],int tour[],int start,int n)
	{
		//Declare following 
		int mintour[]=new int[n+1];//used to save current min-tour
		int temp[]=new int[n+1];//used to hold a copy of tour which gets updated on every recursion
		int mincost=999;//min cost is set to max-value as it need to be checked with lesser-than condition
		int ccost=0;//Current cost 

		//If at the last-2nd vertex then return : the cost to travel to last vertex and then back to source vertex
		if(start==n-1)	
			return( c[tour[n-1]][tour[n]]+c[tour[n]][1] );

		//Loop through all vertices
		for(int i=start+1;i<=n;i++)
		{
			
			//Copy tour[] to temp[]
			for(int j=1;j<=n;j++)
				temp[j]=tour[j];

			//System.out.println("Before\ntemp="+Arrays.toString(temp));
			//System.out.println("tour="+Arrays.toString(tour));
			
			//Reorder temp to be passed as tour for next recursion
			temp[start+1]=tour[i];
			temp[i]=tour[start+1];
			
			//System.out.println("After\ntemp="+Arrays.toString(temp));			
			//System.out.println("tour="+Arrays.toString(tour));
	
			//recursively calculate cost while travesing new tour to check if its minimum
			if( (c[tour[start]][tour[i]] + (ccost=tspdp(c,temp,start+1,n))) < mincost)
			{
				//If true ; update min cost
				mincost=c[tour[start]][tour[i]]+ccost;
				//System.out.println("Min cost1 = "+mincost+"\n\n\n");
				
				//copy temp[] to mintour[] as it gives the current minimum cost
				for(int z=1;z<=n;z++)
					mintour[z]=temp[z];

			}
			

		}
		//After the above loop mintour will have the requried shortest path and is copied back to tour[]
		for(int i=1;i<=n;i++)
			tour[i]=mintour[i];
		
		

		//return to cost of tour which is minimum
		return mincost;


	}


}
