package assign04;

import java.util.Comparator;
import java.util.Scanner;

public class AnagramChecker {

	/**
	 * This method returns the lexicographically-sorted version of the input string.  
	 * The sorting must be accomplished using an insertion sort.
	 * @return String
	 */
	
	public static String sort (String a)
	{
		//Make all char lowercase for insertion sort to work properly.
		a = a.toLowerCase();
		char[] arr = a.toCharArray();
		
			for(int i = 1; i < a.length(); i++)
			{
				char val = arr[i]; 
				int j; 
				for(j = i - 1; j >= 0 && arr[j] > val; j--)
				{
					arr[j + 1] = arr[j]; 
				}
				arr[j + 1] = val; 
			}
			return String.valueOf(arr); 
	}
	
	/**
	 * This generic method sorts the input array using an insertion sort and the input Comparator object.
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> comp)
	{
		for(int i = 1; i < arr.length; i++)
		{
			T val = arr[i]; 
			int j; 
			for(j = i - 1; j >= 0 && comp.compare(arr[j], val) > 0; j--)
			{
				arr[j + 1] = arr[j]; 
			}
			arr[j + 1] = val; 
		}
	}
	
	/**
	 * This method returns true if the two input strings are anagrams of each other, otherwise returns false.
	 * @param a
	 * @param b
	 * @return boolean
	 */
	public static boolean areAnagrams(String a, String b)
	{
		if (AnagramChecker.sort(a).equals(AnagramChecker.sort(b)))
		{
			return true;
		}
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
		for (int i = 0; i < s.length; i ++)
		{
			AnagramChecker.sort(s[i]); 
		}
		Comparator<? super String> ourComparator = null;  
		AnagramChecker.insertionSort(s, ourComparator);
		
		int count1 = 0;
		int count2 = 0;
		
		int finalIndex = 0;
		
		for(int i = 0; i < s.length; i++)
		{
			if(AnagramChecker.areAnagrams(s[i], s[i+1]))
			{
				count1++;
			}
			else
			{
				if(count1 >= count2)
				{
					count2 = count1;
					finalIndex = i;
				}
				count1 = 0;
			}
		}
		
		String[] result = new String[count2];
		
		for(int j = 0; j < count2; j++)
		{
			result[j] = s[finalIndex];
		}
		
		return result;
	}
	
	/**
	 * This method behaves the same as the previous method, but reads the list of words from the input filename.  
	 * It is assumed that the file contains one word per line.  If the file does not exist or is empty, the method returns an empty array because there are no anagrams.
	 * @param filename
	 * @return
	 */
	public static String[] getLargestAnagramGroup(String filename)
	{
		return null; 
	}
	
}
