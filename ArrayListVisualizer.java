import java.util.*;
import java.io.*;

public class ArrayListVisualizer <T> extends Visualizer<T>{
    final static String ESC = "\033[";
    public ArrayList<T> arraylist;
    public int typenum = 0;
    public String type = "";
    Scanner sc;

    public ArrayListVisualizer(){
	arraylist = new ArrayList <T> ();
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
	int index = -1;
	while (mod){
	    System.out.println ("Would you like to: \n1)Add a value \n2)Remove an Index \n3)Add a value to the end of the arraylist \n4)Set an index to a value");
	    try {
		String cho = sc.next();
		choice = Integer.parseInt(cho);
		if (choice == 1 || choice == 3) {
		    System.out.println ("\n Add what value:");
		    boolean notvalid = true;
		    while (notvalid) {
			try {
			    String input = sc.next();
			    if (typenum == 1) {
				String tmp = new String (input);
				if (choice == 3) {
				    add (arraylist.size(), (T)tmp);
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
		}




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
    }
    


 
    public void add(int index, T stuff){
	arraylist.add(index,stuff); //clear the screen
	System.out.println(toString()); 
    }
    public void insert(int index, T stuff){
	try {
	    arraylist.set(index,stuff);
	    System.out.println(toString());
	}
	catch (Exception e){
	    System.out.println(e.getMessage() + ": Invalid index. Try again");
	}
    }
    public void delete(int index){
	System.out.println( arraylist.remove(index)); 
	System.out.println(toString());
    }
    public String toString()
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
    
    public String Stringfy () {
	String retStr = "";
	for (int i = 0; i < this.arraylist.size(); i++) {
	    retStr += "" + this.arraylist.get (i) + ",";
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


    /*   public static void main (String [] args) {
	 ArrayListVisualizer <String> a = new ArrayListVisualizer <String> ();
	 String b = new String ("s");
	 a.add (0,b);
	 System.out.println(a.Stringfy());
	 a.modify ();
	 }
    */
}

