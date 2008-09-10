import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;


public class ArrayVisualizer <T> {
    T [] vis;
    private int slot;
    
    public ArrayVisualizer (T type, int size) {
	@SuppressWarnings("unchecked")
	vis = (T[]) Array.newInstance (type , size);
	slot = 0;
    }
    
    public void print () {
	System.out.print ( "[ ");
	for (int i = 0; i < vis.length - 1; i ++ ) {
	    if (vis [i] == null) 
		System.out.print ( " ,");
	    else
		System.out.print ( vis [i] + ","); 
	}
	if (vis [vis.length - 1] == null) 
	    System.out.print ( " ]");
	else
	    System.out.print ( vis [vis.length - 1] + " ]");
    }

    public void add (T stuff) {//adds to next empty slot in array
	try{
	    while (vis [slot] != null) 
		slot ++;
	    vis [slot] = stuff;
	    slot ++;
	}
	catch (Exception e) {
	    System.out.println (e.getMessage() + ": Array is full");
	}
    }
   
    public void delete () {//deletes rightmost value in array
	try{
	    while (vis [slot] == null) 
		slot --;
	    vis [slot] = null;
	    slot --;
	}
	catch (Exception e) {
	    System.out.println (e.getMessage());
	}
    }
    
    public void insert (int index,  T stuff) {
	try{
	    vis [index] = stuff;
	}
	catch (Exception e) {
	    System.out.println (e.getMessage());
	}
    }
   
    public void delete (int index) {
	try{
	    vis [index] = null;
	}
	catch (Exception e) {
	    System.out.println (e.getMessage());
	}
    }
}
	    
	    
	
    
	
	//if adding past length, return can't add anymore, stack
	
    
    