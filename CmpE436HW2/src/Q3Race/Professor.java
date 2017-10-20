package Q3Race;

public class Professor extends Thread {
	Paper paper;
	public Professor(Paper paper) {
		this.paper = paper;
	}
	
	@Override
	public void run() {
		// Professor grades with caution.
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
		}
		paper.numberGrade = paper.questionsAnswered * 10;
	}
}
