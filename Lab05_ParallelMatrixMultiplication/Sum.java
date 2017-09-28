/*
    CO225
    Lab05: Matrix Multiplication
    E/14/158 gihanchanaka@gmail.com
    2017-sept-24
 */
public class Sum {
    /*
        This class can take a filename as an input and return the sum of all elements
        This is used as a checksum to test the accuracy of the program
    */
    static Type type;
    public static void main(String[] args) {
        IO.print(run(args));
    }

    public static String run(String[] args) {
        if(args[0].equalsIgnoreCase("int")) type=Type.INT;
        else if(args[0].equalsIgnoreCase("float"))type=Type.FLOAT;
        else if(args[0].equalsIgnoreCase("double"))type=Type.DOUBLE;
        else type=Type.INVALID;
        String sum="";
        switch (type){
            case INT:

                sum=(Util.sum(Util.toInt(IO.readFromFile(args[1]))));
                break;
            case FLOAT:
                sum=(Util.sum(Util.toFloat(IO.readFromFile(args[1]))));

                break;
            case DOUBLE:
                sum=(Util.sum(Util.toDouble(IO.readFromFile(args[1]))));

                break;
        }
        return sum;
    }




}
