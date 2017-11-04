package Q1;

public class LockSetRaceThread extends Thread {
		BinarySemaphore mutex;
		int val;
		
		public LockSetRaceThread (BinarySemaphore mutex, int val) {
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
