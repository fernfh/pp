package poll.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import poll.model.Answers;

public class LabelView extends JPanel implements PollChangeListener 
{
	private PollModel pm;
	ArrayList <Answers> ans;
	
	
	public LabelView(PollModel pm)
	{
		this.pm = pm;
		this.ans = pm.getAnswers();
		
		for(int i=0; i < ans.size(); i++)
		{
			JLabel lab = new JLabel(ans.getText());
			lab.setText(ans.getText());
			JButton button = new JButton(ans.getNumber());
			button.setText("Erhöhen");
			
			add(button);
			add(lab);
		}
	}
	
	public modeChanged()
	{
		//ben: 
		//Anzahl der Antworten pro Frage
		//Gesamtantworten
		//Berechnen der Prozentwerte
		setText();
	}
}
