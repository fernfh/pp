package poll.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		for(Answers answers: ans)
		{
			AnswerIncrementView aiv = new AnswerIncrementView(pm, answers); 
			add(aiv);
			/*
			JLabel lab = new JLabel(answers.getName());
			lab.setText(answers.getName());
			JButton button = new JButton("Erhöhen");
			button.setName(answers.getName());
			labels.add(lab);
			buttons.add(button);
			
			add(button);
			add(lab);
			*/
		}		
	}
	
	public void valueChanged()
	{
		for (AnswerIncrementView aiv : myCoolViews) {
			aiv.myDataWasUpdated();
		}
	}
}
