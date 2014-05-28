import java.util.*;
import java.io.*;

public class ArrayListVisualizer<T>{
    final static String ESC = "\033[";
    private ArrayList<T> arraylist;
    public ArrayListVisualizer(ArrayList<T> lel){
	arraylist=lel;
    }
    public void add(T stuff){
	arraylist.add(stuff);
	System.out.print(ESC + "2J"); //clear the screen
	System.out.println(arraylist); 
    }
    public void insert(int index, T stuff){
	try {
	    arraylist.set(index,stuff);
	    System.out.print(ESC+"2J");
	    System.out.println(arraylist);
	}
	catch (Exception e){
	    System.out.println(e.getMessage() + ": Invalid index. Try again");
	}
    }
    public void delete(int index){
	arraylist.remove(index);
	System.out.print(ESC + "2J"); //clear the screen
	System.out.println(arraylist);
    }
}