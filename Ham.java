/*
Hamiltanion Cycle in Java Using Branch and Bound

Bounding function :
	> No Vertex should be duplicated
	> There should be an edge between the selected vertex and previous vertex

Example Output:

No of vertices
4

Enter adj matrix
0 1 1 1 
1 0 1 1 
1 1 0 1
1 1 1 0

Cycle:
[0, 1, 2, 3] 
Cycle:
[0, 1, 3, 2] 
Cycle:
[0, 2, 1, 3] 
Cycle:
[0, 2, 3, 1] 
Cycle:
[0, 3, 1, 2] 
Cycle:
[0, 3, 2, 1] 
 
*/

import java.io.*;
import java.util.*;

class Ham
{
	//Since all these members need to be shared by the methods as one copy we make them static.
	static int n;
	static int x[];	
	static int adj[][];
	
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);		
		
		System.out.println("No of vertices");
		n=s.nextInt();
		
		x=new int[n];//Solution Subset of Back-Tracking 
		
		adj=new int[n][n];//Graph-Matrix

		//Input Graph
		System.out.println("Enter adj matrix");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				adj[i][j]=s.nextInt();
		
		//cause we start from same source always
		x[0]=0;

		//Initialize all other nodes as -1
		for(int i=1;i<n;i++)
			x[i]=-1;
		
		//Create an object and call the getHcycle() methond off the object
		Ham hc=new Ham();
		hc.getHcycle(1);
	
	}

	public void nextValue(int k)
	{

		int i=0;

		while(true)
		{
			x[k]=(x[k]+1)%(n+1);	//we use the % operator to cycle back to the first element after the last one.
			
			if(x[k]==n) 
				x[k]=-1;
	
			if(x[k]==-1)
				return;

			if(adj[x[k-1]][x[k]]==1)	//selected vertex should be connected to the previous vertex
				for(i=0;i<k;i++)
					if(x[i]==x[k])	//To avoid repeating the same node entry into solution subset
						break;

			if(i==k)	//To check if there is an edge back to the starting vertex to complete the cycle
				if(k<n-1 || (k==n-1 && adj[x[n-1]][0]==1) )
					return;

		}
	}

	public void getHcycle(int k)
	{

		while(true)
		{
			nextValue(k);//Update x[] wrt the current value of k.
			

			//System.out.println("x:\n"+Arrays.toString(x));

			if(x[k]==-1)//finally also no path then exit
				return;

			if(k==n-1)//all vertices are covered hence print
				System.out.println("Cycle:\n"+Arrays.toString(x)+" ");

			else
				getHcycle(k+1);



		}
	}		


}





