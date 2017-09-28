import java.awt.Color;

public class Thread_ColorPick extends Thread{
	int startRow,endRow;
	float brightnessParameter;
	
	Thread_ColorPick(int startRow,int endRow,float brightnessParameter){
		this.startRow=startRow;
		this.endRow=endRow;
		this.brightnessParameter=brightnessParameter;
	}
	
	public void run(){
		System.out.println("Starting thread to pick colours for rows"+startRow+" "+endRow);

		for(int y=startRow;y<=endRow;y++){
			for(int x=0;x<Driver.SCREEN_WIDTH;x++){
				if(Fast.steps[y][x]==Driver.ITERATIONS) Fast.colors[y][x]=Color.BLACK;
				else{
					float[] colorIntensity=new float[3];
					colorIntensity[Driver.COLOR]=(float)Math.min(1.0, brightnessParameter*Fast.steps[y][x]);
					Fast.colors[y][x]=new Color(colorIntensity[0],colorIntensity[1],colorIntensity[2]);
				}
			}
			
		}
	}
	
}
