package com.example.sharedpreferences;

import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MyData {
    boolean isValid(String id, String pass) {
        final String SERVER_URL = "http://192.168.43.33:8080/sharedpreferences/login.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            Log.d("Hello1",""+SERVER_URL);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("userid", CHAR_SET) + "=" + URLEncoder.encode(id, CHAR_SET);
            data += "&" + URLEncoder.encode("password", CHAR_SET) + "=" + URLEncoder.encode(pass, CHAR_SET);
            Log.d("Hello","Hello"+data);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true);
            Log.d("Mohit",""+connection);
            connection.setRequestProperty("Accept-Charset", CHAR_SET);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            Log.d("Url data",""+connection);
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) {
                response += line;
            }
            output.close();

        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
        if (response.trim().equals("Valid")) {
            return true;
        }
        else
            return false;
    }

    String save(String id,String pass,String email,String pno)
    {
        final String SERVER_URL = "http://192.168.43.33:8080/sharedpreferences/signup.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("userid", CHAR_SET) + "=" + URLEncoder.encode(id, CHAR_SET);
            data += "&" + URLEncoder.encode("password", CHAR_SET) + "=" + URLEncoder.encode(pass, CHAR_SET);
            data += "&" + URLEncoder.encode("email", CHAR_SET) + "=" + URLEncoder.encode(email, CHAR_SET);
            data += "&" + URLEncoder.encode("pno", CHAR_SET) + "=" + URLEncoder.encode(pno, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept-Charset", CHAR_SET);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET));
            String line = "";
            while ((line = rd.readLine()) != null)
            {
                response += line;
            }
            output.close();
        }
        catch (Exception e) {
        }
        return response;
    }
}
