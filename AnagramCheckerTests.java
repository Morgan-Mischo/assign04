package assign04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramCheckerTests {

	@Test
	void sortString_AppleTest ()
	{
		String a = "apple"; 
		String expected = "aelpp"; 

		assertEquals(expected, AnagramChecker.sort(a)); 
	}
	
	@Test
	void sortString_UppercaseTest ()
	{
		String a = "AppLe"; 
		String expected = "aelpp"; 
		
		assertEquals(expected, AnagramChecker.sort(a)); 
	}
	
	@Test
	void sortString_Numbers ()
	{
		String a = "98765"; 
		String expected = "56789"; 
		
		assertEquals(expected, AnagramChecker.sort(a)); 
	}
	
	
	@Test
	void sortString_Long ()
	{
		String a = "zzzzyyyyxxxxwwwwvvvvuuuuttttssssrrrrqqqqppppoooonnnnmmmmllllkkkkjjjjiiiihhhhggggffffeeeeddddccccbbbbaaaa"; 
		String expected = "aaaabbbbccccddddeeeeffffgggghhhhiiiijjjjkkkkllllmmmmnnnnooooppppqqqqrrrrssssttttuuuuvvvvwwwwxxxxyyyyzzzz"; 
		
		assertEquals(expected, AnagramChecker.sort(a)); 
	}
	
	@Test
	void areAnagrams_True ()
	{
		String a = "fringe";
		String b = "finger";
		
		assertTrue(AnagramChecker.areAnagrams(a, b));
	}
	
	@Test
	void areAnagrams_False ()
	{
		String a = "Human";
		String b = "hummus";
		
		assertFalse(AnagramChecker.areAnagrams(a, b));
	}
}
