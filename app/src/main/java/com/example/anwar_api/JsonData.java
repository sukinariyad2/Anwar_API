package com.example.anwar_api;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonData extends AsyncTask<Void,Void,Void> {
    private  static final String data_API="https://jsonplaceholder.typicode.com/todos/";
    private String bufferdata="";
    private String finaldata="";
    private String Data="";

    @Override
    protected Void doInBackground(Void... voids) {
        URL url=null;
        try {
            url=new URL(data_API);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while (line!=null){
                line= bufferedReader.readLine();
                bufferdata=bufferdata+line;
            }
            JSONObject jsonObject=new JSONObject(bufferdata);
            JSONArray jsonArray= jsonObject.getJSONArray("features");
            for(int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                JSONObject placeholder=  jsonObject1.getJSONObject("placeholder");
                finaldata="id:"+placeholder.get("id")+"\n"+"title:"+placeholder.get("title")+"\n"
                        +"completed:"+placeholder.get("completed");
                Data=Data+finaldata;


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        MainActivity.txt.setText(this.Data);
    }
}




