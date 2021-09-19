import java.io.*;
import java.util.*;

// DO NOT!! IMPORT JAVA.LANG

public class Swamp
{
	static int[][] swamp;  // NOW YOU DON'T HAVE PASS THE REF IN/OUT METHODS

 	public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2]; // row and col will be on the 2nd line of input file;
		swamp = loadSwamp( args[0], dropInPt );
		int row = dropInPt[0], col = dropInPt[1];
		findPathOut( row, col, swamp ); // dropped in a row,col coords
	} // END MAIN

 	// JUST FOR YOUR DEBUGGING - DELETE THIS METHOD AND ITS CALL BEFORE HANDIN
	// ----------------------------------------------------------------
	private static void printSwamp(String label, int[][] swamp )
	{
		System.out.println( label );
		System.out.print("   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print( c + " " ) ;
		System.out.print( "\n   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");

		for(int r = 0; r < swamp.length; r++)
		{	System.out.print( r + "| ");
			for(int c = 0; c < swamp[r].length; c++)
				System.out.print( swamp[r][c] + " ");
			System.out.println("|");
		}
		System.out.print( "   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");
	}
	// --YOU-- WRITE THIS METHOD (LOOK AT PRINTSWAMP FOR CLUES)
   	// ----------------------------------------------------------------
	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
	{
		// OPEN UP A SCANNER USING THE INCOMING FILENAME
		// THE FIRST NUMBER ON THE FIRST LINE WILL BE THE NUMBER OF ROWS & COLS
		// THE SECOND & THIRD NUMBER ON 1st LINE WILL BE THE DROP IN POINT X,Y
		// STORE SEOND NUMBER INTO dropInPt[0] THIRD # INTO dropInPt[1]
		// USING ROW, COL DEFINE A 2D ARRAY OF INT
		// USE A NESTED LOOP. OUTER LOOP ROWS, INNER LOOP COLS
		// READ IN THE GRID OF VALUES FROM THE INPUT FILE
		// CLOSE THE SCANNER
		// RETURN THE 2D ARRAY WITH VALUES LOADED INTO IT

		Scanner readFile = new Scanner(new File(infileName));

		int rows = readFile.nextInt();
		int cols = rows;

		dropInPt[0] = readFile.nextInt();
		dropInPt[1] = readFile.nextInt();

		int[][] swamp = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				swamp[i][j] = readFile.nextInt();
			}
		}

		readFile.close();

		return swamp;  // JUST TO MAKE IT COMPILE
	}

	static void findPathOut( int row, int col, int[][] swamp ) 
	{

		System.out.format("[%d,%d]", row, col);

		while (row != 0 && row != 9 && col != 0 && col != 9) 
		{
			swamp[row][col] = 0;

			int clear = 1;

			if (swamp[row - 1][col] == clear)
				row -= 1;
			else if (swamp[row - 1][col + 1] == clear) {
				row -= 1;
				col += 1;
			}
			else if (swamp[row][col + 1] == clear) 
				col += 1;
			else if (swamp[row + 1][col + 1] == clear) {
				row += 1;
				col += 1;
			}
			else if (swamp[row + 1][col] == clear)
				row += 1;
			else if (swamp[row + 1][col - 1] == clear) {
				row += 1;
				col -= 1;
			}
			else if (swamp[row][col - 1] == clear)
				col -= 1;
			else {
				row -= 1;
				col -= 1;
			}
				
			System.out.format("[%d,%d]", row, col);
		}
	}	
}
