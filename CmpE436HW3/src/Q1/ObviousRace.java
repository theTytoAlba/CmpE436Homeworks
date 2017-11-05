package Q1;

public class ObviousRace {
	public static int var = 5;
	public static void main(String[] args) {
		ObviousRaceThread t1 = new ObviousRaceThread();
		
		t1.start();
		System.out.println(var);
		while(t1.isAlive());
	}
}
