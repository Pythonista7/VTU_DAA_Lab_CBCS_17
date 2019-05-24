/*
Write a Java program that implements a multi-thread application that has three threads.
First thread generates a random integer for every 1 second; second thread computes the
square of the number andprints; third thread will print the value of cube of the number.
*/

import java.util.*;
import java.io.*;

class Multi_Threaded
{
	public static void main(String args[])
	{
		//init object of First class
		First a=new First();
		//Start thread of 1st class
		a.run();

	}

}



class First extends Thread
{
	public void run()
	{	
		try{		
			Random r=new Random();//Create object of "Random" class
			
			for(int i=0;i<5;i++)
			{
				//Generate a random number bw 0 and 20
				System.out.println("\n\ni="+i+"\n");
				int n=r.nextInt(20);//will return random number only between 0-20
				//Display the number 
				System.out.println("Number is "+n);
	
				//Create obj of second class and run its thread
				Second b=new Second(n);	
				b.run();

				//Create obj of third class and run its thread
				Third c=new Third(n);
				c.run();


				//Sleep for 1 sec after every iteration
				Thread.sleep(1000);

			}
		}

		//If any Multi THread exception arises catch and display it 
		catch(Exception e)
		{
			System.out.println("Caught "+e);	
		}
	}
	
}

class Second extends Thread
{
	public int n;
	//Use a constructor to initialize the incoming value to the object of this class
	public Second(int n)
	{
		this.n=n;
	}

	//implement the run() for Second thread
	public void run()
	{
		System.out.println("Square of the number "+n+" is "+(n*n));
	}

}


class Third extends Thread
{	
	public int n;
	//Use a constructor to initialize the incoming value to the object of this class
	public Third(int n)
	{
		this.n=n;
	}
	//implement the run() for Third thread
	public void run()
	{
		System.out.println("Cube of the number "+n+" is "+(n*n*n));
	}

}



