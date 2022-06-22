import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String args[]) {
		List<String> lin = new LinkedList<String>();
		
		lin.add("Ravi");
		lin.add("Ajay");
		lin.add("David");
		
		Collections.sort(lin);
		
		lin.forEach(l -> System.out.println(l));
	}
}
