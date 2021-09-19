// STARTER FILE LAB #3 

import java.util.*;
import java.io.*;

public class Lab3
{
    static final int MAX_CAPACITY = 30;  // HARDOCED PLENTY BIG. WE'LL DO TRIM AFTER
    
    public static void main( String args[] ) throws Exception
    {
        if (args.length < 1 )
        {
            System.out.println("usage: $ java Lab3 <inupt file of random numbers>\n");
            System.exit(0);
        }
        
        int[] arr = new int[ MAX_CAPACITY ];
        int count=0;
        
        Scanner infile = new Scanner( new File( args[0] ) );
        while ( infile.hasNextInt() )
        {
            insertInOrder( arr, count, infile.nextInt() );
            ++count;
        }
        
        arr = trimArray( arr, count );
        printArray( arr ); // NOTE:  NO COUNT PASSED IN
        
    }// END MAIN
    
    // ############################################################################################################
    
    // MUST USE ENHANCED FOR LOOP IN THIS METHOD
    // (YOUR TRIM BETTER HAVE BEEN WRITEN CORRECTLY)
    static void printArray( int[] array )
    {
        for (int i = 0; i < array.length; i++){      // PRINT EACH NUMBER WITH A SPACE AFTER IT
            System.out.format("%d ", array[i]);
        }    
        System.out.println(); // LEAVE THIS HERE
    }
    
    static int[] trimArray( int[] array, int count  )
    {
        int[] trimmedArray = new int[count];

        for (int i = 0; i < count; i++){
            trimmedArray[i] = array[i];
        }

        return trimmedArray; 
    }
    
   
    // THE CODE IN HERE NOW JUST APPENDS. THIS IS NOT CORRECT
    static void insertInOrder( int[] arr, int count, int newVal   )
    {
        int i = count - 1;

        while(i >= 0 && newVal < arr[i]) {
            arr[i+1] = arr[i];
            i--;
        }

        arr[i+1] = newVal;

    }
}// END LAB #3

