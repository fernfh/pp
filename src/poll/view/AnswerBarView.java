package poll.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import poll.model.Poll;

public class AnswerBarView extends JPanel {

	private Poll model;
	private String answers;
	private JProgressBar progressBar;

	public AnswerBarView(Poll model, String answers) {
		this.answers = answers;
		this.model = model;
		setLayout(new GridLayout(1, 0));
		add(new JLabel(answers));
		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(400, 10));
		add(progressBar);
		myDataWasUpdated();
	}

	public void myDataWasUpdated() {
		try {
			int maxCount = model.getMaxCount();
			if (maxCount > 0) {
				int pct = 100 * model.getCount(answers) / maxCount;
				progressBar.setValue(pct);
			}
		} catch (RemoteException re) {
			new RemoteExceptionView(re);
		}
	}

}
