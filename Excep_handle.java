/*
Write a Java program to read two integers a andb. Compute a/b and print, when b is not
zero. Raise an exception when b is equal to zero.
*/
import java.io.*;
import java.util.*;

class Excep_handle
{

	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);

		System.out.println("Enter A: ");
		int a = s.nextInt();
	
		
		System.out.println("Enter B: ");
		int b = s.nextInt();

		try{
			float res=a/b;//This will raise an exception if denominator is 0 hence we place it inside try{}
			System.out.println("Result is "+res);//If there is not exception the res is printed
	
		}
		catch(Exception e)
		{	//If an exception occurs then we catch and show the exception
			System.out.println("Exception Caught!! \n "+e.getMessage());
		}
	}

}
