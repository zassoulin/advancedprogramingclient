package com.advanceprograming.client.server;

public interface CacheReplacementPolicy{
	void add(String word);
	String remove(); 
}
