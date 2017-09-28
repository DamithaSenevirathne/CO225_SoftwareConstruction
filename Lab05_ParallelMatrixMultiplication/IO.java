/*
    CO225
    Lab05: Matrix Multiplication
    E/14/158 gihanchanaka@gmail.com
    2017-sept-24
 */
import java.io.*;
import java.util.ArrayList;

public class IO {
    /*
        Functions to read and write to files.
        The methods are just for matrix reading and writing
        
        Two additional methods to print to the shell is given just to make it easier and not type the long System.out.print()
    */
    public static void writeToFile(String[][] ar,String fileName)throws Exception {
        PrintWriter out=new PrintWriter(fileName);

        for(int r=0;r<ar.length;r++){
            for(int c=0;c<ar[0].length;c++){
                out.print(ar[r][c]+" ");
            }
            out.println("");
        }
        out.flush();
        out.close();

    }
    public static void printHold(String s){
        System.out.print(s);
    }

    public static String[][] readFromFile(String fileName){
        InputReader ir=new InputReader(fileName);
        ArrayList<String[]> ar=new ArrayList<>();
        while(!ir.EOF())ar.add(ir.getLine());
        String[][] toReturn=new String[ar.size()][];
        for(int x=0;x<ar.size();x++){
            toReturn[x]=ar.get(x);
        }
        return toReturn;
    }



    public static void print(String s){
        System.out.println(s);
    }
}




class InputReader {
    /*
        Class for reading from files. Originally developed to increase the file reading speed using buffering.
        A method to check whether the EOF is reached is present.
        getLine() is specifically implemented for matrix reading in this project.
    */

    private BufferedReader bReader;
    private static File file;
    private static FileReader fr;
    private static BufferedReader br;

    InputReader(String fileName){
        try {
            file = new File(fileName);
            fr = new FileReader(file);
            bReader = new BufferedReader(fr);
        }
        catch(Exception e){
            System.out.println("ERROR :"+e.toString());
        }
    }

    public String nextLine(){
        try{
            String inLine= bReader.readLine();
            return inLine;
        }
        catch(Exception e){
            System.out.print("EOF");
            return null;
        }
    }



    public boolean EOF(){
        try{
            return !bReader.ready();
        }
        catch(Exception e){
            return true;
        }
    }

    public String[] getLine(){
        String[] toReturn= nextLine().split(" ");
        for(int x=0;x<toReturn.length;x++){
            toReturn[x]=(toReturn[x]);
        }
        return  toReturn;
    }







}