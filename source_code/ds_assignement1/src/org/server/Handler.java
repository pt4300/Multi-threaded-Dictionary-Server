package org.server;
import java.io.*;
import java.net.Socket;
import org.server.Dictionary;
import com.google.gson.*;
import java.net.SocketException;
import org.server.ServerUI;
/**
 * @author Yuting Yu 1291624
 */
public class Handler implements Runnable {
    private Socket clientSocket;
    private Dictionary dictionary;
    private ServerUI ui;

    private Gson gson;
    private int clientNumber;
    public Handler(Socket clientSocket, Dictionary dictionary,ServerUI ui, int clientNumber){
        this.clientSocket = clientSocket;
        this.dictionary = dictionary;
        this.gson = new Gson();
        this.ui = ui;
        this.clientNumber = clientNumber;
    }

    @Override
    public void run(){
        try(DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream())){
            String clientMsg = null;
            try{
                while ((clientMsg = input.readUTF()) != null) {
                // build a JSON object from the client message
                JsonObject request = gson.fromJson(clientMsg, JsonObject.class);
                String command = request.get("command").getAsString();
                String word = request.get("word").getAsString();
                String definition = request.has("definition") ? request.get("definition").getAsString() : null;
                String response = processRequest(command, word, definition);
                // send the response to the client
                output.writeUTF(response);
                output.flush();

                }
            }catch (SocketException e){
                ui.updateConsoleField("Client " + clientNumber + " disconnected\n");
            }
        } catch (IOException e) {
            ui.updateConsoleField("Client " + clientNumber + " disconnected\n");
            System.out.println("Thread Handler I/O error: " + e.getMessage());
        }

    }
    private String processRequest(String command, String word, String definition){
        JsonObject response = new JsonObject();
        switch(command){
            case "search":
                String result = this.dictionary.search(word);
                if (result != null){
                    response.addProperty("status", "success");
                    response.addProperty("definition", result);
                }
                else{
                    response.addProperty("status", "fail");
                    response.addProperty("message", "Word not found");
                }
                break;

            case "add":
                // check if the definition is passed. Null definition will consider as invalid request for add

                if(definition == null) {
                    response.addProperty("status", "fail");
                    response.addProperty("message", "Definition is missing");
                }
                else if(dictionary.add(word,definition)){
                    response.addProperty("status","success");
                }else{
                    response.addProperty("status","fail");
                    response.addProperty("message", "word already exist");
                }
                break;
            case "delete":
                if(dictionary.delete(word)){
                    response.addProperty("status","success");}
                else{
                    response.addProperty("status","fail");
                    response.addProperty("message", "word is not exist");
                }
                break;
            case "update":
                // check if the definition is passed. Null definition will consider as invalid request for update
                if(definition == null) {
                    response.addProperty("status", "fail");
                    response.addProperty("message", "Definition is missing");
                }
                else if(dictionary.update(word,definition)){
                    response.addProperty("status","success");}
                else{
                    response.addProperty("status","fail");
                    response.addProperty("message", "word is not exist");
                }
                break;
            default:
                response.addProperty("status", "fail");
                response.addProperty("message", "Invalid command");
        }
        return gson.toJson(response);
    }
}
