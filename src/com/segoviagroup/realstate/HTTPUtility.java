package com.segoviagroup.realstate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class HTTPUtility {
	
	public static HTTPResult MakeRequest( String url, String method, BasicNameValuePair pValue)
	{
		return MakeRequest( url, method, Arrays.asList( (NameValuePair)pValue ) );
	}
	
	public static HTTPResult MakeRequest(String url, String method) {
		return MakeRequest( url, method, new ArrayList<NameValuePair>());
	}
	
	public static HTTPResult MakeRequest(String url, String method,
			List<NameValuePair> params) {
		
		HTTPResult res = new HTTPResult( url, method);
		
		// Making HTTP request
		try {

			InputStream is = null;

			// check for request method
			if (method == "POST") {
				// request method is POST
				// defaultHttpClient
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(url);
				httpPost.setEntity(new UrlEncodedFormEntity(params));

				HttpResponse httpResponse = httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();
				//String reason = httpResponse.getStatusLine().getReasonPhrase();
				is = httpEntity.getContent();

			} else if (method == "GET") {
				// request method is GET
				DefaultHttpClient httpClient = new DefaultHttpClient();
				String paramString = URLEncodedUtils.format(params, "utf-8");
				url += "?" + paramString;
				HttpGet httpGet = new HttpGet(url);

				HttpResponse httpResponse = httpClient.execute(httpGet);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			res.output = sb.toString();
			
			//some hacks
			int start = sb.indexOf("<JSON>");
			if( start >= 0)
			{
				res.output = sb.substring(start+6, sb.indexOf("</JSON>"));
			}

		} catch (UnsupportedEncodingException e) {
			res.error = e.getMessage();
		} catch (ClientProtocolException e) {
			res.error = e.getMessage();
		} catch (IOException e) {
			res.error = e.getMessage();
		}
		
		return res;
	}

}
