package com.example.roomdatabase;

public class Startup {
    int address; //Will match port for UDP_Client
    int port;

    public int getAddress() {
        return address;
    }

    public int getPort(){
        return port;
    }

    public void host(){
        //generate address
        //start up server
        //return address
    }

    public void joinMeeting(int address, int port){
        this.address=address;
        this.port = port;
        //Start running UDP_Client
    }

}
