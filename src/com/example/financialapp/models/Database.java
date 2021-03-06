package com.example.financialapp.models;

/**
 * @author Vishal
 * The class used to represent the Database.
 */
public final class Database {
    /**
     * The url of the online database.
     */
    private String url;
    /**
     * constructor for the Database.
     */
    private Database() {
        url = "http://www.lipsum.com";
    }
    /**
     * Returns true if connected.
     * @return true
     */
    public static boolean isConnected() {
        return true;
    }

    /*
     * private class FetchTask extends AsyncTask<String, Void, String> {
     * @Override protected String doInBackground(String url) {
     * // params comes from the execute() call: params[0] is the url. try {
     * return downloadUrl(urls[0]); } catch (IOException e) { return
     * "Unable to retrieve web page. URL may be invalid."; } } // onPostExecute
     * displays the results of the AsyncTask.
     * @Override protected void onPostExecute(String result) {
     * textView.setText(result); } }
     */
}
