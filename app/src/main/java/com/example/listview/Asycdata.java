package com.example.listview;

import android.os.AsyncTask;
import android.util.Log;

public class Asycdata extends AsyncTask<String,String,String> {


    @Override
    protected String doInBackground(String... strings) {


        String jsonurl = strings[0];

        Httphandler httphandler = new Httphandler();

        String json = httphandler.makeRequest(jsonurl);

        Log.i("AsycData JSON : ",json);

        return json;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
