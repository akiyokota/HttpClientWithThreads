package HttpSender.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

public class httpWithThread implements Runnable{

	private String content = "";
	
	
	
	URL url;
    HttpURLConnection connection = null;
	
	
	
	
	public httpWithThread(String content) {
		this.content=content;
	}
	
	public void run() {
		try {
			 HttpClient httpClient = new DefaultHttpClient();
             HttpPost postRequest = new HttpPost(The url goes here!);
             StringEntity input = new StringEntity(content);
             input.setContentType("application/json;charset=UTF-8");
             postRequest.setEntity(input);
             input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
             postRequest.setHeader("Accept", "application/json");
             postRequest.setEntity(input); 

             HttpResponse response = httpClient.execute(postRequest);
             BufferedReader br = new BufferedReader(
                     new InputStreamReader((response.getEntity().getContent())));

		     String output;
		
		     while ((output = br.readLine()) != null) {
		         System.out.println(output);
		     }
		
		     httpClient.getConnectionManager().shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
