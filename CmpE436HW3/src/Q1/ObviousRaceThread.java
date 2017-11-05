package Q1;

public class ObviousRaceThread extends Thread {
	@Override
	public void run() {
		ObviousRace.var *= 50;
	}
}
