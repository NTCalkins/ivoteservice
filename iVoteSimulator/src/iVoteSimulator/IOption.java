package iVoteSimulator;

/*
 * This interface is used to represent an option,
 * which is essentially a string. Options have no
 * inherent correctness.
 */
public interface IOption {
	
	public void setText(String t);
	
	public String getText();
}
