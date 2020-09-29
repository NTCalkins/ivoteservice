package iVoteSimulator;

import java.util.List;

/*
 * The voting service is in charge of printing the question,
 * collecting answers to that question, and then printing the
 * student's answer but also the correct answer
 */
public interface IVotingService {
	
	public void printQuestion();
	
	public void addAnswer(String id, List<Integer> choices);
	
	public void printStudentAnswers();
	
	public void printCorrect();
}
