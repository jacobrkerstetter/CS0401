import java.util.*;
import java.io.*;

public class Jumbles 
{
	public static void main(String[] args) throws Exception
	{

		// put command args in variables
		String dFile = args[0];
		String jFile = args[1];

		// declare ArrayLists
		ArrayList <String> jumbleWords = readFile(jFile);
		ArrayList <String> dictionary = readFile(dFile);
		ArrayList <String> pairs = new ArrayList <String>();

		// sort input ArrayLists
		Collections.sort(dictionary);
		Collections.sort(jumbleWords);

		// make pairs ArrayList
		for (String word: dictionary) {
			String pair = getCanonical(word) + " " + word;
			pairs.add(pair);
		}

		Collections.sort(pairs);

		// make ArrayLists for splitting
		ArrayList<String> dictCanons = new ArrayList<String>();
		ArrayList<String> dictWords = new ArrayList<String>();

		// enhanced for loop for splitting
		for (String element: pairs) {
			String[] pair = element.split("\\s+");
			dictCanons.add(pair[0]);
			dictWords.add(pair[1]);
		}
		
		for (String word: jumbleWords) {
			System.out.print(word + " ");

			String jumbleCanon = getCanonical(word);

			int index = Collections.binarySearch(dictCanons, jumbleCanon);

			if (index >= 0) { // match found
				int firstIndex = index;

				// get to the first instance
				while (firstIndex > 0 && dictCanons.get(index).equals(dictCanons.get(firstIndex-1))) {
					firstIndex--;
				}

				while (firstIndex < dictSize && dictCanons.get(index).equals(dictCanons.get(firstIndex))) {
					System.out.print(dictWords.get(firstIndex) + " ");
					firstIndex++;
				}
			}

			System.out.println();
		}

	} // END MAIN METHOD

	static String getCanonical(String word) 
	{
		char[] letters = word.toCharArray();
		Arrays.sort(letters);

		return new String(letters);
	} // END getCanonical METHOD

	static ArrayList<String> readFile(String file) throws Exception
	{
		ArrayList<String> fileWords = new ArrayList<String>();

		BufferedReader reader = new BufferedReader(new FileReader(file));

		while (reader.ready()) {
			fileWords.add(reader.readLine());
		}

		return fileWords;
	} // END readFile METHOD

} // END Jumbles CLASS