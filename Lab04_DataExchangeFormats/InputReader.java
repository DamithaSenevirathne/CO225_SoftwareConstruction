//gihanchanaka@gmail.com E/14/158

import java.io.*;


class InputReader {
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
        String[] toReturn= nextLine().split(",");
        for(int x=0;x<toReturn.length;x++)toReturn[x]=clean(toReturn[x]);
        return  toReturn;
    }

    public String clean(String s){
        String toReturn="";
        for(int x=0;x<s.length();x++){
            if(isAcceptableCharacter(s.charAt(x)))toReturn+=s.charAt(x);
        }
        return toReturn;
    }

    public boolean isAcceptableCharacter(char c){
        if(Character.isLetterOrDigit(c)) return true;
        if(Character.isWhitespace(c)) return true;
        if(c=='-') return true;
        return false;

    }




}