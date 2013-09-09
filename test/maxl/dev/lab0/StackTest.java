package maxl.dev.lab0;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Максим
 * Date: 09.09.13
 * Time: 23:52
 */
public class StackTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testPush() throws Exception {
        Stack<Double> stack = new Stack<Double>();

        stack.push(12343.0);
        assertFalse(stack.isEmpty());
        assertFalse(stack.isFull());
        assertEquals(new Double(12343.0), stack.peek());

        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        stack.push(5.0);

        exception.expect(Exception.class);
        exception.expectMessage("Stack is full");
        stack.push(666.0);
    }

    @Test
    public void testPop() throws Exception {
        Stack<Integer> stack = new Stack<Integer>();

        exception.expect(EmptyStackException.class);
        stack.pop();

        stack.push(1);
        stack.push(2);
        assertEquals(new Integer(2), stack.pop());

        stack.pop();
        exception.expect(EmptyStackException.class);
        stack.pop();
    }

    @Test
    public void testPeek() throws Exception {
        Stack<String> stack = new Stack<String>();

        stack.push("First");
        assertEquals("First", stack.peek());

        stack.push("Second");
        stack.push("Third");
        assertEquals("Third", stack.peek());
    }

    @Test
    public void testIsEmpty() throws Exception {
        Stack<String> stack = new Stack<String>();
        assertTrue(stack.isEmpty());

        stack.push("aaaa");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsFull() throws Exception {
        Stack<String> stack = new Stack<String>();
        assertFalse(stack.isFull());

        stack.push("aaaa");
        stack.push("bbbb");
        stack.push("cccc");
        stack.push("dddd");
        stack.push("eeee");
        assertTrue(stack.isFull());
    }
}
