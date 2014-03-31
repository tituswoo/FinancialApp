package com.example.financialapp.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

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
public class FileReadWriteTest {
	
	Context fileContext;
	
	private String filename = "test.txt";
	private String outputString = "You have a very evil smile, my friend.";
	
	public FileReadWriteTest(Context context) {
		fileContext = context;
	}
	
	public void save() {
		try {
			FileOutputStream os = fileContext.openFileOutput(filename, Context.MODE_PRIVATE);
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
	
	public void load() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fileContext.getFilesDir(), filename)));
			StringBuilder text = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				text.append(line);
			}
			Log.e("info", "The file was opened sucessfully!");
			Log.e("info", "Here's what it says: " + text);
		} catch (Exception e) {
			Log.e("info", "Some sort of IO error encountered when opening the file.");
		}
	}
}
