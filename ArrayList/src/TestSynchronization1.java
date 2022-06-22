import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

	/**If we use two different object of Class Table, with NON static variable 'list', then it will NOT
	throw ConcurrentException.
	
	If we use two different object of Class Table, with static variable 'list', then it will
	throw ConcurrentException. 
	
	If we use two same object of Class Table, with NON static variable 'list', then it will 
	throw ConcurrentException. 
	
	If we use two same object of Class Table, with static variable 'list', then it will
	throw ConcurrentException. */

class Table {
	
	static ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1000));
	void printTable(int n) {// method not synchronized
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			list.add(n*i);
			list.get(i);
			Collections.sort(list);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}

class MyThread4 extends Thread {
	Table t;

	MyThread4(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread5 extends Thread {
	Table t;

	MyThread5(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}

class TestSynchronization1 {
	public static void main(String args[]) {
		Table obj = new Table();// only one object
		MyThread4 t1 = new MyThread4(obj);
		//Table obj1 = new Table();			
		MyThread5 t2 = new MyThread5(obj);
		t1.start();
		t2.start();
	}
}