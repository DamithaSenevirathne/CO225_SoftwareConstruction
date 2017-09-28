/*
gihanchanaka@gmail.com
E/14/158 CO225
 */
import javax.swing.*;
import java.awt.*;

public class Util {
    /*
        All utilities needed to run the program
     */


    public static int indexOfCaseInsensitive(String[] ar,String s){
        for(int x=0;x<ar.length;x++){
            if(ar[x].equalsIgnoreCase(s))return x;
        }
        return -1;
    }

    public static void pr(Object[] ar){
        for(int x=0;x<ar.length;x++){
            System.out.println(ar[x].toString());
        }
    }

    public static void pr(Object o){
        System.out.print(o.toString());
    }

    public static void prln(Object o){
        System.out.println(o.toString());
    }

    public static void prSameLine(Object[] ar){
        for(int x=0;x<ar.length;x++){
            System.out.print(ar[x].toString()+" ");
        }
    }

    public static void takeInputs(){
        String[] fields=Driver.fileReader.getLine();
        Driver.fields=fields;
        int indexSymbol=Util.indexOfCaseInsensitive(fields,"Symbol");
        int indexName=Util.indexOfCaseInsensitive(fields,"Security Name");
        int indexMarketCategoryR=fields.length-Util.indexOfCaseInsensitive(fields,"Market Category");
        int indexTestIssueR=fields.length-Util.indexOfCaseInsensitive(fields,"Test Issue");
        int indexFinancialStatus=fields.length-Util.indexOfCaseInsensitive(fields,"Financial Status");
        int indexRoundLotSize=fields.length-Util.indexOfCaseInsensitive(fields,"Round Lot Size");
        int indexPrice=fields.length-Util.indexOfCaseInsensitive(fields,"Price");

        while(!Driver.fileReader.EOF()){
            String[] inLine=Driver.fileReader.getLine();
            try{
                String symbol=inLine[indexSymbol];

                String name="";
                for(int x=indexName;x<inLine.length-indexMarketCategoryR;x++){
                    name+=inLine[x];
                }

                String marketCategory=inLine[inLine.length-indexMarketCategoryR];
                String testIssue=inLine[inLine.length-indexTestIssueR];
                String financialStatus=inLine[inLine.length-indexFinancialStatus];
                int roundLotSize=Integer.parseInt(inLine[inLine.length-indexRoundLotSize]);
                float price=Float.parseFloat(inLine[inLine.length-indexPrice]);

                Driver.stockItems.put(new StockItem(symbol,name,marketCategory,testIssue,
                                                    financialStatus,roundLotSize,price));

            }
            catch (Exception e){
                Util.pr("Err: ");


            }
        }
        Util.prln("Finished reading the file. Added "+Driver.stockItems.size()+" items");

    }


    public static void show(CompanyListPanel list1,CompanyListPanel list2){
        JFrame frame=new JFrame("Stock Server");
        frame.setLayout(new GridLayout(1,2));

        frame.add(list1);
        frame.add(list2);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public synchronized static void addToLatestBidQueue(StockItem item){
        if(!Driver.lastestBids.contains(item)) Driver.lastestBids.add(item);
        while(Driver.lastestBids.size()>10)Driver.lastestBids.remove();
    }

}
