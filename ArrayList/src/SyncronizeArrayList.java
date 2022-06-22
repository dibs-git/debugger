import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SyncronizeArrayList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Arrays.asList("Ram","Ajay"));
		list.add("Jai");
		list.add("David");
		
		//list.forEach(ls -> {System.out.println(ls);});
		
		list = Collections.unmodifiableList(list);
		//list.add("Davidd");						// In this Line it will give error

		list = Collections.synchronizedList(list);
		synchronized (list) {
			//list.forEach(ls -> {System.out.println(ls);});
		}
		
		ArrayList<UserBean> bookList = new ArrayList<UserBean>();
		
		UserBean bean = new UserBean(101,"Let us C","Yashwant Kanetkar","BPB",8);
		UserBean bean1 = new UserBean(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
		UserBean bean2 = new UserBean(103,"Operating System","Galvin","Wiley",6);
		
		bookList.add(bean);
		bookList.add(bean1);
		bookList.add(bean2);
		
		for(UserBean b: bookList) {
			System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
		}
		
		Comparator<UserBean> com = (b1, b2) -> {
			if(b1.quantity > b2.quantity)
				return 1;
			else if(b1.quantity < b2.quantity)
				return -1;
			else
				return 0;
		};
				
				/*new Comparator<UserBean>() {
			
			@Override
			public int compare(UserBean o1, UserBean o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};*/
		
		Collections.sort(bookList, com);
		
		for(UserBean b: bookList) {
			System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
		}
	}
}
