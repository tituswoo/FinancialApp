package com.example.financialapp.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

import com.example.financialapp.models.User;
import com.example.financialapp.models.UserModel;
import com.google.gson.Gson;

import android.content.Context;
import android.util.Log;

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
	private static String FILENAME = "user.json";
	private static String outputString = "default text.";
	private static Database instance = null;
	private static UserModel userModel = new UserModel();
	
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
	
	public static UserModel getUserModel() {
		return userModel;
	}
	
	public static void save() {
		try {
			Gson gson = new Gson();
			outputString = gson.toJson(userModel);
			FileOutputStream os = fileContext.openFileOutput(FILENAME, Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.write(outputString.getBytes());
			oos.close();
			Log.e("info", "The file was saved sucessfully.");
			load();
		} catch (Exception e) {
			Log.e("info", "Some sort of IO error encountered when saving the file.");
			e.printStackTrace();
		}
	}
	
	public static void load() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fileContext.getFilesDir(), FILENAME)));
			StringBuilder text = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				text.append(line);
			}
			Log.e("info", "The file was opened sucessfully!");
			Log.e("info", "Here's what it says: " + text);
			Gson gson = new Gson();
			userModel = gson.fromJson(line, UserModel.class);
		} catch (Exception e) {
			Log.e("info", "Some sort of IO error encountered when opening the file. Let's try making one.");
			save();
			load();
		}
	}
}
