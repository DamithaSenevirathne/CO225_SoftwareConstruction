import java.util.ArrayList;

/*
gihanchanaka@gmail.com
E/14/158 CO225
 */
public class StockItem {
    /*
        The object to store a particular stock (all its information)
     */
    String symbol;
    String name;
    String marketCategory;
    String testIssue;
    String financialStatus;
    String bidder;
    int roundLotSize;
    ArrayList<String> log;
    float price;


    StockItem(String symbol, String name, String marketCategory,
                String testIssue, String financialStatus, int roundLotSize, float price){
        this.symbol=symbol;
        this.name=name;
        this.marketCategory=marketCategory;
        this.testIssue=testIssue;
        this.financialStatus=financialStatus;
        this.roundLotSize=roundLotSize;
        this.price=price;
        this.bidder="No bids yet";
        this.log=new ArrayList<String>();
        this.log.add("Initialized with value "+price);
    }

    public boolean bid(float newPrice,String clientName){
        if(newPrice>price){
            price=newPrice;
            bidder=clientName;
            log.add(bidder+" bid for "+price+" and was successful!");
            return true;
        }
        else{
            log.add(clientName+" bid for "+newPrice+" and was NOT successful!");
            return false;
        }
    }

    public boolean adminBid(float newPrice){

        if(newPrice>price) {
            price = newPrice;
            Util.addToLatestBidQueue(this);
            bidder = "Admin";
            log.add(bidder + " bid for " + getPrice() + " and was successful!");
            return true;
        }
        else{
            return false;
        }
    }

    public String getPrice(){
        return String.format("%.02f", price);
    }

    public String getSymbol(){
        return symbol;
    }

    public String get(String key){
        if(key.equalsIgnoreCase(Driver.fields[0]))return symbol;
        if(key.equalsIgnoreCase(Driver.fields[1]))return name;
        if(key.equalsIgnoreCase(Driver.fields[2]))return marketCategory;
        if(key.equalsIgnoreCase(Driver.fields[3]))return testIssue;
        if(key.equalsIgnoreCase(Driver.fields[4]))return financialStatus;
        if(key.equalsIgnoreCase(Driver.fields[5]))return ""+roundLotSize;
        if(key.equalsIgnoreCase(Driver.fields[6]))return getPrice();
        return "";

    }

    public String getBidder(){return this.bidder;}
    public ArrayList<String> getLog(){return this.log;}

}
