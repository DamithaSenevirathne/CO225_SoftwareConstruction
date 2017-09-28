
public class Thread_StepsJulia extends Thread{
	int startRow,endRow;
	double cReal;
	double cImagianry;
	public Thread_StepsJulia(int startRow,int endRow,double cReal,double cImaginary) {
		this.startRow=startRow;
		this.endRow=endRow;
		this.cReal=cReal;
		this.cImagianry=cImaginary;
	}
	
	public void run(){
		System.out.println("Starting thread to iterate rows "+startRow+" "+endRow);

		for(int y=startRow;y<=endRow;y++){
			for(int x=0;x<Driver.SCREEN_WIDTH;x++){
				double zReal=Driver.realMin+x*(Driver.realMax-Driver.realMin)/(float)Driver.SCREEN_WIDTH;
				double zImaginary=Driver.complexMax-y*(Driver.complexMax-Driver.complexMin)/(float)Driver.SCREEN_HEIGHT;
				double zRealTemp;
				int i;
				for(i=0;i<=Driver.ITERATIONS;i++){
					if( (zReal*zReal+zImaginary*zImaginary) > Driver.RADIUS*Driver.RADIUS ){
						Fast.steps[y][x]=i;
					}
					zRealTemp=zReal*zReal-zImaginary*zImaginary+cReal;
					zImaginary=(2*zReal*zImaginary)+cImagianry;
					zReal=zRealTemp;
				}
				if(i==Driver.ITERATIONS)Fast.steps[y][x]=i;
			}
		}
	}
}
