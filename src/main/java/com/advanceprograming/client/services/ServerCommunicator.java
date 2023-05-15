package com.advanceprograming.client.services;

import java.util.List;

public interface ServerCommunicator {

    void runClientQueryRequest(String query);
    void runClientChatRequest(String chat);
    String getClientQueryRequest();
    List getChat();
}
