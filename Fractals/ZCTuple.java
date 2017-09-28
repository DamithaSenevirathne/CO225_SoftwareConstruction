
public class ZCTuple {

	private ComplexNumber Z;
	private ComplexNumber C;
	
	ZCTuple(ComplexNumber Z0,ComplexNumber C){
		Z=Z0;
		this.C=C;
	}
	
	public void takeNextStep(){
		Z=ComplexNumber.add(ComplexNumber.square(Z), C);
	}
	
	public String toString(){
		return "Z = "+Z.toString()+" C= "+C.toString();
	}
	
	public double absZ(){
		return Z.abs();
	}

}
