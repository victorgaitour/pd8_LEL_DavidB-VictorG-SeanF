
//Sean Fitzgerald, David Bang, Victor Gaitour
//Driver file

import java.io.*;
import java.util.*;
import java.awt.*;
import org.jfree.chart.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.chart.plot.*;
import javax.swing.*;

/***********************************
TO COMPILE:
javac -classpath "lib/jfreechart-1.0.17.jar:jcommon-1.0.22/jcommon-1.0.22.jar:." LEL.java

TO RUN:
java -classpath "lib/jfreechart-1.0.17.jar:jcommon-1.0.22/jcommon-1.0.22.jar:." LEL
**********************************/

public class LEL {

    public static class Gui{
	private String type = "";
	private JTextField textfield;
	private JTextPane[] display;; 

	public Gui (String structure, String s) {
	    JFrame guiFrame = new JFrame();
	    //sets up interface
	    guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    guiFrame.setTitle(structure + " Visualizer");
	    guiFrame.setSize(800,800);

	    JPanel panel = new JPanel();

	    
	    if (structure.equals ("Array")) {
		ArrayList a = new ArrayList ();
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			a.add (ch);
		}
		JTextPane [] display = new JTextPane [a.size()];
		for (int m=0; m< a.size(); m++) {
		    display[m] = new JTextPane();
		    //sets it so that the text in the textpane cannot be typed over
		    display[m].setEditable(false);
		    display[m].setBackground (Color.WHITE);
		    display[m].setForeground(Color.BLACK);
		    display[m].setText (m  + ": " + a.get (m));	     
		    panel.add(display[m], BorderLayout.CENTER);
		}	    
	    }
	    if (structure.equals ("ArrayList")) {
		ArrayList a = new ArrayList ();
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			a.add (ch);
		}
		JTextPane [] display = new JTextPane [a.size()];
		for (int m=0; m< a.size(); m++) {
		    display[m] = new JTextPane();
		    //sets it so that the text in the textpane cannot be typed over
		    display[m].setEditable(false);
		    display[m].setBackground (Color.WHITE);
		    display[m].setForeground(Color.BLACK);
		    display[m].setText (m  + ": " + a.get (m));	     
		    panel.add(display[m], BorderLayout.CENTER);
		}
	    }
	    if (structure.equals ("Heap")) {
		ArrayList a = new ArrayList ();
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			a.add (ch);
		}
		JTextPane [] display = new JTextPane [a.size()];
		for (int m=0; m< a.size(); m++) {
		    display[m] = new JTextPane();
		    //sets it so that the text in the textpane cannot be typed over
		    display[m].setEditable(false);
		    display[m].setBackground (Color.WHITE);
		    display[m].setForeground(Color.BLACK);
		    display[m].setText (m  + ": " + a.get (m));	     
		    panel.add(display[m], BorderLayout.CENTER);
		}
	    }
	    if (structure.equals ("Stack")) {
		ArrayList a = new ArrayList ();
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			a.add (ch);
		}
		JTextPane [] display = new JTextPane [a.size()];
		for (int m=0; m< a.size(); m++) {
		    display[m] = new JTextPane();
		    //sets it so that the text in the textpane cannot be typed over
		    display[m].setEditable(false);
		    display[m].setBackground (Color.WHITE);
		    display[m].setForeground(Color.BLACK);
		    display[m].setText (m  + ": "+ a.get (m));	     
		    panel.add(display[m], BorderLayout.CENTER);
		}
	    }
	    if (structure.equals ("LList")) {
		ArrayList a = new ArrayList ();
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			a.add (ch);
		}
		JTextPane [] display = new JTextPane [a.size()];
		for (int m=0; m< a.size(); m++) {
		    display[m] = new JTextPane();
		    //sets it so that the text in the textpane cannot be typed over
		    display[m].setEditable(false);
		    display[m].setBackground (Color.WHITE);
		    display[m].setForeground(Color.BLACK);
		    display[m].setText (m + ": " + a.get (m) + "|.|->");	     
		    panel.add(display[m], BorderLayout.CENTER);
		}
	    }
	    if (structure.equals ("BST")) {
		JTextArea textArea = new JTextArea(40, 40);
		textArea.setText(s);
		JScrollPane scrollPane = new JScrollPane(textArea);	    		    
		panel.add(scrollPane, BorderLayout.CENTER);
	    }



	    guiFrame.getContentPane().add(panel, BorderLayout.CENTER);

	    guiFrame.validate();
	    guiFrame.setVisible(true);
	    }

	}

	
    
    public static void main (String[] args) {
	
	System.out.print( "Would you like to: 1) Read in a .csv file (in the same directory as this java file) with your data 2) Enter your data via the terminal?\n1 or 2: " );
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
	    System.out.println( "What kind of data structure do you want to visualize?\n1: Array\n2: ArrayList\n3: Binary Search Tree\n4: Heap\n5: Stack\n6: Linked List\n7: Queue\n8: Graph" );
	    System.out.print( "Choice: " );

	    try {
		notvalid = false;
		int choice2 = sc.nextInt();
		if ( choice2 == 1 ) { //Array
		    ArrayVisualizer array;
		    while (true) {
			System.out.print ("Initialize the size of the array: ");
			try {
			    int choice3 = sc.nextInt();
			    array = new ArrayVisualizer (choice3);
			    break;
			}
			catch (Exception e) {
			    System.out.println ("ERROR: Please input a valid size" );
			}
		    }
		    while(true) {
			System.out.println( "\nWould you like to: \n1)Modify the data structure \n2)Convert to csv file \n3)Visualize data in Gui \n4)Print the data \n5)End Program " );
			try {
			    int choice4 = sc.nextInt();
			    if ( choice4 == 1 ) { 
				array.modify();
			    }
		
			    else if ( choice4 == 2 ) { 
				array.writeCSV ("test.csv");
			    }
			    else if ( choice4 == 3 ) {
				new Gui ("Array", array.Stringfy());
			    }
			    else if (choice4 == 4) {
				array.print();
			    }
			    else if (choice4 == 5) {
				break;
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid int" );
			}	

		    }
		}
	    
		else if ( choice2 == 2 ) { //ArrayListdone

		}
		else if ( choice2 == 3 ) { //BSTdone

		}
		else if ( choice2 == 4 ) { //Heapdone

		}
		else if ( choice2 == 5 ) { //Stack

		}
		else if ( choice2 == 6 ) { //LList

		}
		else if ( choice2 == 7 ) { //Queuedone

		}
		else if ( choice2 == 8 ) { //Graph
		    System.out.println( "Please choose a type of graph.\n1: Bar Graph\n2: Line Graph\n3: Pie Chart" );
		    int graphChoice;
		    String graphTitle = "";
		    String xTitle = "";
		    String yTitle = "";
		    try {
			System.out.print( "Your choice: " );
			graphChoice = sc.nextInt();
			System.out.print( "Enter a graph title: " );
			graphTitle = sc.next();

			JFrame chartFrame = new JFrame();
			chartFrame.setSize(600, 600);
			chartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel chartPanel = new JPanel();
			chartPanel.setLayout(new java.awt.BorderLayout());

			if ( graphChoice == 1 || graphChoice == 2 ) { //Bar or Line graph
			    System.out.print( "Enter a x-axis title: " );
			    xTitle = sc.next();
			    System.out.print( "Enter a y-axis title: " );
			    yTitle = sc.next();

			    BarGraph barGraph = new BarGraph( graphTitle, xTitle, yTitle );
			    for ( String s: data )
				barGraph.addValue( s );
			    ChartPanel chart = barGraph.createBarGraph();
			    chartPanel.add(chart, BorderLayout.CENTER);
			}
			else if ( graphChoice == 3 ) {
			    PieChart pieChart = new PieChart( graphTitle );
			    for ( String s: data )
				pieChart.addValue( s );
			    ChartPanel chart = pieChart.createChart();
			    chartPanel.add(chart, BorderLayout.CENTER);
			}
			else if ( graphChoice != 3 )
			    System.out.println( "ERROR: Please enter a valid int" );
			chartPanel.validate();
			chartFrame.add( chartPanel );
			chartFrame.setVisible( true );
		    }
		    catch ( Exception e ) {
			System.out.println( "!ERROR: Please input a valid int" );
		    }
		}
		else
		    System.out.println( "ERROR: User input invalid" );
	    }
	    catch ( Exception e ) {
		notvalid = true;
		System.out.println( "ERROR: Please input a valid int" );
	    }
	}
    }
}
