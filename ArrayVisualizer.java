import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.lang.Object.*;
import java.io.FileWriter;
import java.io.IOException;

public class ArrayVisualizer <T> extends Visualizer<T>{
    private  T[] vis;
    private int slot;
    final static String ESC = "\033[";
    private Scanner sc;
    private int typenum = 0;
    private int size;
    
    public ArrayVisualizer (int size) {
	@SuppressWarnings("unchecked")
	T[] s =(T[]) new Object[size];
	vis = s;
	slot = 0;
	this.size = size;

	String type = "";
	sc = new Scanner(System.in);
	System.out.println( "Which Data Type: \nString \nInteger\n" );
	while (type.equals("")) {
	    try {
		type = sc.next();
		if (type.equals ("String") || type.equals ("string")) {
		    typenum = 1;
		}
		else if (type.equals("Integer") || type.equals("integer")) {
		    typenum = 2;
		}
		else {
		    type = "";
		    System.out.println( "ERROR: Please enter a valid data type and do not use spaces" );
		}
	    }

	    catch (Exception e) {
		type = "";
		System.out.println( "ERROR: Please enter a valid data type and do not use spaces" );
	    }
	}
    }


    

    public void modify () {
	boolean mod = true;
	int choice;
	while (mod){
	    System.out.println ("\nWould you like to: \n1)Add an element \n2)Remove an index \n3)Set an index \n4)Get an index");

	    try {
		String cho = sc.next();
		choice = Integer.parseInt (cho);
		int index = -1;
		if (choice == 1) {
		    System.out.println ("\nAdd at what index :");
		    while (index == -1) {
			try {
			    String line = sc.next();
			    index = Integer.parseInt (line);
			    if (index > size){
				System.out.println( "ERROR: Please input a valid index" );
				index = -1;
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid index" );
			}
		    }


		    System.out.println ("Add what value:");
		    boolean notvalid = true;


		    while (notvalid) {
			try {
			    String input = sc.next();
			    if (typenum == 1) {
				String tmp = new String (input);
				add (index, (T)tmp);
				mod = false;
				notvalid = false;
			    }
			    else {
				while (notvalid) {
				    try{
					int tmp = Integer.parseInt (input);
					Integer a = new Integer (tmp);
					add (index,(T) a);
					mod = false;
					notvalid = false;
				    }
				    catch (Exception e) {
					System.out.println( "ERROR: Please input valid Integer" );
					input = sc.next();
				    }
				}
			    }


			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input the correct data type" );
			}
		    }
		}


		else if (choice == 2) {
		    System.out.println ("Remove what index :");
		    while (index == -1) {
			try {
			    String ind = sc.next();
			    index = Integer.parseInt (ind);
			    if (index > size - 1){
				System.out.println( "ERROR: Please input a valid index" );
				index = -1;
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid index" );
			}
		    }
		    System.out.println ("\n" + delete (index));
		    mod = false;
		}

		else if (choice == 3) {
		    System.out.println ("Set what index :");
		    while (index == -1) {
			try {
			    String line = sc.next();
			    index = Integer.parseInt (line);
			    if (index > size){
				System.out.println( "ERROR: Please input a valid index" );
				index = -1;
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid index" );
			}
		    }
		    System.out.println ("Set to what value:");
		    boolean notvalid = true;


		    while (notvalid) {
			try {
			    String input = sc.next();
			    if (typenum == 1) {
				set (index, (T) input);
				mod = false;
				notvalid = false;
			    }
			    else {
				while (notvalid) {
				    try{
					int tmp = Integer.parseInt (input);
					Integer a = new Integer (tmp);
					add (index,(T) a);
					mod = false;
					notvalid = false;
				    }
				    catch (Exception e) {
					System.out.println( "ERROR: Please input valid Integer" );
					input = sc.next();
				    }
				}
			    }

			}


			catch (Exception e) {
			    System.out.println( "ERROR: Please input the correct data type" );
			}
		    }
		}


		else if (choice == 4) {
		    System.out.println ("Get what index :");
		    while (index == -1) {
			try {
			    String ind = sc.next();
			    index = Integer.parseInt (ind);
			    if (index > size - 1){
				System.out.println( "ERROR: Please input a valid index" );
				index = -1;
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid index" );
			}
		    }
		    System.out.println ("" + get(index));
		    mod = false;
		}
		else {
		    System.out.println( "ERROR: Please input a valid choice" );
		}




	    }
	    catch (Exception e) {
		System.out.println( "ERROR: Please input a valid int" );
	    }
	}
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
	    System.out.print ( vis [vis.length - 1] + " ]\n");
    }

    public void add (int index, T stuff) {
	try{
	    vis [index] = stuff;
	    System.out.print(ESC + "2J"); //clear the screen
	    this.print ();
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
	    System.out.print(ESC + "2J"); //clear the screen
	    this.print ();
	}
	catch (Exception e) {
	    System.out.println (e.getMessage());
	}
    }
    
    /*    public void insert (int index,  T stuff) {
	try{

	    vis [index] = stuff;
	    System.out.print(ESC + "2J"); //clear the screen
	    this.print ();
	}
	catch (Exception e) {
	    System.out.println (e.getMessage());
	}
	} */ 
   
    public T delete (int index) {
	try{
	    T tmp = vis [index];
	    vis [index] = null;
	    System.out.print(ESC + "2J"); //clear the screen
	    this.print ();
	    return tmp;
	}
	catch (Exception e) {
	    System.out.println (e.getMessage());
	}
	return null;
    }

    public void set (int index, T value) {
	try{
	    vis [index] = value;
	    System.out.print(ESC + "2J"); //clear the screen
	    this.print ();
	}
	catch (Exception e) {
	    System.out.println (e.getMessage());
	}
    }
    
    public T get (int index) {
	try{
	    return vis [index];
	}
	catch (Exception e) {
	    System.out.println ("Index out of bounds");
	    return null;
	}
       
    }

    public String Stringfy () {
	String retStr = "";
	for (int i = 0; i < size; i++) {
	    retStr += "" + get (i) + ",";
	}
	//	System.out.println (retStr);
	return retStr;
    }

	
	
    public void writeCSV (String FileName) {
	try{
		FileWriter writer = new FileWriter(FileName);
		for (char ch: this.Stringfy().toCharArray()) {
		    writer.append (ch);
		}
		writer.flush();
		writer.close();
	}
	catch(IOException e){
	    System.out.println ("Error: Conversion error");
	} 
    }

    /*public static void main (String [] args) {
    	ArrayVisualizer test = new ArrayVisualizer (5);
	Integer a = new Integer (10);
	test.add (0, a);
   	System.out.println(test.Stringfy().toCharArray());
    	test.modify ();
	}*/
    
}
	    
