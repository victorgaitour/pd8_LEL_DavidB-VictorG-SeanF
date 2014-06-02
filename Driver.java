public class Driver{
    public static void main (String args[]){
	HeapVisualizer pile= new HeapVisualizer();
	   
	
	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);
	
	pile.delete();
	System.out.println(pile);
	pile.delete();
	System.out.println(pile);/*
	System.out.println("removing " + pile.delete() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.delete() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.delete() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.delete() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.delete() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.delete() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.delete() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.delete() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.delete() + "...");
	System.out.println(pile);*/
    }
}
    
