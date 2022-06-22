import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String args[]) {
		PriorityQueue<String> queue = new PriorityQueue<String>();
		queue.add("Amit");  
		queue.add("Vijay");  
		queue.add("Karan");  
		queue.add("Jai");  
		queue.add("Rahul");  
		queue.add("Jai");  
		queue.add("Rahul");
		System.out.println("head:"+queue.element());  
		System.out.println("head:"+queue.peek());  
		queue.remove();
		queue.poll();
		System.out.println("head:"+queue.element());
		System.out.println("iterating the queue elements:");  
		Iterator it = queue.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		PriorityQueue<UserBean> queue1 = new PriorityQueue<UserBean>(); 
		
		UserBean bean = new UserBean(101,"Let us C","Yashwant Kanetkar","BPB",8);
		UserBean bean1 = new UserBean(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
		UserBean bean2 = new UserBean(103,"Operating System","Galvin","Wiley",6);
			
		queue1.add(bean); /// In this Line it will give runtime exception of Comparable 
							//if UserBean not implements Comparable Interface
		queue1.add(bean1);
		queue1.add(bean2);
//		Collections.sort(new ArrayList<UserBean>(queue1));
		for(UserBean b: queue1) {
			System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
						/** For every three object, publisher will be Wiley as it is STATIC variable*/
		}
	}
}
