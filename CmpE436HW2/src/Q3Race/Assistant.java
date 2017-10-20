package Q3Race;

public class Assistant extends Thread {
	Paper paper;
	public Assistant(Paper paper) {
		this.paper = paper;
	}
	
	@Override
	public void run() {
		// Assistant is always super busy.
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		paper.letterGrade = (paper.numberGrade < 50) ? "Fail" : "Pass";

		System.out.println("Questions answered: " + paper.questionsAnswered);
		System.out.println("Number grade: " + paper.numberGrade);
		System.out.println("Letter grade: " + paper.letterGrade);
	}
}
