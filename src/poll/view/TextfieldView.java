package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import poll.model.Poll;
import poll.model.PollListener;

public class TextfieldView extends JPanel implements PollListener {
	private Poll pm;
	private Map<String, AnswerSetView> answerList = new HashMap<String, AnswerSetView>();
	private ActionListener controller;

	public TextfieldView(Poll pm, ActionListener controller) {
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
		for (String answers : pm.getAnswers()) {
			AnswerSetView asv = answerList.get(answers);
			if (asv == null) {
				asv = new AnswerSetView(pm, answers, controller);
				answerList.put(answers, asv);
				add(asv);
				revalidate();
				repaint();
			} else {
				asv.myDataWasUpdated();
			}
		}
	}
}
