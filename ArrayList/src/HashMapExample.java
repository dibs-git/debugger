import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {

	public static void main(String args[]) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1,"Mango");  //Put elements in Map  
		map.put(2,"Apple");    
		map.put(3,"Banana");   
		map.put(4,"Grapes"); 
		map.put(2,"Grapese");
		map.replace(3, "Date");
		map.replace(4, "Grapes", "Banana");
		
		map.forEach((k,v) -> {System.out.println("Key "+ k + " Value "+ v);});
		
		for(Map.Entry<Integer, String> m: map.entrySet()) {
			System.out.println(m.getKey() + "   "+m.getValue());
		}
		
		for(Integer k: map.keySet()) {
			System.out.println(k);
		}
		
		for(String v: map.values()) {
			System.out.println(v);
		}
		Map<Integer,UserBean> mapList=new HashMap<Integer,UserBean>();   
		
		UserBean bean = new UserBean(101,"Let us C","Yashwant Kanetkar","BPB",8);
		UserBean bean1 = new UserBean(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
		UserBean bean2 = new UserBean(103,"Operating System","Galvin","Wiley",6);
		
		mapList.put(1, bean);
		mapList.put(2, bean1);
		mapList.put(3, bean2);
		
		for(Map.Entry<Integer, UserBean> m: mapList.entrySet()) {
			System.out.println(m.getValue().toString());
		}
	}
}
