package com.eshop.test;

import java.util.Arrays;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class ListContainsAllTest {

	public void testListContainsAllString(){

		List<String> list1 = Arrays.asList("Sandeep", "Dipti");
		
		List<String> list2 = Arrays.asList("Dipti", "Sandeep" );
	
		AssertJUnit.assertTrue(list1.containsAll(list2));
		
	}

	public void testListEqualsString(){

		List<String> list1 = Arrays.asList("Sandeep", "Dipti");
		
		List<String> list2 = Arrays.asList("Sandeep", "Dipti");
	
		AssertJUnit.assertTrue(list1.equals(list2));
		
	}

}
