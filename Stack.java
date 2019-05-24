/*
Write a Java program to implement the Stack using arrays. Write Push(), Pop(), and
Display() methods to demonstrate its working.
*/
import java.io.*;
import java.util.*;

class Stack
{
	int top=-1;
	
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		//Input size of stack
		System.out.println("Enter Stack Size :");	
		int n=s.nextInt();
		//Create a stack of size n		
		int stk[]=new int[n];
		//Create a stack object
		Stack St =new Stack();
		//Create a menu driver		
		while(true)
		{
			System.out.println("\n\n========================================\n");
			System.out.println("\t\t  Menu ");
			System.out.println("========================================");
			System.out.println("1.PUSH\n2.POP\n3.Display\n4.EXIT");	
			System.out.println("Enter the option number :");	
			int op=s.nextInt();
			
			switch(op)
			{
				case 1: System.out.println("Enter Element to push:");int ele=s.nextInt();
					St.push(n,ele,stk);
					break;
				case 2: St.pop(n,stk);break;

				case 3: St.disp(n,stk);break;

				case 4: System.exit(0);


			}

		}

	}


	void push(int n,int e,int stk[])
	{
		if(top<n-1)
		{
			top++;stk[top]=e;
		}
		else 
			System.out.println("OVERFLOW!!!!");

	}

	void pop(int n,int stk[])
	{
		if(top<0)
			System.out.println("Underflow!!!!!!!!");
		else 
		{
			System.out.println("Poped item is : "+stk[top]);
			top--;
		}

	}
		
	void disp(int n,int stk[])
	{	System.out.println("========================================");
		System.out.println("\t\t  Stack ");
		int i=top;
		while(i!=-1)
		{
			System.out.println("\t\t    "+stk[i]);
			i--;
		}
		System.out.println("========================================");
		

	}

}
