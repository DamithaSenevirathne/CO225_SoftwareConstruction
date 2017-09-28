//gihanchanaka@gmail.com E/14/158

public class Util {
    public static int indexOf(String[] ar,String toFind){
        for(int x=0;x<ar.length;x++){
            if(ar[x].equalsIgnoreCase(toFind)) return x;
        }
        return -1;
    }

    public static Long getNumber(String s){
        long ans=0l;
        for(int x=0;x<s.length();x++)if(Character.isDigit(s.charAt(x))) ans=(ans*10)+(s.charAt(x)-'0');
        return new Long(ans);
    }

    public static boolean isAcceptableEntry(String[] entry){
        if(digitCount(entry[Driver.contactNumberIndex])<3)return false;
        return true;
    }

    public static int digitCount(String s){
        int count=0;
        for(int x=0;x<s.length();x++)if(Character.isDigit(s.charAt(x)))count++;
        return count;
    }
    public static String toLowerCase(String s){
        String toReturn="";
        for(int x=0;x<s.length();x++){
            if(Character.isLetter(s.charAt(x)))toReturn+=Character.toLowerCase(s.charAt(x));
            else toReturn+=s.charAt(x);
        }
        return toReturn;
    }

    public static String[] toLowerCase(String[] ar){
        String[] toReturn=new String[ar.length];
        for(int x=0;x<toReturn.length;x++)toReturn[x]=toLowerCase(ar[x]);
        return toReturn;
    }
}
