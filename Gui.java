import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
   


public class Gui implements ActionListener{
    private String structure= "";
    private String type = "";
    JTextField textfield;
    private JTextPane[][] display = new JTextPane [20] [20]; 

    public Gui () {
	try{
	    JOptionPane pane = new JOptionPane ();
	    Object[] datastruc = {"Array", "ArrayList", "BST", "Heap", "Stack", "LList"};
	    structure = (String)pane.showInputDialog(null, "Choose a Data Structure", "Data Structure Selection Menu",JOptionPane.QUESTION_MESSAGE, null, datastruc,"Array");

	    JOptionPane pane2 = new JOptionPane ();
	    Object[] datatypes = {"String", "Integer"};
	    String type = (String)pane2.showInputDialog(null, "Choose a Data Type/Value", "Data Type/Value Selection Menu",JOptionPane.QUESTION_MESSAGE, null, datatypes,"String");
	    
	    if (type == "" || structure == "") 
		System.exit (0);
	}
	catch (Exception e) {
	    System.exit (0);
	}
	

        JFrame guiFrame = new JFrame();
	//sets up interface
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("" + structure + " Visualizer");
        guiFrame.setSize(800,800);

	JPanel panel = new JPanel();

	JToolBar toolbar = new JToolBar();
	toolbar.setFloatable(false); 

        textfield = new JTextField(7);

	JButton i = new JButton("Insert (Index, Value)");
	JButton d = new JButton("Delete (Index)");
	JButton g = new JButton("Get (Index)"); 
	JButton s = new JButton("Set (Index, Value)");
	JButton p = new JButton("Export to CSV");
	toolbar.add(textfield);
	toolbar.add(i);
	toolbar.add(d);
	toolbar.add(g);	
	toolbar.add(s);
	toolbar.add(p);
	
	for (int m=0; m< 20; m++) {
	    for (int j=0; j< 20; j++) {
		display[m] [j] = new JTextPane();
		//sets it so that the text in the textpane cannot be typed over
		display[m][j].setEditable(false);
		display[m][j].setBackground (Color.WHITE);
		display[m][j].setForeground(Color.BLACK);
		display[m][j].setText (((m * 10) + j) + ": ");
		panel.add (display [m][j]);
	    }
	}


	guiFrame.getContentPane().add(panel, BorderLayout.CENTER);
	guiFrame.getContentPane().add(toolbar, BorderLayout.PAGE_START);

        guiFrame.validate();
        guiFrame.setVisible(true);

    }

    @Override 
    public void actionPerformed (ActionEvent e) {
	JButton b = (JButton)e.getSource();
	String action = b.getText();
	if (action.equals ("Export to CSV") {
		
		
	String value  = textfield.getText();
	textfield.setText("");
    }

   public static void main(String[] args) {
        new Gui();
    }
   

}

