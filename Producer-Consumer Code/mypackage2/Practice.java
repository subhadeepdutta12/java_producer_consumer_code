package mypackage2;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Practice {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> product_list= new ArrayBlockingQueue<>(5);
		Thread t1= new Thread(new Producer(product_list));
		Thread t2= new Thread(new Consumer(product_list));
		
		t1.start();
		t2.start();
		

	}

}
