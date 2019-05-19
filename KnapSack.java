/*
GREEDY-KnapSack
===============

Sample Output:
=============
input number of items n:
4
input capacity m :
5
Input profit array :
12
10
20
15
Input weight array :
2
1
3
2

	PW_arr

10.0
7.5
6.6666665
6.0

Current bag=1/5.0

Current profit=10

Current bag=3/5.0

Current profit=25

Fraction = 0.6666667

Current bag=5/5.0

Current profit=38
Profit = 38


*/

import java.io.*;
import java.util.*;

class KnapSack
{

	
	public void proc(float profit[],float weight[],float pw_arr[],int n,float m)
	{
		//Sort column is pw_arr[]
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{       float temp;
				if(pw_arr[j]<pw_arr[j+1])
				{	//Swap content of all 3 - weight[],pw_arr[] and profit[]
					temp=pw_arr[j];
					pw_arr[j]=pw_arr[j+1];
					pw_arr[j+1]=temp;

					temp=profit[j];
					profit[j]=profit[j+1];
					profit[j+1]=temp;
					
					temp=weight[j];
					weight[j]=weight[j+1];
					weight[j+1]=temp;

					
				}


			}

		}

		//Printing sorted pw_arr
		System.out.println("\n	PW_arr\n");
		for(int i=0;i<n;i++)
		{
			System.out.println(pw_arr[i]);
		
		}

		//Adding items to knapsack
		int cap=0;int i=0;int final_profit=0;
		//if current capacity is lesser than max capacity 
		while(cap<m)
		{
			//if full item fits into the sack
			if(weight[i]<=(m-cap))
			{	cap+=weight[i];//Include item
				System.out.println("\nCurrent bag="+cap+"/"+m);
				final_profit+=profit[i];//Total new profit
				System.out.println("\nCurrent profit="+final_profit);
				
			}
			
			//Only a fraction of the item fits into the sack
			else
			{
				//calculate fraction
				float frac=(m-cap)/weight[i];
				System.out.println("\nFraction = "+frac);
				//Add fraction of the item into the sack
				cap+=frac*weight[i];
				System.out.println("\nCurrent bag="+cap+"/"+m);
				//Total new profit
				final_profit+=frac*profit[i];
				System.out.println("\nCurrent profit="+final_profit);
			}



			i++;
		}

		System.out.println("Profit = "+final_profit);

		
	}



	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		//input number of items n
		System.out.println("input number of items n:");
		int n=s.nextInt();
		

		//input capacity m
		System.out.println("input capacity m :"); 
		float m=s.nextInt();

		//profit array
		System.out.println("Input profit array :");
		float profit[]=new float[n];
		//Input to profit array
		for(int i=0;i<n;i++)
		{
			profit[i]=s.nextInt();
		
		}

		//weight array
		System.out.println("Input weight array :");
		float weight[]=new float[n];
		//Input to weight array
		for(int i=0;i<n;i++)
		{
			weight[i]=s.nextInt();
		
		}	

		//calculate and store p/w int arr
		float pw_arr[]=new float[n];
		for(int i=0;i<n;i++)
			pw_arr[i]=profit[i]/weight[i];
		
		KnapSack obj=new KnapSack();
		obj.proc( profit, weight, pw_arr, n,m);
	
		

	}



}
