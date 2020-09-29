package iVoteSimulator;

import java.util.List;

/*
 * This class is mainly used in keeping with good OOP design.
 * Although I could just use the Question class as the QuestionMC
 * class, I find it to be distasteful to extend QuestionSC from 
 * QuestionMC.
 */
public class QuestionMC extends Question {

	public QuestionMC(String t, List<QuestionOption> o) {
		super(t, o);
	}

	@Override
	public boolean isMultipleChoice() {
		return true;
	}

}
