package poll.model;

public class Answers {

	private int count;
	private String name;
	
	public Answers(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	public Answers (String name) {
		this(name, 0);
	}
	
	public String getName() {
		return name;
	}
	
	public int getCount() {
		return count;
	}
	
	public void increment(){
		count++;
	}

	public void setCount(int count2) {
		count = count2;
	}
}
