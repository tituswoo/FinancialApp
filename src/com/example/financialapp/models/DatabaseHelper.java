package com.example.financialapp.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
		// Create the user table:
		db.execSQL("CREATE TABLE " + userTable + "(" +
				"UserID int AUTO_INCREMENT," +
				"UserType varchar(225) NOT NULL," +
				"UserName varchar(225) NOT NULL," +
				"Password varchar(255) NOT NULL," +
				"FirstName varchar(255) NOT NULL," +
				"LastName varchar(255) NOT NULL," +
				"Email varchar(255) NOT NULL," +
				"UNIQUE (UserName, Email)," +
				"PRIMARY KEY (UserID)" +
				");");
		
		// Create the accounts table:
		db.execSQL("CREATE TABLE " + accountsTable + "(" +
				"OwnerID int," +
				"AccountNumber varchar(255) NOT NULL," +
				"AccountType varchar(255) NOT NULL," +
				"AccountName varchar(255) NOT NULL," +
				"PRIMARY KEY (AccountNumber)," +
				"FOREIGN KEY (OwnerID) REFERENCES Users(UserID)" +
				");");
		
		// Create the account relations table:
		db.execSQL("CREATE TABLE " + accountRelationsTable + "(" +
				"AccountNumber varchar(255) NOT NULL," +
				"OwnerID int NOT NULL," +
				"AllowedID int NOT NULL," +
				"CreatedOn DATETIME DEFAULT NOW()," +
				"PRIMARY KEY (AccountNumber, AllowedID)," +
				"FOREIGN KEY (AccountNumber) REFERENCES Accounts(AccountNumber)," +
				"FOREIGN KEY (AllowedID) REFERENCES Users(UserID)," +
				"FOREIGN KEY (OwnerID) REFERENCES Users(UserID)" +
				");");
		
		// Create the transactions table:
		db.execSQL("CREATE TABLE " + transactionsTable + "(" +
				"UserName varchar(255) NOT NULL," +
				"AccountNumber varchar(255) NOT NULL," +
				"TransactionID int AUTO_INCREMENT," +
				"Amount int NOT NULL," +
				"TransactionFrom varchar(255) NOT NULL," +
				"TransactionsTo varchar(255) NOT NULL," +
				"Comment varchar(255) NOT NULL," +
				"Time DATETIME DEFAULT NOW()," +
				"PRIMARY KEY (TransactionID, AccountNumber)," +
				"FOREIGN KEY (AccountNumber) REFERENCES Accounts(AccountNumber)," +
				"FOREIGN KEY (UserName) REFERENCES Users(UserName)" +
				");");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
