import javax.swing.JFrame;


public class Driver {

	static int SCREEN_HEIGHT=800;
	static int SCREEN_WIDTH=800;
	static int ITERATIONS=1000;
	static double RADIUS=2.0;
	static double AVERAGE_LIGHT=0.100f;
	static int COLOR=Math.min(2,(int)(Math.random()*3f));
	static int NUMBER_OF_THREADS=4;
	
	static double complexMin=-1;
	static double complexMax=1;
	static double realMin=-1;
	static double realMax=1;
	
	static double juliaR=0;
	static double juliaI=0;
	
	static int pattern=0; //1=Mandelbrot, 2=Julia
	
	static JFrame frame;
	public static void run(String[] args) {
		
	}
	
	public static void show(ColorGrid grid,String title){
		frame = new JFrame(title); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true); 
		frame.setContentPane(new DisplayGrid(Driver.SCREEN_WIDTH,Driver.SCREEN_HEIGHT,grid)); 	
		frame.pack(); 
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true); 
		
	}
	
	public static void handleInput(String[] arg,int offset){
		try{
			if(arg[offset+0].equalsIgnoreCase("mandelbrot")) pattern=1;
			else if(arg[offset+0].equalsIgnoreCase("julia"))pattern=2;
			else return;
			
			if(pattern==2){
				juliaR=Double.parseDouble(arg[offset+1]);
				juliaI=Double.parseDouble(arg[offset+2]);
				ITERATIONS=Integer.parseInt(arg[offset+3]);
			}
			else if(pattern==1){
				realMin=Double.parseDouble(arg[offset+1]);
				realMax=Double.parseDouble(arg[offset+2]);
				complexMin=Double.parseDouble(arg[offset+3]);
				complexMax=Double.parseDouble(arg[offset+4]);
				ITERATIONS=Integer.parseInt(arg[offset+5]);

			}
		}
		catch(Exception e){
			pattern=0;
		}
		
	}
	
	public static void printError(){
		System.out.println("YOU HAVE MADE A WRONG INPUT");
	}

}
