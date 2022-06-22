import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListExample {
	public static void main(String args[]) {
		/*
		 * Creation of ArrayList: I'm going to add String elements so I made it of
		 * string type
		 */
		ArrayList<String> obj = new ArrayList<String>();

		/* This is how elements should be added to the array list */
		obj.add("Ajeet");
		obj.add("Harry");
		obj.add("Chaitanya");
		obj.add("Steve");
		obj.add("Anuj");

		/* Displaying array list elements */
		System.out.println("Currently the array list has following elements:" + obj);

		/* Add element at the given index */
		obj.add(0, "Rahul");
		obj.add(1, "Justin");
		System.out.println("Index :" + obj);
		/* Remove elements from array list like this */
		obj.remove("Chaitanya");
		obj.remove("Harry");

		System.out.println("Current array list is:" + obj);

		/* Remove element from the given index */
		obj.remove(1);

		System.out.println("Current array list is:" + obj);

		System.out.println("Convert ArrayList to Array... ");

		String[] item = obj.toArray(new String[obj.size()]);

		System.out.println("Printing Array " + item.length + "  " + item[0]);

		System.out.println("Convert Array to ArrayList.... ");

		List<String> itemList = new ArrayList<>(Arrays.asList(item));

		System.out.println("Printing ArrayList --- " + itemList);

		ArrayList<String> al = new ArrayList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ajay");
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("Ravwi");
		al2.add("Hanumat");
		al2.add("Vijay");
		al2.add("Santosh");
		al.retainAll(al2);
		System.out.println("iterating the elements after retaining the elements of al2" + al);
		System.out.println("_____________________________");
		Collections.sort(al2, Collections.reverseOrder()); // descending order sorting
//	  System.out.println(al2);
		Iterator<String> itr = al2.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		Collections.reverse(al2);
//		System.out.println(al2);
		ListIterator<String> t = al2.listIterator();
		while (t.hasNext()) {
			System.out.println(t.next());
		}
		System.out.println("Printing in reverse order...");
		// without hasNext hasPrevious will not work..
		while (t.hasPrevious()) {
			System.out.println(t.previous());
		}

		LinkedList<String> ll = new LinkedList<String>();
		ll.add("Ravi");
		ll.add("Vijay");
		ll.add("Ajay");

		Collections.sort(ll);
		System.out.println("Printing in descending order...");
		Iterator<String> it = ll.descendingIterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
