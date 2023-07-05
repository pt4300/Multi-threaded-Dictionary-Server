package org.server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.*;
import org.server.Dictionary;
import org.server.Handler;
import org.server.ServerUI;
/**
 * @author Yuting Yu 1291624
 */
public class Server {
    // Declare the port number
    private int port;
    private Dictionary dictionary;
    // Identifies the user number connected
    protected static int counter = 0;
    private ServerUI ui;

    public Server(int port,String dictionaryPath) {
        this.port = port;
        this.dictionary = new Dictionary(dictionaryPath);
        this.ui = new ServerUI();
    }

    public void beginService(){
        // using cached worker pool to dynamically allocated threads
        ExecutorService executor = Executors.newCachedThreadPool();
        try (ServerSocket server = new ServerSocket(port)){
            server.setReuseAddress(true);
            ui.updatePortField(Integer.toString(port));
            // Wait for connections.
            while(true)
            {
                try{
                    Socket client = server.accept();
                    counter++;
                    ui.updateConsoleField("Client "+counter+" connected"+"\n");
                    executor.submit(new Handler(client,dictionary,ui,counter));
                }catch(SocketException e){
                    System.err.println("Server Socket exception: " + e.getMessage());
                }

            }
        } catch (IOException e)
        {
            System.err.println("Server exception: " + e.getMessage());
        } finally {
            executor.shutdown();
        }

    }
    public static void main(String[] args) {
        if(args.length != 2){
            System.err.println("Usage: java -jar DictionaryServer.jar <port> <dictionary-file>");
            System.exit(1);
        }else{
            try{
                int port = Integer.parseInt(args[0]);
                String dictionaryPath = args[1];
                Server server = new Server(port,dictionaryPath);
                server.beginService();
            }catch (NumberFormatException e){
                System.err.println("Port number must be an integer");
                System.exit(1);
            }
            catch (Exception e){
                System.err.println("Wrong args, please fix and try again");
                System.exit(1);
            }

        }
    }

}
