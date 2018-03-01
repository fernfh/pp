package poll.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import poll.model.PollStats;

@SuppressWarnings("serial")
public class AnswerBarView extends JPanel {

	private String answer;
	private JProgressBar progressBar;

	public AnswerBarView(String answer, PollStats stats) {
		this.answer = answer;
		setLayout(new GridLayout(1, 0));
		add(new JLabel(answer));
		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(400, 10));
		add(progressBar);
		update(stats);
	}

	public void update(PollStats stats) {
		int maxCount = stats.max;
		if (maxCount > 0) {
			int pct = 100 * stats.answers.get(answer) / maxCount;
			progressBar.setValue(pct);
		}
	}
}
