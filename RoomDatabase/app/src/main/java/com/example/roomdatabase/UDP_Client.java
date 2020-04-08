package com.example.roomdatabase;

import java.io.*;
import java.net.*;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;

public class UDP_Client {
    public static String client_helloworld() throws Exception {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket=new DatagramSocket();
        InetAddress IPAddress=InetAddress.getByName("localhost");

        byte[]sendData=new byte[1024];
        byte[]receiveData=new byte[1024];

        String sentence= "Hello worlds";

        sendData=sentence.getBytes();
        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9876);
        clientSocket.send(sendPacket);
        System.out.println("Sent");
        DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence=new String(receivePacket.getData());
        System.out.println("Printing Data:");
        System.out.println("FROM SERVER:"+modifiedSentence);
        clientSocket.close();
        return modifiedSentence;
    }
}


