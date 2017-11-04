package test.Q1;


public class LockSetRace {
	static int raceVar = 0;
	public static void main(String[] args) {
		
		BinarySemaphore s = new BinarySemaphore();
		RaceThread t1 = new RaceThread(s, 5);
		RaceThread t2 = new RaceThread(s, 15);
		
		t1.start();
		t2.start();
		while(t1.isAlive() || t2.isAlive());
	}
}
