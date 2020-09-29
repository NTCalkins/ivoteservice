package iVoteSimulator;

/*
 * In addition to the text body of an option, the
 * QuestionOption has fields that indicate correctness
 */
public interface IQuestionOption extends IOption {
	
	public void setCorrect(boolean b);
	
	public boolean isCorrect();
}
