import java.util.ArrayList;

public class HeapVisualizer{
    final static String ESC = "\033[";
    private ALHeap heap;
    public HeapVisualizer(ArrayList<Integer> lel){
	heap=new ALHeap();
	for (int s : lel){
	    heap.add(s);
	}
    }
    public HeapVisualizer(){
	heap=new ALHeap();
    }
    public void add(int stuff){
	heap.add(stuff);
	System.out.println(heap);
    }
    public void delete(){
	heap.removeMin();
	System.out.println(heap);
    }
    public String toString(){
	return heap.toString();
    }
	

    public class ALHeap {
	
	//instance vars
	private ArrayList<Integer> heap; //underlying container
    
	
	/*****************************************************
	 * default constructor --- inits empty heap
	 *****************************************************/
	public ALHeap()
	{
	    heap= new ArrayList<Integer>();
	    // /*** YOUR IMPLEMENTATION HERE ***/
	}//O(1)
	
	
	
	/*****************************************************
	 * boolean isEmpty()
	 * Returns true if no meaningful elements in heap, false otherwise
	 *****************************************************/
	public boolean isEmpty()
	{
	    if (heap.size()==0)
		return true;
	    return false;
	    // /*** YOUR IMPLEMENTATION HERE ***/
	}//O(1)
	
	/*****************************************************
	 * add(Integer)
	 * Inserts an element in the heap
	 * Postcondition: Tree maintains heap property.
	 *****************************************************/
	public void add( int addVal )
	{
	    if (isEmpty()){
		heap.add(addVal);
		return;
	    }
	    else{
		heap.add(addVal);
		int childIn=heap.size()-1;
		int parentIn=getParent(childIn);
		while (heap.get(childIn)<heap.get(parentIn)){
		    swap(childIn,parentIn);
		    childIn=parentIn;
		    parentIn=getParent(parentIn);
		}
	    }
	}
	
	// /*** YOUR IMPLEMENTATION HERE ***/
	//O(n)
	
    
	
	
	/*****************************************************
	 * Integer peekMin()
	 * Returns min value in heap
	 * Postcondition: Heap remains unchanged.
	 *****************************************************/
	public int peekMin()
	{
	    return heap.get(0);
	    // /*** YOUR IMPLEMENTATION HERE ***/
	}//O(1)
	
	
	
	/*****************************************************
	 * removeMin() --- means of removing an element from heap
	 * Removes and returns least element in heap.
	 * Postcondition: Tree maintains heap property.
	 *****************************************************/
	public int removeMin()
	{	if ( heap.size() == 0 )
		return 0;
	    
	    //store root value for return at end of fxn
	    Integer retVal = peekMin();
	    
	    //store val about to be swapped into root
	    Integer foo = heap.get( heap.size() - 1);
	    
	    //swap last (rightmost, deepest) leaf with root
	    swap( 0, heap.size() - 1 );
	    heap.remove(heap.size()-1);
	    int pos = 0;//index
	    int minChildPos;
	    while( pos < heap.size() ) {
		
		//choose child w/ min value, or check for child
		minChildPos = minChildPos(pos);
		
		//if no children, then i've walked far enough
		if ( minChildPos == -1 )
		    break;
		//if i am less than my least child, then i've walked far enough
		else if ( foo.compareTo( heap.get(minChildPos) ) <= 0 )
		    break;
		//if i am > least child, swap with that child
		else {
		    swap( pos, minChildPos );
		    pos = minChildPos;
		}
	    }
	    //return removed value
	    return retVal;
	}//O(logn)
	
	
	
	/*****************************************************
	 * minChildPos(int) --- helper fxn for removeMin()
	 * Returns index of least child, or
	 * -1 if no children, or if input pos is not in ArrayList
	 * Postcondition: Tree unchanged
	 *****************************************************/
	private int minChildPos( int pos ) {
	    int retVal;
	    int lc = 2*pos + 1; //index of left child
	    int rc = 2*pos + 2; //index of right child
	    
	    //pos is not in the heap or pos is a leaf position
	    if ( pos < 0 || pos >= heap.size() || lc >= heap.size() )
		retVal = -1;
	    //if no right child, then left child is only option for min
	    else if ( rc >= heap.size() )
		retVal = lc;
	    //have 2 children, so compare to find least
	    else if ( heap.get(lc).compareTo(heap.get(rc)) < 0 )
		retVal = lc;
	    else
		retVal = rc;
	    return retVal;
	}//O(1)
	
	
	
	//~~~~~~~~~~~~~~~v~ MISC HELPERS ~v~~~~~~~~~~~~~~~
	
	private void swap ( int pos1, int pos2){
	    int stuff = heap.get(pos1);
	    heap.set(pos1,heap.get(pos2));
	    heap.set(pos2,stuff);
	}
	
	private int getLeft(int pos){
	    return pos*2 + 1;
	}
	private int getRight(int pos){
	    return pos*2 + 2;
	}
	private int getParent(int pos){
	    return (pos - 1)/2;
	}
	// perhaps a minOf(Integer,Integer)... ?
	
    //~~~~~~~~~~~~~~~^~ MISC HELPERS ~^~~~~~~~~~~~~~~~
	
	
	
    /*****************************************************
     * toString() --- overrides inherited method
     * Returns either
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
	public String toString()
	{
	    String lel=ESC + "2J";
	    for (int i=0; i<heap.size();i++){
		if (i<10){//for spacing in single digits
		    lel=lel + i + "  ";
		    int j=heap.get(i);
		    while(j>=10){ //for spacing
			lel=lel+" ";
			j=j/10;
		    }
		}
		else {//for spacing in double digits
		    lel=lel+i;
		    int j=heap.get(i);
		    while(j>=10){
			lel=lel+" ";
			j=j/10;
		    }
		}
	    }
	
	    String retstr="Heap: " + heap.toString()+"\n";
	    retstr+="Index: "+ lel+ "\n";
	    return retstr;
	}//O(?)
    }
}    
