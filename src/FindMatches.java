import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * Class helps to find matches from input file with text
 * 
 * @author Yulia Krivitskaya
 *
 */
public class FindMatches {

	/** List of String contains all words from text after split */
	private List<String> text = new ArrayList<String>();

	/**
	 * Map of String - word which want to find and Integer - count of matches
	 */
	public Map<String, Integer> wordsForFind = new HashMap<String, Integer>();

	/**
	 * Constructor
	 * 
	 * @param filename
	 *            - name of file with input text
	 */
	public FindMatches(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename + ".txt"))) {
			// read to line
			String s;
			while ((s = br.readLine()) != null) {
				// Create list of words
				createList(s);
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Additional method to create list of words after splitting
	 * 
	 * @param s
	 *            - line from text
	 */
	private void createList(String s) {
		String[] params;
		params = s.split("[ ,!?;:.\"’`]+|[ - ]");
		for (int i = 0; i < params.length; i++) {
			text.add(params[i]);
		}
	}

	/**
	 * Method to find matches from List<String> text
	 * 
	 * @param word
	 *            - word witch should be found
	 */
	public void findMatch(String word) {
		// count of matches (default = 0)
		int count = 0;
		for (String t : text) {
			if (t.toLowerCase().equals(word.toLowerCase())) {
				count++;
			}
		}
		// put in public Map<String, Integer> wordsForFind result
		wordsForFind.put(word, count);

	}

	/**
	 * Method print result of find
	 */
	public void printResult() {
		for (Entry<String, Integer> entry : wordsForFind.entrySet()) {
			if (entry.getValue() == 0) {
				System.out.println("Word: \"" + entry.getKey() + "\" was not used ");
			}
			if (entry.getValue() > 1) {
				System.out.println("Word: \"" + entry.getKey() + "\" was used " + entry.getValue() + " times");
			}

		}

	}

}
