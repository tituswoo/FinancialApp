package com.example.financialapp.database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;

import com.example.financialapp.models.User;
import com.google.gson.Gson;

/**
 * This database is a facade that actually deals with the database stuff. It
 * also uses the singleton design pattern.
 * 
 * @author Titus Woo
 * 
 */
public class Database {
	private static Database instance = null;
	private static User user;
	private static String FILENAME = "userData.json";

	// Requirement for singleton design pattern... need to control
	// how this is instantiated originally
	protected Database() {
		// Left blank to defeat initialization
	}

	/**
	 * Returns the singleton instance if it exists. If it does not exist, it
	 * returns a new (and first) instance of the database.
	 * 
	 * @return singleton instance of the database.
	 */
	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	/**
	 * Sets the user that this database is in charge of storing.
	 * 
	 * @param u
	 *            - the user
	 */
	public static void setUser(User u) {
		if (u == null) {
			throw new IllegalArgumentException();
		}

		user = u;
	}

	/**
	 * Saves the information for the current user in the appropriate
	 * database(s).
	 */
	public static void save() {
		if (hasInternetConnection()) {
			// Save the information to the database using Gene's API.
			saveRemotely();
		} else {
			// Save the stuff locally on to the machine for later use.
			try {
				saveLocally();
			} catch (IOException e) {
				// DO something if it fails.
			}
		}
	}

	/**
	 * Loads user data from the database.
	 */
	public static void load() {
		if (hasInternetConnection()) {
			// load stuff from the online database.
		} else {
			// load stuff from local database.
			Gson gson = new Gson();
			user = gson.fromJson(json, User.class);
		}
	}

	/**
	 * Determins if there's an internet connection or not.
	 * 
	 * @return true if there's a connection, false otherwise.
	 */
	public static boolean hasInternetConnection() {
		return false;
	}

	// Save the user information on the device (locally).
	private static void saveLocally() throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(user);

		File dataFile = new File(Environment.getDataDirectory() + FILENAME);

		if (dataFile.exists()) {
			dataFile.delete();
		}

		BufferedWriter out = new BufferedWriter(new FileWriter(dataFile));
		out.write(json);
		out.close();
	}

	// Save the user information on the server (remotely).
	private static void saveRemotely() {
		// Save the database stuff remotely.
	}
}
