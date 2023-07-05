package org.server;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
/**
 * @author Yuting Yu 1291624
 */
public class Dictionary {
    private ConcurrentHashMap<String, String> dictionary;
    private String dictionaryPath;
    private Gson gson;

    public Dictionary(String dictionaryPath) {
        this.dictionaryPath = dictionaryPath;
        this.dictionary = new ConcurrentHashMap<>();
        this.gson = new Gson();
        try {
            // Load dictionary from file
            this.loadDictionary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDictionary() throws IOException{
        File file = new File(System.getProperty("user.dir"),this.dictionaryPath);
        if (!file.exists()) {
            // Create a new dictionary file if not exist
            file.createNewFile();
            System.out.println("No existing dictionary, Creating a new one");
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // get the type of the dictionary, used for gson serialization
            Type type = new TypeToken<ConcurrentHashMap<String,String>>(){}.getType();
            ConcurrentHashMap<String, String> loaded = gson.fromJson(br, type);
            if(loaded != null) {
                this.dictionary.putAll(loaded);
            }
        }
    }

    private void save(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.dictionaryPath))){
            gson.toJson(this.dictionary, bw);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error when saving dictionary");
        }
    }

    public synchronized String search(String word){
        // return the definition of the word, if no matched, null will be returned to ensure server can handle it correctly
        return this.dictionary.getOrDefault(word,null);
    }
    public synchronized boolean delete(String word){
        if(!this.dictionary.containsKey(word)) {
            return false;
        }
        else {
            this.dictionary.remove(word);
            this.save();
            return true;
        }
    }
    public synchronized boolean update(String word, String definition){
        if(!this.dictionary.containsKey(word)) {
            return false;
        }
        else{
            this.dictionary.put(word, definition);
            this.save();
            return true;
        }

    }

    public synchronized boolean add(String word, String definition){
        if(this.dictionary.containsKey(word)) {
            return false;
        }
        else {
            this.dictionary.put(word, definition);
            this.save();
            return true;
        }
    }
}
