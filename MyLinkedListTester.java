/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.remove(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		String a = "Li Xiaopeng";
		MyLinkedList<Character> husband = new MyLinkedList<Character>();
		for (int i = 0; i < a.length(); i++) {
			husband.add(a.charAt(i));
			assertEquals("Add: check whether the newly added element is correct ", a.charAt(i), (char)husband.get(i));
		}
		
		try {
			husband.add(null);
			fail("Check intert null element");
		}
		catch (NullPointerException e) {
			
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("Size: check the size of shortList is correct", 2, shortList.size());
		assertEquals("Size: check the size of longerList is correct ", 10, longerList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		int[] a = {1, 9, 9, 3, 1, 1, 0, 7};
		MyLinkedList<Integer> birthday = new MyLinkedList<Integer>();
		for (int i = 0; i < a.length; i++) {
			birthday.add(i, a[i]);
			assertEquals("Add: check whether the newly added element is correct ", a[i], (int)birthday.get(i));
		}
		
		try {
			birthday.add(8, null);
			fail("Check intert null element");
		}
		catch (NullPointerException e) {
			
		}
		
		try {
			birthday.add(-1, 2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			birthday.add(9, 2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    MyLinkedList<String> sun = new MyLinkedList<String>();
	    sun.add("S");
	    sun.add("U");
	    sun.add("N");
	    sun.set(1, "O");
	    assertEquals("Set: check whether the set is correct ", "O", sun.get(1));
	    
	    try {
			sun.set(-1, "W");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			sun.set(3, "G");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	}
	
	
	
}
