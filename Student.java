/*
Create a Java class called Studentwith the following details as variables within it.
1
A
(i) USN
(ii) Name
(iii) Branch
(iv) Phone
Write a Java program to create nStudent objects and print the USN, Name, Branch, and
Phoneof these objects with suitable headings.
*/


import java.util.*;
import java.io.*;

class Student 
{
	//Class members needed by the object are declared outside methods.	
	String usn,name,br,ph;

	public static void main(String args[])
	{
		int n;//Stores no of students
	
		Scanner s=new Scanner(System.in);
		
		//Input the number of students
		System.out.println("Enter the no of students");
		n=s.nextInt();
			
		//First create an array of objects of size 'n'	
		//****NOTE: creating arr of obj will not allocated memory for each obj,this needs to be done to individual elements	
		Student stu[]=new Student[n];
	
		for(int i=0;i<n;i++)
		{
			stu[i]=new Student();//The obj arr element is allocated memory and then the read_info() is called 
			stu[i].read_info(n);
		}

		//Display all stored records
		System.out.println("\n\n\nALL RECORDS\n\n\n");
		for(int i=0;i<n;i++)
		{
			stu[i].display_info(n);
		}
	}
	
	void read_info(int n)
	{
		//this._member_ referes to the data member of the current object i.e stu[i] when this fn is called from the loop above.
		Scanner s=new Scanner(System.in);
		System.out.println("Enter name:");
		this.name=s.nextLine();
		System.out.println("Enter usn:");
		this.usn=s.nextLine();
		System.out.println("Enter branch:");
		this.br=s.nextLine();
		System.out.println("Enter Oh no:");
		this.ph=s.nextLine();
		
		
	}

	void display_info(int n)
	{	//Similarly this._member_ is used to refer to it when we are accessing the data members within the display loop
		for(int i=0;i<n;i++)
		{	System.out.println("=================================================");
			System.out.println("Name --> "+this.name);
			System.out.println("usn --> "+this.usn);
			System.out.println("branch --> "+this.br);
			System.out.println("ph no --> "+this.ph);
			System.out.println("=================================================");
		}


	}
}
