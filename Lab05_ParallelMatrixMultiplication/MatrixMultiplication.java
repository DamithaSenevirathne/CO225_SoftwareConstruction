/*
    CO225
    Lab05: Matrix Multiplication
    E/14/158 gihanchanaka@gmail.com
    2017-sept-24
 */
import java.util.ArrayList;

public class MatrixMultiplication {
    /*
        This is the main class that tries the program for different matrix dimensions and types and analyze runtimes.
        This calls the main method os other classes which are designed to work on the unix shell
        Therefore the arguments passed to those classes are passed as space seperated strings.
    */
    public static void main(String[] args) {

        //Change these parameters for different test runes
        String[] type={"int","float","double"}; //The matrix types to be tested
        int[] mnp={10,100,1000};                //The matrix dimensions to be tested
        int[] threads={2,4,8,16,32,64};         //The number of threads to be tested
        

        int testCaseCount=1;
        for(String ty:type) {
            for (int m : mnp) {
                for (int n : mnp) if(n>=m){
                    for (int p : mnp) {
                        String A = "Test_" + testCaseCount + "A.txt";
                        String B = "Test_" + testCaseCount + "B.txt";
                        String C = "Test_" + testCaseCount + "C.txt";
                        testCaseCount++;

                        GenerateMatrix.main((ty + " " + A + " " + m + " " + p).split(" "));
                        GenerateMatrix.main((ty + " " + B + " " + p + " " + n).split(" "));
                        Multiply.main((ty + " " + A + " " + B + " " + C).split(" "));
                        String sumC = Sum.run(("ty " + C).split(" "));
                        for (int th : threads)
                            if (th <= m) {
                                String CC = "Test_" + testCaseCount + "C_" + th + ".txt";
                                Multiply.main((ty + " " + A + " " + B + " " + CC + " " + th).split(" "));
                                String sumCC = Sum.run(("ty " + CC).split(" "));

                                if (!sumC.equals(sumCC))
                                    IO.print("Error in multiplying " + ty + " " + m + " " + n + " " + p + " " + th);
                            }


                    }
                }
            }

        }
    }
}
