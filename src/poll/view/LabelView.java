package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import poll.model.Poll;
import poll.model.PollListener;

public class LabelView extends JPanel implements PollListener {
	private Poll pm;
	private Map<String, AnswerIncrementView> myViews;
	private ActionListener controller;

	public LabelView(Poll pm, ActionListener incrController) {
		this.pm = pm;
		myViews = new HashMap<String, AnswerIncrementView>();
		controller = incrController;
		setLayout(new GridLayout(0, 1, 5, 5));
		try {
			pm.addPollModelListener(this);
			update();
		} catch (RemoteException re) {
			new RemoteExceptionView(re);
		}
	}

	public void valueChanged() {
		try {
			update();
		} catch (RemoteException re) {
			new RemoteExceptionView(re);
		}
	}

	private void update() throws RemoteException {
		for (String answers : pm.getAnswers()) {
			AnswerIncrementView aiv = myViews.get(answers);
			if (aiv == null) {
				aiv = new AnswerIncrementView(pm, answers, controller);
				myViews.put(answers, aiv);
				add(aiv);
				revalidate();
				repaint();
			} else {
				aiv.myDataWasUpdated();
			}
		}
	}
}
