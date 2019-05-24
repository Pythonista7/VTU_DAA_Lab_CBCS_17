//This is the java program to implement the knapsack problem using Dynamic Programming
/*
Example run:
===========

Enter the number of items: 
4
Enter the items weights: 
2
1
3
2
Enter the items values: 
12
10
20
15
Enter the maximum capacity: 
5


Table


0	0	0	0	0	0	
0	0	12	12	12	12	
0	10	12	22	22	22	
0	10	12	22	30	32	
0	10	15	25	30	37	

The maximum value that can be put in a knapsack of capacity W is: 37

*/
import java.util.*;
 
public class Knapsack_DP 
{
    static int max(int a, int b) 
    { 
        return (a > b)? a : b; 
    }

	
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int [][]K = new int[n+1][W+1];
 
	// Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
		//if no item is picked or if item has no weight then we dont consider
                if (i==0 || w==0)
                    K[i][w] = 0;
		//if currently picked item fits into current weight column 
		//we take the max of 
		//> value of current item + profit of including item whose weight is(current weight allowed - weight of item being included)
		//								       ^==========REMAINING WEIGHT============^		
		//or> profit of adding previous item for current allowed weight
                else if (wt[i-1] <= w)
            		K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);

                //profit of adding previous item for current allowed weight
		else
                    K[i][w] = K[i-1][w];
            }
        }
	
	/*
	Print the Table
	 ##NOTE## 
	 (1)no of (rows is no of items + 1)
	 (2)no of columns is (max capacity + 1)
	*/	
	System.out.println("\n\nTable\n\n");
 	for(i=0;i<=n;i++)
	{	for(int j=0;j<=n+1;j++)
			System.out.print(K[i][j]+"\t");

		System.out.println();
	}
	
        return K[n][W];
    }
 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        System.out.println("Enter the items weights: ");
        int []wt = new int[n];
        for(int i=0; i<n; i++)
            wt[i] = sc.nextInt();
 
        System.out.println("Enter the items values: ");
        int []val = new int[n];
        for(int i=0; i<n; i++)
            val[i] = sc.nextInt();
 
        System.out.println("Enter the maximum capacity: ");
        int W = sc.nextInt();
 	
	

        System.out.println("\nThe maximum value that can be put in a knapsack of capacity W is: " + knapSack(W, wt, val, n));
	

        sc.close();
    }
}
