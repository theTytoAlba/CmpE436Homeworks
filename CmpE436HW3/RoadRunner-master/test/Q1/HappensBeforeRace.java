package test.Q1;

public class HappensBeforeRace {
	static int raceVar = 0;
	public static void main(String[] args) {
		
		CountingSemaphore s = new CountingSemaphore(2);
		
		HBRaceThread t1 = new HBRaceThread(s, 5);
		HBRaceThread t2 = new HBRaceThread(s, 15);
		HBRaceThread t3 = new HBRaceThread(s, 25);
		HBRaceThread t4 = new HBRaceThread(s, 35);
		HBRaceThread t5 = new HBRaceThread(s, 45);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		while(t1.isAlive() || t2.isAlive() || t3.isAlive()|| t4.isAlive()|| t5.isAlive());
		System.out.println(raceVar);
	}
}
