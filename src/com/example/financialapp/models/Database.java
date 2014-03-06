package com.example.financialapp.models;

import java.io.IOException;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

public class Database {
	private String url;
	public Database() {
		url = "http://www.lipsum.com";
	}
	public static boolean isConnected() {
		return true;
	}
	
	/*private class FetchTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String url) {
              
            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            textView.setText(result);
       }
    }*/
}
