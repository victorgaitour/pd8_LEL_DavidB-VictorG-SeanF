//Sean Fitzgerald, David Bang, Victor Gaitour
//Driver file

public class LEL {
    
    public static void main (String[] args) {
	
	System.out.print( "Would you like to: 1) Read in a .csv file (in the same directory as this java file) with your data 2) Enter your data in the terminal?\n1 or 2: " );
	Scanner sc = new Scanner( System.in );
	String inputData = "";
	try {
	    String choice1 = sc.nextInt();
	    if ( choice1 == 1 ) {
		System.out.print( "Your file name: " );
		try {
		    String filename = sc.nextLine();
		    BufferedReader reader = new BufferedReader( new FileReader( filename ) );
		    while ( reader.readLine() != null )
			inputData += reader.readLine();
		}
		catch (Exception e) {
		    System.out.println( "ERROR: file not found" );
		}
	    }
	    else if ( choice1 == 2 ) {
		System.out.print( "Enter your data (separated by commas, NO SPACES): " );
		inputData = sc.nextLine();
	    }
	    else
		System.out.println( "ERROR: User input invalid" );
	}
	catch (Exception e)
	    System.out.println( "ERROR: User input invalid" );

	ArrayList data = new ArrayList<String>();
	for ( int i = 0; i < inputData.length(); i++ ) {
	    String value = "";
	    while ( !(inputData.substring( i, i+1 ).equals(",") || inputData.substring( i, i+1 ).equals("")) ) { //isn't comma or end of string
		value += inputData.substring( i, i+1 );
		i++;
	    }
	    i++; //skips comma
	    data.add( value );
	}
    }
}

