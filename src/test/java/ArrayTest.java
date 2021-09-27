
import static org.junit.Assert.*;
import java.io.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Array.FullArray.Array;

public class ArrayTest {
	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	Array Arr;

	//	For Checking the console output
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(Output));
	}
	@After 
	public void restoreStreams() {
		System.setOut(originalOut);
		Arr=null;
	}

	// Default method to initialize array for each test	
	@Before
	public void IntializeArr() {
		Arr= new Array();
		int temp=9; 
		for(int i=0; i<10; i++ )
		{	
			Array.insert(temp, i);
			temp--;
		}	
	}

	//	insert function test. 
	@Test 
	public void insertTest() {
		// default-input :9 8 7 6 5 4 3 2 1 0			  => because of before function
		// Expected_output:10 9 0 8 7 6 5 4 3 2 1 0 \r\n  => Inserted 10 at position 4
		Array.insert(6, 4);
		String Expected="9 8 7 6 6 5 4 3 2 1 0 \r\n";
		Array.display();
		assertEquals(Expected, Output.toString());

	}

	//	Delete function 
	@Test
	public void deleteTest() {
		// original-input :9 8 7 6 5 4 3 2 1 0 
		// Expected-output:8 7 6 5 4 3 2 1 \r\n  
		// deleting 9 at index 0
		String Expected= "8 7 6 5 4 3 2 1 0 \r\n";
		Array.delete(0);
		Array.display();
		assertEquals(Expected, Output.toString());
	}


	@Test 
	public void linearSearchTest() {
		// original-input :9 8 7 6 5 4 3 2 1 0 

		//	finding 5  in the Array :- true (Expected) 
		assertTrue(Array.linearSearch(5));
		//  finding 0  in the Array :- true(Expected)
		assertTrue(Array.linearSearch(0));
		//	finding -1 in the Array :- false(Expected)
		assertFalse(Array.linearSearch(-1));
		//  finding 11 in the Array :- false(Expected)
		assertFalse(Array.linearSearch(11));
	}

	@Test 
	public void bubbleSortTest() {
		// original-input :9 8 7 6 5 4 3 2 1 0 
		// Expected-output:0 1 2 3 4 5 6 7 8 9 \r\n  
		String Expected= "0 1 2 3 4 5 6 7 8 9 \r\n";
		Array.bubbleSort();
		Array.display();
		assertEquals(Expected, Output.toString());
	}

	@Test
	public void binarySearchTest() {
		// original-input :9 8 7 6 5 4 3 2 1 0 
		int size= 10;
		//	Required a sorted array to apply the binary array.
		Array.bubbleSort();

		//	finding 5  in the Array :- true (Expected) 
		assertTrue(Array.binarySearch(5,0,size));
		//  finding 0  in the Array :- true(Expected)
		assertTrue(Array.binarySearch(0,0,size));
		//	finding -1 in the Array :- false(Expected)
		assertFalse(Array.binarySearch(-1,0, size));
		//  finding 11 in the Array :- false(Expected)
		assertFalse(Array.binarySearch(11,0,size));
	}

}