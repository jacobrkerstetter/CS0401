// Lab1.java STARTER FILE

import java.io.*; // I/O
import java.util.*; // Scanner class

public class Lab1
{
	public static void main( String args[] ) 
	{
		final double MILES_PER_MARATHON = 26.21875; // i.e 26 miles 285 yards

		Scanner kbd = new Scanner (System.in);

		// THE FOLLOWING THREE VARIABLES ARE PRINTED OUT AT THE END OF THE PROGRAM
		double aveMPH=0, aveMinsPerMile=0, aveSecsPerMile=0;

		// YOUR JOB IS TO DO WHAT YOU HAVE TO TO TO PUT THE CORRECT VALUES INTO THEM
		// BEFORE THEY GET PRINTED OUT AT THE BOTTOM

		System.out.print("Enter marathon time in hrs minutes seconds: "); // i.e. 3 49 37
		// DO NOT WRITE OR MODIFY ANYTHING ABOVE THIS LINE

		
		//  - - - - - - - - - - - A L L   Y O U R   C O D E   H E R E - - - - - - - - - - - - - - - 
		
		// create conversion factors
		final double MINUTES_PER_HOUR = 60.0;
		final double SECONDS_PER_MINUTE = 60.0;
		final double SECONDS_PER_HOUR = 3600.0;

		// read input into 3 variables for hours, minutes, and seconds
		double marathonHours = kbd.nextDouble();
		double marathonMinutes = kbd.nextDouble();
		double marathonSeconds = kbd.nextDouble();

		// create total time as a decimal in hours for MPH calculation
		double fractionalMarathonHours = marathonHours + (marathonMinutes/MINUTES_PER_HOUR) + (marathonSeconds/SECONDS_PER_HOUR);
		aveMPH = MILES_PER_MARATHON/fractionalMarathonHours;

		// convert the fractional marathon in hours to be in minutes for mile spliit calculation
		double fractionalMarathonMinutes = fractionalMarathonHours * MINUTES_PER_HOUR;

		// divide marathon time in minutes by distance to get minutes per mile split
		double mileSplitFracMinutes = fractionalMarathonMinutes / MILES_PER_MARATHON;

		// separate the decimal and whole number using %1, then convert the decimal part to seconds
		aveMinsPerMile = mileSplitFracMinutes - mileSplitFracMinutes % 1;
		aveSecsPerMile = (mileSplitFracMinutes % 1) * SECONDS_PER_MINUTE;


		// DO NOT WRITE OR MODIFY ANYTHING BELOW THIS LINE. JUST LET MY CODE PRINT THE VALUES YOU PUT INTO THE 3 VARS
		System.out.println();
		System.out.format("Average MPH was: %.2f mph\n", aveMPH  );
		System.out.format("Average mile split was %.0f mins %.1f seconds per mile", aveMinsPerMile, aveSecsPerMile );
		System.out.println();

	} // END MAIN METHOD
} // EOF