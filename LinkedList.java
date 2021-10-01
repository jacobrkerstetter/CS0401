import java.io.*;
import java.util.*;

public class LinkedList
{
	private Node head;  // REF TO 1ST ELEM IN LIST

	// #######################################################################
	// #### G I V E N  A S  I S.  D O  N O T  M O D I F Y / D E L E T E   ####
	// #######################################################################

	public LList()
	{	head = null; //MUST BE INIALIZED TO NULL
	}

	// LOAD LINKED LIST FROM INCOMING FILE
	public LList( String fileName )
	{	Scanner infile=null;
		try
		{	infile = new Scanner( new File( fileName ) );
		}
		catch ( Exception e )
		{	System.out.println( "FATAL ERROR: " + e );
			System.exit(0);
		}
		while ( infile.hasNext() ) insertAtFront( infile.next() );
		infile.close();
	}

	// SPLICE NEW ELEM ONTO FRONT PUSH EXISTING ELEMs TO RIGHT
	public void insertAtFront( String data)
	{	head = new Node(data,head);
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// $$$$$ Y O U  W R I T E  T H E S E  F O U R  M E T H O D S  B E L O W $$$$$
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// WORTH 15%  WRITE & TEST THIS ONE FIRST
	public int size()
	{	
		int count = 0;

		for (Node curr = head; curr != null; curr = curr.getNext()) {
			count++;
		}
		
		return count; // REPLACE W/YOUR CODE. TRAVERSE LIST & COUNT Nodes
	}

	// WORTH 25%  WRITE & TEST THIS ONE SECOND
	public void printList()
	{	
		for (Node curr = head; curr != null; curr = curr.getNext()) {
			if (curr.getNext() == null)
				System.out.print(curr.getData());
			else
				System.out.print(curr.getData() + "->");

		}

		System.out.println();
	}

	// WORTH 35% WRITE & TEST THIS ONE THIRD
	// RETURN TRUE/FALSE Node CONTAINING KEY FOUND IN LIST
	public boolean contains( String key )
	{
		for (Node curr = head; curr != null; curr = curr.getNext()) {
			if (curr.getData().equals(key))
				return true;
		}

		return false;
	}

	// WORTH 25%   WRITE & TEST THIS ONE LAST. NO ANY ADDITINAL DATA STRUCTURES
	// NO ARROWS BETWEEN ELEMENTS. JUST PUT ONE SPACE BETWEEN
 
	// ### H I N T:  U S E  R E C U R S I O N  ###
	public void printListRev()
	{
		printListRev(this.head);
		System.out.println();
	}

	private void printListRev(Node head)
	{
		if (head == null) return;

		else {
			printListRev(head.getNext());
			System.out.print(head.getData() + " ");
		}
	}

} //END LINKEDLIST CLASS
