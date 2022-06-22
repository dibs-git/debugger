import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {
	
	public static void main(String[] args) {
		
		Hashtable<Integer, String> hTable = new Hashtable<Integer, String>();
			
		hTable.put(100, "Ravi");
		hTable.put(101, "Amritesh");
		hTable.put(102, "Santosh");
		hTable.put(103, "Dibakar");
//		hTable.put(null, null); // it will give runtime exception as HashTable do not allow null key or null value
		
		for(Map.Entry<Integer, String> en: hTable.entrySet())
			System.out.println(en.getKey() + " = "+ en.getValue());
		
		hTable.remove(102);
		
		System.out.println(hTable);
		System.out.println(hTable.getOrDefault(102, "Not Found"));
		
		hTable.putIfAbsent(102, "Santosh");
		hTable.putIfAbsent(103, "Saurav");
		
		System.out.println(hTable);
		
		Map<Integer, UserBean> hBook = new Hashtable<Integer, UserBean>();
		
		UserBean bean = new UserBean(101,"Let us C","Yashwant Kanetkar","BPB",8);
		UserBean bean1 = new UserBean(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
		UserBean bean2 = new UserBean(103,"Operating System","Galvin","Wiley",6);
		
		hBook.put(1, bean);
		hBook.put(2, bean1);
		hBook.put(3, bean2);
		
		hBook.forEach((k,v) -> System.out.println(k + " = "+ v.toString()));
	}
}
