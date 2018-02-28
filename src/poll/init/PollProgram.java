package poll.init;

import poll.model.Poll;
import poll.model.PollList;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PollProgram {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry(2018);
			PollList pollList = (PollList) registry.lookup("PollList");
			new PollListFrame(pollList, "Alle Umfragen");
			pollList.addPoll(sample1());
			pollList.addPoll(sample2());
			pollList.addPoll(sample3());
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
		}
	}

	private static Poll sample1() {
		Poll samplePoll = new Poll("Was woll'n Sie denn trink'n?");
		String[] answers = new String[] { "Wasser", "Kaffee", "Tee", "Pils", "Weizen", "Weißwein", "Rotwein", "Rosé" };
		int ix = 1;
		for (String s : answers) {
			samplePoll.addAnswer(s, ix++ * 11);
		}
		return samplePoll;
	}

	private static Poll sample2() {
		Poll samplePoll = new Poll("Was woll'n Sie denn ess'n?");
		String[] answers = new String[] { "Wurst", "Currywurst", "Pistazienwurst", "Paprikawurst", "Wurst mit Eiern",
				"Wurst mit Wurst & Wurst" };
		int ix = 1;
		for (String s : answers) {
			samplePoll.addAnswer(s, ix++ * 11);
		}
		return samplePoll;
	}

	private static Poll sample3() {
		Poll samplePoll = new Poll("Was woll'n Sie denn rauch'n?");
		String[] answers = new String[] { "Tabak", "Grünes Zeug", "Hashish", "Shisha" };
		int ix = 1;
		for (String s : answers) {
			samplePoll.addAnswer(s, ix++ * 11);
		}
		return samplePoll;
	}
}
