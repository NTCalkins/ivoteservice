package iVoteSimulator;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is abstract because I figured that a question should not
 * be able to be instantiated if it is neither multiple-choice nor
 * single-choice.
 */
public abstract class Question implements IQuestion {

	private String text;
	private List<QuestionOption> options;
	
	public Question(String t, List<QuestionOption> o) {
		this.text = t;
		this.options = o;
	}
	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public List<QuestionOption> getOptions() {
		return this.options;
	}

	@Override
	public List<String> getOptionsString() {
		List<String> retList = new ArrayList<String>();
		for (QuestionOption qo : this.options) {
			retList.add(qo.getText());
		}
		return retList;
	}

	@Override
	public List<String> getAnswer() {
		List<String> retList = new ArrayList<String>();
		for (QuestionOption qo : this.options) {
			if (qo.isCorrect())
				retList.add(qo.getText());
		}
		return retList;
	}
	
	/*
	 * This function is left as abstract, as the type of question that extends
	 * this class will have to be one or the other.
	 */
	public abstract boolean isMultipleChoice();

}
