//gihanchanaka@gmail.com
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonClickListener implements ActionListener {
	int x,y;
	
	ButtonClickListener(int x,int y){
		//System.out.println("Making an action listener for "+x+" "+y);
		this.x=x;
		this.y=y;
	}
	public void actionPerformed(ActionEvent e) {
		if(!Driver.previouslyClicked(x, y)){
			Driver.move(x, y);
		}

	}

}
