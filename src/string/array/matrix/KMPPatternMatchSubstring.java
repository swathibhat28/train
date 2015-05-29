package string.array.matrix;

/*
 * KMP Pattern Match is good for small string matches 
 * Involves two steps -
 * 1. Preprocessing where you calculate the longest prefix that matches the longest suffix
 * 2. Search
 * 
a         : no prefix and no suffix since there is only one letter
ab        : prefixes[a]
            suffixes[b]
abc       : prefixes[a,ab]
            suffixes[c,bc]
abca      : prefixes[a,ab,abc]
            suffixes[a,ca,bca]
abcab     : prefixes[a,ab,abc,abca]
            suffixes[b,ab,cab,bcab]
abcabd    : prefixes[a,ab,abc,abca,abcab]
            suffixes[d,bd,abd,cabd,bcabd]
abcabda   : prefixes[a,ab,abc,abca,abcab,abcabd]
            suffixes[a,da,bda,abda,cabda,bcabda]
abcabdab  : prefixes[a,ab,abc,abca,abcab,abcabd,abcabda]
            suffixes[b,ab,dab,bdab,abdab,cabdab,bcabdab]
abcabdabc : prefixes[a,ab,abc,abca,abcab,abcabd,abcabda,abcabdab]
            suffixes[c,bc,abc,dabc,bdabc,abdabc,cabdabc,bcabdabc,abcabdabc]
 */
public class KMPPatternMatchSubstring {
		 	 
	    /**
	     * Pre processes the pattern array based on proper prefixes and proper
	     * suffixes at every position of the array
	     * 
	     * @param ptrn
	     *            word that is to be searched in the search string
	     * @return partial match table which indicates
	     */
	    public int[] preProcessPattern(char[] ptrn) {
	        int i = 0, j = -1;
	        int ptrnLen = ptrn.length;
	        int[] b = new int[ptrnLen + 1];
	 
	        b[i] = j;
	        while (i < ptrnLen) {
	            while (j >= 0 && ptrn[i] != ptrn[j]) {
	                // if there is mismatch consider next widest border
	                j = b[j];
	            }
	            i++;
	            j++;
	            b[i] = j;
	        }
	        // print pettern, partial match table and index
	        System.out
	                .println("printing pattern, partial match table, and its index");
	        System.out.print(" ");
	        for (char c : ptrn) {
	            System.out.print(c + "   ");
	        }
	        System.out.println(" ");
	        for (int tmp : b) {
	            System.out.print(tmp + "   ");
	        }
	        System.out.print("\n ");
	        for (int l = 0; l < ptrn.length; l++) {
	            System.out.print(l + "   ");
	        }
	        System.out.println();
	        return b;
	    }
	 
	    /**
	     * Based on the pre processed array, search for the pattern in the text
	     * 
	     * @param text
	     *            text over which search happens
	     * @param ptrn
	     *            pattern that is to be searched
	     */
	    public void searchSubString(char[] text, char[] ptrn) {
	        int i = 0, j = 0;
	        // pattern and text lengths
	        int ptrnLen = ptrn.length;
	        int txtLen = text.length;
	 
	        // initialize new array and preprocess the pattern
	        int[] b = preProcessPattern(ptrn);
	 
	        while (i < txtLen) {
	            while (j >= 0 && text[i] != ptrn[j]) {
	                System.out.println("Mismatch happened, between text char "
	                        + text[i] + " and pattern char " + ptrn[j]
	                        + ", \nhence jumping the value of " + "j from " + j
	                        + " to " + b[j] + " at text index i at " + i
	                        + " based on partial match table");
	                j = b[j];
	            }
	            i++;
	            j++;
	 
	            // a match is found
	            if (j == ptrnLen) {
	                System.out.println("FOUND SUBSTRING AT i " + i + " and index:"
	                        + (i - ptrnLen));
	                System.out.println("Setting j from " + j + " to " + b[j]);
	                j = b[j];
	            }
	        }
	    }
	 
	    // only for test purposes
	    public static void main(String[] args) {
	    	KMPPatternMatchSubstring stm = new KMPPatternMatchSubstring();
	        // pattern
	        char[] ptrn = "abcabdabc".toCharArray();
	 
	        char[] text = "abcabdabcabeabcabdabcabd".toCharArray();
	        System.out.print(" ");
	        for (char c : text) {
	            System.out.print(c + "   ");
	        }
	        System.out.println();
	        // search for pattern in the string
	        stm.searchSubString(text, ptrn);
	    }
	

}
