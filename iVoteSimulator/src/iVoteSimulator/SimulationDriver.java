package iVoteSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver {
	
	public static void main(String[] args) throws Exception {
		
		//Creating a single choice question, getting student input, and testing
		String title = "What is the first letter of the alphabet?";
		List<QuestionOption> qList = new ArrayList<QuestionOption>();
		qList.add(new QuestionOption("A",true));
		qList.add(new QuestionOption("B",false));
		qList.add(new QuestionOption("C",false));
		qList.add(new QuestionOption("D",false));
		IQuestion qsc = new QuestionSC(title, qList);
		
		VotingService vs = new VotingService(qsc);
		
		Random rand = new Random();
		
		vs.printQuestion();
		Student s;
		for (int i = 0; i < 20; i++) {
			s = new Student( Integer.toString(rand.nextInt(1000)) );
			List<Integer> answers = s.generateAnswers(vs.getOptionsString(), 
													  vs.isMultipleChoice());
			vs.addAnswer(s.getId(), answers);
		}
		vs.printStudentAnswers();
		vs.printCorrect();
		
		//Doing the same for a MC Question
		title = "Which of the following are ways to say hello in a language?";
		qList.clear();
		qList.add(new QuestionOption("Hello", true));
		qList.add(new QuestionOption("Goodbye", false));
		qList.add(new QuestionOption("Guten Tag", true));
		qList.add(new QuestionOption("Hola", true));
		qList.add(new QuestionOption("Domo Arigato", false));
		
		IQuestion qmc = new QuestionMC(title,qList);
		vs = new VotingService(qmc);
		
		vs.printQuestion();
		for (int i = 0; i < 20; i++) {
			s = new Student( Integer.toString(rand.nextInt(1000)) );
			List<Integer> answers = s.generateAnswers(vs.getOptionsString(),
													  vs.isMultipleChoice());
			vs.addAnswer(s.getId(), answers);
		}
		vs.printStudentAnswers();
		vs.printCorrect();
		
		//Testing that a student can change their answer
		title = "Can a student can change their answer?";
		qList.clear();
		qList.add(new QuestionOption("Yes", true));
		qList.add(new QuestionOption("No", false));
		IQuestion qscChange = new QuestionSC(title,qList);
		vs = new VotingService(qscChange);
		
		vs.printQuestion();
		s = new Student("1234");
		List<Integer> answers = new ArrayList<Integer>();
		answers.add(0);
		vs.addAnswer(s.getId(), answers);
		vs.printStudentAnswers();
		System.out.println("\nChanging answer...\n");
		answers.clear();
		answers.add(1);
		vs.addAnswer(s.getId(), answers);
		vs.printStudentAnswers();
		
	}
}
