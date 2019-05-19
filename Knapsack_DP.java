//This is the java program to implement the knapsack problem using Dynamic Programming
/*
Example run:
===========
Enter the number of items: 
7
Enter the items weights: 
2
3
5
7
1
4
1
Enter the items values: 
10
5
15
7
6
18
3
Enter the maximum capacity: 
15
The maximum value that can be put in a knapsack of capacity W is: 54

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
	System.out.println("\n\nTable\n\n");
 	System.out.println(Arrays.deepToString(K));
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
 
        System.out.println("The maximum value that can be put in a knapsack of capacity W is: " + knapSack(W, wt, val, n));
        sc.close();
    }
}
