import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDequeExample {

	public static void main(String args[]) {
		
		Deque<String> deque = new ArrayDeque<String>();
		
		deque.offer("arvind");  
	    deque.offer("vimal");  
	    deque.add("mukul");  
	    deque.offerFirst("jai");  /// Add at first position
	    System.out.println("After offerFirst Traversal...");  
	    for(String s:deque){  
	        System.out.println(s);  
	    } 
	    
	    deque.pollFirst();
	    deque.pollLast();
	    System.out.println("After Poll Traversal...");  
	    deque.forEach(d -> System.out.println(d));
	    
	    Deque<UserBean> dequeList = new ArrayDeque<UserBean>();
	    
	    UserBean bean = new UserBean(101,"Let us C","Yashwant Kanetkar","BPB",8);
		UserBean bean1 = new UserBean(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
		UserBean bean2 = new UserBean(103,"Operating System","Galvin","Wiley",6);
		
		dequeList.add(bean);
		dequeList.add(bean1);
		dequeList.add(bean2);
		
		Iterator it = dequeList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
