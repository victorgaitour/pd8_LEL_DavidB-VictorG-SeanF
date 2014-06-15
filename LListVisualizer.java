//this is just old hw code from the basement that was modified into interactive magic

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.*;
import java.util.*;
import java.awt.*;


public class LListVisualizer<T> { 
    public Scanner sc;
    private DLLNode<T> _head, _tail; //pointers to first and last nodes
    private int _size;
    private String type = "";
    public int typenum = 0;



    // constructor -- initializes instance vars
     public LListVisualizer( ) {
	_head = _tail = null; //at birth, a list has no elements
	_size = 0;
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
	    System.out.println ("Would you like to: \n1)Add a node \n2)Remove a Node \n3)Set an index \n4)Get an index");
	    
	    try {
		String cho = sc.next();
		choice = Integer.parseInt(cho);
		int index = -1;
		if (choice == 1) {
		    System.out.println ("\nAdd at what index :");
		    while (index == -1) {
			try {
			    String line = sc.next();
			    index = Integer.parseInt (line);
			    if (index > size ()){
				System.out.println( "ERROR: Please input a valid index" );
				index = -1;
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid index" );
			}
		    }
		    
		    System.out.println ("Add what value:");
		    boolean notvalid = true;
		
		    while (notvalid) {
			try {
			    String input = sc.next();
			    if (typenum == 1) {
				String tmp = new String (input);
				add (index, (T)tmp);
				mod = false;
				notvalid = false;
			    }
			    else {
				while (notvalid) {
				    try{
					int tmp = Integer.parseInt (input);
					Integer a = new Integer (tmp);
					add (index,(T) a);
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
		    System.out.println ("Remove what index :");
		    while (index == -1) {
			try {
			    String ind = sc.next();
			    index = Integer.parseInt (ind);
			    
			    if (index > size () - 1){
				System.out.println( "ERROR: Please input a valid index" );
				index = -1;
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid index" );
			}
		    }
		    remove (index);
		    mod = false;
		}
		else if (choice == 3) {
		    System.out.println ("Set what index :");
		    while (index == -1) {
			try {
			    String ind = sc.next();
			    index = Integer.parseInt (ind);			   
			    if (index > size () - 1){
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
				set (index, (T) input);
				mod = false;
				notvalid = false;
			    }
			    else {
				while (notvalid) {
				    try{
					int tmp = Integer.parseInt (input);
					Integer a = new Integer (tmp);
					add (index,(T) a);
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

		else if (choice == 4) {
		    System.out.println ("Get what index :");
		    while (index == -1) {
			try {
			    String ind = sc.next();
			    index = Integer.parseInt (ind);
			    if (index > size () - 1){
				System.out.println( "ERROR: Please input a valid index" );
				index = -1;
			    }
			}
			catch (Exception e) {
			    System.out.println( "ERROR: Please input a valid index" );
			}
		    }
		    get(index);
		    mod = false;
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

	


    //--------------v  List interface methods  v--------------


    //insert a node in front of first node
    public boolean add( T newVal ) { 
	addLast( newVal );
	return true; //per Java API spec
    } 


    //insert a node containing newVal at position index
    public void add( int index, T newVal ) {


	if ( index < 0 || index > size() )
	    throw new IndexOutOfBoundsException();


	else if ( index == size() ) 
	    addLast( newVal );


	DLLNode<T> newNode = new DLLNode<T>( newVal, null, null );


	//if index==0, insert node before head node
	if ( index == 0 ) 
	    addFirst( newVal );
	else {
	    DLLNode<T> tmp1 = _head; //create alias to head


	    //walk tmp1 to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp1 = tmp1.getNext();


	    //init a pointer to node at insertion index
	    DLLNode<T> tmp2 = tmp1.getNext(); 


	    //insert new node
	    newNode.setNext( tmp2 );
	    newNode.setPrev( tmp1 );
	    tmp1.setNext( newNode );
	    tmp2.setPrev( newNode );


	    //increment size attribute
	    _size++;


	}
    }


    //remove node at pos index, return its cargo
    public T remove( int index ) {


	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();


	if ( index == 0 )
	    return removeFirst();
	else if ( index == size()-1 )
	    return removeLast();
	else {
	    DLLNode<T> tmp1 = _head; //create alias to head


	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ ) {
		tmp1 = tmp1.getNext();
		System.out.println( "tmp1: " + tmp1.getCargo() );
	    }
	    //check target node's cargo hold
	    T retVal = tmp1.getNext().getCargo();


	    //remove target node
	    tmp1.setNext( tmp1.getNext().getNext() );
	    System.out.println( "tmp1.getNext: " + tmp1.getNext().getCargo() );
	    tmp1.getNext().setPrev( tmp1 );


	    _size--;


	    return retVal;
	}
    }


    public T get( int index ) { 


	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();


	T retVal;
	DLLNode<T> tmp = _head; //create alias to head


	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();


	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    } 


    public T set( int index, T newVal ) { 


	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();


	DLLNode<T> tmp = _head; //create alias to head


	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();


	//store target node's cargo
	T oldVal = tmp.getCargo();


	//modify target node's cargo
	tmp.setCargo( newVal );


	return oldVal;
    } 


    //return number of nodes in list
    public int size() { return _size; } 






    //--------------v  Helper methods  v--------------
    public void addFirst( T newFirstVal ) { 
	//insert new node before first node (prev=null, next=_head)
	_head = new DLLNode<T>( newFirstVal, null, _head );


	if ( _size == 0 ) 
	    _tail = _head;
	else 
	    _head.getNext().setPrev( _head );
	_size++;
    }


    public void addLast( T newLastVal ) { 
	//insert new node after last node (prev=_last, next=null)
	_tail = new DLLNode<T>( newLastVal, _tail, null );


	if ( _size == 0 ) 
	    _head = _tail;
	else 
	    _tail.getPrev().setNext( _tail );
	_size++;
    }


    public T getFirst() { return _head.getCargo(); }


    public T getLast() { return _tail.getCargo(); }


    public T removeFirst() { 
	T retVal = getFirst();
	if ( size() == 1 ) {
	    _head = _tail = null;
	}
	else {
	    _head = _head.getNext();
	    _head.setPrev( null );
	}
	_size--;
	return retVal;
    }


    public T removeLast() { 
	T retVal = getLast();
	if ( size() == 1 ) {
	    _head = _tail = null;
	}
	else {
	    _tail = _tail.getPrev();
	    _tail.setNext( null );
	}
	_size--;
	return retVal;
    }
    //--------------^  Helper methods  ^--------------



    public String print() { 
	String retStr = "|";
	DLLNode<T> tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "|.| -> |";
	    tmp = tmp.getNext();
	}
	retStr += "NULL|";
	return retStr;
    }

  /*  public static void main (String [] args) {
	LListVisualizer <String> a = new LListVisualizer <String> ();
	String b = new String ("s");
	a.add (b);
	a.modify ();
    }
  */
}

