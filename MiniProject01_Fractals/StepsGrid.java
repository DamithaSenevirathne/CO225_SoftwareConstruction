
public class StepsGrid {
	private int[][] grid=new int[Driver.SCREEN_HEIGHT][Driver.SCREEN_WIDTH];
	
	StepsGrid(int[][] grid){
		this.grid=grid;
	}
	StepsGrid(ZCTupleGrid grid){
		for(int y=0;y<Driver.SCREEN_HEIGHT;y++){
			for(int x=0;x<Driver.SCREEN_WIDTH;x++){
				put(y,x,calculateSteps(grid.get(y, x)));
			}
		}
	}
	
	public static int calculateSteps(ZCTuple zc){
		int ans=0;
		while(ans<=Driver.ITERATIONS && zc.absZ()<Driver.RADIUS){
			ans++;
			zc.takeNextStep();
		}
		return ans;
	}
	
	public int get(int y,int x){
		return this.grid[y][x];
	}
	public void put(int y,int x, int steps){
		this.grid[y][x]=steps;
	}

}
