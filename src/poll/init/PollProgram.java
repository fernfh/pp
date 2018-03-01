package poll.init;

import poll.model.PollList;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class PollProgram {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry(2018);
			PollList pollList = (PollList) registry.lookup("PollList");
			new PollListFrame(pollList, "Alle Umfragen");
			System.err.println("Adding sample 1");
			sample1(pollList);
			System.err.println("Adding sample 2");
			sample2(pollList);
			System.err.println("Adding sample 3");
			sample3(pollList);
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
		}
	}

	private static void sample1(PollList polls) throws RemoteException {
		String q = "Was woll'n Sie denn trink'n?";
		System.err.println("adding question" + q);
		polls.addPoll(q);
		String[] answers = new String[] { "Wasser", "Kaffee", "Tee", "Pils", "Weizen", "Weißwein", "Rotwein", "Rosé" };
		int ix = 1;
		for (String a : answers) {
			System.err.println("adding answer " + a);
			polls.setPollAnswer(q, a, ix++ * 11);
		}
	}

	private static void sample2(PollList polls) throws RemoteException {
		String q = "Was woll'n Sie denn ess'n?";
		System.err.println("adding question" + q);
		polls.addPoll(q);
		String[] answers = new String[] { "Wurst", "Currywurst", "Pistazienwurst", "Paprikawurst", "Wurst mit Eiern", "Wurst mit Wurst & Wurst" };
		int ix = 1;
		for (String a : answers) {
			System.err.println("adding answer " + a);
			polls.setPollAnswer(q, a, ix++ * 11);
		}
	}

	private static void sample3(PollList polls) throws RemoteException {
		String q ="Was woll'n Sie denn rauch'n?";
		System.err.println("adding question" + q);
		polls.addPoll(q);
		String[] answers = new String[] { "Tabak", "Grünes Zeug", "Hashish", "Shisha" };
		int ix = 1;
		for (String a : answers) {
			System.err.println("adding answer " + a);
			polls.setPollAnswer(q, a, ix++ * 11);
		}
	}
}
