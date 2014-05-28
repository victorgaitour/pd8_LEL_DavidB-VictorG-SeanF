import java.util.*;
import java.io.*;

public class ArrayListVisualizer<T>{
    final static String ESC = "\033[";
    private ArrayList<T> arraylist;
    public ArrayListVisualizer(ArrayList<T>){
	arraylist=new ArrayList<T>();
    }
    public void add(T stuff){
	arraylist.add(stuff);
	System.out.print(ESC + "2J"); //clear the screen
	System.out.println(arraylist); 
    }
    public void delete(int index){
	arraylist.remove(index);
	System.out.print(ESC + "2J"); //clear the screen
	System.out.println(arraylist);
    }
}