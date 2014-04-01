package com.example.financialapp.database;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.HashMap;

import android.content.Context;
import android.util.Log;

import com.example.financialapp.models.User;
import com.example.financialapp.models.UserModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
/**
 * This is just a test to save files at the moment.
 * Finance reborn has some more advanced stuff, but I want
 * to go back to the basics and get this file writing working.
 * However, in reborn I implemented some cool things with a
 * Database singleton & facade which are pretty nice.
 * 
 * @author Titus Woo
 *
 */
public class Database {
    
	private static Context fileContext;	
	private static String FILENAME = "we.json";
	private static String outputString = "default text.";
	private static Database instance = null;
	private static User user;
	
	static {
	    user = new User();
	}
	
	/**
	 * Requires a context to save files in the appropriate location.
	 * @param context
	 */
	protected Database(Context context) {
		fileContext = context;
	}
	
	public static void setContext(Context context) {
		fileContext = context;
	}
	
	public static User getUser() {
	    if(user == null) {
	        return new User("Mr. Null", "Pointer" );
	    } else {
	        return user;
	    }
	}
	
	public static void debug() {
	    Gson gson = new Gson();
	    user = gson.fromJson(gson.toJson(user), User.class);
	    Log.i("xyz", "User gson works");
	    load();
	    save();
	    load();
	}
	
	public static void save() {
	    GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.enableComplexMapKeySerialization().setPrettyPrinting().create();
		HashMap<String, User> users = UserModel.getBackingMap();
		Type type = new TypeToken<HashMap<String, User>>(){}.getType();
		//serialize users
		String json = gson.toJson(users, type);
		//write file
		writeFile(json);
	}
	
	public static void load() {
	    String json = readFile();
        Gson gson = new Gson();
	    String actualJson = gson.toJson(UserModel.getBackingMap(), HashMap.class);
	    Log.d("xyz", "LOAD");
	    Log.i("xyz", actualJson);
	    Log.e("xyz", "" + actualJson.equals(json));
	    Log.d("xyz", "" + json);
	    Type collectionType = new TypeToken<HashMap<String, User>>(){}.getType();
	    Log.e("xyz", "Before gson deserialization");
	    HashMap<String, User> users = gson.fromJson(json, collectionType);
	    UserModel.setMap(users);
	}
	
	private static boolean writeFile(String output) {
	    FileOutputStream outputStream;

	    try {
	      outputStream = fileContext.openFileOutput(FILENAME, Context.MODE_PRIVATE);
	      outputStream.write(output.getBytes());
	      outputStream.close();
	      return true;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return false;
	}
	
	private static String readFile() {
	    try {
            FileInputStream fis = fileContext.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        
            String json = sb.toString();
            Log.e("xyz", json);
            return json;
	    } catch (IOException e) {
	        return null;
	    }
	}
	
	//code copy and pasted from StackOverFlow
	
	private static void writeToFile(String data) {
	    try {
	        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileContext.openFileOutput(FILENAME, Context.MODE_PRIVATE));
	        outputStreamWriter.write(data);
	        outputStreamWriter.close();
	    }
	    catch (IOException e) {
	        Log.e("xyz", "File write failed: " + e.toString());
	    } 
	}

    private static String readFromFile() {

	    String ret = "";

	    try {
	        InputStream inputStream = fileContext.openFileInput(FILENAME);

	        if ( inputStream != null ) {
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	            String receiveString = "";
	            StringBuilder stringBuilder = new StringBuilder();

	            while ( (receiveString = bufferedReader.readLine()) != null ) {
	                stringBuilder.append(receiveString);
	            }

	            inputStream.close();
	            ret = stringBuilder.toString();
	        }
	    }
	    catch (FileNotFoundException e) {
	        Log.e("xyz", "File not found: " + e.toString());
	    } catch (IOException e) {
	        Log.e("xyz", "Can not read file: " + e.toString());
	    }

	    return ret;
	}
	
	
}
