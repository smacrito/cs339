package com.example.roomdatabase;

import android.os.AsyncTask;
import android.os.StrictMode;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.*;
import java.io.*;



class UDP_Server implements Runnable{

    private int var;
    boolean run = true;

    public UDP_Server (int var){
        this.var=var;
    }

    public void runServer() throws IOException {
        run = true;
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];


        while(run)
        {
            System.out.println("RUNNING!! AHH");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String( receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
    public void stopServer(){
        run = false;
    }

    @Override
    public void run(){
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            runServer();
        }
        catch(Exception E){
            System.out.println(E);
        }
    }
}
