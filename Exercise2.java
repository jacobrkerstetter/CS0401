/*
	Exercise2.java
	- WRITE A SINGLE DO LOOP THAT DOES THE FOLLOWING UNTIL THE USER ENTERS AN INT IN 1..100 INCLUSIVE
	- 	USE TRY CATCH TO READ AN INT FROM THE KBD SUCH THAT IF USER ENTERS "FOO" IT DOES NOT CRASH
	- 	BE SURE TO MANUALLY THROW AN EXCEPTION & CATCH IT FOR THE CASE OF USER ENTERING AN VALID 
	-	INT THAT HAPPENS TO BE OUT OF RANGE.

*/
import java.io.*;
import java.util.*;

public class Exercise2
{
	public static void main( String args[] )
	{
		// MODIFY, REPLACE, ADD LOOP CODE, ADD TRY CATCH BLOCK(S) AS NEEDED BELOW
		Scanner kbd = new Scanner(System.in);
		boolean inRange = false;
		String discard = "";

		do
		{
			int userNum = 0;
			System.out.print("Enter int in range 1..100 inclusive: ");

			try
			{
				userNum = kbd.nextInt();

				if (userNum >= 1 && userNum <= 100) {
					System.out.format("\nThank you. You entered %d\n", userNum);
					inRange = true;
				}
				else
					throw new Exception();
			}
			catch (InputMismatchException ime)
			{
				discard = kbd.nextLine();
				System.out.println("Input was not an integer");
			}
			catch (Exception e)
			{
				discard = kbd.nextLine();
				System.out.println("Number:" + userNum + " out of range. Must be in 1..100");
			}

		} while (!inRange);
		
	} //END main
} //END CLASS