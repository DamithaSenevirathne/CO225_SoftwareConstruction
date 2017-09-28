import java.awt.Color;

public class Fast {
	static double[][] z=new double[Driver.SCREEN_HEIGHT][Driver.SCREEN_WIDTH];
	static double[][] c=new double[Driver.SCREEN_HEIGHT][Driver.SCREEN_WIDTH];
	static int[][] steps=new int[Driver.SCREEN_HEIGHT][Driver.SCREEN_WIDTH];
	static Color[][] colors=new Color[Driver.SCREEN_HEIGHT][Driver.SCREEN_WIDTH];
	static double[] temp_UsedToSum=new double[Driver.NUMBER_OF_THREADS];
	
	
	public static ColorGrid mandelbrot(){
		Thread_StepsMandelbrot[] steps_threads=new Thread_StepsMandelbrot[Driver.NUMBER_OF_THREADS];
		for(int threadId=0;threadId<Driver.NUMBER_OF_THREADS;threadId++){
			steps_threads[threadId]=new Thread_StepsMandelbrot( ((threadId*Driver.SCREEN_HEIGHT)/Driver.NUMBER_OF_THREADS)     ,  (((threadId+1)*Driver.SCREEN_HEIGHT)/Driver.NUMBER_OF_THREADS)-1           );
		}
		for(int threadId=0;threadId<Driver.NUMBER_OF_THREADS;threadId++){
			steps_threads[threadId].start();
		}
		
		for(int threadId=0;threadId<Driver.NUMBER_OF_THREADS;threadId++){
			try {
				steps_threads[threadId].join();
			} catch (InterruptedException e) {
				System.out.println("Thread error");
				System.out.println(e.toString());
			}
		}
		
		return commonContinuation();
	}
	
	public static ColorGrid julia(){
		Thread_StepsJulia[] steps_threads=new Thread_StepsJulia[Driver.NUMBER_OF_THREADS];
		for(int threadId=0;threadId<Driver.NUMBER_OF_THREADS;threadId++){
			steps_threads[threadId]=new Thread_StepsJulia( ((threadId*Driver.SCREEN_HEIGHT)/Driver.NUMBER_OF_THREADS)     ,  (((threadId+1)*Driver.SCREEN_HEIGHT)/Driver.NUMBER_OF_THREADS)-1  ,Driver.juliaR,Driver.juliaI        );
		}
		for(int threadId=0;threadId<Driver.NUMBER_OF_THREADS;threadId++){
			steps_threads[threadId].start();
		}
		
		for(int threadId=0;threadId<Driver.NUMBER_OF_THREADS;threadId++){
			try {
				steps_threads[threadId].join();
			} catch (InterruptedException e) {
				System.out.println("Thread error");
				System.out.println(e.toString());
			}
		}
		
		return commonContinuation();
		
		
	}
	
	public static ColorGrid commonContinuation(){
		float brightnessParameter=ColorGrid.calculateBrightnessParameter(new StepsGrid(steps));
		Thread_ColorPick[] colors_thread=new Thread_ColorPick[Driver.NUMBER_OF_THREADS];
		for(int threadId=0;threadId<Driver.NUMBER_OF_THREADS;threadId++){
			colors_thread[threadId]=new Thread_ColorPick( ((threadId*Driver.SCREEN_HEIGHT)/Driver.NUMBER_OF_THREADS)     ,  (((threadId+1)*Driver.SCREEN_HEIGHT)/Driver.NUMBER_OF_THREADS)-1  ,brightnessParameter);
		}
		for(int threadId=0;threadId<Driver.NUMBER_OF_THREADS;threadId++){
			colors_thread[threadId].start();
		}
		
		for(int threadId=0;threadId<Driver.NUMBER_OF_THREADS;threadId++){
			try {
				colors_thread[threadId].join();
			} catch (InterruptedException e) {
				System.out.println("Thread error");
				System.out.println(e.toString());
			}
		}
		
		return new ColorGrid(colors);
	}
	
	
	
}
