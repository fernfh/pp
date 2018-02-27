package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import poll.model.Answers;
import poll.model.PollModel;
import poll.model.PollModelListener;

public class TextfieldView extends JPanel implements PollModelListener {
	private PollModel pm;
	private Map<String, AnswerSetView> answerList = new HashMap<String, AnswerSetView>();
	private ActionListener controller;

	public TextfieldView(PollModel pm, ActionListener controller) {
		this.pm = pm;
		this.controller = controller;
		setLayout(new GridLayout(0, 1, 5, 5));
		pm.addPollModelListener(this);
		update();
	}

	public void valueChanged() {
		update();
	}

	private void update() {
		for (Answers answers : pm.getAnswers()) {
			String answerName = answers.getName();
			AnswerSetView asv = answerList.get(answerName);
			if (asv == null) {
				asv = new AnswerSetView(pm, answers, controller);
				answerList.put(answerName, asv);
				add(asv);
				revalidate();
				repaint();
			} else {
				asv.myDataWasUpdated();
			}
		}
	}
}
