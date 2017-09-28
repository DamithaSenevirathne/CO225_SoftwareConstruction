import java.awt.Color;


public class ColorGrid {
	private Color[][] grid=new Color[Driver.SCREEN_HEIGHT][Driver.SCREEN_WIDTH];
	
	ColorGrid(Color[][] grid){
		this.grid=grid;
	}
	
	
	ColorGrid(StepsGrid grid){
		float parameter= calculateBrightnessParameter(grid);
		for(int y=0;y<Driver.SCREEN_HEIGHT;y++){
			for(int x=0;x<Driver.SCREEN_WIDTH;x++){
				if(grid.get(y, x)>=Driver.ITERATIONS){
					put(y,x,Color.BLACK);
				}
				else{
					float[] colorIntensity=new float[3];
					colorIntensity[Driver.COLOR]=(float)Math.min(1.0, parameter*grid.get(y, x));
					put(y,x,new Color(colorIntensity[0],colorIntensity[1],colorIntensity[2]));
				}
			}
		}
	}
	
	public static float calculateBrightnessParameter(StepsGrid grid){ //Public coz this is used in the parallel version as well :-)
		double intensitySum=0d;
		int colouredPixel=0;
		for(int y=0;y<Driver.SCREEN_HEIGHT;y++){
			for(int x=0;x<Driver.SCREEN_WIDTH;x++){
				if(grid.get(y,x)<Driver.ITERATIONS){
					intensitySum+=grid.get(y, x);
					colouredPixel++;
				}
			}
		}
		double thisPatternAverageIntensity=intensitySum/Math.pow(colouredPixel,1.08);
		float kk= (float)(Driver.AVERAGE_LIGHT/thisPatternAverageIntensity);
		//System.out.println(intensitySum+" "+colouredPixel+" "+kk);

		return kk;
	}
	
	public void put(int y,int x,Color col){
		this.grid[y][x]=col;
	}
	
	public Color get(int y,int x){
		return this.grid[y][x];
	}

}
