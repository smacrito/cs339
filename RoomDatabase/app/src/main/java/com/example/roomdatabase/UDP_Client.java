package com.example.roomdatabase;

import android.os.AsyncTask;
import android.os.StrictMode;

import com.google.gson.Gson;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;


public class UDP_Client extends AsyncTask<Void,Void,Void>{

    @Override
    protected Void doInBackground(Void... params){
        try {
            clientGet();
        }
        catch(Exception E){
            System.out.println(E);
        }
        return null;
    }


    public static String client_helloworld() throws Exception {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket=new DatagramSocket();
        InetAddress IPAddress=InetAddress.getByName("localhost");

        byte[]sendData=new byte[1024];
        byte[]receiveData=new byte[1024];

        //String sentence= "Hello worlds";
        List<Question> question = MainActivity.QuestionDB.dao().getQuestion();
        String questionToJSON = new Gson().toJson(question);


        sendData=questionToJSON.getBytes();

        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9876);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence=new String(receivePacket.getData());
        clientSocket.close();
        return modifiedSentence;
    }

    public static int clientSend() throws Exception{
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket=new DatagramSocket();
        InetAddress IPAddress=InetAddress.getByName("localhost");

        byte[]sendData=new byte[1024];

        //String sentence= "Hello worlds";
        List<Question> question = MainActivity.QuestionDB.dao().getQuestion();
        String questionToJSON = new Gson().toJson(question);


        sendData=questionToJSON.getBytes();

        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9876);
        clientSocket.send(sendPacket);
        return 0;
    }


    public static String clientGet() throws Exception {
        System.out.println("Pos1");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        System.out.println("Pos2");
        byte[] receiveData = new byte[1024];
        DatagramSocket clientSocket = new DatagramSocket();
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        System.out.println("Pos3");
        clientSocket.receive(receivePacket);
        System.out.println("Pos4");
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("Pos5");
        clientSocket.close();
        System.out.println("Pos6");
        return modifiedSentence;
    }
}


