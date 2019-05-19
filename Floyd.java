/*
The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. 
The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph.

/* Let us create the following weighted graph 
            10 
       (0)------->(3) 
        |         /|\ 
      5 |          | 
        |          | 1 
       \|/         | 
       (1)------->(2) 
            3        

Enter number of nodes in the graph : 
4


INPUT ADJ MATRIX 4x4


0 5 8 9
999 0 3 4
999 999 0 1
999 999 999 0

SHORTEST PATHS ARE :


0  5  8  9  
999  0  3  4  
999  999  0  1  
999  999  999  0  
   
*/

import java.util.*;
import java.io.*;

class Floyd
{	
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int N;
		//Input no of nodes
		System.out.println("Enter number of nodes in the graph : ");
		N=s.nextInt();
		
		//Input Graph Matrix
		int adj_mat[][]=new int[N][N];
		System.out.println("\n\nINPUT ADJ MATRIX "+N+"x"+N+"\n\n");
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
				adj_mat[i][j]=s.nextInt();
		}

		//Empty array where solution is stored
		int A[][]=new int[N][N];

		//Create object and call get_paths()
		Floyd F=new Floyd();
		F.get_paths(adj_mat,A,N);

		

	}

	void get_paths(int cost[][],int A[][],int n)
	{
		
		//Copy cost[][] to A[][]	
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				A[i][j]=cost[i][j];

		//loop through all pairs of vertices (n-1)times
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				{	//assign minimum among : to A[i[][j]
					//(1)Direct path from i to j i.e- adj[i][j] or 
					//(2)Path from i to j via k who's cost will be A[i][k]+A[k][j] 
					A[i][j]=Math.min(A[i][j],A[i][k]+A[k][j]);
				}

		//print the A[][]
		System.out.println("\nSHORTEST PATHS ARE :\n\n");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(A[i][j]+ "  ");

			System.out.println();
		}
	}

}
