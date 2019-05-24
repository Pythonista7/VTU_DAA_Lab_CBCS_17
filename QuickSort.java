/*
Sort a given set of n integer elements using Quick Sort method and compute its time
complexity. Run the program for varied values of n> 5000 and record the time taken to sort.
Plot a graph of the time taken versus n on graph sheet. The elements can be read from a file or
can be generated using the random number generator. Demonstrate using Java how the divide-
and-conquer method works along with its time complexity analysis: worst case, average case
and best case.

Algorithm fot this program was reffered from "Intoduction to DAA By Anany Levintin" Chapter: Divide and Conqure - QuickSort


*/

import java.util.*;
import java.io.*;

class QuickSort
{
	
	public static void main(String args[])
	{
		//Input the number of elements
		Scanner s =new Scanner(System.in);
		System.out.println("Input number of elements: ");
		int n=s.nextInt();

		//Initialize an array of size n
		int arr[]=new int[n];//{5,3,1,9,8,2,4,7};	
		
		//Generate n random numbers
		Random r=new Random();
		for(int i=0;i<n;i++)
			arr[i]=r.nextInt();

		//Variables to log time
		long start_time,end_time;		
		
		//Create an object of the class 
		QuickSort qs=new QuickSort();
		
		//Record the time before and after the call to the sorting funciton	
		start_time=System.nanoTime();
		qs.Qsort(arr,0,n-1);
		end_time=System.nanoTime();

		//Display the Sorted array and the time 
		System.out.println("Sorted array is :"+Arrays.toString(arr));
		System.out.println("Time taken is :"+(end_time-start_time)/1000000.0+" ms"); 
	}

	//The sorting funvtion
	public void Qsort(int arr[],int l,int r)
	{	int s;
		//We keep recursively calling this function until a single element is left at the bottom of the recursion tree
		if(r-l>=1)
		{
			//we partition the array at 's',the index at which partition occurs.It is generated bt partition() 
			s=partition(arr,l,r);

			//The partition indicates that every element before s is smaller and after it is greater,but not sorted.
			//Hence we recurse the 2 sub-arrays i.e [0..(s-1)] and [(s+1)...end] seperately.
			//__NOTE__ : 's'th element is not included for recursion as its already been place in the right position. 
			Qsort(arr,l,s-1);
			Qsort(arr,s+1,r);
		
		}

	}

	public int partition(int arr[],int l,int r)
	{	
		//We first define a pivot element which we will use for comparisions		
		int pivot;
		//Here we use the lowest element of array as pivot
		pivot=arr[l];
	
		//Initialize i and j to lower and upper bounds of the array
		int i=l;
		int j=r;

		//Loop until i and j do not cross over each other i.e until j>i 
		while(j>i)
		{//We travesres the array 2 times 
			 
			//First from l towards r until i and j overlap or until arr[i] has a value greater than pivot has been found.
			//if a value is greater than pivot is found we know it'll be at i'th position as loop breaks when this is true.
			while(arr[i]<=pivot && i<r)
				i++;
			
			//Similarly,j is looped from r to l until i and j overlap or until we find an element lesser than pivot.
			//if a value lesser than pivot is found the loop stops and its index is pointed to by j.
			while(arr[j]>pivot && j>=l)
				j--;

			//if j and i have not overlapped it means there is a element smaller than pivot in the 2nd half and larger than pivot
			//in the first half ,indicate by indexs j and i accordingly,Hence we need to swap them.
			if(j>i)
				swap(arr,i,j);		
	
		}
		//After the above loop all elements greater than and lesser than pivot would be segreated to 2 sides of the arr		
		//And the j'th index would point to the index of last swap.
		//Hence , now if we swap j'th element with l'th element which is the pivot we would have 2 appropriate sub arrays.
		swap(arr,j,l);//swap arr[j],arr[l]
		
		//Finally we return the index j(which is now the index of the pivot used ) back to the sort function for partition. 
		return j;	
	}

	//Helper function to swap 2 values a & b.
	//NOTE-  a and b are indices of arr which needs to be swapped.
	void swap(int arr[],int a,int b )
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
}
