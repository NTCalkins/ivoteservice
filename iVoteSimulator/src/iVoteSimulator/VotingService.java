package iVoteSimulator;

import java.util.HashMap;
import java.util.List;

public class VotingService implements IVotingService{
	
	private HashMap<String, List<Integer>> submissions = new HashMap<String, List<Integer>>();
	
	private IQuestion q;
	
	public VotingService(IQuestion question) {
		this.q = question;
	}
	
	@Override
	public void printQuestion() {
		System.out.println("QUESTION: " + q.getText() + "\n");
		
		System.out.println("OPTIONS:");
		for (String o : q.getOptionsString()) {
			System.out.println(o);
		}
	}

	@Override
	public void addAnswer(String id, List<Integer> choices) {
		
		if (!q.isMultipleChoice() && choices.size() > 1) {
			System.out.println("Answer from " + id + " cannot be added: "
					+ "too many arguments for single choice question ");
			return;
		}
		
		//put will override answers if the id is already in the HashMap
		this.submissions.put(id, choices);
	}

	@Override
	public void printStudentAnswers() {
		HashMap<Integer, Integer> answerCounts = new HashMap<Integer, Integer>();
		for (List<Integer> submission : this.submissions.values()) {
			for (int choice : submission) {
				if (answerCounts.containsKey(choice))
					answerCounts.put(choice, answerCounts.get(choice)+1);
				else
					answerCounts.put(choice, 1);
			}
		}
		List<String> qOptions = q.getOptionsString();
		int num;
		for (int i = 0; i < qOptions.size(); i++) {
			if (answerCounts.get(i) == null) {
				num = 0;
			}
			else {
				num = answerCounts.get(i);
			}
			System.out.println(qOptions.get(i) + ": " + num);
		}
		
	}

	@Override
	public void printCorrect() {
		System.out.println("CORRECT ANSWER(S):");
		
		for (String o : q.getAnswer()) {
			System.out.println(o);
		}
		
	}
	
	public List<String> getOptionsString() {
		return q.getOptionsString();
	}
	
	public boolean isMultipleChoice() {
		return q.isMultipleChoice();
	}

}
