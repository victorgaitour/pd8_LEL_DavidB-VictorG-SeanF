//Sean Fitzgerald, David Bang, Victor Gaitour
//Driver file

import java.io.*;
import java.util.*;

public class LEL {
    
    public static void main (String[] args) {
	
	System.out.print( "Would you like to: 1) Read in a .csv file (in the same directory as this java file) with your data 2) Enter your data in the terminal?\n1 or 2: " );
	Scanner sc = new Scanner( System.in );
	String inputData = "";
	try {
	    int choice1 = sc.nextInt();
	    if ( choice1 == 1 ) {
		try {
		    System.out.print( "Your file name: " );
		    String filename = sc.next();
		    System.out.println( "Your file name: " + filename );
		    BufferedReader reader = new BufferedReader( new FileReader( filename ) );
		    while ( reader.readLine() != null ) {
			System.out.println( "readLine: " + reader.readLine() );
			inputData += reader.readLine();
		    }
		}
		catch (Exception e) {
		    System.out.println( "ERROR: file not found" );
		}
	    }
	    else if ( choice1 == 2 ) {
		System.out.print( "Enter your data (separated by commas, NO SPACES): " );
		inputData = sc.next();
	    }
	    else
		System.out.println( "ERROR: Please input a valid int" );
	}
	catch (Exception e) {
	    System.out.println( "ERROR: Please input a valid int" );
	}

	System.out.println( "inputData: " + inputData );
	ArrayList data = new ArrayList<String>();
	for ( int i = 0; i < inputData.length(); i++ ) {
	    String value = "";
	    while ( !(inputData.substring( i, i+1 ).equals(",") || inputData.substring( i, i+1 ).equals("")) ) { //isn't comma or end of string
		value += inputData.substring( i, i+1 );
		System.out.println( "Value: " + value );
		i++;
	    }
	    i++; //skips comma
	    System.out.println( "Value: " + value );
	    data.add( value );
	}

	//^^^ENTERING DATA CODE^^^
	
	System.out.println( "What kind of data structure do you want to visualize?\n1: Array\n2: ArrayList\n3: Binary Search Tree\n4: Heap\n5: Stack\n6: Linked List\n7: Queue\n8: Graph" );
	System.out.print( "Choice: " );

	try {
	    int choice2 = sc.nextInt();
	    if ( choice2 == 1 ) { //Array
	    
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
	    else if ( choice2 == 8 ) { //Graph
		System.out.println( "Please choose a type of graph.\n1: Bar Graph\n2: Line Graph\n3: Pie Chart" );
		int graphChoice;
		String graphTitle = "";
		String xTitle = "";
		String yTitle = "";
		try {
		    graphChoice = sc.nextInt();
		    System.out.print( "Enter a graph title: " );
		    graphTitle = sc.next();
		    if ( graphChoice == 1 || graphChoice == 2 ) { //Bar or Line graph
			System.out.print( "Enter a x-axis title: " );
			xTitle = sc.next();
			System.out.print( "Enter a y-axis title: " );
			yTitle = sc.next();
		    }
		    else if ( graphChoice != 3 )
			System.out.println( "ERROR: Please enter a valid int" );
		}
		catch ( Exception e ) {
		    System.out.println( "ERROR: Please input a valid int" );
		}
	    }
	    else
		System.out.println( "ERROR: User input invalid" );
	}
	catch ( Exception e ) {
	    System.out.println( "ERROR: Please input a valid int" );
	}
    }
}

