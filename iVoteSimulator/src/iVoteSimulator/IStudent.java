package iVoteSimulator;

import java.util.List;

/*
 * A student can get and set their id as well as generate their answers
 * to a question, given a string of options and whether or not the question is
 * MC or SC.
 */
public interface IStudent {
	
	public String getId();
	
	public void setId(String i);
	
	public List<Integer> generateAnswers(List<String> options, boolean multi);
}
