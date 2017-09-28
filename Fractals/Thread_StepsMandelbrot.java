
public class Thread_StepsMandelbrot extends Thread{
	int startRow,endRow;
	public Thread_StepsMandelbrot(int startRow,int endRow) {
		this.startRow=startRow;
		this.endRow=endRow;
	}
	public void run(){
		System.out.println("Starting thread to iterate rows "+startRow+" "+endRow);
		for(int y=startRow;y<=endRow;y++){
			for(int x=0;x<Driver.SCREEN_WIDTH;x++){
				double cReal=Driver.realMin+x*(Driver.realMax-Driver.realMin)/(float)Driver.SCREEN_WIDTH;
				double cImaginary=Driver.complexMax-y*(Driver.complexMax-Driver.complexMin)/(float)Driver.SCREEN_HEIGHT;
				double zReal=0d;
				double zRealTemp;
				double zImaginary=0d;
				
				int i;
				for(i=0;i<=Driver.ITERATIONS;i++){
					if( (zReal*zReal+zImaginary*zImaginary) > Driver.RADIUS*Driver.RADIUS ){
						Fast.steps[y][x]=i+1;
						break;
					}
					zRealTemp=zReal*zReal-zImaginary*zImaginary+cReal;
					zImaginary=(2*zReal*zImaginary)+cImaginary;
					zReal=zRealTemp;
				}
				if(i==Driver.ITERATIONS)Fast.steps[y][x]=i;
			}
		}
	}
}
