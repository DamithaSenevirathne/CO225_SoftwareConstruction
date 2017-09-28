/*
    CO225
    Lab05: Matrix Multiplication
    E/14/158 gihanchanaka@gmail.com
    2017-sept-24
 */
public class Multiply {
    /*
        This class can multiply two matrices in text files and output the results to another text file
        The usage is given in README
        Most methods are overloaded for different number types because java dooesnt support generics for primitives.
    */

    static Type type;
    public static void main(String[] args) {

        if(args[0].equalsIgnoreCase("int")) type=Type.INT;
        else if(args[0].equalsIgnoreCase("float"))type=Type.FLOAT;
        else if(args[0].equalsIgnoreCase("double"))type=Type.DOUBLE;
        else type=Type.INVALID;



        String fileNameA=args[1];
        String fileNameB=args[2];
        String fileNameC=args[3];
        try {
            switch (type) {
                case INT:

                    if (args.length == 4) {
                        IO.writeToFile(Util.toString((Multiply.multiply(
                                            Util.toInt(IO.readFromFile(fileNameA)),
                                            Util.toInt(IO.readFromFile(fileNameB))))),
                                    fileNameC);
                    } else {
                        IO.writeToFile(Util.toString((Multiply.multiply(
                                Util.toInt(IO.readFromFile(fileNameA)),
                                Util.toInt(IO.readFromFile(fileNameB)),
                                Integer.parseInt(args[4])))),
                                fileNameC);

                    }
                    break;
                case FLOAT:
                    if (args.length == 4) {
                        IO.writeToFile(Util.toString((Multiply.multiply(
                                Util.toFloat(IO.readFromFile(fileNameA)),
                                Util.toFloat(IO.readFromFile(fileNameB))))),
                                fileNameC);
                    } else {
                        IO.writeToFile(Util.toString((Multiply.multiply(
                                Util.toFloat(IO.readFromFile(fileNameA)),
                                Util.toFloat(IO.readFromFile(fileNameB)),
                                Integer.parseInt(args[4])))),
                                fileNameC);

                    }
                    break;
                case DOUBLE:
                    if (args.length == 4) {
                        IO.writeToFile(Util.toString((Multiply.multiply(
                                Util.toDouble(IO.readFromFile(fileNameA)),
                                Util.toDouble(IO.readFromFile(fileNameB))))),
                                fileNameC);
                    } else {
                        IO.writeToFile(Util.toString((Multiply.multiply(
                                Util.toDouble(IO.readFromFile(fileNameA)),
                                Util.toDouble(IO.readFromFile(fileNameB)),
                                Integer.parseInt(args[4])))),
                                fileNameC);

                    }
                    break;
            }
        }
        catch(Exception e){
            IO.print(e.toString());
        }
    }

    public static int[][] multiply(int[][] A, int[][] B)throws MatrixDimensionMismatch{
        /*
            Function to multiply two int matrices using single thread and print the time taken
        */
        if(A[0].length!=B.length) throw new MatrixDimensionMismatch();
        long time=System.currentTimeMillis();
        int[][] ans=new int[A.length][B[0].length];
        for(int r=0;r<A.length;r++){
            for(int c=0;c<B[0].length;c++){
                for(int x=0;x<B.length;x++){
                    ans[r][c]+=A[r][x]*B[x][c];

                }
            }
        }
        IO.printHold("Int arrays of size "+A.length+"x"+A[0].length+" and "+B.length+"x"+B[0].length);
        IO.print("."+"1 thread . Multiplying time = "+(System.currentTimeMillis()-time)+"ms");
        return ans;

    }

    public static float[][] multiply(float[][] A, float[][] B)throws MatrixDimensionMismatch{
        /*
            Function to multiply two float matrices using single thread and print the time taken
        */
        if(A[0].length!=B.length) throw new MatrixDimensionMismatch();
        long time=System.currentTimeMillis();

        float[][] ans=new float[A.length][B[0].length];
        for(int r=0;r<A.length;r++){
            for(int c=0;c<B[0].length;c++){
                for(int x=0;x<B.length;x++){
                    ans[r][c]+=A[r][x]*B[x][c];
                }
            }
        }
        IO.printHold("Float arrays of size "+A.length+"x"+A[0].length+" and "+B.length+"x"+B[0].length);
        IO.print("."+"1 thread . Multiplying time = "+(System.currentTimeMillis()-time)+"ms");
        return ans;

    }


