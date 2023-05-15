package com.advanceprograming.client.services;

import com.advanceprograming.client.server.BookScrabbleHandler;
import com.advanceprograming.client.server.MyServer;
import com.advanceprograming.client.server.Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Observable;

public class LocalServerCommunicator extends Observable implements ServerCommunicator{
    String result;
    Socket serverSocket;
    Server Localserver;
    LocalServerCommunicator(String host,int port,boolean newLocalServer){
        if(newLocalServer){
            Localserver = new MyServer(port,new BookScrabbleHandler(),4);
        }
        try {
            serverSocket = new Socket(host,port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void runClientQueryRequest(String query) {

    }

    @Override
    public void runClientChatRequest(String chat) {

    }
}
