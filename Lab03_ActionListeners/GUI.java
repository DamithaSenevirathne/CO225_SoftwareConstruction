//gihanchanaka@gmail.com
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI {
	static JButton[][] buttons=new JButton[3][3];
	static JFrame frame;
	static JPanel panel;
	static int[][] clickedBy;
	public static void buildGUI(){
		frame=new JFrame("TicTacToe Game E/14/158");
		frame.setSize(new Dimension(640,640));
		panel=new JPanel();
		clickedBy=new int[3][3];
		panel.setSize(new Dimension(600,600));
		for(int x=0;x<3;x++)for(int y=0;y<3;y++){
			buttons[x][y]=new JButton("-");
			buttons[x][y].setPreferredSize(new Dimension(200,200));
			buttons[x][y].setLocation(x*200, y*200);
			buttons[x][y].addActionListener(new ButtonClickListener(x, y));
			buttons[x][y].setFont(new Font("Times new roman",Font.PLAIN,50));

			panel.add(buttons[x][y]);
		}
		frame.setContentPane(panel);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void markMove(int x,int y,int player){
		buttons[x][y].setText(""+player);
		buttons[x][y].setEnabled(false);
		
	}
	public static void hideGUI(){
		frame.setVisible(false);
	}
	public static void playerWin(int i){
		if(i==1)showResult("Player one wins!");
		if(i==2)showResult("Player two wins!");
	}
	
	public static void draw(){
		showResult("The game is draw");
	}
	
	public static void showResult(String result){
		frame.setEnabled(false);
		JFrame resultFrame=new JFrame("Result");
		resultFrame.setSize(new Dimension(400,200));
		
		JPanel resultPanel=new JPanel();
		resultPanel.setSize(new Dimension(400,200));
		
		resultFrame.setContentPane(resultPanel);
		
		JTextField resultText=new JTextField(result);
		resultText.setSize(new Dimension(400,200));
		resultText.setEditable(false);
		resultText.setFont(new Font("Times new roman",Font.PLAIN,40));
		
		resultPanel.add(resultText);

		JButton newGameButton=new JButton("New Game");
		newGameButton.addActionListener(new ButtonActionListener_Control());
		resultPanel.add(newGameButton);
		
		resultFrame.setVisible(true);
		
		resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
	
	
}
