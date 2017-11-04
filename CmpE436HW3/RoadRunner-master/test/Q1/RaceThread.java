package test.Q1;

public class RaceThread extends Thread {
		BinarySemaphore mutex;
		int val;
		
		public RaceThread (BinarySemaphore mutex, int val) {
			this.mutex = mutex;
			this.val = val;
		}
		
		@Override
		public void run() {
			mutex.take();
			LockSetRace.raceVar = val;
			mutex.release();
		}

}
