package apicalling;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;


public class ResponseApi {
    
     public static void main(String[] args) throws IOException, Exception {
         
                String responseString = "";
                String token = "";
                
               
        try {
            JSONObject json = new JSONObject();            
            json.put("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiJucHNidXNlciIsIklzQmxvY2tlZCI6IkZhbHNlIiwibmJmIjoxNjcyMzAyMDE3LCJleHAiOjE2NzIzMDU2MTcsImlhdCI6MTY3MjMwMjAxNywiaXNzIjoiaHR0cDovL2VyYWluZm90ZWNoYmQuY29tIiwiYXVkIjoiaHR0cDovL2V4Y2hhbmdlaG91c2UuY29tIn0.Moa1SjvyJQgQzo_U1bYkv0r90A0oJ2-weA-osgXznzw");                
            json.put("fromDate", "20221228");
            json.put("toDate", "20221228");  
            String jsonString = json.toString();
            System.out.println("jsonString = " + jsonString);
            

            String url = "http://192.168.155.16:83/api/NPSB/getNPSBHoldData/20221228/20221228";
            System.out.println("url = " + url);         

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            JSONObject jsonObject = new JSONObject(jsonString);
            
            StringEntity enttity = new StringEntity(String.valueOf(jsonObject));
    	    httpget.addHeader("Authorization", "token");
            
            
            CloseableHttpResponse httpResponse = httpClient.execute(httpget);

            int status = httpResponse.getStatusLine().getStatusCode();
            System.out.println("status => " + status);

            if (status == 200) {
                System.out.println("status = " + status);
                responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println("response = " + responseString);

                JSONObject obj = new JSONObject(responseString);
                                            
            }
            

        } catch (JSONException ex) {
            Logger.getLogger(CallApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CallApi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
