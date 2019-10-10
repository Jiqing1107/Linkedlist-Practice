package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 * @return 
	 */
	public boolean add(E element ) 
	{
		if(element != null) {
			LLNode<E> node = new LLNode<E>(element);
			if (head == null) {
				head = node;
				tail = node;
				head.next = null;
				tail.prev = null;
			}
			else {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
			size++;
			return true;
		}
		else {
			throw new NullPointerException();
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index >=0 && index < size) {
			LLNode<E> node = head;
			for(int i = index; i > 0; i--) {
				node = node.next;
			}
			return node.data;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (element != null) {
			LLNode<E> node = new LLNode<E>(element);
			if (index >= 0 && index <= size) {
				if(size == 0) {
					head = node;
					tail = node;
				}
				else {
					if (index == 0) {
						head.prev = node;
						node.next = head;
						head = node;
					}
					else if (index == size) {
						tail.next = node;
						node.prev = tail;
						tail = node;
					}
					else {
						LLNode<E> node_tmp = head;
						for (int i = index; i > 0; i--) {
							node_tmp = node_tmp.next;
						}
						node.next = node_tmp;
						node.prev = node_tmp.prev;
						node_tmp.prev.next = node;
						node_tmp.prev = node;
					}
				}
				size++;
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
		else {
			throw new NullPointerException();
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove (int index) 
	{
		if (size == 1) {
			if (index == 0) {
				E out;
				out = head.data;
				head = null;
				size--;
				return out;
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
		if (size > 1) {
			if (index >= 0 && index < size) {
				E out;
				if (index == 0) {
					out = head.data;
					head = head.next;
					head.prev = null;
				}
				else if (index == size - 1) {
					out = tail.data;
					tail = tail.prev;
					tail.next = null;
				}
				else {
					LLNode<E> node = head;
					for (int i = index; i > 0; i--) {
						node = node.next;
					}
					out = node.data;
					node.prev.next = node.next;
					node.next.prev = node.prev;
				}
				size--;
				return out;
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
		else {
			throw new NullPointerException();
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (element != null) {
			if (index >=0 && index < size) {
				LLNode<E> node = head;
				for(int i = index; i > 0; i--) {
					node = node.next;
				}
				E out = node.data;
				node.data = element;
				return out;
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
		else {
			throw new NullPointerException();
		}
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
