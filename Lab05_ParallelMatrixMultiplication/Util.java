/*
    CO225
    Lab05: Matrix Multiplication
    E/14/158 gihanchanaka@gmail.com
    2017-sept-24
 */
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class Util {
    /*
        All the "utilities" needed for the program to run
        Bad software engineering practice :-) motivation from java.util
        
        Most of the methods are overloaded fo three number types (Why cant java support generics for primitives!)
    */

//Radom number generators with a bound for the absolute value
    static Random ran=new Random();
    public static int randomInt(int max){
        return ran.nextInt(2*max)-max;
    }

    public static float randomFloat(float max){
        return Math.abs(ran.nextFloat()%2*max)-max;
    }

    public static double randomDouble(double max){
        return Math.abs(ran.nextDouble()%2*max)-max;
    }

//Convert string arrays (read from files) to number arrays
    public static int[][] toInt(String[][] ar){
        int[][] toReturn=new int[ar.length][ar[0].length];
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                toReturn[x][y]=Integer.parseInt(ar[x][y]);
            }
        }
        return toReturn;
    }
    public static float[][] toFloat(String[][] ar){
        float[][] toReturn=new float[ar.length][ar[0].length];
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                toReturn[x][y]=Float.parseFloat(ar[x][y]);
            }
        }
        return toReturn;
    }
    public static double[][] toDouble(String[][] ar){
        double[][] toReturn=new double[ar.length][ar[0].length];
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                toReturn[x][y]=Double.parseDouble(ar[x][y]);
            }
        }
        return toReturn;
    }

//To sum up a number array in the absolute values
    public static float absMax(float[][] ar){
        float absMax=0;
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                absMax=Math.max(absMax,Math.abs(ar[x][y]));
            }
        }
        return absMax;
    }
    public static double absMax(double[][] ar){
        double absMax=0;
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                absMax=Math.max(absMax,Math.abs(ar[x][y]));
            }
        }
        return absMax;
    }
    public static int absMax(int[][] ar){
        int absMax=0;
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                absMax=Math.max(absMax,Math.abs(ar[x][y]));
            }
        }
        return absMax;
    }

//To Sum up a number matrix as BigInteger/BigDecimal and return the answer as string
    public static String sum(double[][] ar){
        BigDecimal sum=new BigDecimal("0");
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                sum=sum.add(new BigDecimal(Double.toString(ar[x][y])));

            }
        }
        return sum.toString();
    }
    public static String sum(float[][] ar){
        BigDecimal sum=new BigDecimal("0");
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                sum=sum.add(new BigDecimal(Float.toString(ar[x][y])));
            }
        }
        return sum.toString();
    }
    public static String sum(int[][] ar){
        BigInteger sum=new BigInteger("0");
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                sum=sum.add(new BigInteger(Integer.toString(ar[x][y])));
            }
        }
        return sum.toString();
    }

//to turn the number matrices into string arrays before writing to files
//This is used to keep the IO file code simple
    public static String[][] toString(int[][] ar){
        String[][] toReturn=new String[ar.length][ar[0].length];
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                toReturn[x][y]=""+ar[x][y];
            }
        }
        return toReturn;

    }
    public static String[][] toString(float[][] ar){
        String[][] toReturn=new String[ar.length][ar[0].length];
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                toReturn[x][y]=""+ar[x][y];
            }
        }
        return toReturn;

    }
    public static String[][] toString(double[][] ar){
        String[][] toReturn=new String[ar.length][ar[0].length];
        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar[0].length;y++){
                toReturn[x][y]=""+ar[x][y];
            }
        }
        return toReturn;

    }





}