    public static double[][] multiply(double[][] A, double[][] B)throws MatrixDimensionMismatch{
        /*
            Function to multiply two double matrices using single thread and print the time taken
        */
        if(A[0].length!=B.length) throw new MatrixDimensionMismatch();
        long time=System.currentTimeMillis();
        double[][] ans=new double[A.length][B[0].length];
        for(int r=0;r<A.length;r++){
            for(int c=0;c<B[0].length;c++){
                for(int x=0;x<B.length;x++){
                    ans[r][c]+=A[r][x]*B[x][c];
                }
            }
        }
        IO.printHold("Double arrays of size "+A.length+"x"+A[0].length+" and "+B.length+"x"+B[0].length);
        IO.print("."+"1 thread . Multiplying time = "+(System.currentTimeMillis()-time)+"ms");
        return ans;

    }

    public static int[][] multiply(int[][] A, int[][] B,int threads)throws MatrixDimensionMismatch{
        /*
            Function to multiply two int matrices using multiple threads and print the time taken
        */
        if(A[0].length!=B.length) throw new MatrixDimensionMismatch();
        long time=System.currentTimeMillis();
        int[][] C=new int[A.length][B[0].length];
        Thread[] thr=new Thread[threads];

        for(int t=0;t<threads-1;t++) {
            thr[t]=new Thread(new ThreadMultiply
                    (A,B,C,A.length*t/threads,A.length*(t+1)/threads));
            thr[t].start();
        }

        thr[threads-1]=new Thread(new ThreadMultiply
                (A,B,C,A.length*(threads-1)/threads,A.length));
        thr[threads-1].start();

        for(int t=0;t<threads;t++) {
            try {
                thr[t].join();
            }
            catch (InterruptedException e) {
                IO.print("Error while joining threads: "+e.toString());
            }

        }
        IO.printHold("Int arrays of size "+A.length+"x"+A[0].length+" and "+B.length+"x"+B[0].length);
        IO.print("."+threads+" threads. Multiplying time = "+(System.currentTimeMillis()-time)+"ms");
        return C;
    }



    public static float[][] multiply(float[][] A,float[][] B,int threads)throws MatrixDimensionMismatch{
        /*
            Function to multiply two float matrices using multiple threads and print the time taken
        */
        if(A[0].length!=B.length) throw new MatrixDimensionMismatch();
        long time=System.currentTimeMillis();
        float[][] C=new float[A.length][B[0].length];
        Thread[] thr=new Thread[threads];

        for(int t=0;t<threads-1;t++) {
            thr[t]=new Thread(new ThreadMultiply
                    (A,B,C,A.length*t/threads,A.length*(t+1)/threads));
            thr[t].start();
        }

        thr[threads-1]=new Thread(new ThreadMultiply
                (A,B,C,A.length*(threads-1)/threads,A.length));
        thr[threads-1].start();

        for(int t=0;t<threads;t++) {
            try {
                thr[t].join();
            }
            catch (InterruptedException e) {
                IO.print("Error while joining threads: "+e.toString());
            }

        }
        IO.printHold("Float arrays of size "+A.length+"x"+A[0].length+" and "+B.length+"x"+B[0].length);
        IO.print("."+threads+" threads. Multiplying time = "+(System.currentTimeMillis()-time)+"ms");
        return C;
    }


    public static double[][] multiply(double[][] A,double[][] B,int threads)throws MatrixDimensionMismatch{
        /*
            Function to multiply two double matrices using multiple threads and print the time taken
        */
        if(A[0].length!=B.length) throw new MatrixDimensionMismatch();
        long time=System.currentTimeMillis();
        double[][] C=new double[A.length][B[0].length];
        Thread[] thr=new Thread[threads];

        for(int t=0;t<threads-1;t++) {
            thr[t]=new Thread(new ThreadMultiply
                    (A,B,C,A.length*t/threads,A.length*(t+1)/threads));
            thr[t].start();
        }

        thr[threads-1]=new Thread(new ThreadMultiply
                (A,B,C,A.length*(threads-1)/threads,A.length));
        thr[threads-1].start();

        for(int t=0;t<threads;t++) {
            try {
                thr[t].join();
            }
            catch (InterruptedException e) {
                IO.print("Error while joining threads: "+e.toString());
            }

        }
        IO.printHold("Double arrays of size "+A.length+"x"+A[0].length+" and "+B.length+"x"+B[0].length);
        IO.print("."+threads+" threads. Multiplying time = "+(System.currentTimeMillis()-time)+"ms");
        return C;
    }

}
