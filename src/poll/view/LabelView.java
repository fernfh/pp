package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import poll.model.Answers;
import poll.model.PollModel;
import poll.model.PollModelListener;

public class LabelView extends JPanel implements PollModelListener {
	private PollModel pm;
	private Map<String, AnswerIncrementView> myViews;
	private ActionListener controller;

	public LabelView(PollModel pm, ActionListener incrController) {
		this.pm = pm;
		myViews = new HashMap<String, AnswerIncrementView>();
		controller = incrController;
		setLayout(new GridLayout(0, 1, 5, 5));
		pm.addPollModelListener(this);
		update();
	}

	public void valueChanged() {
		update();
	}

	private void update() {
		for (Answers answers : pm.getAnswers()) {
			AnswerIncrementView aiv = myViews.get(answers.getName());
			if (aiv == null) {
				aiv = new AnswerIncrementView(pm, answers, controller);
				myViews.put(answers.getName(), aiv);
				add(aiv);
				revalidate();
				repaint();
			} else {
				aiv.myDataWasUpdated();
			}
		}
	}
}
