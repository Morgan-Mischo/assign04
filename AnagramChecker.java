package assign04;

public class AnagramChecker {

	/**
	 * This method returns the lexicographically-sorted version of the input string.  
	 * The sorting must be accomplished using an insertion sort.
	 * @return String
	 */
	
	public static String sort (String a)
	{
		return null; 
	}
	
	/**
	 * This generic method sorts the input array using an insertion sort and the input Comparator object.
	 */
	public static <T> void insertionSort(T[] s, Comparator<? super T>)
	{
		
	}
	
	/**
	 * This method returns true if the two input strings are anagrams of each other, otherwise returns false.
	 * @param a
	 * @param b
	 * @return boolean
	 */
	public static boolean areAnagrams(String a, String b)
	{
		return false; 
	}
	
	/**
	 * This method returns the largest group of anagrams in the input array of words, in no particular order.  
	 * It returns an empty array if there are no anagrams in the input array. 
	 * @param s
	 * @return
	 */
	public static String[] getLargestAnagramGroup(String[] s)
	{
		return null; 
	}
	
	/**
	 * This method behaves the same as the previous method, but reads the list of words from the input filename.  It is assumed that the file contains one word per line.  If the file does not exist or is empty, the method returns an empty array because there are no anagrams.
	 * @param filename
	 * @return
	 */
	public static String[] getLargestAnagramGroup(String filename)
	{
		return null; 
	}
	
}