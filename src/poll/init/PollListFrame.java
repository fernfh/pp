package poll.init;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import poll.model.PollList;
import poll.model.PollStats;
import poll.model.PollListListener;
import poll.view.PollControl;
import poll.view.RemoteExceptionView;
import poll.controllers.RemovePollController;

public class PollListFrame extends JFrame implements PollListListener {
	private Map<String, PollControl> pollControls = new HashMap<String, PollControl>();
	private JPanel pollListPane;
	private PollList polls;

	public PollListFrame(PollList polls, String title) throws RemoteException {
		super(title);
		this.polls = polls;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pollListPane = new JPanel(new GridLayout(3, 3, 5, 5));
		add(pollListPane, BorderLayout.CENTER);
		pollListPane.setBorder(BorderFactory.createTitledBorder("Alle Umfragen"));
		JPanel newPollPane = new NewPollPane(polls);
		add(newPollPane, BorderLayout.SOUTH);
		newPollPane.setBorder(BorderFactory.createTitledBorder("Neue Umfrage anlegen"));
		System.err.println("adding PollListFrame as listener ");
		polls.addPollListListener(this);
		for (String question : polls.getPolls()) {
			pollAdded(question);
		}
		setSize(600, 400);
		setLocation(200, 200);
		setVisible(true);
	}

	@Override
	public void pollAdded(String q) {
		System.err.println("pollAdded: " + q);
		PollControl pc = new PollControl(polls, q);
		pollControls.put(q, pc);
		pollListPane.add(pc);
		revalidate();
		repaint();
	}

	@Override
	public void pollRemoved(String q) {
		System.err.println("pollRemoved: " + q);
		PollControl pc = pollControls.get(q);
		pollListPane.remove(pc);
		revalidate();
		repaint();
	}
	@Override
	public void pollUpdated (String q, PollStats p) {
		System.err.println("pollUpdated: " + q);
	}
}
