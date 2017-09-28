/*
gihanchanaka@gmail.com
E/14/158 CO225
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import javax.swing.Timer;

public class Driver {
    /*
        The main program
     */
    public static final int PORT = 2000;
    public static HashMap2 stockItems = new HashMap2();
    public static CompanyListPanel topCompanies,newBids;
    public static ActionListener listUpdater = new ListUpdater();
    public static Timer timer = new Timer(500, listUpdater);
    public static InputReader fileReader = new InputReader("stocks.csv");
    public static Server server;
    public static Queue<StockItem> lastestBids=new LinkedList<StockItem>();
    public static String[] fields;

    public static void main(String[] args) throws IOException {



        try{
            server=new Server(PORT);
            Thread t=new Thread(server);
            t.start();
        }
        catch (IOException e){
            Util.prln("Error while creating server");
            Util.prln(e.toString());
        }

        Util.takeInputs();
        timer.start();
        topCompanies = new CompanyListPanel(new Dimension(200, 500),"Top Companies");
        newBids= new CompanyListPanel(new Dimension(200,150),"New bids");
        Util.show(topCompanies,newBids);
    }

    public static StockItem authenticate(String securityName){
        if(stockItems.containsKey(securityName)) return stockItems.get(securityName);
        else return null;
    }

    public static float stockPrice(String s){
        return stockItems.get(s).price;
    }
}
