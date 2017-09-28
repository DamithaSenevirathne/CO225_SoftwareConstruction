//gihanchanaka@gmail.com
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;


public class ButtonActionListener_Control implements ActionListener{
	

	
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked=(JButton)event.getSource();
		if(buttonClicked.getText().equals("New Game")){
			Driver.newGame();
			SwingUtilities.windowForComponent(buttonClicked.getParent()).setVisible(false);
		}
		
	}
	
	
}
