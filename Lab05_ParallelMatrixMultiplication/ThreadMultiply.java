/*
    CO225
    Lab05: Matrix Multiplication
    E/14/158 gihanchanaka@gmail.com
    2017-sept-24
 */

public class ThreadMultiply implements Runnable{
    /*
        The class used to run matrix multiplication on multiple threads.
    */

    int[][] intA,intB,intC;
    float[][] floatA,floatB,floatC;
    double[][] doubleA,doubleB,doubleC;
    int rStart,rEnd;
    Type type;


    //The constructors for different matrix types
    ThreadMultiply(int[][] A,int[][] B,int[][] C,int rStart,int rEnd){
        type=Type.INT;
        intA=A;intB=B;intC=C;this.rStart=rStart;this.rEnd=rEnd;
    }

    ThreadMultiply(float[][] A,float[][] B,float[][] C,int rStart,int rEnd){
        type=Type.FLOAT;
        floatA=A;floatB=B;floatC=C;this.rStart=rStart;this.rEnd=rEnd;
    }

    ThreadMultiply(double[][] A,double[][] B,double[][] C,int rStart,int rEnd){
        type=Type.DOUBLE;
        doubleA=A;doubleB=B;doubleC=C;this.rStart=rStart;this.rEnd=rEnd;
    }

    //A common run function
    public void run(){
        switch (type){
            case INT:
                for(int r=rStart;r<rEnd;r++){
                    for(int c=0;c<intB[0].length;c++){
                        for(int x=0;x<intB.length;x++){
                            intC[r][c]+=intA[r][x]*intB[x][c];
                        }
                    }
                }
                break;


            case FLOAT:
                for(int r=rStart;r<rEnd;r++){
                    for(int c=0;c<floatB[0].length;c++){
                        for(int x=0;x<floatB.length;x++){
                            floatC[r][c]+=floatA[r][x]*floatB[x][c];
                        }
                    }
                }
                break;
            case DOUBLE:
                for(int r=rStart;r<rEnd;r++){
                    for(int c=0;c<doubleB[0].length;c++){
                        for(int x=0;x<doubleB.length;x++){
                            doubleC[r][c]+=doubleA[r][x]*doubleB[x][c];
                        }
                    }
                }
                break;

        }
    }
}
