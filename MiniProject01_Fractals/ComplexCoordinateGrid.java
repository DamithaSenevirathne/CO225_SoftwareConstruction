
public class ComplexCoordinateGrid {
	private ComplexNumber[][] grid=new ComplexNumber[Driver.SCREEN_HEIGHT][Driver.SCREEN_WIDTH];
	
	public ComplexCoordinateGrid(double realMin,double realMax,double complexMin, double complexMax) {
		for(int y=0;y<Driver.SCREEN_HEIGHT;y++){
			for(int x=0;x<Driver.SCREEN_WIDTH;x++){
				put(y,x,new ComplexNumber(realMin+x*(realMax-realMin)/(float)Driver.SCREEN_WIDTH,complexMax-y*(complexMax-complexMin)/(float)Driver.SCREEN_HEIGHT));
			}
		}
	}
	
	






	public ComplexNumber get(int y,int x){
		return grid[y][x];
	}
	public void put(int y,int x,ComplexNumber c){
		grid[y][x]=c;
	}
}
