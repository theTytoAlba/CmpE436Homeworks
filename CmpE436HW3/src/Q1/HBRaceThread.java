package Q1;

public class HBRaceThread extends Thread {
		CountingSemaphore mutex;
		int val;
		
		public HBRaceThread (CountingSemaphore mutex, int val) {
			this.mutex = mutex;
			this.val = val;
		}
		
		@Override
		public void run() {
			mutex.P();
			HappensBeforeRace.raceVar = val;
			System.out.println(val + " " + HappensBeforeRace.raceVar);
			mutex.V();
		}

}
