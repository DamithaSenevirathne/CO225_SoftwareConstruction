//gihanchanaka@gmail.com
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Driver {
	private static int[][] clickedBy=new int[3][3];
	private static boolean playerOnesMove=true;
	public static void driverMain(String[] args) {
		GUI.buildGUI();		
	}
	
	public static boolean previouslyClicked(int x,int y){
		return clickedBy[x][y]!=0;
	}
	
	public static int whoseMove(){
		if(playerOnesMove)return 1;
		else return 2;
	}
	
	public static void move(int x,int y){
		GUI.markMove(x, y, whoseMove());
		if(playerOnesMove) clickedBy[x][y]=1;
		else clickedBy[x][y]=2;
		playerOnesMove=!playerOnesMove;
		if(playerWon(1)) GUI.playerWin(1);
		if(playerWon(2)) GUI.playerWin(2);
		if(isDraw()) GUI.draw();
		
	}
	
	public static boolean playerWon(int p){
		for(int x=0;x<3;x++){
			for(int y=0;y<4;y++){
				if(y==3) return true;
				if(clickedBy[x][y]!=p)break;
			}
		}		
		for(int x=0;x<3;x++){
			for(int y=0;y<4;y++){
				if(y==3) return true;
				if(clickedBy[y][x]!=p)break;
			}
		}
		
		for(int x=0;x<4;x++){
			if(x==3) return true;
			if(clickedBy[x][x]!=p)break;
		}
		for(int x=0;x<4;x++){
			if(x==3) return true;
			if(clickedBy[2-x][x]!=p)break;
		}
		return false;
	}
	
	public static boolean isDraw(){
		for(int x=0;x<9;x++) if(clickedBy[x/3][x%3]==0) return false;
		return true;
	}
	
	public static void newGame(){
		for(int x=0;x<9;x++)clickedBy[x/3][x%3]=0;
		playerOnesMove=true;
		GUI.hideGUI();
		GUI.buildGUI();
	}

}
