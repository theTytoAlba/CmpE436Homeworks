package Q3Race;

public class Main {
	public static void main(String[] args) {
		// Say we have a Paper with 10 questions to be given to students and graded.
		Paper paper = new Paper();
		// We have a student to answer questions in paper.
		Student student = new Student(paper);
		// We have a professor to grade the paper.
		Professor professor = new Professor(paper);
		// We have an assistant to calculate letter grades.
		Assistant assistant = new Assistant(paper);
		
		// Student takes the exam.
		student.start();
		// Professor grades it.
		professor.start();
		// Assistant gives letters and announces results.
		assistant.start();
		
		// In the end paper is not graded nicely because race condition.
	}
}
