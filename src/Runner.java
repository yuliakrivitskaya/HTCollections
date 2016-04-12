
public class Runner {

	public static void main(String[] args) {

		// read input file
		FindMatches m = new FindMatches("text");

		// find matches
		m.findMatch("in");
		m.findMatch("Alice");
		m.findMatch("peace");

		// print result
		m.printResult();

	}

}
