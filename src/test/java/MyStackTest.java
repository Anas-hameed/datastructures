import static org.junit.Assert.*;
import Stack.StackImplementation.MyStack;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Exception;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {

	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	MyStack Temp;
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
		size= 10;
		Temp = new MyStack(size);	
	}

	// Pushing element test
	// Making stack overflow for throwing the Exception
	@Test(expected=Exception.class)
	public void pushExceptionTest() throws Exception{
		for(int i=0; i<=size; i++)
		{
			Temp.push(1);	
		}
	}

	// Adding 10 element in the stack
	// Display must return those 10 Element:- i-e : Stack : [ 0 1 2 3 4 5 6 7 8 9 ]
	@Test
	public void pushTest() {
		for(int i=0; i<size+1; i++ )
		{	
			try {
				Temp.push(i);
			} 
			catch (Exception e) {
			}	
		}
		resetBuffer();
		Temp.displayStack();
		String expectedString =  "Stack : [ 0 1 2 3 4 5 6 7 8 9 ]\r\n";
		assertEquals(expectedString, Output.toString());
	}

	// Popping out an Element from the Empty-stack
	@Test(expected=Exception.class)
	public void popExceptionTest() throws Exception{
		Temp = new MyStack(2);	
		Temp.pop();
	}

	// Pop-out 1 element from the stack after pushing 2 into it 
	// i-e Initial 		 ::	Stack = []
	// After Pushing 0,1 :: Stack = [0,1]
	// Pop an Element    :: Stack = [0]
	
	@Test
	public void popTest() {
		int size= 2;
		Temp = new MyStack(size);
		try {
			Temp.push(0);
			Temp.push(1);
		} catch (Exception e) {	
		}
		try {
			Temp.pop();
		} catch (Exception e) {
		}
		try {
			assertEquals(0, Temp.top());
		} catch (Exception e) {
		}
	}

	//	Checking top of an Empty stack
	// Must throw a exception
	@Test (expected=Exception.class)
	public void TopExceptionTest() throws Exception{			
		Temp.top();
	}
}
