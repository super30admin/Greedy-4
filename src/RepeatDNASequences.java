import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//time complexity : O(n)
public class RepeatDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {

		HashSet<String> allsub = new HashSet<>();
		HashSet<String> result = new HashSet<String>();

		for (int i = 0; i <=s.length() - 10; i++) {
			String substr = s.substring(i, i + 10);
			if (allsub.contains(substr)) {
				result.add(substr);
			}
			allsub.add(substr);
		}
		return new ArrayList<String>(result);

	}

	public static void main(String[] args) {
		RepeatDNASequences dna = new RepeatDNASequences();
		dna.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

	}
}
