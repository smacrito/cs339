package com.example.roomdatabase;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

public class Startup {
    private static String address; //Will match port for UDP_Client
    private static int port;

    UDP_Server udp = new UDP_Server();
    UDP_Client udpClient = new UDP_Client();

    public static String getAddress() {
        return address;
    }

    public static int getPort(){
        return port;
    }

    public void host() throws UnknownHostException {
        //generate address
        //InetAddress IPAddress=InetAddress.getByName("localhost");
        String IPAddress = "localhost";
        address = IPAddress;
        //Generate port
        port = 9876;
        this.port = port;

        //start up server
        udp.execute();
        //return address
    }

    public void joinMeeting(String address, int port) throws UnknownHostException {
        this.address=address;
        this.port = port;
        //Start running UDP_Client
        //Schedule this

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                udpClient.execute(); //udp getter
            }
        }, 0, 15000);


        //udp sender to go at the end of each question submission
        /*
        try{
            System.out.println("send_data_button clicked");
            udpClient.clientSend();
        }
        catch(Exception E){
            System.out.println(E);
        }

         */
    }

}
