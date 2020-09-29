package iVoteSimulator;

import java.util.List;

/*
 * QuestionSC differs in that if a user tries to create an instance with
 * multiple correct answers, then the constructor will throw an exception.
 */
public class QuestionSC extends Question {

	public QuestionSC(String t, List<QuestionOption> o) throws Exception {
		super(t, o);
		
		int numCorrect = 0;
		//Count the number of correct options
		for ( QuestionOption qo : this.getOptions()) {
			if (qo.isCorrect()) {
				numCorrect++;
			}
		}
		if (numCorrect != 1) {
			throw new Exception("Number of correct answers must be EXACTLY one (1).");
		}
	}

	@Override
	public boolean isMultipleChoice() {
		return false;
	}

}
