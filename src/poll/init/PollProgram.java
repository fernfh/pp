package poll.init;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import poll.model.PollList;

public class PollProgram {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry(2018);
			PollList pollList = (PollList) registry.lookup("PollList");
			new PollListFrame(pollList, "Alle Umfragen");
			sample1(pollList);
			sample2(pollList);
			sample3(pollList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void sample1(PollList polls) throws RemoteException {
		String q = "Was woll'n Sie denn trink'n?";
		polls.addPoll(q);
		String[] answers = new String[] { "Wasser", "Kaffee", "Tee", "Pils", "Weizen", "Weißwein", "Rotwein", "Rosé" };
		int ix = 1;
		for (String a : answers) {
			polls.setPollAnswer(q, a, ix++ * 11);
		}
	}

	private static void sample2(PollList polls) throws RemoteException {
		String q = "Was woll'n Sie denn ess'n?";
		polls.addPoll(q);
		String[] answers = new String[] { "Wurst", "Currywurst", "Pistazienwurst", "Paprikawurst", "Wurst mit Eiern",
				"Wurst mit Wurst & Wurst" };
		int ix = 1;
		for (String a : answers) {
			polls.setPollAnswer(q, a, ix++ * 11);
		}
	}

	private static void sample3(PollList polls) throws RemoteException {
		String q = "Was woll'n Sie denn rauch'n?";
		polls.addPoll(q);
		String[] answers = new String[] { "Tabak", "Grünes Zeug", "Hashish", "Shisha" };
		int ix = 1;
		for (String a : answers) {
			polls.setPollAnswer(q, a, ix++ * 11);
		}
	}
}
