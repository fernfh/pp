package poll.init;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import poll.model.Poll;
import poll.model.PollList;
import poll.model.PollListListener;
import poll.view.PollControl;
import poll.view.RemoteExceptionView;

public class PollListFrame extends JFrame implements PollListListener {
	private PollList polls;
	private Map<String, PollControl> pollControls = new HashMap<String, PollControl>();
	private JPanel pollListPane;

	public PollListFrame(PollList polls, String title) {
		super(title);
		this.polls = polls;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pollListPane = new JPanel(new GridLayout(3, 3, 5, 5));
		add(pollListPane, BorderLayout.CENTER);
		pollListPane.setBorder(BorderFactory.createTitledBorder("Alle Umfragen"));
		JPanel newPollPane = new NewPollPane(polls);
		add(newPollPane, BorderLayout.SOUTH);
		newPollPane.setBorder(BorderFactory.createTitledBorder("Neue Umfrage anlegen"));
		try {
			polls.addPollListListener(this);
			for (Poll poll : polls.getPolls()) {
				pollAdded(poll);
			}
		} catch (RemoteException e) {
			new RemoteExceptionView(e);
		}
		setSize(600, 400);
		setLocation(200, 200);
		setVisible(true);
	}

	@Override
	public void pollAdded(Poll model) {
		PollControl pc = new PollControl(polls, model);
		pollControls.put(model.getQuestion(), pc);
		pc.setName(model.getQuestion());
		pollListPane.add(pc);
		revalidate();
		repaint();
	}

	@Override
	public void pollRemoved(Poll model) {
		String q = model.getQuestion();
		PollControl pc = pollControls.get(q);
		pollListPane.remove(pc);
		revalidate();
		repaint();
	}
}
