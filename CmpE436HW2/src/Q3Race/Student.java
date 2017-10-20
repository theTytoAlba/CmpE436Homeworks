package Q3Race;

public class Student extends Thread {
	Paper paper;
	public Student(Paper paper) {
		this.paper = paper;
	}

	@Override
	public void run() {
		// Student thinks the answers to the questions.
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		paper.questionsAnswered = 8;
	}
}
