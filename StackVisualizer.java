import java.util.*;
import java.lang.*;

public class StackVisualizer <T> {
    private  ArrayList <T> vis;
    private int top;
    final static String ESC = "\033[";

    public StackVisualizer( ArrayList<T> lel){
	vis=lel;
	top = 0;
    }
    public StackVisualizer () {
	vis = new ArrayList <T> ();
	top = 0;
    }
    
    public void push (T stuff) { 
	vis.add (stuff);
	top ++;
	System.out.print(ESC + "2J"); //clear the screen
	System.out.println(vis); 
    }

    public T pop () {
	top --;
	try {
	    T tmp = vis.remove (top + 1);
	    System.out.print(ESC + "2J"); //clear the screen
	    System.out.println(vis); 
	    return tmp;
	}
	catch (Exception e ) {	
	    System.out.println (e.getMessage() + ": Stack is empty");
	    return null;
	}
	    
    }

    public T peek (){
	try {
	    T tmp = vis.remove (top);
	    System.out.print(ESC + "2J"); //clear the screen
	    System.out.println(vis); 
	    return tmp;
	}
	catch (Exception e ) {	
	    System.out.println (e.getMessage() + ": Stack is empty");
	    return null;
	}
    }
}
    
    
	
	