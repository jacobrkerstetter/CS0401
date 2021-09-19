// EXTRA CREDIT PROGRAM CS 401 SPRING 2018  WORTH 1% COURSE CREDIT
import java.util.*;
import java.io.*;

public class Mult
{
	public static void main(String [] args)
	{	// CHANGE NOTHING IN MAIN
		System.out.println(  mult( Integer.parseInt(args[0]), Integer.parseInt(args[1]) )  );
	}
	// RETURN THE PRODUCT OF a * b
	static int mult( int a, int b )
	{
		if (a == 0 || b == 0) return 0;

		if (a > 0) return b + mult(a - 1, b);
		else return -b + mult(a + 1, b);
	}
}

