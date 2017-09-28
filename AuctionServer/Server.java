/*
gihanchanaka@gmail.com
E/14/158 CO225
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable{
    /*
        This is the thread for the sever

     */
    private ServerSocket serverSocket;

    public Server(int PORT) throws IOException {
        serverSocket = new ServerSocket(PORT);
        //this.loop();
        // create a new server socket
    }

    public void run(){
        while(true) {
            Socket socket=null;
            try {
                socket = serverSocket.accept();
                handle(socket);
            } catch (IOException e) {
                System.out.println("Exception: "+e);
                try{
                    socket.close();
                }
                catch (IOException ee){
                    Util.prln("");
                }
            }

        }
    }

    private void handle(Socket socket) throws IOException {
        ClientThread ct=new ClientThread(socket);
        Thread t=new Thread(ct);
        t.start();
        //Util.prln("Started thread for one client. waiting for next client..");
    }


}
	    
	