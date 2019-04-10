package com.nqr.smsapp;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String,Void,Void> {

    Socket canalEnvio;
    DataOutputStream valor;
    PrintWriter pw;


    @Override
    protected Void doInBackground(String... voids) {
        String message=voids[0];


        try {
            canalEnvio=new Socket("192.168.0.102",8079);
            pw=new PrintWriter(canalEnvio.getOutputStream());
            pw.flush();
            pw.write(message);
            pw.close();
            canalEnvio.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    return null;}
}

