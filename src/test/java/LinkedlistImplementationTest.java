import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LinkedList.LinkedListImplementation.LinkedList;


public class LinkedlistImplementationTest {

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
	public void RestIntialize() {
		LinkedList.numofElements=0;
		LinkedList.headPointer=null;
		LinkedList.tailPointer=null;
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
		list= new LinkedList();
		//assert 1
		list.pushFront(1);
		clearBuffer();
		list.display();
		String Expected1= "LinkedList : [ 1 ]\r\n";
		assertEquals(Expected1, Output.toString());

		//assert 2
		list.pushFront(2);
		clearBuffer();
		list.display();
		String Expected2= "LinkedList : [ 2 1 ]\r\n";
		assertEquals(Expected2, Output.toString());

		//Assert 3
		list.pushFront(3);
		list.pushFront(4);
		list.pushFront(5);
		clearBuffer();
		list.display();
		String Expected3= "LinkedList : [ 5 4 3 2 1 ]\r\n";
		assertEquals(Expected3, Output.toString());
	}

	// Case 1 :: Pushing 1 at end to empty list
	// Case 2 :: Pushing 2 at end to that  list
	// Case 3 :: pushing 3,4,5 at end then asserted
	@Test 
	public void pushBackTest(){

		//assert 1
		list.pushBack(1);
		clearBuffer();
		list.display();
		String Expected1= "LinkedList : [ 1 ]\r\n";
		assertEquals(Expected1, Output.toString());

		//assert 2
		list.pushBack(2);
		clearBuffer();
		list.display();
		String Expected2= "LinkedList : [ 1 2 ]\r\n";
		assertEquals(Expected2, Output.toString());

		//Assert 3
		list.pushBack(3);
		list.pushBack(4);
		list.pushBack(5);
		clearBuffer();
		list.display();
		String Expected3= "LinkedList : [ 1 2 3 4 5 ]\r\n";
		assertEquals(Expected3, Output.toString());		
	}

	// Adding An Element Test
	// Case 1 :: Adding 1 at end to empty list
	// Case 2 :: Adding 2 at end to that  list
	// Case 3 :: Adding 3,4,5 at end then asserted
	@Test
	public void addTest(){
		//assert 1
		list.add(1);
		clearBuffer();
		list.display();
		String Expected1= "LinkedList : [ 1 ]\r\n";
		assertEquals(Expected1, Output.toString());

		//assert 2
		list.add(2);
		clearBuffer();
		list.display();
		String Expected2= "LinkedList : [ 1 2 ]\r\n";
		assertEquals(Expected2, Output.toString());

		//Assert 3
		list.add(3);
		list.add(4);
		list.add(5);
		clearBuffer();
		list.display();
		String Expected3= "LinkedList : [ 1 2 3 4 5 ]\r\n";
		assertEquals(Expected3, Output.toString());		
	}


	//	Initializing an list 	
	private void intializeListWithRange(int start, int end) {
		list.display();
		for(int i=start; i<=end ; i++ ) {
			list.pushBack(i);
		}
	}

	//  case 1-> popFront in empty Linked list
	//	case 2-> Initialize list as [0] and popFront.
	//	case 3-> Initialize list as [0 1 2 3 4 5 6 7 8 9] and popFront.
	@Test
	public void popFrontTest() {
		// Case 1
		try {
			list.popFront();
		} catch (Exception e) {
			String Expected1= "LinkedList is empty";
			assertEquals(Expected1, e.getMessage());
		}
		intializeListWithRange(0,0);
		try {
			list.popFront();
		} catch (Exception e) {}
		clearBuffer();
		list.display();
		String Expected2= "LinkedList : [ ]\r\n";
		assertEquals(Expected2, Output.toString());	


		// Case 3
		intializeListWithRange(0,9);
		try {
			list.popFront();
		} catch (Exception e) {}
		clearBuffer();
		list.display();
		String Expected3= "LinkedList : [ 1 2 3 4 5 6 7 8 9 ]\r\n";
		assertEquals(Expected3, Output.toString());	

	}

	//  Getter setter for top_front and top_back and size
	//  case 1: checking top and back in an empty stack.
	//  case 2: check  top and back having multiple elements [0 1 2]
	@Test
	public void TopFrontBackTest() {
		// Case 1
		try {
			list.topFront();
		} catch (Exception e) {
			String Expected1= "LinkedList is empty";
			assertEquals(Expected1, e.getMessage());
		}
		try {
			list.topBack();
		} catch (Exception e) {
			String Expected1= "LinkedList is empty!";
			assertEquals(Expected1, e.getMessage());
		}
		
		
		// Case 2
		intializeListWithRange(0,2);
		clearBuffer();
		int x1=0, x2=0;
		try {
			x1=list.topFront();
			x2=list.topBack();
		} catch (Exception e) {}
		
		assertEquals(0, x1);
		assertEquals(2, x2);

	}

}
