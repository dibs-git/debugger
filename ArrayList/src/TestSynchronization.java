import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/*This Program is an example of difference between "Non Synchronized ArrayList" and "Synchronized
 * Vector List". Here if we try to manipulate same ArrayList at a time using multiple threads through
 * NON Synchronized method (printTable) it will throw ConcurrentModificationException error. Because
 * at the time of list sorting, other element inserted using different thread. And as the ArrayList is
 * NOT Synchronized, it throws error. But As the VECTOR is Synchronized, we can't do this kind of 
 * manipulation on a VECTOR type list at the same time using multiple thread, even through NON
 * Synchronized method.
 * 
 * So, VECTOR is Thread Safe but ArrayList is not.
 * 
 * And though if we want to use ArrayList in this below situation, we can use Synchronized Method.So
 *  that more than one thread will not access same list at a time.*/
public class TestSynchronization {
	
	static ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1000));
	//static Vector<Integer> list = new Vector<Integer>(Arrays.asList(1000));
	
	static /* synchronized */ void printTable(int n) {
		//TestSynchronization synchronization = new TestSynchronization();
		//Collections.synchronizedList(list);
		for(int i = 1; i<=5; i++) {
			System.out.println(n*i);
			//list.remove(i);
			//System.out.println(list.get(1));
			list.add(n*i);
			//synchronized(list) {
				Collections.sort(list);
			//}
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		  list.forEach(ls -> { System.out.print(ls + " - "); }); // Lamda Expression
		  System.out.println();
		 
	}
	
//	static void printTable1(int n) {
//		//TestSynchronization synchronization = new TestSynchronization();
//		for(int i = 1; i<=5; i++) {
//			System.out.println(n*i);
//			list.add(n*i);
//			//list.remove(i);
//			//System.out.println(list.get(1));
//			Collections.sort(list);
//			try {
//				Thread.sleep(400);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		/*
//		 * list.forEach(ls -> { System.out.print(ls + " - "); }); // Lamda Expression
//		 * System.out.println();
//		 */
//	}
	
	public static void main(String[] args) {
		
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		MyThread3 t3 = new MyThread3();
		
		t1.start();
		//t2.start();
		t3.start();
		
		/*
		 * for (int l : list) { System.out.print(l + ','); }
		 */
		/*
		 * list.forEach(ls -> { System.out.print(ls + " , "); }); // Lamda Expression
		 * System.out.println();
		 */
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		
//		Enumeration en = list.elements();
//		while(en.hasMoreElements()) {
//			System.out.println(en.nextElement());
//		}
		
	}

}

class MyThread1 extends Thread{
	
	public void run() {
		TestSynchronization.printTable(5);
	}
}

class MyThread2 extends Thread{
	
	public void run() {
		TestSynchronization.printTable(100);
	}
}

class MyThread3 extends Thread{
	
	public void run() {
		TestSynchronization.printTable(1000);
	}
}