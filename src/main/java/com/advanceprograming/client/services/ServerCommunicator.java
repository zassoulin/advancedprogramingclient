package com.advanceprograming.client.services;

public interface ServerCommunicator {

    void runClientQueryRequest(String query);
    void runClientChatRequest(String chat);
}
