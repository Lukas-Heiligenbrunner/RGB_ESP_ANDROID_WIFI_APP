package com.example.lukas.rgb_strip_app_navigation;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class changecolor extends AsyncTask<String, Void, Void> {
    public Void doInBackground(String... color) {

        final String USER_AGENT = "Mozilla/5.0";
        String url = "http://192.168.0.120/val?val="+color[0];

        URL obj;
        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
        } catch (ProtocolException e) {
            System.out.println(">>>>>>>>>>>>>>protocol error<<<<<<<<<<<<<<<");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println(">>>>>>>>>>>>>>url excepton<<<<<<<<<<<<<<<");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println(">>>>>>>>>>>>>>io error<<<<<<<<<<<<<<<");
            e.printStackTrace();
        } catch (Exception e)
        {
            System.out.println(">>>>>>>>>>>>>>other exception...<<<<<<<<<<<<<<<");
            e.printStackTrace();
        }
        return null;
    }

    protected void onProgressUpdate(Void... progress) {

    }

    protected void onPostExecute(Void result) {

    }
}



