public class TreeNode <T extends Comparable<T>>  {


    //instance variables / attributes of a TreeNode:
    private T cargo;
    private TreeNode right, left;




    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode( T initValue )
    {
	cargo = initValue;
	left = null;
	right = null;
    }
          


    /*****************************************************
     * overloaded constructor
     * Construct a tree node with specified value, left, and right subtrees.
     *****************************************************/
    TreeNode( T initValue, TreeNode initLeft, TreeNode initRight ) 
    {
	cargo = initValue;
	left = initLeft;
	right = initRight;
	   
    }
 


    /*****************************************************
     * Returns the left subtree of this node.
     *****************************************************/
    TreeNode getLeft() 
    {
	return left;
    }




    /*****************************************************
     * Returns the right subtree of this node.
     *****************************************************/
    TreeNode getRight() 
    {
	return right;
    }




    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    T getValue() 
    {
        return cargo;
    }




    /*****************************************************
     * Sets the value of the left subtree of this node.
     *****************************************************/
    void setLeft( TreeNode theNewLeft ) 
    {
	left = theNewLeft;
    }




    /*****************************************************
     * Sets the value of the right subtree of this node.
     *****************************************************/
    void setRight( TreeNode theNewRight ) 
    {
        right = theNewRight;
    }




    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    void setValue( T theNewValue ) 
    {
	cargo = theNewValue;
    }
 
}//end class
