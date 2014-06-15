import java.util.*;
import java.lang.*;
import java.io.*;

public class StackVisualizer <T> {
    public  ArrayList <T> vis;
    private int top;
    final static String ESC = "\033[";
    public int typenum = 0;
    public String type = "";
    Scanner sc;


    public StackVisualizer( ArrayList<T> lel){
	vis=lel;
	top = 0;
    }
    public StackVisualizer () {
	vis = new ArrayList <T> ();
	top = 0;
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
	    System.out.println ("Would you like to: \n1)Push \n2)Pop \n3)Peek");
	    
	    try {
		String cho = sc.next();
		choice = Integer.parseInt(cho);
		int index = -1;
		if (choice == 1) {
		    
		    System.out.println ("\n Push what value:");
		    boolean notvalid = true;
		
		    while (notvalid) {
			try {
			    String input = sc.next();
			    if (typenum == 1) {
				String tmp = new String (input);
				push ((T)tmp);
				mod = false;
				notvalid = false;
			    }
			    else {
				while (notvalid) {
				    try{
					int tmp = Integer.parseInt (input);
					Integer a = new Integer (tmp);
					push ((T) a);
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
		    System.out.println ("Popping:");
		    System.out.println (pop ());
		}
		else if (choice == 3) {
		    System.out.println ("Peeking :");
		    System.out.println (peek());
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


    public String Stringfy () {
	String retStr = "";
	for (int i = 0; i < this.vis.size(); i++) {
	    retStr += "" + this.vis.get (i) + ",";
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
    /*    public static void main (String [] args) {
	StackVisualizer a = new StackVisualizer ();
	Integer b = new Integer (7);
	a.push (b);
	a.modify ();
	}*/
	    
}
    
    
	
	
