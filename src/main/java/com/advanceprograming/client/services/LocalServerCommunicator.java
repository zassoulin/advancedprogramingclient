package com.advanceprograming.client.services;

import com.advanceprograming.client.server.BookScrabbleHandler;
import com.advanceprograming.client.server.MyServer;
import com.advanceprograming.client.server.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

public class LocalServerCommunicator extends Observable implements ServerCommunicator{
    String QueryResult;
    Socket serverSocket;
    Server Localserver;
    List Chat;
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
        try {
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream());
            Scanner in=new Scanner(serverSocket.getInputStream());
            out.println(query);
            out.flush();
            String res=in.next();
            this.QueryResult = res;
            setChanged();
            notifyObservers();
            in.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void runClientChatRequest(String chat) {

    }

    @Override
    public String getClientQueryRequest() {
        return QueryResult;
    }

    @Override
    public List getChat() {
        return null;
    }
}
