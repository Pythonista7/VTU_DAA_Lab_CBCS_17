/*
Kruskals Algorith for finding MST
=================================
1. Sort all the edges in non-decreasing order of their weight.(we are not doing this here, can be done to increase time efficiency)
2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If cycle is not formed, include this edge. Else, discard it.
3. Repeat step#2 until there are (V-1) edges in the spanning tree.

No of vertices = 4
No of edges = 5 
	      	10 
            0--------1 
            |  \     | 
           6|   5\   |15 
            |      \ | 
            2--------3 
                4      

	0 10 6 5
	10 0 999 15
	6 999 0 4
	5 15 4 0
 
*/
import java.io.*;
import java.util.*;

class Kruskal
{
	

	
	public int proc(int e,int N,int cost[][],int parent[])
	{	
		int u=0;int v=0;

		//Loop through all edges
		for(int count=0;count<e;count++)
		{
			int min=999;
		
			//Scan matrix for least element
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(cost[i][j]<min && cost[i][j]!=0)
					{	//assign cost of min-edge to min
						min=cost[i][j];
						//save i&j in u&v					
						u=i;
						v=j;

		
					}


				}				
	
			}
			
			
			find(u,v,parent,N);

			cost[u][v]=cost[v][u]=999;
		
			



		}

		return 1;
	}





	public int find(int u,int v,int parent[],int N)
	{	//find if it forms a cycle
		if(parent[u]!=parent[v])
			//if parent of nodes is not same then they dont form cycle,hence add them to the tree(union)
			union(u,v,parent,N);
		
		return 1;
	}
	

	public int union(int u,int v,int parent[],int N)
	{	
		//Show edge of MST
		System.out.println("Edge :"+u+" "+v);
		//loop through all nodes
		for(int i=0;i<N;i++)
		{	//After adding edge to tree make the node's parent as root of current-tree
			if(parent[i]==parent[v])
			{	
				//System.out.println(parent[u] + parent[v]);
				parent[i]=parent[u];
			}
			
		}

		
		
		return 1;		
	}

	public static void main(String args[])	
	
	{	
		
		int N;
		//int u=0,v=0;
		Scanner s=new Scanner(System.in);

		System.out.println("Enter no of nodes ");
		N=s.nextInt();

		System.out.println("Enter the no of edges");
		int e=s.nextInt();
		
		int parent[]=new int[N];
		//init parent array,node is initially parent of itself
		for(int i=0;i<N;i++)
			parent[i]=i;

		//Input Graph matrix
		int cost[][]=new int[N][N];
		System.out.println("\n\nINPUT ADJ MATRIX "+N+"x"+N+"\n\n");
		for(int i=0;i<N;i++)
		{

			for(int j=0;j<N;j++)
				cost[i][j]=s.nextInt();

		}
		
		//Create obj and call methong proc()
		Kruskal obj=new Kruskal();
		obj.proc(e,N,cost,parent);

			
	}

		
}


