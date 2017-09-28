
public class Fractal {
	
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		
		
		if(args[0].toLowerCase().equals("fast") ){
			Driver.handleInput(args, 1);
			if(Driver.pattern==1)Driver.show(Fast.mandelbrot(), args[1]);
			if(Driver.pattern==2)Driver.show(Fast.julia(), args[1]);
		}
		else{
			ColorGrid cg = null;
			Driver.handleInput(args, 0);
			if(Driver.pattern==1)cg=new ColorGrid(new StepsGrid(new ZCTupleGrid(new ComplexCoordinateGrid(Driver.realMin,Driver.realMax,Driver.complexMin,Driver.complexMax))));
			if(Driver.pattern==2)cg=new ColorGrid(new StepsGrid(new ZCTupleGrid(new ComplexCoordinateGrid(Driver.realMin,Driver.realMax,Driver.complexMin,Driver.complexMax), new ComplexNumber(Driver.juliaR,Driver.juliaI)) ));
			if(Driver.pattern!=0)Driver.show(cg,args[0]+" "+Driver.ITERATIONS);
				
		}
		if(Driver.pattern==0) Driver.printError();
		else{
			long estimatedTime = System.currentTimeMillis() - startTime;
			estimatedTime/=1000;
			if(args[0].toLowerCase().equals("fast"))System.out.println("TIME "+estimatedTime+"s using "+Driver.NUMBER_OF_THREADS+" threads");
			else System.out.println("TIME "+estimatedTime+" using one thread");
		}
		
		System.out.println("Screen size: "+Driver.realMin+" "+Driver.realMax+" "+Driver.complexMin+" "+Driver.complexMax);
		if(Driver.pattern==1){
			System.out.println("Pattern: Mandelbrot");
			
		}
		if(Driver.pattern==2){
			System.out.println("Pattern: Julia");
			System.out.println("Complex number: "+Driver.juliaR+" "+Driver.juliaI);
			
		}
		
		System.out.println("Iterations: "+Driver.ITERATIONS);
		
				
	}
}
