package Q1;

public class LockSetRace {
	static int raceVar = 0;
	public static void main(String[] args) {
		
		BinarySemaphore s = new BinarySemaphore();
		LockSetRaceThread t1 = new LockSetRaceThread(s, 5);
		LockSetRaceThread t2 = new LockSetRaceThread(s, 15);
		
		t1.start();
		t2.start();
		while(t1.isAlive() || t2.isAlive());
	}
}
