package maxl.dev.lab0;

import java.util.EmptyStackException;

/**
 * Created with IntelliJ IDEA.
 * User: Максим
 * Date: 09.09.13
 * Time: 21:21
 */
public class Stack<T> {
    public final int maxSize = 5;
    private Object[] stackArray;
    private int sp;

    public Stack() {
        stackArray = new Object[maxSize];
        sp = -1;
    }

    public void push(T a) throws Exception {
        if (sp == 5) throw new Exception("Stack is full");
        stackArray[sp] = a;
        sp++;
    }

    public T pop() {
        if (sp == -1) throw new EmptyStackException();
        return (T) stackArray[sp--];
    }

    public T peek() {
        if (sp == -1) throw new EmptyStackException();
        return (T) stackArray[sp];
    }

    public boolean isEmpty() {
        return (sp == -1);
    }

    public boolean isFull() {
        return (sp == maxSize - 1);
    }

    public static void main(String[] args) {
        Stack<Integer> theStack = new Stack<Integer>();
        try {
            theStack.push(10);
            theStack.push(20);
            theStack.push(30);
            theStack.push(40);
            theStack.push(50);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int a = theStack.pop();
        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println(a);
    }
}
