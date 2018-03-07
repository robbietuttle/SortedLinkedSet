/**
 * A linked-node implementation of the Set ADT in which elements of the set
 * are always sorted (in this case, lexicographically, which is a fancy
 * way of saying "alphabetically").  Note that the String class has a compareTo
 * method which you should be using to assist you in keeping the set sorted.
 * 
 * @author robbietuttle
 */
public class SortedSet implements SetInterface<String> {


	//--------------------------------------------------- Properties
	private Node head;
	private int size;

	//--------------------------------------------------- Constructor
	/**
	 * Constructs an empty Set by initializing head node.
	 * Initialize size to zero.
	 */
	public SortedSet() {
		head = null;
		size = 0;
	}

	//--------------------------------------------------- Methods

	/** Gets the current number of entries in this set.
    @return  The integer number of entries currently in the set. */
	@Override
	public int getCurrentSize() {
		return size;
	}

	/** Sees whether this set is empty.
    @return  True if the set is empty, or false if not. */
	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	/** Adds a new entry to this set, avoiding duplicates.
    @param newEntry  The object to be added as a new entry.
    @return  True if the addition is successful, or
             false if the item already is in the set. */
	@Override
	public boolean add(String newEntry) {
		if(contains(newEntry)) {
			return false;
		}
		// make new node
		Node current = new Node(newEntry);
		// if the list is empty make the new node the head
		if (head == null){
			head = current;
			size++;
			return true;
		}
		// if the list isnt empty see if the new node goes at the head
		else if (newEntry.compareTo(head.data) < 0){
			current.next = head;
			head = current;
		}
		// else find where the new node goes and insert it into the proper spot
		else{
			Node after = head.next;
			Node before = head;
			while (after != null){
				if (newEntry.compareTo(after.data) < 0)
					break;
				before = after;
				after = after.next;
			}
			current.next = before.next;
			before.next = current;
		}
		size++;
		return true;
	}

	/** Removes a specific entry from this set, if possible.
	    @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
	@Override
	public boolean remove(String anEntry) {
		if(isEmpty()) {
			return false;
		}
		if(head.data.equals(anEntry)) {
			head = head.next;
			return true;
		}
		
		Node now = head;
		
		while(now.next != null) {
			if(anEntry.equals(now.next.data)) {
				now.next = now.next.next;
				size--;
				return true;
			}
			if(anEntry.compareTo(now.next.data)>0) {
				now = now.next;
			}else {
				return false;
			}
		}
		return false;
	}

	/** Removes one unspecified entry from this set, if possible.
    @return  Either the removed entry, if the removal
             was successful, or null. */
	@Override
	public String remove() {
		if(head == null)
			return null;
		Node ret = head;
		head = head.next;
		size--;
		return ret.data;
	}

	/** Removes all entries from this set. */
	@Override
	public void clear() {
		head =null;
		size=0;
	}

	/** Tests whether this set contains a given entry.
    @param anEntry  The entry to locate.
    @return  True if the set contains anEntry, or false if not. */
	@Override
	public boolean contains(String anEntry) {
		Node current = head;  //points to first element "like saying i =0"
		while(current != null) {
			if(current.data.equals(anEntry)) { return true; } //if current data = value return true
			current = current.next;     //if its not equal to the value move current to next
		}
		return false;
	}

	/*
	 * returns a string representation of the items in the bag,
	 * specifically a space separated list of the strings, enclosed
	 * in square brackets [].  For example, if the set contained
	 * cat, dog, then this should return "[cat dog]".  If the
	 * set were empty, then this should return "[]".
	 */
	@Override
	public String toString() {
		String result = "[";
		Node current = head;
		while (current != null) {
			result = result + current.data + " ";
			current = current.next;
		}
		if(result.length()>1)
			result = result.substring(0,result.length()-1);
		result= result+"]";
		return result;
	}

	/** Retrieves all entries that are in this set.
	 @return  A newly allocated array of all the entries in the set. */
	@Override
	public String[] toArray() {
		Node current = head;
		String[] ret = new String[size];
		for(int i = 0 ; i<size ; i++) {
			ret[i]=current.data;
			current = current.next;		
		}
		return ret;
	}


	// A private inner class.
	private class Node {
		private String data;
		private Node next;

		private Node(String data) {
			this.data = data;
		}
	}
}