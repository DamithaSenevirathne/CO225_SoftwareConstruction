//gihanchanaka@gmail.com E/14/158

/*
    This program makes a CSV file identical to the google contacts format
    Run this as
    java SampleCSVMmaker > google.csv 1000

    1000=the number of contacts to be generated

 */

import java.util.ArrayList;
import java.util.Random;

public class SampleCSVmaker {
    static String fields="Name,Given Name,Additional Name,Family Name,Yomi Name,Given Name Yomi,Additional Name Yomi,Family Name Yomi,Name Prefix,Name Suffix,Initials,Nickname,Short Name,Maiden Name,Birthday,Gender,Location,Billing Information,Directory Server,Mileage,Occupation,Hobby,Sensitivity,Priority,Subject,Notes,Group Membership,E-mail 1 - Type,E-mail 1 - Value,E-mail 2 - Type,E-mail 2 - Value,IM 1 - Type,IM 1 - Service,IM 1 - Value,Phone 1 - Type,Phone 1 - Value,Phone 2 - Type,Phone 2 - Value,Address 1 - Type,Address 1 - Formatted,Address 1 - Street,Address 1 - City,Address 1 - PO Box,Address 1 - Region,Address 1 - Postal Code,Address 1 - Country,Address 1 - Extended Address,Organization 1 - Type,Organization 1 - Name,Organization 1 - Yomi Name,Organization 1 - Title,Organization 1 - Department,Organization 1 - Symbol,Organization 1 - Location,Organization 1 - Job Description,Website 1 - Type,Website 1 - Value";
    static Random ran=new Random();
    public static void main(String[] args) {
        System.out.println(fields);
        InputReader firstNameFile=new InputReader("Database_of_First_Names.csv");
        InputReader lastNameFile=new InputReader("Database_of_First_Names.csv");

        ArrayList<String> firstNames=new ArrayList<>();
        ArrayList<String> lastNames=new ArrayList<>();

        while(!firstNameFile.EOF())firstNames.add(firstNameFile.nextLine());
        while(!lastNameFile.EOF())lastNames.add(lastNameFile.nextLine());

        for(int x=0;x<Integer.parseInt(args[0]);x++){
            System.out.print("   ,");
            System.out.print(firstNames.get(ran.nextInt(firstNames.size()))+",");//Given name
            System.out.print(firstNames.get(ran.nextInt(firstNames.size()))+",");//Additional name
            System.out.print(lastNames.get(ran.nextInt(lastNames.size()))+",");//Family Name
            System.out.print("Yomi Name,Given Name Yomi,Additional Name Yomi,Family Name Yomi,Name Prefix,Name Suffix,Initials,Nickname,Short Name,Maiden Name,Birthday,Gender,Location,Billing Information,Directory Server,Mileage,Occupation,Hobby,Sensitivity,Priority,Subject,Notes,Group Membership,E-mail 1 - Type,E-mail 1 - Value,E-mail 2 - Type,E-mail 2 - Value,IM 1 - Type,IM 1 - Service,IM 1 - Value,");
            String[] types={"Home","Mobile","Work"};
            System.out.print(types[ran.nextInt(types.length)]+",");
            int type=ran.nextInt(100);
            if(type<2)System.out.print(makeNumber(3)+",");
            else System.out.print(makeNumber(10)+",");
            System.out.print("Phone 2 - Type,Phone 2 - Value,Address 1 - Type,Address 1 - Formatted,Address 1 - Street,Address 1 - City,Address 1 - PO Box,Address 1 - Region,Address 1 - Postal Code,Address 1 - Country,Address 1 - Extended Address,Organization 1 - Type,Organization 1 - Name,Organization 1 - Yomi Name,Organization 1 - Title,Organization 1 - Department,Organization 1 - Symbol,Organization 1 - Location,Organization 1 - Job Description,Website 1 - Type,Website 1 - Value");
            System.out.println("");
        }

    }

    public static String makeNumber(int digits){
        String toReturn="";
        if(digits<4){
            toReturn=""+ran.nextInt(10000);
        }
        else{
            toReturn+=0;
            toReturn+=""+ran.nextInt(100)+"-"+ran.nextInt(1000)+" "+ran.nextInt(10000);
        }
        while (Util.digitCount(toReturn)==digits){
            toReturn+=ran.nextInt(10);
        }
        return toReturn;
    }
}
