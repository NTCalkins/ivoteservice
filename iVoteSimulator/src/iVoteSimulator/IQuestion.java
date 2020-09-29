package iVoteSimulator;

import java.util.List;

/*
 * This is the interface for a question. A question
 * has "text," that is a title of a question. It can
 * generate its QuestionOptions but also a string of the
 * text of the QuestionOptions given that it would be unwise
 * to give the correctness values to someone who is answering
 * the question. It can get the correct QuestionOptions out of
 * the question options in the list.
 */
public interface IQuestion {
	
	public String getText();
	
	public List<QuestionOption> getOptions();
	
	public List<String> getOptionsString();
	
	public List<String> getAnswer();
	
	public boolean isMultipleChoice();
}
