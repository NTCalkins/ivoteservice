package iVoteSimulator;

/*
 * Implentation of IQuestionOption. Standard setters and
 * getters, I made this class as a tuple of sorts that has
 * a text body and a correctness of said text body.
 */
public class QuestionOption implements IQuestionOption {

	String text;
	boolean correct;
	
	public QuestionOption(String t, boolean c) {
		this.text = t;
		this.correct = c;
	}
	
	@Override
	public void setText(String t) {
		this.text = t;
	}

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public void setCorrect(boolean b) {
		this.correct = b;
	}

	@Override
	public boolean isCorrect() {
		return this.correct;
	}

}
