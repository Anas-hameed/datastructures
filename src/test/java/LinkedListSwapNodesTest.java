import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import LinkedList.LinkedListSwapNodes.LinkedList;


public class LinkedListSwapNodesTest {

	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	private LinkedList list; 
	//	For Checking the console output
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(Output));
	}
	@After 
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Before 
	public void Intializelist() {
		list= new LinkedList();
	}
	@After
	public void Intialize() {
		list= null;
	}

	public void clearBuffer() {
		Output.reset();
	}


	//	Testing inserting at front.
	// case 1-> Pushing 1 at start to empty list
	// case 2-> Pushing 2 at start to that  list
	// case 3-> pushing 3,4,5 at start then asserted
	@Test
	public void pushFrontTest() {

		//assert 1
		LinkedList.pushFront(1);
		clearBuffer();
		LinkedList.display();
		String Expected1= "List : 1 \r\n";
		assertEquals(Expected1, Output.toString());

		//assert 2
		LinkedList.pushFront(2);
		clearBuffer();
		LinkedList.display();
		String Expected2= "List : 2 1 \r\n";
		assertEquals(Expected2, Output.toString());

		//Assert 3
		LinkedList.pushFront(3);
		LinkedList.pushFront(4);
		LinkedList.pushFront(5);
		clearBuffer();
		LinkedList.display();
		String Expected3= "List : 5 4 3 2 1 \r\n";
		assertEquals(Expected3, Output.toString());
	}

	// Push_back function test 
	// Pushing 1 at end to empty list
	// Pushing 2 at end to that  list
	// pushing 3,4,5 at end then asserted
	@Test 
	public void pushBackTest(){

		//assert 1
		LinkedList.pushBack(1);
		clearBuffer();
		LinkedList.display();
		String Expected1= "List : 1 \r\n";
		assertEquals(Expected1, Output.toString());

		//assert 2
		LinkedList.pushBack(2);
		clearBuffer();
		LinkedList.display();
		String Expected2= "List : 1 2 \r\n";
		assertEquals(Expected2, Output.toString());

		//Assert 3
		LinkedList.pushBack(3);
		LinkedList.pushBack(4);
		LinkedList.pushBack(5);
		clearBuffer();
		LinkedList.display();
		String Expected3= "List : 1 2 3 4 5 \r\n";
		assertEquals(Expected3, Output.toString());		
	}
	
	private void intializeListWithRange(int start, int end) {
		for(int i=start; i<=end ; i++ ) {
			LinkedList.pushBack(i);
		}
	}
	
	//	Swap function. The first Element is Swap with the last Element.
	// case 1:- Call on Empty      linked list
	// case 2:- Call on 01-Element linked list
	// case 3:- Call on 10-Element linked list
	@Test
	public void swapTest(){

		//assert 1
		LinkedList.swap();
		clearBuffer();
		LinkedList.display();
		String Expected1= "List : Empty.\r\n";			
		assertEquals(Expected1, Output.toString());

		//assert 2
		intializeListWithRange(0,0);  						//added 1-element
		LinkedList.swap();									
		clearBuffer();										
		LinkedList.display();								
		String Expected2= "List : 0 \r\n"; 				
		assertEquals(Expected2, Output.toString());			
															
		//Assert 3											
		intializeListWithRange(1,9); 						// added 8-element 
		LinkedList.swap();
		clearBuffer();
		LinkedList.display();
		String Expected3= "List : 9 1 2 3 4 5 6 7 8 0 \r\n";
		assertEquals(Expected3, Output.toString());		
	}
	
	

}
