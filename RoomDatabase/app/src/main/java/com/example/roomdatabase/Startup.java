package com.example.roomdatabase;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

public class Startup {
    private static InetAddress address; //Will match port for UDP_Client
    private static int port;

    UDP_Server udp = new UDP_Server();
    UDP_Client udpClient = new UDP_Client();

    public static InetAddress getAddress() {
        return address;
    }

    public static int getPort(){
        return port;
    }

    public void host() throws UnknownHostException {
        //generate address
        InetAddress IPAddress=InetAddress.getByName("localhost");
        address = IPAddress;
        //Generate port
        port = 9876;
        this.port = port;

        //start up server
        udp.execute();
        //return address
    }

    public void joinMeeting(String input, int port) throws UnknownHostException {
        InetAddress address = InetAddress.getByName(input);
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
