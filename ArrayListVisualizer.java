import java.util.*;
import java.io.*;

public class ArrayListVisualizer<T>{
    final static String ESC = "\033[";
    private ArrayList<T> arraylist;
    public ArrayListVisualizer(ArrayList<T> lel){
	arraylist=lel;
    }
    public ArrayListVisualizer(){
	arraylist= new ArrayList<T>();
    }
    public void add(T stuff){
	arraylist.add(stuff); //clear the screen
	System.out.println(arraylist); 
    }
    public void insert(int index, T stuff){
	try {
	    arraylist.set(index,stuff);
	    System.out.println(arraylist);
	}
	catch (Exception e){
	    System.out.println(e.getMessage() + ": Invalid index. Try again");
	}
    }
    public void delete(int index){
	arraylist.remove(index); //clear the screen
	System.out.println(arraylist);
     
    }
    public String toString()
    {
	String lel=ESC + "2J";
	for (int i=0; i<arraylist.size();i++){
	    if (i<10){//for spacing in single digits indeces
		lel=lel + i + "  ";
	 	T j=arraylist.get(i);
		try{
		    while(j.compareTo( (Integer)10)>=0){ //for spacing
			lel=lel+" ";
			j=j/10;
		    }
		}
		catch (Exception e){
		    while(j.length>=2){
			lel=lel+" ";
			j=j.substring(0,j.length-1);
		    }
		}
	    }
	    else {//for spacing in double digits
		lel=lel+i;
		T j=arraylist.get(i);
		while(j>=10){
		    lel=lel+" ";
		    j=j/10;
		}
	    }
	}
	
	String retstr="Arraylist: " + arraylist.toString()+"\n";
	retstr+="Index: "+ lel+ "\n";
	return retstr;
    }//O(?)
}

