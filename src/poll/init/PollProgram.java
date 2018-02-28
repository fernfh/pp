package poll.init;

import poll.model.Poll;
import poll.model.PollList;

public class PollProgram {

	public static void main(String[] args) {
/*
		Poll model = new Poll("Was woll'n Sie denn trink'n?");
		String[] answers = new String[] { "Wasser", "Kaffee", "Tee", "Pils", "Weizen", "Weißwein", "Rotwein", "Rosé" };
		int ix = 1;
		for (String s : answers) {
			model.addAnswer(s, ix++ * 11);
		}
		new PollFrame(model, "Poll");
		*/
		new PollListFrame(new PollList(), "Alle Umfragen");
	}
}
