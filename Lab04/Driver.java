//gihanchanaka@gmail.com E/14/158

import java.util.*;

public class Driver {
    static String fileName="google.csv";
    static String[] fieldNames;
    static String[][] contacts;
    static int lastNameIndex,firstNameIndex,contactNumberIndex;

    public static void main(String[] args) {

        InputReader ir=new InputReader(fileName);
        fieldNames=Util.toLowerCase(ir.getLine());

        lastNameIndex=Util.indexOf(fieldNames,Util.toLowerCase(Util.toLowerCase("Family Name")));
        firstNameIndex=Util.indexOf(fieldNames,Util.toLowerCase(Util.toLowerCase("Given Name")));
        contactNumberIndex=Util.indexOf(fieldNames,Util.toLowerCase(Util.toLowerCase("Phone 1 - Value")));


        HashMap<String,String> contactList=new HashMap<>();
        while(!ir.EOF()){
            try {
                String[] temp = (ir.getLine());
                if(Util.isAcceptableEntry(temp)) {
                    contactList.put(Util.toLowerCase("F:" + temp[firstNameIndex]), temp[contactNumberIndex]);
                    contactList.put(Util.toLowerCase("L:" + temp[lastNameIndex]), ((temp[contactNumberIndex])));
                }
            }
            catch (Exception e){
                continue;
            }
        }


        Scanner sc=new Scanner(System.in);
        while(true){
            String s=sc.nextLine();
            if(contactList.containsKey(Util.toLowerCase(s)))System.out.println(contactList.get(Util.toLowerCase(s)));
            else if(s.charAt(1)==':'){
                if(Character.toUpperCase(s.charAt(0))=='F')
                    System.out.println("No entry with first name "+s.substring(2));
                else if(Character.toUpperCase(s.charAt(0))=='L')
                    System.out.println("No entry with last name "+s.substring(2));
                else System.out.println("Only F and L are allowed");
            }
            else{
                System.out.println("You have to use the format F:firstName or L:lastName");
            }
        }


    }






}
