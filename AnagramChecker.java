
package assign04;



import java.io.File;

import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.Comparator;

import java.util.Scanner;

/**
 * Class that checks if inputs are anagrams
 * 
 * @author Morgan Mischo and Casey Rand
 *
 */

public class AnagramChecker {



	/**

	 * This method returns the lexicographically-sorted version of the input string.  

	 * The sorting must be accomplished using an insertion sort.

	 * @return String

	 */

	

	public static String sort (String a)

	{

		//Make all char lowercase for insertion sort to work properly.

		//a = a.toLowerCase();

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

		a = a.toLowerCase();

		b = b.toLowerCase();

		if (AnagramChecker.sort(a).equals(AnagramChecker.sort(b)))

		{

			return true;

		}

		return false; 

	}

	

	/**

	 * This method returns the largest group of anagrams in the input array of words, in no particular order.  

	 * It returns an empty array if there are no anagrams in the input array. 

	 * @param arr

	 * @return

	 */

	public static String[] getLargestAnagramGroup(String[] arr)

	{

		AnagramChecker.insertionSort(arr, (lhs, rhs) -> AnagramChecker.sort(lhs).compareTo(AnagramChecker.sort(rhs)));

		String[] result = new String[0];
		ArrayList<String> arraylist1 = new ArrayList<String>();
		ArrayList<String> maxarraylist = new ArrayList<String>();

		for(int i=0; i < arr.length - 1; i++)
		{
			if(arraylist1.size() == 0) {
				arraylist1.add(arr[i]);
			}

			if(AnagramChecker.areAnagrams(arr[i], arr[i+1]))
			{
				arraylist1.add(arr[i+1]);
			}

			else if(arraylist1.size() > maxarraylist.size())
			{
				maxarraylist.clear();
				maxarraylist.addAll(arraylist1);
				arraylist1.clear();
			}

			else
			{
				arraylist1.clear();
			}
		}

		result = maxarraylist.toArray(result);
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

		File file = new File(filename); 

		String[] arr = new String[0]; 

		

		Scanner scn;

		try {

			scn = new Scanner(file);

		

		ArrayList<String> initial = new ArrayList<String>();

		

		while(scn.hasNextLine())

		{

			initial.add(scn.nextLine()); 

		}

		scn.close();

		

		arr = initial.toArray(arr);

		

		} catch (FileNotFoundException e) {

			return arr;

		}

		

		return AnagramChecker.getLargestAnagramGroup(arr);

	}

}
