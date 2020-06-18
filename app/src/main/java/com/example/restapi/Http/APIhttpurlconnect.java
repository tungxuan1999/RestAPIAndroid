package com.example.restapi.Http;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.FileUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIhttpurlconnect {
    public static void HttpAPI(Context context, final String urlstr, final String method, final String data)
    {
        final InterfaceAPI interfaceAPI = (InterfaceAPI) context;
        final StringBuffer response = new StringBuffer();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlstr);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestProperty("Content-Type", "application/json; utf-8");
                    con.setRequestProperty("Accept", "application/json");
                    switch (method)
                    {
                        case "GET":{
                            con.setRequestMethod("GET");
                        }break;
                        case "POST":{
                            con.setRequestMethod("POST");
                            con.setDoOutput(true);
                            byte[] input = data.getBytes("utf-8");
                            con.getOutputStream().write(input,0,input.length);
                        }break;
                        case "PUT":{
                            con.setRequestMethod("PUT");
                            con.setDoOutput(true);
                            byte[] input = data.getBytes("utf-8");
                            con.getOutputStream().write(input,0,input.length);
                        }break;
                        case "PATCH":{
                            con.setRequestMethod("PATCH");
                            con.setDoOutput(true);
                            byte[] input = data.getBytes("utf-8");
                            con.getOutputStream().write(input,0,input.length);
                        }break;
                        case "DELETE":{
                            con.setRequestMethod("DELETE");
                            con.setDoOutput(true);
                            byte[] input = data.getBytes("utf-8");
                            con.getOutputStream().write(input,0,input.length);
                        }break;
                    }
                    if(con.getResponseCode() == 200)
                    {
                        Log.d("asdasd","OK");
                        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        String in;
                        while ((in = inputStreamReader.readLine())!= null)
                            response.append(in);
                        interfaceAPI.ResponseURL(true,response);
//                        Log.d("asdasd",response.toString());
                    }
                    else {
                        Log.d("asdasd","False");
                        interfaceAPI.ResponseURL(false,response);
                    }
                    con.disconnect();
                } catch (Exception e) {
                    Log.d("asdasd", e.toString());
//                    interfaceAPI.ResponseURL(false,response);
                }
            }
        });
    }
//    public static void httpAPIUploadImage(Context context,String urlstr,String path)
//    {
//        File file = new File(path);
//
//        int bytesAva;
//        int buffSize;
//        byte[] buffer;
//        String lineEnd = "\r\n";
//        String twoHyphens = "--";
//        String boundary = "*****";
//
//        final InterfaceAPI interfaceAPI = (InterfaceAPI) context;
//        final StringBuffer response = new StringBuffer();
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            URL url = new URL(urlstr);
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//            con.setRequestProperty("Content-Type", "application/json; utf-8");
////            con.setRequestProperty("Accept", "application/json");
//
//            con.setDoInput(true);
//            con.setUseCaches(false);
//            con.setRequestMethod("POST");
//            con.setDoOutput(true);
//            con.setRequestProperty("Connection", "Keep-Alive");
//            con.setRequestProperty("ENCTYPE", "multipart/form-data");
//            con.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
//            con.setRequestProperty("uploaded_file", "asd.jpg");
//            con.connect();
//
//            DataOutputStream request = new DataOutputStream(con.getOutputStream());
//
//            request.writeBytes(twoHyphens + boundary + lineEnd);
//            request.writeBytes("Content-Disposition: form-data; name='asd.jpg';filename='"
//                    + "asd.jpg" + "'" + lineEnd);
//            request.writeBytes(lineEnd);
//
//            bytesAva = fileInputStream.available();
//            buffSize = Math.min(bytesAva,1024*1024);
//            buffer = new byte[buffSize];
//
//            int bytesRead = fileInputStream.read(buffer,0,buffSize);
//            while (bytesRead>0)
//            {
//                request.write(buffer,0,buffSize);
//                bytesAva = fileInputStream.available();
//                buffSize = Math.min(bytesAva,1024*1024);
//                bytesRead = fileInputStream.read(buffer,0,buffSize);
//            }
//            request.writeBytes(lineEnd);
//            request.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
//
////            request.flush();
//
//            if(con.getResponseCode() == 200)
//            {
//                Log.d("asdasd","OK");
//                BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//                String in;
//                while ((in = inputStreamReader.readLine())!= null)
//                    response.append(in);
//                interfaceAPI.ResponseURL(true,response);
////                        Log.d("asdasd",response.toString());
//            }
//            else {
//                Log.d("asdasd","False");
//                interfaceAPI.ResponseURL(false,response);
//            }
//            con.disconnect();
//            fileInputStream.close();
//            request.flush();
//            request.close();
//        } catch (Exception e) {
//            Log.e("asdasd", e.toString());
//        }
//    }
}
