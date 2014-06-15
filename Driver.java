import java.io.*;
import java.util.*;
import java.awt.*;

public class Driver { //for terminal interaction
    
    public void interact () {
	System.out.println( "\nWould you like to: \n1)Modify the data structure \n2)Convert to csv file \n3)Visualize: " );
	System.out.print( "Choice: " );
	boolean notvalid = true;
	while (notvalid)
	    try {
		boolean notvalid = false;
		int choice2 = sc.nextInt();
		if ( choice2 == 1 ) { 
		    this.modify();
		}
		
		else if ( choice2 == 2 ) { 
		    this.writeCSV (choice2, "test.csv")
		}
		else if ( choice2 == 3 ) {
		    
    
	
        


    }
}
    public static void main (String[] args) {
	System.out.print( "Would you like to: 1) Read in a .csv file (in the same directory as this java file) with your data 2) Enter your data via the terminal?\n1 or 2: " );
	Scanner sc = new Scanner( System.in );
	String inputData = "";

	//taken from LEL
	try {
	    int choice1 = sc.nextInt();
	    if ( choice1 == 1 ) {
		try {
		    System.out.print( "Your file name: " );
		    String filename = sc.next();
		    System.out.println( "Your file name: " + filename );
		    BufferedReader reader = new BufferedReader( new FileReader( filename ) );
		    String line = reader.readLine();
		    while ( line != null ) {
			//System.out.println( "readLine: " + line );
			inputData += line + ",";
			line = reader.readLine();
		    }
		    inputData = inputData.substring( 0, inputData.length()-1 );
		}
		catch (Exception e) {
		    System.out.println( "ERROR: file not found" );
		}
	    }
	    else if ( choice1 == 2 ) {
		System.out.print( "Enter your data (FORMAT: Label1:1,Label2:2 (NO SPACES)) : " );
		inputData = sc.next();
	    }
	    else
		System.out.println( "ERROR: Please input a valid int" );
	}
	catch (Exception e) {
	    System.out.println( "ERROR: Please input a valid int" );
	}


	System.out.println( "inputData: " + inputData );
	ArrayList<String> data = new ArrayList<String>();
	for ( int i = 0; i < inputData.length(); i++ ) {
	    String value = "";
	    while ( i < inputData.length() && !(inputData.substring( i, i+1 ).equals(",") || inputData.substring( i, i+1 ).equals("")) ) { //isn't comma or end of string
		value += inputData.substring( i, i+1 );
		//System.out.println( "Value: " + value );
		i++;
	    }
	    //i++; //skips comma
	    //System.out.println( "value: " + value );
	    data.add( value );
	    //System.out.println( data );
	}


	System.out.println( "data: " + data );
	//^^^ENTERING DATA CODE^^^

	boolean notvalid = true;
	while (notvalid) {
	    System.out.println( "What kind of data structure do you want to visualize?\n1: Array\n2: ArrayList\n3: Binary Search Tree\n4: Heap\n5: Stack\n6: Linked List\n7: Queue\n");
	    System.out.print( "Choice: " );

	    try {
		notvalid = false;
		int choice2 = sc.nextInt();
		if ( choice2 == 1 ) { //Array
		    System.out.print ("Initialize size of array: ");
		    try {
			int choice3 = sc.nextInt();
			ArrayVisualizer <T> array = new ArrayVisualizer <T> (choice3);
		    }
		    

			}
		else if ( choice2 == 2 ) { //ArrayList


		}
		else if ( choice2 == 3 ) { //BST


		}
		else if ( choice2 == 4 ) { //Heap


		}
		else if ( choice2 == 5 ) { //Stack


		}
		else if ( choice2 == 6 ) { //LList


		}
		else if ( choice2 == 7 ) { //Queue

		}
	    }

	    catch ( Exception e ) {
		System.out.println( "ERROR: Please input a valid int" );
		notvalid = true;
	    }
