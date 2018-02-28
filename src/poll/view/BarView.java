package poll.view;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import poll.model.Poll;
import poll.model.PollListener;

public class BarView extends JPanel implements PollListener {
	private Poll model;
	private Map<String, AnswerBarView> myViews = new HashMap<String, AnswerBarView>();

	public BarView(Poll model) {
		this.model = model;
		model.addPollModelListener(this);
		setLayout(new GridLayout(0, 1, 1, 1));
		update();
	}

	@Override
	public void valueChanged() {
		update();
	}

	private void update() {
		for (String answers : model.getAnswers()) {
			String answerName = answers;
			AnswerBarView view = myViews.get(answerName);
			if (view == null) {
				view = new AnswerBarView(model, answers);
				myViews.put(answerName, view);
				add(view);
				revalidate();
				repaint();
			} else {
				view.myDataWasUpdated();
			}
		}
	}
}
