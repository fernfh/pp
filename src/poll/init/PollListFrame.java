package poll.init;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import poll.model.Poll;
import poll.model.PollList;
import poll.model.PollListListener;
import poll.view.PollControl;

public class PollListFrame extends JFrame implements PollListListener {
	private JPanel pollList;
	private PollList polls;
	private Map<String, PollControl> pollControls = new HashMap<String, PollControl>();

	public PollListFrame(PollList polls, String title) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.polls = polls;
		pollList = new JPanel(new GridLayout(3, 3, 5, 5));
		polls.addPollListListener(this);
		add(pollList, BorderLayout.CENTER);
		pollList.setBorder(BorderFactory.createTitledBorder("Alle Umfragen"));
		JPanel newPollPane = new NewPollPane(polls);
		add(newPollPane, BorderLayout.SOUTH);
		newPollPane.setBorder(BorderFactory.createTitledBorder("Neue Umfrage anlegen"));
		setSize(600, 400);
		setLocation(200, 200);
		setVisible(true);
	}

	@Override
	public void pollAdded(Poll model) {
		PollControl pc = new PollControl(polls, model);
		pollControls.put(model.getQuestion(), pc);
		pc.setName(model.getQuestion());
		pollList.add(pc);
		revalidate();
		repaint();
	}

	@Override
	public void pollRemoved(Poll model) {
		String q = model.getQuestion();
		PollControl pc = pollControls.get(q);
		pollList.remove(pc);
		revalidate();
		repaint();
	}
}
