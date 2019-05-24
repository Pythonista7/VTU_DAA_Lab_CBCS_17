/*

Sort a given set of n integer elements using Merge Sort method and compute its time
complexity. Run the program for varied values of n> 5000, and record the time taken to sort.
Plot a graph of the time taken versus non graph sheet. The elements can be read from a file or
can be generated using the random number generator. Demonstrate using Java how the divide-
and-conquer method works along with its time complexity analysis: worst case, average case
and best case.

*/

import java.io.*;
import java.util.*;

class MergeSort
{

	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		Random r=new Random();

		//Input number of elements
		System.out.println("Enter no of elements :");
		int n=s.nextInt();
	
		int arr[]=new int[n];
		//Initialize array with random numbers
		for(int i=0;i<n;i++)
			arr[i]=r.nextInt();
	
		MergeSort sorter=new MergeSort();

		//log time before and after sorting 
		long start_time=System.nanoTime();		
		arr=sorter.divide(0,n-1,arr);
		long end_time=System.nanoTime();
	
		//Display Sorted array and time taken for sorting.
		System.out.println("Sorted array is :\n"+Arrays.toString(arr));
		System.out.println("Time for sorting is : "+ (end_time - start_time)/1000000.0+" ms");
		
	}

	//l=left most (low) , r=right most(high)
	int[] divide(int l,int r,int arr[])
	{
		int m;//m=mid element index

		//Perfrom recursion until 1 element is left as arr
		if(l<r)
		{
			//calculate mid as (low+high)/2
			m=(l+r)/2;
			//recursively divide first sub arr
			divide(l,m,arr);
			//recursively divide second sub arr
			divide(m+1,r,arr);
			//Merge all the sub arrays into arr
			merge(l,m,r,arr);
		}	

		//Return sorted array
		return arr;
	}


	void merge(int l,int m,int r,int arr[])
	{
		int n1=m-l+1;//here we calculate size hence we need to do +1 to account for array index starting from 0
		int n2=r-m;
		
		//create arrays of sizes n1 and n2
		int left_arr[]=new int[n1];
		int right_arr[]=new int[n2];

		//Copy the data from arr to left_arr and right_arr respectively	
		int x=0;	
		for(int i=l;i<=m;i++)
		{	left_arr[x]=arr[i];
			x++;
		}

		x=0;
		for(int i=m+1;i<=r;i++)
		{	right_arr[x]=arr[i];
			x++;
		}	


		//i is a pointer to left_arr, j to right_arr and k to 'main' arr[]
		int i=0,j=0,k=l;//**NOTE** access arr[] from l'th index ,hence k=l
		
		//While either of the arrays have not been fully traversed
		while(i<n1 && j<n2)
		{	
			//Pick the smaller element between left_arr[i] or right_arr[j] and then add to arr[k]
			
			if(left_arr[i]<right_arr[j])
			{	arr[k]=left_arr[i];
				i++;k++;
			}
		
			else
			{	arr[k]=right_arr[j];
				j++;k++;
			}

		}
		
		//After either of the arrays have completed traversing empty the remain contents of either left or right arrays into arr.
	//**NOTE** Only one of the below 2 loops will run,because either i==n1 or j==n2 for the above while-loop to break		
		while(i<n1)
		{	arr[k]=left_arr[i];
			i++;k++;
		}
		
		while(j<n2)
		{	arr[k]=right_arr[j];
			j++;k++;
		}
		
	}	

}
