public class QueueVisualizer<T>{
	private LLQueue<T> queue;
	public QueueVisualizer(){
		queue= new LLQueue<T>();
		}
	
	public void add(T stuff){
	queue.enqueue(stuff);
	System.out.println(queue);
    }
    public void delete(){
	T tmp = queue.dequeue();
	System.out.println ("" + tmp);
	System.out.println(queue);
    }
    
    public void peek () {
	System.out.println (queue.peekFront());
	System.out.println(queue);
    }
    public String toString(){
	return queue.toString();
    }
	public class LLQueue<T> implements Queue<T> {

    	private LLNode<T> _front, _end;

    // default constructor creates an empty queue
   		 public LLQueue() { 
		_front= null;
		_end= null;
    	}

    	// means of adding a thing to the collection
    	public void enqueue( T enQVal ) {
		if (isEmpty()){
	    	_front=_end=new LLNode<T>(enQVal, null);
		}
		else {
	    	LLNode<T> temp = new LLNode<T>(enQVal,null);
	    	_end.setNext(temp);
	    	_end=_end.getNext();
		}
    	}//O(1) constant
    

    // means of removing a thing from the collection
    // Remove and return thing at front of queue.
    // Assume _queue ! empty.
    public T dequeue() { 
	T retval= _front.getValue();
	LLNode<T> temp = _front.getNext();
	_front = temp;
	return retval;
    }//O(1) constant time


    // means of peeking at thing next in line for removal
    public T peekFront() {
	return _front.getValue();
    }//O(?)


    public boolean isEmpty() {
	return _front==null;
    }//O(?)


    // print each node, separated by spaces
    public String toString() { 
	String foo = "";
	LLNode<T> tmp = _front;
	while ( tmp != null ) {
	    foo += tmp.getValue() + " ";
	    tmp = tmp.getNext();
	}
	return foo;
    }//O(?)

}//end class LLQueue
public interface Queue<Quasar> {

    //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue();

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x );

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty();

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront();
    //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~


}//end interface Queue
public class LLNode<T> {

    private T _cargo;    //cargo may only be of type T
    private LLNode<T> _nextNode; //pointer to next LLNode


    // constructor -- initializes instance vars
    public LLNode( T value, LLNode<T> next ) {
	_cargo = value;
	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public T getValue() { return _cargo; }

    public LLNode<T> getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setValue( T newCargo ) {
	T foo = getValue();
	_cargo = newCargo;
	return foo;
    }

    public LLNode<T> setNext( LLNode<T> newNext ) {
	LLNode<T> foo = getNext();
	_nextNode = newNext;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }

}//end class LLNode
}