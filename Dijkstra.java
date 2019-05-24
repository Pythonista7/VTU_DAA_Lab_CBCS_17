/*
From a given vertex in a weighted connected graph, find shortest paths to other
vertices using Dijkstra's algorithm. Write the program in Java.
*/
import java.io.*;
import java.util.*;

class Dijkstra
{

	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int n;
		//Input no of nodes
		System.out.println("No of nodes :");
		n=s.nextInt();

		//Vertices are numbered starting from 1 hence we will use index no as reference to vertices
		int cost[][]=new int[n+1][n+1];//Hence size of array is n+1 as we ignore the 0th index
		
		//input cost matrix of the graph
		System.out.println("Enter Cost matrix:");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)			
				cost[i][j]=s.nextInt();
		//Input source vertex
		System.out.println("Enter source vertex");
		int scr=s.nextInt();
		
		//Create a distance array	
		int dist[]=new int[n+1];
		//Initialize with the cost to travel directly from source to i 
		for(int i=1;i<=n;i++)
			dist[i]=cost[scr][i];
	
		//Call function passing all the parameters
		ShortestPath(n,scr,cost,dist);
	}	

	static void ShortestPath(int n,int src,int cost[][],int dist[])
	{
		//reach[] is used to chk if a vertex has been reacher or not. 1=reached and 0=not_reached.
		int reach[]=new int[n+1];
		//path[] keeps track of the path of min cost
		int path[]=new int[n+1];
		
		//path is initialized to src initially
		for(int i=0;i<n;i++)
			path[i]=src;
	
		int u=0,count=1,min;

		//we loop though n-1 edges as the source is already accounted.
		while(count<n)
		{
			min=999;

			//Find an adj vertex which can be visited from the current vetrex with minimum cost
			for(int i=1;i<=n;i++)			
				if(dist[i]<min && reach[i]==0)
				{
					min=dist[i];
					u=i;//The vetrex is stored in u
				}

			//reach u which is the nearest vertex
			reach[u]=1;
			count++;

			//check among neighbours of u , if the direct path to the neighbour is longer than path from src via u,if so update.
			for(int i=1;i<=n;i++)
			{
				if(dist[i]>dist[u]+cost[u][i])
				{
					dist[i]=dist[u]+cost[u][i];//update dist[] with new min dist to i
					path[i]=u;
				}
			}
			
		}

		System.out.println("Distance Array : "+Arrays.toString(dist));
		
		
		/*
		for(int i=1;i<=n;i++)
		{	
			if(i!=src)
			{	System.out.println("Distance from "+src+" to "+i+" is ---> "+dist[i]);
	
				if(dist[i]<999)
				{
					System.out.println("Path : i <-- ");
					int j=i;
					while(j!=src)
					{
						j=path[j];
						System.out.print("<-- "+j);
					}
				}
			}
		}
		*/
	}
}
