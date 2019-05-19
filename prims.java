/*
Prims algorith to find to find minimum cost spanning tree

Example Output:
==============
Enter number of nodes in the graph : 
5


INPUT ADJ MATRIX 5x5


0 2 0 6 0
2 0 3 8 5
0 3 0 0 7
6 8 0 0 9
0 5 7 9 0
Edge selected is 0 1
Edge selected is 1 2
Edge selected is 1 4
Edge selected is 0 3
Cost is 16

*/

import java.io.*;
import java.util.*;

class prims
{

	void prim(int adj[][], int n)
	{
		//Start from node2{arr[1] i.e arr[ne]} as node1(arr[0]) is already included
		int i,j,ne=1,min,min_cost=0,u=0,v=0;

		//Matrix to keep track of which vertex was visited,init all vertices to 0(unvisited) 
		int visit[]=new int[n];
		for(i=0;i<n;i++)
			visit[i]=0;

		//Visit node-1 by making visit[0]=1(visited)
		visit[0]=1;

		while(ne<n)//no of edges < no of vertices
		{
			min=999;
			//Loop through all vertices 
			for(i=0;i<n;i++)
			{	//If node is currently visited
				if(visit[i]==1)
				{	//Loop to all other nodes
					for(j=0;j<n;j++)
					{	// find a adj vertex such that cost to that vertex is min and not 0
						if(adj[i][j]<min && adj[i][j]!=0)
						{	
							//assign new minimum value
							min=adj[i][j];
							//save i&j in u&v							
							u=i;
							v=j;
	
						}

					}
				}

			}
	
			//Check if current vertex is visited and next vertex is NOT visited
			if(visit[u]==1 && visit[v]==0)
			{	//Visit the unvisited vertex
				visit[v]=1;
				//Add the vertex to MST				
				ne++;
				//add the cost to total min cost
				min_cost+=min;
				System.out.println("Edge selected is "+u+" "+v);

			}
			//Block paths back but assigning max cost to these edges
			adj[u][v]=adj[v][u]=999;

		}
		
		//Output final minimum cost
		System.out.println("Cost is "+min_cost);


	}

	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int N;
		
		//Input no of nodes
		System.out.println("Enter number of nodes in the graph : ");
		N=s.nextInt();

		//Input graph matrix
		int adj_mat[][]=new int[N][N];
		System.out.println("\n\nINPUT ADJ MATRIX "+N+"x"+N+"\n\n");
		for(int i=0;i<N;i++)
		{

			for(int j=0;j<N;j++)
				adj_mat[i][j]=s.nextInt();

		}
	
		/*                  {{0, 2, 0, 6, 0}, 
                                    {2, 0, 3, 8, 5}, 
                                    {0, 3, 0, 0, 7}, 
                                    {6, 8, 0, 0, 9}, 
                                    {0, 5, 7, 9, 0}}; 
	
		*/

		//create object and call prim()
		prims obj=new prims();
		obj.prim(adj_mat,N);
	}

}
