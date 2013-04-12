package com.segoviagroup.realstate;

public class HTTPResult
{
	public String url = "";
	public String output = "";
	public String error = "";
	public String method = "";
	
	public HTTPResult( String pUrl, String pMethod)
	{
		url = pUrl;
		method = pMethod;
	}
}