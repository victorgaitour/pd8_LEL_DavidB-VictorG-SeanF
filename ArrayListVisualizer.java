import java.util.*;
import java.io.*;

public class ArrayListVisualizer <T> extends Visualizer<T>{
    final static String ESC = "\033[";//skips lines in terminal, looks like screen is refreshed
    public ArrayList<T> arraylist;
    public int typenum = 0;//1 stands for String, 2 Stands for Integer
    public String type = "";
    Scanner sc; //scanner class

    public ArrayListVisualizer(){
	arraylist = new ArrayList <T> ();
	sc = new Scanner(System.in); 
	System.out.println( "Which Data Type: \nString \nInteger\n" );//determines what data type this generic arrayList will be
	while (type.equals("")) {//give the user tons of tries to get it right
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
		    System.out.println( "ERROR: Please enter a valid data type and do not use spaces" );//if it was mispelled or mistype
		}
	    }

	    catch (Exception e) {
		type = "";
		System.out.println( "ERROR: Please enter a valid data type and do not use spaces" );
	    }
	}
    }

    public void modify () {
	boolean mod = true; //continue to modify
	int choice;
	int index = -1;
	while (mod){
	    System.out.println ("Would you like to: \n1)Add a value \n2)Remove an Index \n3)Add a value to the end of the arraylist \n4)Set an index to a value");
	    try {
		String cho = sc.next(); //we found next() to be the least prone to causing errors
		choice = Integer.parseInt(cho);
		if (choice == 1 || choice == 3) { //if option 1 or 3 was chosen
		    System.out.println ("\n Add what value:");
		    boolean notvalid = true;
		    while (notvalid) { //keeps asking for user input until they return a valid answer
			try {
			    String input = sc.next();
			    if (typenum == 1) {
				String tmp = new String (input);
				if (choice == 3) {
				    add (arraylist.size(), (T)tmp);//add value to end of ArrayLIst
				}
				if (choice == 1) {
				    index = - 1;
				    System.out.println ("\nAdd at what index :");
				    while (index == -1) {
					try {
					    String line = sc.next();
					    index = Integer.parseInt (line);
					    if (index > arraylist.size ()){
						System.out.println( "ERROR: Please input a valid index" );
						index = -1;
					    }
					}
					catch (Exception e) {
					    System.out.println( "ERROR: Please input a valid index" );
					}
				    }
				    add (index, (T) tmp);
				}
				mod = false;
				notvalid = false;
			    }
			    else {
				while (notvalid) {
				    try{
					int tmp = Integer.parseInt (input);
					Integer a = new Integer (tmp);
					index = - 1;
					if (choice == 3)
					    index = arraylist.size();
					else if (choice == 1){
					    System.out.println ("\nAdd at what index :");
					    while (index == -1) {
						try {
						    String line = sc.next();
						    index = Integer.parseInt (line);
						    if (index > arraylist.size ()){
							System.out.println( "ERROR: Please input a valid index" );
							index = -1;
						    } 
						}
						catch (Exception e) {
						    System.out.println( "ERROR: Please input a valid index" );
						}
					    }
					}
					add (index, (T) a);
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
		}//so many cases to ensure we don't get runtime errors




		else if (choice == 2) {
		    System.out.println ("Removing:");
		    index = -1;
		    System.out.println ("\nRemove at what index :");
		    while (index == -1) {
			try {
			    String line = sc.next();
			    index = Integer.parseInt (line);
			    if (index > arraylist.size ()){
				System.out.println( "ERROR: Please input a valid index" );
				index = -1;
			    } 
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid index" );
			}
		    }
		    delete(index);
		}
		else if (choice == 4) {
		    System.out.println ("Set  what index:");
		    index = -1;
		    while (index == -1) {
			try {
			    String line = sc.next();
			    index = Integer.parseInt (line);
			    if (index > arraylist.size ()){
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
				insert (index, (T) input);
				mod = false;
				notvalid = false;
			    }
			    else {
				while (notvalid) {
				    try{
					int tmp = Integer.parseInt (input);
					Integer a = new Integer (tmp);
					insert (index,(T) a);
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
		else {
		    System.out.println( "ERROR: Please input a valid choice" );
		}
	    
	    }
	    catch (Exception e) {
		System.out.println( "ERROR: Please input a valid int" );
	    }
	}
    }//again, so many cases, to avoid getting errors
    


 
    public void add(int index, T stuff){//modified add for ArrayListVisualizer
	arraylist.add(index,stuff); 
	System.out.println(toString()); 
    }
    public void insert(int index, T stuff){// modified insert/set
	try {
	    arraylist.set(index,stuff);
	    System.out.println(toString());
	}
	catch (Exception e){
	    System.out.println(e.getMessage() + ": Invalid index. Try again");
	}
    }
    public void delete(int index){//modified remove
	System.out.println( arraylist.remove(index)); 
	System.out.println(toString());
    }
    public String toString()// terminal interface data structure visualization
    {
	String lel="";
	String retstr= "";
	for (int i=0; i<arraylist.size();i++){
	    if (typenum==2) {
		int j = ((Integer) (arraylist.get(i))).intValue();
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
		int j = ((String) arraylist.get(i)).length();
		if (i<10){//for spacing in single digits
		    lel=lel + i + "  ";   
		    while(j>=10){ //for spacing
			lel=lel+" ";
			j--;
		    }
		}
		else {//for spacing in double digits
		    lel=lel+i+" ";
		    while(j>=10){
			lel=lel+" ";
			j--;
		    }
		}
	    }
	}

	 
	retstr+=ESC + "2J"+"Arraylist: " + arraylist.toString()+"\n";
	retstr+="Index:      "+ lel+ "\n";
	return retstr;
    }
    
    public String Stringfy () {//converts data structure to comman seperated values, for csv files
	String retStr = "";
	for (int i = 0; i < this.arraylist.size(); i++) {
	    retStr += "" + this.arraylist.get (i) + ",";
	}
	//	System.out.println (retStr);
	return retStr;
    }

	
	
    public void writeCSV (String FileName) {//writes to a csv file
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


    /*   public static void main (String [] args) {
	 ArrayListVisualizer <String> a = new ArrayListVisualizer <String> ();
	 String b = new String ("s");
	 a.add (0,b);
	 System.out.println(a.Stringfy());
	 a.modify ();
	 }
    */
}

