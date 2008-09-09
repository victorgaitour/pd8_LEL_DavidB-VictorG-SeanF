import java.util.*;

public class ArrayVisualizer {
    T [] vis;
    private int slot;
    
    public ArrayVisualizer (int size) {
	vis = new T [size];
	slot = 0;
    }
    
    public String toString () {
	System.out.print ( "[ ");
	for (T var : vis) {
	    System.out.print ( "," + var); //fix at home
	}
    }

   public void add (T stuff) {
	try{
	    vis [slot] = stuff;
	    slot ++;

	}
	catch (IndexOutOfBoundException e) {
	    System.out.println (e.getMessage() + ": Array is full");
	}
    }
   
    public void delete () {
	try{
	    vis [index] = null;
	}
	catch (IndexOutOfBoundException e) {
	    System.out.println (e.getMessage());
	}
    
    public void insert (int index,  T stuff) {
	try{
	    vis [index] = stuff;
	}
	catch (IndexOutOfBoundException e) {
	    System.out.println (e.getMessage());
	}
    }
   
    public void delete (int index) {
	try{
	    vis [index] = null;
	}
	catch (IndexOutOfBoundException e) {
	    System.out.println (e.getMessage());
	}
    }
}
	    
	    
	
    
	
	//if adding past length, return can't add anymore, stack
	
    
    