package test.Q1;

public class BinarySemaphore {
	private boolean taken = false;

	public synchronized void take() {
		while (taken)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		taken = true;
	}

	public synchronized void release() {
		taken = false;
		notify();
	}
}
