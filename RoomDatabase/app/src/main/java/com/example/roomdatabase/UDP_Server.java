package com.example.roomdatabase;

import android.os.AsyncTask;
import android.os.StrictMode;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.*;
import java.io.*;



class UDP_Server extends AsyncTask<Void, Void, Void> {

    boolean run = true;

    protected Void doInBackground(Void... params){
        try {
            runServer();
        }
        catch(Exception E){
            System.out.println(E);
        }
        return null;
    }


    public void runServer() throws IOException {
        run = true;
        DatagramSocket serverSocket = new DatagramSocket(Startup.getPort());
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


}
