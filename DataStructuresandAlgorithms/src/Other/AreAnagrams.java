



public class AreAnagrams {
    public static boolean areAnagrams(String a, String b) {
       char[] charFromWord = a.toCharArray();
		// char[] charFromAnagram=a.toCharArray();

		StringBuilder sbSecond = new StringBuilder(b);
		for (char ch : charFromWord) {
			int index = sbSecond.indexOf("" + ch);
			if (index != -1) {
				sbSecond.deleteCharAt(index);
			} else {
				return false;
			}
		}
		return sbSecond.length() == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("momdad", "dadmom"));
    }
}