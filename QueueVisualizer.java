import java.util.*;
import java.io.*;
import java.lang.*;
public class QueueVisualizer<T>{
    private ALQueue<T> queue;
    private String ESC="\033[";
    Scanner sc;
    int typenum=0;
    String type="";
    public QueueVisualizer(){
	queue= new ALQueue<T>();
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
	    System.out.println ("Would you like to: \n1)Add a value \n2)Remove Min \n3)Peek Min");
	    try {
		String cho = sc.next();
		choice = Integer.parseInt(cho);
		int index = -1;
		if (choice == 1) {

		    System.out.println ("\n Add what value:");
		    boolean notvalid = true;
		    while (notvalid) {
			try {
			    String input = sc.next();
			    if (typenum == 1) {
				String tmp = new String (input);
				add ((T)tmp);
				notvalid = false;
			    }
			    else {
				while (notvalid) {
				    try{
					int tmp = Integer.parseInt (input);
					Integer a = new Integer (tmp);
					add ((T) a);
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
		    System.out.println ("Removing Min:");
		    delete();
		}
		else if (choice == 3) {
		    System.out.println ("Peeking at Min:");
		    peek();
		}
		else {
		    System.out.println( "ERROR: Please input a valid choice" );
		}


	    }
	    catch (Exception e) {
		System.out.println( "ERROR: Please input a valid int" );
	    }
	}}
    public void add(T stuff){
	queue.enqueue(stuff);
	System.out.println(toString());
    }
    public void delete(){
	T tmp = queue.dequeue();
	System.out.println ("" + tmp);
	System.out.println(toString());
    }
    
    public void peek () {
	System.out.println (queue.peekFront());
	System.out.println(toString());
    }
    public String toString() {
	    String lel="";
	    for (int i=0; i<queue._queue.size();i++){
		if (typenum==2) {
		    int j = ((Integer) (queue._queue.get(i))).intValue();
		    if (i<10){//for spacing in single digits
			lel=lel + i + "  ";   
			while(j>=10){ //for spacing
			    lel=lel+" ";
			    j=j/10;
			}
		    }
		    else {//for spacing in double digits
			lel=lel+i+" ";
			while(j>=10){
			    lel=lel+" ";
			    j=j/10;
			}
		    }
		}
		else if (typenum==1) {
		    int j = ((String) queue._queue.get(i)).length();
		    if (i<10){//for spacing in single digits
			lel=lel + i + "  ";   
			while(j>=10){ //for spacing
			    lel=lel+" ";
			    j--;
			}
		    }
		    else {//for spacing in double digits
			lel=lel+i;
			while(j>=10){
			    lel=lel+" ";
			    j--;
			}
		    }
		}
	    }
	    
	
	    String retstr=ESC + "2J"+"Queue:" + queue._queue.toString()+"\n";
	    retstr+="Index: "+ lel+ "\n";
	    return retstr;
	}//O(?)
    
    public class ALQueue<T>{

	public ArrayList<T> _queue;
	
	// default constructor
	public ALQueue() { 
	    _queue = new ArrayList<T>(); 
	}
	
	// means of adding an item to collection 
	public void enqueue( T x ) {
	    _queue.add(x);
	}//O(1) expected, O(n) rarely
	
	
	// means of removing an item from collection 
	public T dequeue() {
	    return _queue.remove(0);
	}//O(n) bc n-1 shifted
	
	
	// means of "peeking" at the front item
	public T peekFront() {
	    return _queue.get(0);
	}//O(1)
	
	
	// means of checking to see if collection is empty
	public boolean isEmpty() {
	    return _queue.isEmpty();
	}//O(1)
	
	
	public String toString(){
		return _queue.toString();
		}
}}