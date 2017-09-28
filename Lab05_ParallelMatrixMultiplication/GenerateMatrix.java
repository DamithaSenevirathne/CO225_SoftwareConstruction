/*
    CO225
    Lab05: Matrix Multiplication
    E/14/158 gihanchanaka@gmail.com
    2017-sept-24
 */

public class GenerateMatrix {
	/*
		This class can be used to generate random matrices.
		The usage instructions are in README
	*/

    public static void main(String[] args) {
        //args={type,fileName,rows,cols}

        int R=Integer.parseInt(args[2]);
        int C=Integer.parseInt(args[3]);

        //These max values are chosen in a way that int,float,double overflows do not happen

        double doubleMax=Math.sqrt(Double.MAX_VALUE)/(Math.max(R,C));
        int intMax=(int)(Math.sqrt(Integer.MAX_VALUE)/(Math.max(R,C)));
        float floatMax=(float)(Math.sqrt(Float.MAX_VALUE)/(Math.max(R,C)));

        Type type;
        if(args[0].equalsIgnoreCase("int"))type=Type.INT;
        else if(args[0].equalsIgnoreCase("float"))type=Type.FLOAT;
        else if(args[0].equalsIgnoreCase("double"))type=Type.DOUBLE;
        else  type=Type.INVALID;



        String[][] ar=new String[R][C];

        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                switch (type){
                    case INT:
                        ar[r][c]=""+Util.randomInt(intMax);
                        break;
                    case FLOAT:
                        ar[r][c]=""+Util.randomFloat(floatMax);
                        break;
                    case DOUBLE:
                        ar[r][c]=""+Util.randomDouble(doubleMax);
                        break;
                }
            }
        }

        try{
            IO.writeToFile(ar,args[1]);
        }
        catch (Exception e){
            IO.print(e.toString());
        }





    }

}
