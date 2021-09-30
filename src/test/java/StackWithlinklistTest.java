import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Stack.StackwithLinkedList.Stack;


public class StackWithlinklistTest {

	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	Stack Temp;
	int size;
	//	For Checking the console output
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(Output));
	}
	@After 
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	public void resetBuffer() {
		Output.reset();
	}

	@Before 
	public void IntializeStack(){
		size= 2;
		Temp = new Stack();	
	}



	// Adding 2 element in the stack
	// comparing value in reverse order
	@Test
	public void pushTest() {
		for(int i=0; i<size; i++ )
		{	
			Stack.push(i); 
		}
		resetBuffer();
		Stack.display();
		String Expected="\r\n"
				+ "Stack \r\n"
				+ "----------\r\n"
				+ "|   1   |\r\n"
				+ "----------\r\n"
				+ "|   0   |\r\n"
				+ "----------\r\n"
				+ "\r\n";
		assertEquals(Expected, Output.toString());
	}


	// Checking pop functionality
	// case 1:- Pop-out an element from an Empty     stack..
	// case 2:- Pop-out an element from an 1-element stack..
	// case 3:- Pop-out an element from an 2-element stack..
	@Test
	public void popTest() {
		//case 1 
		Stack.display();
		resetBuffer();
		Stack.pop();
		String Expected1="Empty Stack.\r\n";
		assertEquals(Expected1, Output.toString() );

		//case2
		Stack.push(0);
		Stack.pop();
		resetBuffer();
		Stack.display();
		String Expected2= "Stack is empty.\r\n";
		assertEquals(Expected2, Output.toString() );

		// case 3
		Stack.push(0);
		Stack.push(1);
		Stack.pop();
		resetBuffer();
		Stack.display();
		String Expected3= "\r\n"+ "Stack \r\n"
				+ "----------\r\n"
				+ "|   0   |\r\n"
				+ "----------\r\n"
				+ "\r\n";
		assertEquals(Expected3, Output.toString() );

	}

	// Checking top functionality
	// case 1:- Checking Top in an Empty     	   Stack..
	// case 2:- Checking Top in    1-element 	   Stack..
	// case 3:- Checking Top in  multiple-Element  Stack..
	// 
	@Test 
	public void topTest() {
		//case 1 
		int Actual1	 =Stack.top();
		int Expected1=-1;
		assertEquals(Expected1,Actual1 );

		//case2
		Stack.push(0);
		int Actual2	 = Stack.top();
		int Expected2= 0;
		assertEquals(Expected2,Actual2);

		// case 3
		Stack.push(0);
		Stack.push(1);
		int Actual3  = Stack.pop();
		int Expected3= 1;
		assertEquals(Expected3, Actual3 );

	}
}
