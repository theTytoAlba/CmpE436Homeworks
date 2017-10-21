package Q2Deadlock;

public class BinarySemaphore {
	private boolean forkTaken = false;

	public synchronized void take() {
		while (forkTaken)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		forkTaken = true;
	}

	public synchronized void release() {
		forkTaken = false;
		notify();
	}
}
