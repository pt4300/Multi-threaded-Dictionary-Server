package org.client;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import com.google.gson.*;
/**
 * @author Yuting Yu 1291624
 */

public class Client {
    private String hostname;
    private int port;
    private final Gson gson;
    private DataInputStream input;
    private DataOutputStream output;

    private Socket socket;
    public Client(String hostname, int port){
        this.hostname = hostname;
        this.port = port;
        this.gson = new Gson();
    }
    public void connect(){
        try{
            socket = new Socket(hostname,port);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

        }catch(UnknownHostException e){
            System.err.println("Server not found: " + e.getMessage());
            System.exit(1);
        }catch(IOException e){
            System.out.println("I/O error: " + e.getMessage());
            System.exit(1);
        }
    }
    public String send(String command, String word, String definition){
        try{
            JsonObject request = new JsonObject();
            request.addProperty("command", command);
            request.addProperty("word", word);
            // do not add definition if it is null
            if(definition!=null){
                request.addProperty("definition", definition);
            }

            // send the request to the server
            output.writeUTF(request.toString());
            output.flush();
            // read the response from the server
            return input.readUTF();

        }catch(IOException e){
            e.printStackTrace();
            return e.getMessage();
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public static void main(String[] args) {
        // do not proceed further if cmd args is incorrect
        if(args.length != 2){
            System.err.println("Usage: java –jar DictionaryClient.jar <server-address> <server-port>");
            System.exit(1);
        }else{
            try{
                String hostname = args[0];
                int port = Integer.parseInt(args[1]);
                ClientUI ui = new ClientUI(hostname, port);
            }catch(NumberFormatException e){
                System.err.println("Please input a valid port number");
                System.exit(1);
            }catch(Exception e){
                System.err.println("Wrong args, please fix and try again");
                System.exit(1);
            }

        }

    }
}
