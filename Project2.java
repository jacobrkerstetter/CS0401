// Project2.java

import java.io.*; // BufferedReader
import java.util.*; // Scanner to read from a text file

public class Project2
{
	public static void main (String args[]) throws Exception // we NEED this 'throws' clause
	{
		// ALWAYS TEST FIRST TO VERIFY USER PUT REQUIRED CMD ARGS
		if (args.length < 3)
		{
			System.out.println("\nusage: C:\\> java Project1 <input file name> <lo>  <hi>\n\n"); 
			// i.e. C:\> java Project1 P1input.txt 1 30
			System.exit(0);
		}
		
		String infileName = args[0];  // no need to convert, just copy into infileName
		int lo = Integer.parseInt( args[1] ); // conver to int then store into to
		int hi = Integer.parseInt( args[2] ); // conver to int then store into hi
		
	
		// STEP #1: OPEN THE INPUT FILE AND COMPUTE THE MIN AND MAX. NO OUTPUT STATMENTS ALLOWED
		Scanner infile = new Scanner( new File(infileName) );
		int min,max;
		min=max=infile.nextInt(); // WE ASSUME INPUT FILE HAS AT LEAST ONE VALUE

		while ( infile.hasNextInt() )
		{
			int test = infile.nextInt(); // create variable being tested as the next int in the file

			if (test < min) // if test < min, the test becomes the min
				min = test;
			else if (test > max) // if it's not the min it could be the max, but if its the min this gets
				max = test;      // skipped to preserve efficiency
		}
		System.out.format("min: %d max: %d\n",min,max); // DO NOT REMOVE OR MODIFY IN ANY WAY


		// STEP #2: DO NOT MODIFY THE REST OF MAIN. USE THIS CODE AS IS 
		// WE ARE TESTING EVERY NUMBER BETWEEN LO AND HI INCLUSIVE FOR
		// BEING PRIME AND/OR BEING PERFECT 
		for ( int i=lo ; i<=hi ; ++i)
		{
			System.out.print( i );
			if ( isPrime(i) ) System.out.print( " prime ");
			if ( isPerfect(i) ) System.out.print( " perfect ");
			System.out.println();
		}
	} // END MAIN
	
	// *************** YOU FILL IN THE METHODS BELOW **********************
	
	// RETURNs true if and only if the number passed in is perfect
	static boolean isPerfect( int n )
	{	
		int sum = 1; // initialize sum to include 1 (a factor of every number)

		// loop from 2 to the sqrt of n (essentially the midpoint) so factors do not repeat
		// adding any factors (and their counterpart on the other side of the sqrt to the 
		// sum
		if (n < 6)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) 
				sum += i + n/i;
		}

		return sum == n; // (just to make it compile) YOU CHANGE AS NEEDED
	}
	// RETURNs true if and only if the number passed in is prime
	static boolean isPrime( int n )
	{	

		if (n < 2) 
				return false;

		for (int i = 1; i <= Math.sqrt(n); i++) {

			if (n != i+1 && n % (i+1) == 0)   // if number has a factor besides 1, it's not prime
				return false;		
		}

		return true; // (just to make it compile) YOU CHANGE AS NEEDED
	}
} // END Project2 CLASS

