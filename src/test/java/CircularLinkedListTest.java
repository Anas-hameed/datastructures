import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import LinkedList.CircularLinkedList.CircularLinkedList;

public class CircularLinkedListTest {

	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	private CircularLinkedList list; 
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
		list= new CircularLinkedList();
	}
	@After
	public void Intialize() {
		list= null;
	}

	public void clearBuffer() {
		Output.reset();
	}
	//	Testing inserting at front.
	@Test
	public void pushFrontTest() {
		// case 1-> Pushing 1 at start to empty list
		// case 2-> Pushing 2 at start to that  list
		// case 3-> pushing 3,4,5 at start then asserted

		//assert 1
		CircularLinkedList.pushFront(1);
		clearBuffer();
		CircularLinkedList.display();
		String Expected1= "List : 1\r\n";
		assertEquals(Expected1, Output.toString());

		//assert 2
		CircularLinkedList.pushFront(2);
		clearBuffer();
		CircularLinkedList.display();
		String Expected2= "List : 2 1\r\n";
		assertEquals(Expected2, Output.toString());

		//Assert 3
		CircularLinkedList.pushFront(3);
		CircularLinkedList.pushFront(4);
		CircularLinkedList.pushFront(5);
		clearBuffer();
		CircularLinkedList.display();
		String Expected3= "List : 5 4 3 2 1\r\n";
		assertEquals(Expected3, Output.toString());
	}

	@Test 
	public void pushBackTest(){
		//	Pushing 1 at end to empty list
		// 	Pushing 2 at end to that  list
		// pushing 3,4,5 at end then asserted

		//assert 1
		CircularLinkedList.pushBack(1);
		clearBuffer();
		CircularLinkedList.display();
		String Expected1= "List : 1\r\n";
		assertEquals(Expected1, Output.toString());

		//assert 2
		CircularLinkedList.pushBack(2);
		clearBuffer();
		CircularLinkedList.display();
		String Expected2= "List : 1 2\r\n";
		assertEquals(Expected2, Output.toString());

		//Assert 3
		CircularLinkedList.pushBack(3);
		CircularLinkedList.pushBack(4);
		CircularLinkedList.pushBack(5);
		clearBuffer();
		CircularLinkedList.display();
		String Expected3= "List : 1 2 3 4 5\r\n";
		assertEquals(Expected3, Output.toString());		
	}

	//	Initializing an list 	
	private void intializeListWithRange(int start, int end) {
		CircularLinkedList.display();
		for(int i=start; i<=end ; i++ ) {
			CircularLinkedList.pushBack(i);
		}
	}


	//  case 1-> popFront in empty 
	//  case 2-> popFront in 1 element list.
	//	case 3-> Initialize Array(0 1 2 3 4 5 6 7 8 9) and popFront.
	@Test
	public void popFrontTest() {
		// Case 1
		CircularLinkedList.popFront();
		String Expected1= "PopFront Operation : Empty List.\r\n";
		assertEquals(Expected1, Output.toString());
		clearBuffer();

		// Case 2
		CircularLinkedList.pushBack(0);
		clearBuffer();
		CircularLinkedList.popFront();
		String Expected2= "PopFront Operation : Successfull.\r\n";
		assertEquals(Expected2, Output.toString());
		clearBuffer();

		// Case 3
		intializeListWithRange(0,9);
		CircularLinkedList.popFront();
		clearBuffer();
		CircularLinkedList.display();
		String Expected3= "List : 1 2 3 4 5 6 7 8 9\r\n";
		assertEquals(Expected3, Output.toString());	

	}
	
	//  case 1-> popBack in empty 
	//  case 2-> popBack in 1 element list.
	//	case 3-> Initialize list(0 1 2 3 4 5 6 7 8 9) and popFront.

	@Test
	public void popBackTest() {
		// Case 1
		CircularLinkedList.popBack();
		String Expected1= "PopBack Operation  : Empty List.\r\n";
		assertEquals(Expected1, Output.toString());
		clearBuffer();

		// Case 2
		CircularLinkedList.pushBack(0);
		clearBuffer();
		CircularLinkedList.popBack();
		String Expected2= "PopBack Operation  : Successfull.\r\n";
		assertEquals(Expected2, Output.toString());
		clearBuffer();
		
		
		//case 3
		intializeListWithRange(0,9);		
		CircularLinkedList.popBack();
		clearBuffer();
		CircularLinkedList.display();
		String Expected3= "List : 0 1 2 3 4 5 6 7 8\r\n";
		assertEquals(Expected3, Output.toString());

	}
}
