package iVoteSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Implementation of IStudent. Generate answers uses
 * the Random library to generate random answers to the questions.
 * The number of questions generated is random for the most part.
 */
public class Student implements IStudent{

	private String id;
	
	public Student(String i) {
		this.id = i;
	}
	
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String i) {
		this.id = i;
	}

	/*
	 * This function will generate 0 to n many answers if a multiple choice, otherwise
	 * will select only one answer. 
	 */
	@Override
	public List<Integer> generateAnswers(List<String> options, boolean multi) {
		
		Random rand = new Random();
		
		List<Integer> answers = new ArrayList<Integer>();
		if (multi) {
			int coinflip;
			for (int i = 0; i < options.size(); i++) {
				coinflip = rand.nextInt(2);
				if (coinflip == 0)
					answers.add(i);
			}
		}
		else {
			answers.add(rand.nextInt(options.size()));
		}
		return answers;
	}
	
}
