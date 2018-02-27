package poll.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.media.sound.ModelAbstractChannelMixer;

import poll.model.Answers;
import poll.model.PollModel;
import poll.model.PollModelListener;

public class LabelView extends JPanel implements PollModelListener 
{
	private PollModel pm;
	ArrayList <Answers> ans;
	ArrayList <AnswerIncrementView> myCoolViews = new ArrayList<AnswerIncrementView>();
	
	public LabelView(PollModel pm)
	{
		this.pm = pm;
		this.ans = pm.getAnswers();
		setLayout(new GridLayout(2,0));
		pm.addPollModelListener(this);
		
		for(Answers answers: ans)
		{
			AnswerIncrementView aiv = new AnswerIncrementView(pm, answers);
			myCoolViews.add(aiv);
			add(aiv);
		}		
	}
	
	public void valueChanged()
	{
		for (AnswerIncrementView aiv : myCoolViews) {
			aiv.myDataWasUpdated();
		}
	}
}
