package poll.init;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import poll.model.PollList;
import poll.model.PollStats;
import poll.view.GuiListener;
import poll.view.PollControl;
import poll.view.RMIClient;

@SuppressWarnings("serial")
public class PollListFrame extends JFrame implements GuiListener {
	private Map<String, PollControl> pollControls = new HashMap<String, PollControl>();
	private JPanel pollListPane;
	private RMIClient polls;

	public PollListFrame(PollList pollList, String title) throws RemoteException {
		super(title);
		RMIClient polls = new RMIClient(pollList);
		UnicastRemoteObject.exportObject(polls, 0);
		pollList.addPollListListener(polls);
		this.polls = polls;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pollListPane = new JPanel(new GridLayout(3, 3, 5, 5));
		add(pollListPane, BorderLayout.CENTER);
		pollListPane.setBorder(BorderFactory.createTitledBorder("Alle Umfragen"));
		JPanel newPollPane = new NewPollPane(polls);
		add(newPollPane, BorderLayout.SOUTH);
		newPollPane.setBorder(BorderFactory.createTitledBorder("Neue Umfrage anlegen"));
		polls.addListener(this);
		for (String question : polls.getPolls()) {
			pollAdded(question);
		}
		setSize(600, 400);
		setLocation(200, 200);
		setVisible(true);
	}

	@Override
	public void pollAdded(String q) {
		PollControl pc = new PollControl(polls, q);
		pollControls.put(q, pc);
		pollListPane.add(pc);
		revalidate();
		repaint();
	}

	@Override
	public void pollRemoved(String q) {
		PollControl pc = pollControls.get(q);
		pollListPane.remove(pc);
		revalidate();
		repaint();
	}

	@Override
	public void pollUpdated(String q, PollStats p) {
	}
}
