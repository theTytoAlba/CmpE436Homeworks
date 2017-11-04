package Q1;

//Irmak Kavasoglu
//2013400090
//irmakkavasoglu@gmail.com
//CmpE436 Assignment 2.
public class CountingSemaphore { 
	 int value;
	 public CountingSemaphore(int initValue) {
	 value = initValue;
	 }
	 
	 // Take
	 public synchronized void P() {
	 while (value == 0)
		try {
			wait();
		} catch (InterruptedException e) {}
	 value--;
	}
	 
	 // Release
	 public synchronized void V() {
		 value++;
		 notify();
	 }
} 
