import java.util.*;
import java.lang.*;
import java.io.*;

public class BSTVisualizer <T extends Comparable <T>>
{
    @SuppressWarnings("unchecked")
    TreeNode <T>  _root;
    public int typenum = 0;
    public String type = "";
    Scanner sc;

    public BSTVisualizer ( ) {
	_root = null;
	System.out.println( "Which TreeNode Value Type: \nString \nInteger\n" );
	sc = new Scanner (System.in);
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
	    System.out.println ("\nWould you like to: \n1)Insert a value \n2)Remove a value \n3)Print a traversal");
	    try {
		String cho = sc.next();
		choice = Integer.parseInt(cho);
		int index = -1;
		if (choice == 1) {
		    System.out.println ("\nInsert what value:");
		    boolean notvalid = true;
		    while (notvalid) {
			try {
			    String input = sc.next();
			    if (typenum == 1) {
				String tmp = new String (input);
				insert ((T)tmp);
				print (height());
				mod = false;
				notvalid = false;
			    }
			    else {
				while (notvalid) {
				    try{
					int tmp = Integer.parseInt (input);
					Integer a = new Integer (tmp);
					insert ((T) a);
					print (height());
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
		    System.out.println ("Remove what value:");
		    boolean notvalid = true;
		    while (notvalid) {
			try {
			    String input = sc.next();
			    if (typenum == 1) {
				String tmp = new String (input);
			        remove ((T)tmp);
				print (height());
				mod = false;
				notvalid = false;
			    }
			    else {
				while (notvalid) {
				    try{
					int tmp = Integer.parseInt (input);
					Integer a = new Integer (tmp);
				        remove ((T) a);
					print (height());
					mod = false;
					notvalid = false;
				    }
				    catch (Exception e) {
					System.out.println( "ERROR: Value Not found or Please input valid Integer" );
					input = sc.next();
				    }
				}
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Value not found or Please input the correct data type" );
			}
		    }
		}
		else if (choice == 3) {
		    System.out.println ("Print what traversal: \n1)PostOrder \n2)PreOrder \n3)InOrder");
		    boolean nottrav = true;
		    while (nottrav) {
			try{
			    cho = sc.next();
			    int choice2 = Integer.parseInt(cho);
			    if (choice2 == 1) {
				postOrderTrav();
				nottrav = false;
				mod = false;
			    }
			    else if (choice2 == 2) {
				preOrderTrav ();
				nottrav = false;
				mod = false;
			    }
			    else if (choice2 == 3) {
				inOrderTrav ();
				nottrav = false;
				mod = false;
			    } 
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid int" );
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



    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( T newVal ) {

	TreeNode <T> newNode = new TreeNode <T>( newVal );

	if ( _root == null ) {
	    _root = newNode;
	    return;
	}
        insert( _root, newNode );
    }
    //recursive helper for insert(int)
    public void insert( TreeNode <T> stRoot, TreeNode <T> newNode ){


	if ( newNode.getValue().compareTo ( stRoot.getValue()) < 0 ) {
	    //if no left child, make newNode the left child
	    if ( stRoot.getLeft() == null )
		stRoot.setLeft( newNode );
	    else //recurse down left subtree
		insert( stRoot.getLeft(), newNode );
	    return;
	}
	else { // new val >= curr, so look down right subtree
	    //if no right child, make newNode the right child
	    if ( stRoot.getRight() == null )
		stRoot.setRight( newNode );
	    else //recurse down right subtree
		insert( stRoot.getRight(), newNode );
	    return;
	}
    }

    public boolean isLeaf( TreeNode node ) { 
	return ( node.getLeft() == null && node.getRight() == null );
    }


    public TreeNode remove( T remVal )
    {
	TreeNode leader = _root;  
	TreeNode follower = null; //piggybacker

	if (!(remVal.compareTo((T)leader.getValue()) < 0 ) || ( remVal.compareTo((T)leader.getValue()) < 0 ))
	    _root = null;

	//first, walk leader ptr down to target node w/ trailing follower ptr
	while( leader != null && !((((T)(leader.getValue())).compareTo(remVal) < 0)||((T)(leader.getValue())).compareTo(remVal) < 0)  ) {
	    if ( remVal.compareTo((T)leader.getValue()) < 0 ) {
		follower = leader;
		leader = leader.getLeft();
	    }
	    else { // remVal > leader.getValue()
		follower = leader;
		leader = leader.getRight();
	    }
	}


	if ( leader == null ) //remVal was not in tree
	    return leader;


	//CASE 1: removal node is a leaf
	//action: snip it
	if ( isLeaf(leader) ) {
	    //subcase: 1-node tree
	    if ( leader==_root ) {
		_root = null;
		return leader;
	    }


	    //subcase: removal node is a left child
	    if ( follower.getLeft()==leader ) { 
		follower.setLeft( null );
		return leader;
	    } 
	    //subcase: removal node is a right child
	    else { 
		follower.setRight( null );
		return leader;
	    }
	}


	//CASE 2: removal node has 1 subtree
	//action: replace node with only child
	else if ( leader.getRight()==null ) { //rem node's child is on left


	    //subcase: removal node is root
	    if ( leader==_root ) {
		_root = leader.getLeft();
		return leader;
	    }


	    //subcase: removal node is a left child
	    if ( follower!=null && follower.getLeft()==leader ) { 
		follower.setLeft( leader.getLeft() );
		return leader;
	    } 
	    //subcase: removal node is a right child
	    else if ( follower!=null ) { 
		follower.setRight( leader.getLeft() );
		return leader;
	    }
	}
	else if ( leader.getLeft()==null ) { //rem node's child is on right


	    //subcase: removal node is root
	    if ( leader==_root ) {
		_root = leader.getRight();
		return leader;
	    }


	    //subcase: removal node is a left child
	    if ( follower!=null && follower.getLeft()==leader ) { 
		follower.setLeft( leader.getRight() );
		return leader;
	    } 
	    //subcase: removal node is a right child
	    else { 
		follower.setRight( leader.getRight() );
		return leader;
	    }
	}


	//CASE 3: removal node has 2 subtrees
	//action: overwrite removal node value with max value in left subtree
	//        (deepest node with no right child), then remove that node, 
	//        promoting its left child if exists
	else {
            TreeNode <T> maxLST = leader.getLeft();
            while( maxLST.getRight() != null ) {
		maxLST = maxLST.getRight();
            }


	    //create replacement node for removal node
            TreeNode tmp = new TreeNode( maxLST.getValue() );
            tmp.setLeft( leader.getLeft() );
            tmp.setRight( leader.getRight() );


            remove( maxLST.getValue() );


	    //subcase: removal node is root
            if ( follower==null ) { 
                _root = tmp;
                return leader;
            }


	    //subcase: removal node is a left child
            if ( follower.getLeft() == leader) {
                follower.setLeft( tmp );
            }
	    //subcase: removal node is a right child
            else {
                follower.setRight( tmp );
            }
	}
	return leader;
    }//end remove()


    public int height()
    {
        return height (_root);
    }

    public int height( TreeNode <T> currNode )
    {
	if ( currNode==null ) //Q: Why cannot use .equals() ?
	    return 0;
	if ( isLeaf(currNode) )
	    return 1;
	else //height is 1 for this node + height of deepest subtree
	    return 1 + Math.max( height(currNode.getLeft()),
				 height(currNode.getRight()) );
    }



    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeaves( _root );
    }
    public int numLeaves( TreeNode <T>  currNode ) { 
	int foo = 0;
	if ( currNode == null )
	    return 0;
	foo += numLeaves( currNode.getLeft() );
	if ( isLeaf(currNode) )
	    foo++;
	foo += numLeaves( currNode.getRight() );
	return foo;
    }


    public void preOrderTrav() {
	preOrderTrav( _root );
    }
    public void preOrderTrav( TreeNode <T> currNode ) {
	if ( currNode == null )
	    return;
	System.out.print( currNode.getValue() + " " );
	preOrderTrav( currNode.getLeft() );
	preOrderTrav( currNode.getRight() );
    }


    //recurse left, process root, recurse right
    public void inOrderTrav() {
	inOrderTrav( _root );
    }
    public void inOrderTrav( TreeNode <T> currNode ) {
	if ( currNode == null )
	    return;
	inOrderTrav( currNode.getLeft() );
	System.out.print( currNode.getValue() + " " );
	inOrderTrav( currNode.getRight() );
    }


    //recurse left, recurse right, process root
    public void postOrderTrav() {
	postOrderTrav( _root );
    }
    public void postOrderTrav( TreeNode <T>  currNode ) {
	if ( currNode == null )
	    return;
	postOrderTrav( currNode.getLeft() );
	postOrderTrav( currNode.getRight() );
	System.out.print( currNode.getValue() + " "  );
    }

   public void print(int depth) {
	for (int i = 1; i <= depth; i++) {
	    String space = "";
	    int tmp = height () - i;
	    for (int j = tmp; j > 0; j --) 
		space += " ";
	    System.out.print("Level " + (i-1) + ": ");
	    String levelNodes = printLevel(_root, i);
	    System.out.print(space + levelNodes + "\n");		
	}
    }






    //helper for print
    public String printLevel(TreeNode <T> tree, int level) {
	if (tree == null) {
	    return " ";
	}
	if (level == 1) {
	    if (tree.getValue() == null)
		return " " + null;
	    else
		return " " + tree.getValue();
	} else if (level > 1) {
	    String leftStr = printLevel(tree.getLeft(), level - 1);
	    String rightStr = printLevel(tree.getRight(), level - 1);
	    if (leftStr ==  " " || leftStr == "")
		leftStr = "  ";
	    return leftStr + rightStr;
	}
	else 
	    return "";
    }


    public String printLevelCommas(TreeNode <T> tree, int level) {
	if (tree == null) {
	    return ",";
	}
	if (level == 1) {
	    if (tree.getValue() == null)
		return "," + null + ",";
	    else
		return "," +  tree.getValue() + ",";
	} else if (level > 1) {
	    String leftStr = printLevel(tree.getLeft(), level - 1);
	    String rightStr = printLevel(tree.getRight(), level - 1);
	    if (leftStr ==  " " || leftStr == "")
		leftStr = ",";
	    return "," + leftStr + ", ," +  rightStr + "," ;
	}
	else 
	    return ", ,";
    }




    public String Stringfy () {
	String retStr = "";
	for (int i = 1; i <= height(); i++) {
	    String space = "";
	    int tmp = height () - i;
	    for (int j = tmp; j > 0; j --) 
		space += ",";
	    retStr =  retStr + space +  printLevelCommas(_root, i)  + "\n";
	}
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


    /*  //main method for testing
    @SuppressWarnings ("unchecked")
    public static void main( String[] args ) {
	BSTVisualizer test = new BSTVisualizer ();
	Integer a = new Integer (10);
	Integer b = new Integer (11);
	//test.insert(a);
	//test.insert (b);
	String s = new String ("ssds");
	test.insert (s);
	int h = test.height ();
	test.print(h);
	test.preOrderTrav();
	test.modify ();
	h = test.height ();
	test.print(h);
    }
    */

}//end class
