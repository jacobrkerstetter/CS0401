import java.util. *;
import java.io.*;

public class Lab4
{
	public static void main(String[] args) throws Exception
	{
		// read user input text file and create ArrayList to put lines into
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		ArrayList <String> words = new ArrayList <String>(); 

		while (reader.ready()) {
			words.add(reader.readLine());
		}

		// sort words array
		Collections.sort(words);

		// enhanced for loop to print canonical form
		for (String word : words) {
			System.out.format("%s %s \n", word, getCanonical(word)); 
		} 
	} // END MAIN

	static String getCanonical(String word)
	{
		char[] letters = word.toCharArray();
		Arrays.sort(letters);
		return new String(letters);

	} // END getCanonical
} // END CLASS Lab4