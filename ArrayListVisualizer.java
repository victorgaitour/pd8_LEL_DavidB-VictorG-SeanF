import java.util.*;
import java.io.*;

public class ArrayListVisualizer{
    final static String ESC = "\033[";
    private ArrayList<Integer> arraylist;
    public ArrayListVisualizer(ArrayList<Integer> lel){
	arraylist=lel;
    }
    public ArrayListVisualizer(){
	arraylist= new ArrayList<Integer>();
    }
    public void add(int stuff){
	arraylist.add(stuff); //clear the screen
	System.out.println(toString()); 
    }
    public void insert(int index, int stuff){
	try {
	    arraylist.set(index,stuff);
	    System.out.println(toString());
	}
	catch (Exception e){
	    System.out.println(e.getMessage() + ": Invalid index. Try again");
	}
    }
    public void delete(int index){
	arraylist.remove(index); //clear the screen
	System.out.println(toString());
     
    }
    public String toString()
    {
	 String retstr=ESC + "2J";
	 String lel="";
	 for (int i=0; i<arraylist.size();i++){
	     if (i<10){//for spacing in single digits
		 lel=lel + i + "  ";
		 int j=arraylist.get(i);
		 while(j>=10){ //for spacing
		     lel=lel+" ";
		     j=j/10;
		 }
	     }
	     else {
		 if (i==10){
		     lel=lel.substring(0,lel.length());//for spacing in double digits
		 }
		 lel=lel+i+" ";
		 int j=arraylist.get(i);
		 while(j>=10){
		     lel=lel+" ";
		     j=j/10;
		 }
	     }
	 }
	 
	 retstr+="Arraylist: " + arraylist.toString()+"\n";
	 retstr+="Index:      "+ lel+ "\n";
	 return retstr;
    }
}

