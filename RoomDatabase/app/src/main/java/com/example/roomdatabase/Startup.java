package com.example.roomdatabase;

public class Startup {
    int address; //Will match port for UDP_Client
    int port;

    UDP_Server udp = new UDP_Server();
    UDP_Client udpClient = new UDP_Client();

    public int getAddress() {
        return address;
    }

    public int getPort(){
        return port;
    }

    public void host(){
        //generate address
        //start up server
        udp.execute();
        //return address
    }

    public void joinMeeting(int address, int port){
        this.address=address;
        this.port = port;
        //Start running UDP_Client
        //Schedule this
        udpClient.execute(); //udp getter

        //udp sender to go at the end of each question submission
        try{
            System.out.println("send_data_button clicked");
            udpClient.clientSend();
        }
        catch(Exception E){
            System.out.println(E);
        }
    }

}
