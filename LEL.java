
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
import javax.swing.border.LineBorder;

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
	    guiFrame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);;
	    guiFrame.setTitle(structure + " Visualizer");
	    guiFrame.setSize(800,800);

	    JPanel panel = new JPanel();
	    panel.setBorder(new LineBorder(Color.GREEN, 4));
	    panel.setBackground(Color.CYAN);
	    
	    if (structure.equals ("Array")) {
		ArrayList a = new ArrayList ();
		String t = "";
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			t += ch;
		    else{
		        a.add (t);
			t = "";
		    }
		    
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
		String t = "";
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			t += ch;
		    else{
		        a.add (t);
			t = "";
		    }
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
		String t = "";
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			t += ch;
		    else{
		        a.add (t);
			t = "";
		    }
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
		String t = "";
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			t += ch;
		    else{
		        a.add (t);
			t = "";
		    }
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
		String t = "";
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			t += ch;
		    else{
		        a.add (t);
			t = "";
		    }
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
		ArrayList a = new ArrayList ();
		JTextArea textArea = new JTextArea(40, 40);
		String t = "";
		for (char ch: s.toCharArray()) {
		    if (!(ch == ','))
			t += ch;
		    else{
		        a.add (t);
			t = " ";
		    }
		}
		t = "";
		for (int m = 0; m < a.size (); m ++) {
		    t += a.get (m);
		}
		textArea.setText(t);
		JScrollPane scrollPane = new JScrollPane(textArea);	    		    
		panel.add(scrollPane, BorderLayout.CENTER);
	    }



	    guiFrame.getContentPane().add(panel, BorderLayout.CENTER);

	    guiFrame.validate();
	    guiFrame.setVisible(true);
	    }

	}

	
    
    public static void main (String[] args) {
	Scanner sc = new Scanner( System.in );
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
				System.out.println("Written to test.csv");
			    }
			    else if ( choice4 == 3 ) {
				new Gui ("Array", array.Stringfy());
			    }
			    else if (choice4 == 4) {
				array.print();
			    }
			    else if (choice4 == 5) {
				System.exit(0); 
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid int" );
			}	

		    }
		}
	    
		else if ( choice2 == 2 ) { //ArrayList
		    ArrayListVisualizer arrayl = new ArrayListVisualizer ();
		    while(true) {
			System.out.println( "\nWould you like to: \n1)Modify the data structure \n2)Convert to csv file \n3)Visualize data in Gui \n4)Print the data \n5)End Program " );
			try {
			    int choice4 = sc.nextInt();
			    if ( choice4 == 1 ) { 
				arrayl.modify();
			    }
		
			    else if ( choice4 == 2 ) { 
				arrayl.writeCSV ("test.csv");
				System.out.println("Written to test.csv");
			    }
			    else if ( choice4 == 3 ) {
				new Gui ("ArrayList", arrayl.Stringfy());
			    }
			    else if (choice4 == 4) {
				System.out.println (arrayl.toString());
			    }
			    else if (choice4 == 5) {
				System.exit(0); 
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid int" );
			}	

		    }

		}
		else if ( choice2 == 3 ) { //BST
		    BSTVisualizer BST = new BSTVisualizer ();
		    while(true) {
			System.out.println( "\nWould you like to: \n1)Modify the data structure \n2)Convert to csv file \n3)Visualize data in Gui \n4)Print the data \n5)End Program " );
			try {
			    int choice4 = sc.nextInt();
			    if ( choice4 == 1 ) { 
				BST.modify();
			    }
			    else if ( choice4 == 2 ) { 
				BST.writeCSV ("test.csv");
				System.out.println("Written to test.csv");
			    }
			    else if ( choice4 == 3 ) {
				new Gui ("BST", BST.Stringfy());
			    }
			    else if (choice4 == 4) {
				BST.print(BST.height());
			    }
			    else if (choice4 == 5) {
				System.exit(0); 
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid int" );
			}
		    }	
		}
		else if ( choice2 == 4 ) { //Heap
		    HeapVisualizer heap = new HeapVisualizer ();
		    while(true) {
			System.out.println( "\nWould you like to: \n1)Modify the data structure \n2)Convert to csv file \n3)Visualize data in Gui \n4)Print the data \n5)End Program " );
			try {
			    int choice4 = sc.nextInt();
			    if ( choice4 == 1 ) { 
				heap.modify();
			    }
		
			    else if ( choice4 == 2 ) { 
				heap.writeCSV ("test.csv");
				System.out.println("Written to test.csv");
			    }
			    else if ( choice4 == 3 ) {
				new Gui ("Heap", heap.Stringfy());
			    }
			    else if (choice4 == 4) {
				System.out.println (heap.toString());
			    }
			    else if (choice4 == 5) {
				System.exit(0); 
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid int" );
			}
		    }	

		}
		else if ( choice2 == 5 ) { //Stack
		    StackVisualizer stack = new StackVisualizer ();
		    while(true) {
			System.out.println( "\nWould you like to: \n1)Modify the data structure \n2)Convert to csv file \n3)Visualize data in Gui \n4)Print the data \n5)End Program " );
			try {
			    int choice4 = sc.nextInt();
			    if ( choice4 == 1 ) { 
				stack.modify();
			    }
		
			    else if ( choice4 == 2 ) { 
				stack.writeCSV ("test.csv");
			    }
			    else if ( choice4 == 3 ) {
				new Gui ("Stack", stack.Stringfy());
			    }
			    else if (choice4 == 4) {
				System.out.println (stack.toString());
			    }
			    else if (choice4 == 5) {
				System.exit(0); 
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid int" );
			}	

		    }
		}
		else if ( choice2 == 6 ) { //LList
		    LListVisualizer LL = new LListVisualizer ();
		    while(true) {
			System.out.println( "\nWould you like to: \n1)Modify the data structure \n2)Convert to csv file \n3)Visualize data in Gui \n4)Print the data \n5)End Program " );
			try {
			    int choice4 = sc.nextInt();
			    if ( choice4 == 1 ) { 
				LL.modify();
			    }
		
			    else if ( choice4 == 2 ) { 
				LL.writeCSV ("test.csv");
				System.out.println("Written to test.csv");
			    }
			    else if ( choice4 == 3 ) {
				new Gui ("LList", LL.Stringfy());
			    }
			    else if (choice4 == 4) {
				System.out.println (LL.toString());
			    }
			    else if (choice4 == 5) {
				System.exit(0); 
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid int" );
			}	
		    }

		}
		else if ( choice2 == 7 ) { //Queue
		    QueueVisualizer Que = new QueueVisualizer ();
		    while(true) {
			System.out.println( "\nWould you like to: \n1)Modify the data structure \n2)Convert to csv file \n3)Visualize data in Gui \n4)Print the data \n5)End Program " );
			try {
			    int choice4 = sc.nextInt();
			    if ( choice4 == 1 ) { 
				Que.modify();
			    }
		
			    else if ( choice4 == 2 ) { 
				Que.writeCSV ("test.csv");
				System.out.println("Written to test.csv");
			    }
			    else if ( choice4 == 3 ) {
				new Gui ("Queue", Que.Stringfy());
			    }
			    else if (choice4 == 4) {
				System.out.println (Que.toString());
			    }
			    else if (choice4 == 5) {
				System.exit(0); 
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid int" );
			}	
		    }

		}
		else if ( choice2 == 8 ) { //Graph
		    	
		    System.out.print( "Would you like to: 1) Read in a .csv file (in the same directory as this java file) with your data 2) Enter your data via the terminal?\n1 or 2: " );
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

		    System.out.println( "Please choose a type of graph.\n1: Bar Graph(DOES NOT WORK) \n2:Line Graph(DOES NOT WORK)\n3: Pie Chart" );
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

			/*if ( graphChoice == 1 || graphChoice == 2 ) { //Bar or Line graph
			    System.out.print( "Enter a x-axis title: " );
			    xTitle = sc.next();
			    System.out.print( "Enter a y-axis title: " );
			    yTitle = sc.next();

			    BarGraph barGraph = new BarGraph( graphTitle, xTitle, yTitle );
			    for ( String s: data )
				barGraph.addValue( s );
			    ChartPanel chart = barGraph.createBarGraph();
			    chartPanel.add(chart, BorderLayout.CENTER);
			}*/
		    if ( graphChoice == 3 ) {
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
