
public class ZCTupleGrid {

	private ZCTuple[][] grid=new ZCTuple[Driver.SCREEN_HEIGHT][Driver.SCREEN_WIDTH];
	
	ZCTupleGrid(ComplexCoordinateGrid grid){
		//This is mandelbrot set
		for(int y=0;y<Driver.SCREEN_HEIGHT;y++){
			for(int x=0;x<Driver.SCREEN_WIDTH;x++){
				put(y,x, new ZCTuple(ComplexNumber.ZERO,grid.get(y, x)));
			}
		}
	}
	
	ZCTupleGrid(ComplexCoordinateGrid grid,ComplexNumber C){
		//This is the Julia set
		for(int y=0;y<Driver.SCREEN_HEIGHT;y++){
			for(int x=0;x<Driver.SCREEN_WIDTH;x++){
				put(y,x,new ZCTuple(grid.get(y, x),C));
			}
		}
	}
	ZCTuple get(int y,int x){
		return grid[y][x];
	}
	
	void put(int y,int x,ZCTuple zc){
		grid[y][x]=zc;
	}
}
