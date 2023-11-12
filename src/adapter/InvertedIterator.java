package adapter;

import java.util.Iterator;

public interface InvertedIterator extends Iterator {
	// return the actual element and go to the previous
	public Object previous();

	// true if there is a previous element
	public boolean hasPrevious();

	// It is placed in the last element
	public void goLast();
} 
