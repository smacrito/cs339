package com.example.roomdatabase;

import java.io.*;
import java.net.*;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;

public class UDP_Client {
    public static void client_helloworld() throws Exception
    {
        //BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket=new DatagramSocket();
        InetAddress IPAddress=InetAddress.getByName("localhost");
        byte[]sendData=new byte[1024];
        byte[]receiveData=new byte[1024];
        String sentence= "Hello world";
        sendData=sentence.getBytes();
        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9876);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence=new String(receivePacket.getData());
        //System.out.println("FROM SERVER:"+modifiedSentence);
        clientSocket.close();
    }
}


