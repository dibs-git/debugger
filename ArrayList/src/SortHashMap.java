import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortHashMap {

	public static void main(String args[]) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("Apple", 65000);  
		map.put("HP", 20000);  
		map.put("Dell", 32000);  
		map.put("Asus", 21478);  
		map.put("Samsung", 36546);  
		map.put("Lenovo", 19990);  
		
		System.out.println("Before Sorting.. "+ map);
		
		System.out.println("Sorting by Key Using TreeHashMap in Ascending Order..........");
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);
		
		Iterator<String> it = treeMap.keySet().iterator();
		
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str + " = " + treeMap.get(str));
		}
		
		System.out.println("Sorting by Key Using TreeHashMap in Descending Order..........");
		Map<String, Integer> treeMap1 = new TreeMap<String, Integer>((k1,k2) -> {return k2.compareTo(k1);});
		treeMap1.putAll(map);
		
		Iterator<String> itr = treeMap1.keySet().iterator();
		
		while(itr.hasNext()) {
			String str = itr.next();
			System.out.println(str + " = " + treeMap1.get(str));
		}
		
		System.out.println("Sorting by Value Using Comparator..............");
		SortHashMap sortMap = new SortHashMap();
		map = sortMap.sortMapValueAscending(map);
		
		System.out.println("Printing in Ascending Order........ ");
		for(Map.Entry<String, Integer> m : map.entrySet()) {
			System.out.println(m.getKey() + " = " + m.getValue());
		}
		
		map = sortMap.sortMapValueDescending(map);
		System.out.println("Printing in Dscending Order...........");
		
		map.forEach((k,v) ->{
			System.out.println(k + " = " + v);
		});
	}
	
	public Map<String, Integer> sortMapValueAscending(Map<String, Integer> mapList){
		
		List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(mapList.entrySet());
		
		Comparator<Entry<String, Integer>> com = (l1, l2) ->{
			return l1.getValue().compareTo(l2.getValue());
		};
		
		Collections.sort(list,com);
		
		//Map<String, Integer> sortedMap = new HashMap<String, Integer>();
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		
//		sortedMap = new LinkedHashMap<String, Integer>();
		//Local variable sortedMap defined in an enclosing scope must be final or effectively final
	
		list.forEach(k -> {
			//System.out.println(k.getKey() + "  " +k.getValue());
			sortedMap.put(k.getKey(), k.getValue());
		});
		
		return sortedMap;
	}
	
public Map<String, Integer> sortMapValueDescending(Map<String, Integer> mapList){
		
		List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(mapList.entrySet());
		
		Comparator<Entry<String, Integer>> com = new Comparator<Map.Entry<String,Integer>>() {
			
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		};
				
		Collections.sort(list,com);
		
		//Map<String, Integer> sortedMap = new HashMap<String, Integer>();
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		
		for(Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}
}
