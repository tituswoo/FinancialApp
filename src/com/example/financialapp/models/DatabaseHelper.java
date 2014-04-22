package com.example.financialapp.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	static final String dbName = "userDb";
	static final String userTable = "Users";
	static final String accountsTable = "Accounts";
	static final String accountRelationsTable = "AccountRelations";
	static final String transactionsTable = "Transactions";

	public DatabaseHelper(Context context) {
		super(context, dbName, null, 33);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Attempt to create the database:
		try {
			// Create the user table:
			db.execSQL("CREATE TABLE " + userTable + "("
					+ "UserID int AUTO_INCREMENT,"
					+ "UserType varchar(225) NOT NULL,"
					+ "UserName varchar(225) NOT NULL,"
					+ "Password varchar(255) NOT NULL,"
					+ "FirstName varchar(255) NOT NULL,"
					+ "LastName varchar(255) NOT NULL,"
					+ "Email varchar(255) NOT NULL,"
					+ "UNIQUE (UserName, Email)," + "PRIMARY KEY (UserID)"
					+ ");");

			// Create the accounts table:
			db.execSQL("CREATE TABLE " + accountsTable + "(" + "OwnerID int,"
					+ "AccountNumber varchar(255) NOT NULL,"
					+ "AccountType varchar(255) NOT NULL,"
					+ "AccountName varchar(255) NOT NULL,"
					+ "PRIMARY KEY (AccountNumber),"
					+ "FOREIGN KEY (OwnerID) REFERENCES Users(UserID)" + ");");

			// Create the account relations table:
			db.execSQL("CREATE TABLE "
					+ accountRelationsTable
					+ "("
					+ "AccountNumber varchar(255) NOT NULL,"
					+ "OwnerID int NOT NULL,"
					+ "AllowedID int NOT NULL,"
					+ "CreatedOn DATETIME DEFAULT NOW(),"
					+ "PRIMARY KEY (AccountNumber, AllowedID),"
					+ "FOREIGN KEY (AccountNumber) REFERENCES Accounts(AccountNumber),"
					+ "FOREIGN KEY (AllowedID) REFERENCES Users(UserID),"
					+ "FOREIGN KEY (OwnerID) REFERENCES Users(UserID)" + ");");

			// Create the transactions table:
			db.execSQL("CREATE TABLE "
					+ transactionsTable
					+ "("
					+ "UserName varchar(255) NOT NULL,"
					+ "AccountNumber varchar(255) NOT NULL,"
					+ "TransactionID int AUTO_INCREMENT,"
					+ "Amount int NOT NULL,"
					+ "TransactionFrom varchar(255) NOT NULL,"
					+ "TransactionsTo varchar(255) NOT NULL,"
					+ "Comment varchar(255) NOT NULL,"
					+ "Time DATETIME DEFAULT NOW(),"
					+ "PRIMARY KEY (TransactionID, AccountNumber),"
					+ "FOREIGN KEY (AccountNumber) REFERENCES Accounts(AccountNumber),"
					+ "FOREIGN KEY (UserName) REFERENCES Users(UserName)"
					+ ");");
		} catch (SQLiteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Obliterate everything if it exists:
		db.execSQL("DROP TABLE IF EXISTS " + userTable);
		db.execSQL("DROP TABLE IF EXISTS " + accountsTable);
		db.execSQL("DROP TABLE IF EXISTS " + accountRelationsTable);
		db.execSQL("DROP TABLE IF EXISTS " + transactionsTable);

		// Only called when the table is made for the first time:
		onCreate(db);
	}
}
