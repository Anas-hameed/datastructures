import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Stack.StackwithArray.Stack;


public class StackWithArrayTest {

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
		size= 100;
		Temp = new Stack();	
	}



	// Adding 101 element in the stack to make the stack overflow and meet all condition
	// Displaying and comparing actual value
	@Test
	public void pushTest() {
		for(int i=0; i<size+1; i++ )
		{	
			Stack.push(i); 
		}
		resetBuffer();
		Stack.display();
		String expectedString =  "Stack : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 \r\n";
		assertEquals(expectedString, Output.toString());
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
		String Expected1="Stack is Empty!\r\n";
		assertEquals(Expected1, Output.toString() );
		
		//case2
		Stack.push(0);
		Stack.pop();
		resetBuffer();
		Stack.display();
		String Expected2= "Empty Stack.\r\n";
		assertEquals(Expected2, Output.toString() );
		
		// case 3
		Stack.push(0);
		Stack.push(1);
		Stack.pop();
		resetBuffer();
		Stack.display();
		String Expected3= "Stack : 0 \r\n";
		assertEquals(Expected3, Output.toString() );

	}


}
