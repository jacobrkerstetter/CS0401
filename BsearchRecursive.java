/* Project3.java  InsertInOrder with bSearch optimization to compute insertion index */
// STUDENT STARTER FILE
// YOUR NAME/ID:

import java.util.*;
import java.io.*;

public class BsearchRecursive
{
    static final int INITIAL_CAPACITY = 5;
    
    public static void main( String args[] ) throws Exception
    {
        if (args.length < 1 )
        {
            System.out.println("ERROR: Must put input filename on cmd line\n");
            System.exit(0);
        }
        
        Scanner infile = new Scanner( new File( args[0] ) );        
               
        int[] arr = new int[INITIAL_CAPACITY];
        int count = 0;

        while ( infile.hasNextInt() )
        {
            if ( count==arr.length ) arr = upSizeArr(arr);
            if ( insertInOrder( arr, count, infile.nextInt() ) ) 
            ++count;
        }
        
        arr=trimArr(arr,count); // Now count == .length
        printArray( arr );  // we trimmed it thus count == length so we don't bother to pass in count
        
    }
    
    // ############################################################################################################
    
    static void printArray( int[] arr  )
    {
        for( int i=0 ; i<arr.length ;++i )
			System.out.print(arr[i] + " " );
        System.out.println();
    }
    
    static int[] upSizeArr( int[] fullArr )
    {
        int[] upSizedArr = new int[ fullArr.length * 2 ];
        for ( int i=0; i<fullArr.length ; ++i )
			upSizedArr[i] = fullArr[i];
        return upSizedArr;
    }
    
    static int[] trimArr( int[] oldArr, int count )
    {
        int[] trimmedArr = new int[ count ];
        for ( int i=0; i<count ; ++i )
			trimmedArr[i] = oldArr[i];
        return trimmedArr;
    }
    
    // REMOVE ALL COMMENTS FROM INSERT IN ORDER JUST BEFORE HANDIN
    static boolean insertInOrder( int[] arr, int count, int newVal )
    {
        int index = bSearch( arr, 0, count - 1, newVal );
        
    	if ( index >= 0 ) return false;

        index = -(index + 1);

        int i = count - 1;

        while (i >= index) {
            arr[i+1] = arr[i--];
        }

        arr[index] = newVal; 
        return true;
    }
    
    // REMOVE ALL COMMENTS FROM BSEARCH JUST BEFORE HANDIN
    static int bSearch(int[] a, int lo, int hi, int key)
    {
        int mid = lo + (hi - lo) / 2;

        if (lo > hi) return -(lo + 1);

        else if (a[mid] == key) return 1;

        else if (key > a[mid]) return bSearch(a, mid + 1, hi, key);

        else return bSearch(a, lo, mid - 1, key);
    }
}// END PROJECT3

