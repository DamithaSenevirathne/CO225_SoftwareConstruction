/*
gihanchanaka@gmail.com
E/14/158 CO225
 */
import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable {
    /*
        This is a thread to handle a single client

     */
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    String clientName;
    String symbol;
    StockItem stockItem;
    ClientThread(Socket socket) throws IOException{
        this.socket=socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

    }

    public boolean authenticate(){
        try{
            clientName=in.readLine();
            symbol=in.readLine();
            StockItem si=Driver.authenticate(symbol);
            if(si==null){
                out.println("-1");
                out.flush();
                return false;
            }
            else{
                out.println(si.getPrice());
                out.flush();
                this.stockItem=si;
                return true;
            }

        }
        catch(IOException e){
            Util.pr("Failed connecting to client. ");
            Util.prln(e.toString());
            return false;
        }

    }

    public void clientBidLoop(){
        while(true) {
            String s="";
            float f=-1;
            try{
                s=in.readLine();
            }
            catch (Exception e){
                Util.pr("Error communicating with client: ");
                Util.prln(e.toString());
                continue;
            }


            try{
                f=Float.parseFloat(s);
            }
            catch (Exception e){
                out.println("Please enter a float");
                out.flush();
                continue;
            }


            if(stockItem.bid(f,clientName)){
                Util.addToLatestBidQueue(stockItem);
                out.println("Successful bid!");
                out.flush();
            }
            else{
                out.println("Bid higher than "+stockItem.getPrice());
                out.flush();
            }

        }
    }

    public void run(){
        if(authenticate()){
            Util.prln("Authenticated the client "+clientName);
            clientBidLoop();
        }
        else{
            return;
        }
    }
}
