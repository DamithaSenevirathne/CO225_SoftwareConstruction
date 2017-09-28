
public class ComplexNumber {
	double real;
	double imaginary;
	static ComplexNumber ZERO=new ComplexNumber(0,0);
	ComplexNumber(double real,double imaginary){
		this.real=real;
		this.imaginary=imaginary;
	}
	
	public static ComplexNumber add(ComplexNumber a,ComplexNumber b){
		return new ComplexNumber(a.real+b.real,a.imaginary+b.imaginary);
	}
	public static ComplexNumber sub(ComplexNumber a,ComplexNumber b){
		return new ComplexNumber(a.real-b.real,a.imaginary-b.imaginary);
	}
	public static ComplexNumber multiply(ComplexNumber a,ComplexNumber b){
		return new ComplexNumber(a.real*b.real-a.imaginary*b.imaginary,a.real*b.imaginary+a.imaginary*b.real);
	}
	public static ComplexNumber square(ComplexNumber a){
		return new ComplexNumber(Math.pow(a.real,2)-Math.pow(a.imaginary, 2),2*a.real*a.imaginary);
	}
	
	public double abs(){
		return Math.sqrt(Math.pow(real,2)+Math.pow(imaginary,2));
	}
	
	@Override
	public String toString(){
		return this.real+" "+this.imaginary+"i";
	}
	
	public static void main(String[] args){
		System.out.println("Testing complex number class");
		ComplexNumber a=new ComplexNumber(1, 1);
		System.out.println(a+" \n"+ComplexNumber.square(a)+"\n"+ComplexNumber.square(ComplexNumber.square(a)));
	}
}
