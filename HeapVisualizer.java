import java.util.ArrayList;

public class HeapVisualizer<T>{
    final static String ESC = "\033[";
    private ALHeap<T> heap;
    public HeapVisualizer(ArrayList<T> lel){
	heap=new ALHeap<T>();
	for (T s : lel){
	    heap.add(s);
	}
    }
    public void add(T stuff){
	heap.add(stuff);
	System.out.println(ESC+"2J");
	System.out.println(heap);
    }
    public void delete(){
	heap.removeMin();
	System.out.println(ESC+"2J");
	System.out.println(heap);
    }
	

    public class ALHeap<T> {
	
	//instance vars
	private ArrayList<T> heap; //underlying container
    
	
	/*****************************************************
	 * default constructor --- inits empty heap
	 *****************************************************/
	public ALHeap()
	{
	    heap= new ArrayList<T>();
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
	public void add( T addVal )
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
	public T peekMin()
	{
	    return heap.get(0);
	    // /*** YOUR IMPLEMENTATION HERE ***/
	}//O(1)
	
	
	
	/*****************************************************
	 * removeMin() --- means of removing an element from heap
	 * Removes and returns least element in heap.
	 * Postcondition: Tree maintains heap property.
	 *****************************************************/
	public T removeMin()
	{	if ( heap.size() == 0 )
		return null;
	    
	    //store root value for return at end of fxn
	    T retVal = peekMin();
	    
	    //store val about to be swapped into root
	    T foo = heap.get( heap.size() - 1);
	    
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
	    int spaces=0;
	    int dashes;
	    String retstr="";
	    if (isEmpty()){
		return heap.toString();
	    }
	    int height=1;
	    while (heap.size()>Math.pow(2,height)){
		height++;
	    }
	    int prevLength=heap.size()-1;
	    for (int i = height; i>0; i--){
		int length = Math.pow(2, i-1);
		prevLength=length-1;
		retstr="\n"+retstr;
		for(int k=0; k<spaces; k++){
		    retstr=
		for(int j=length;j<prevLength; j++){
		    retstr=retstr + "" + heap.get(j);
		
	    
	}//O(?)
	
	
    }    
}