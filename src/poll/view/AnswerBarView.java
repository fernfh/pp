package poll.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import poll.model.Answers;
import poll.model.PollModel;

public class AnswerBarView extends JPanel {

	private PollModel model;
	private Answers answers;
	private JProgressBar progressBar;

	public AnswerBarView(PollModel model, Answers answers) {
		this.answers = answers;
		this.model = model;
		setLayout(new GridLayout(1, 0));
		add(new JLabel(answers.getName()));
		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(400, 10));
		add(progressBar);
		myDataWasUpdated();
	}

	public void myDataWasUpdated() {
		int maxCount = model.getMaxCount();
		if (maxCount > 0) {
			int pct = 100 * answers.getCount() / maxCount;
			progressBar.setValue(pct);
		}
	}

}
