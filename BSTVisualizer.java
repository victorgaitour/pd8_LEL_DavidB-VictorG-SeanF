import java.util.*;
import java.lang.*;


public class BSTVisualizer <T> {
    ArrayList <T> tree;
    int size;

    public BSTVisualizer () {
	@SuppressWarnings("unchecked")
	ArrayList <T> t  = new ArrayList <T> ();
	tree = t;
	size = 0;
    }
    
    public void add (T data) {
	tree.add (data);
    }
	
    //put old BST stuff here


    public String toString () {
	String retStr = "";
	int parse = 1;
	int index = 0;
	boolean dash = false;
	int height = (int) (Math.log(size)/Math.log(2) * 2);
	while (index < tree.size()) { 
	    if (dash) {
		for (int i = height; height > 0; i --) {
		    retStr += " ";
		}
		for (int i = parse; i > 0; i--) {
		    retStr += "/  \\  ";
		}
		dash = false;
	    }
	
	    else{
		for (int i = parse; i > 0; i--) {
		    if (index < tree.size ()) {
			retStr = retStr + tree.get (index) + "  ";
			index ++;
		    }
		    else
			break;		 
		}
		dash = true;
		parse = parse * 2;
	    }
	    retStr += "\n";
	    height--;
	}
	return retStr;
    }

    @SuppressWarnings("unchecked")
    public static void main (String [] args) {
	BSTVisualizer test = new BSTVisualizer ();
	Integer a = new Integer (10);
	test.add (a);
	Integer b = new Integer (11);	
	test.add (b);
    }
}
	    
	    

	    