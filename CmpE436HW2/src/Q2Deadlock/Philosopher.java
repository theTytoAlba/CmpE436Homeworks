package Q2Deadlock;

public class Philosopher extends Thread {
	int id;
	
	public Philosopher(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		// Super hungry Philosopher. Needs 2 forks.
		// Takes left fork.
		Main.forks[id].take();
		// Takes right fork. Reaching for the fork takes time because they think it through.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		Main.forks[(id+1)%3].take();
		// Eats.
		eat();
		// Leaves forks.
		Main.forks[id].release();
		Main.forks[(id+1)%3].release();
		
	}
	
	private void eat() {
		System.out.println("Phil " + id + " eating.");
	}
}
