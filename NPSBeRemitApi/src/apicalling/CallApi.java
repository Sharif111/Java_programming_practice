package apicalling;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;



public class CallApi {    
             String token = "";
       public void gethttp() {

        
        String responseString = "";

        try {
            JSONObject json = new JSONObject();
            json.put("username", "npsbuser");
            json.put("password", "Bankasia#2021");

            String jsonString = json.toString();
            System.out.println("jsonString = " + jsonString);
            

            String url = "http://192.168.155.16:83/api/customer/tokenForExHouse";
            System.out.println("url = " + url);

            
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(url);
            JSONObject jsonObject = new JSONObject(jsonString);

            
            StringEntity enttity = new StringEntity(String.valueOf(jsonObject));
    	    httppost.addHeader("content-type", "application/json");
    	    httppost.setEntity(enttity);

            

            CloseableHttpResponse httpResponse = httpClient.execute(httppost);

            int status = httpResponse.getStatusLine().getStatusCode();
            System.out.println("status => " + status);

            if (status == 200) {
                System.out.println("status = " + status);
                responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println("response = " + responseString);

                JSONObject obj = new JSONObject(responseString);
                System.out.println("obj = " + obj);

                String apiData = "";
                String token = "";
                
                if (obj.has("apiData") && !obj.isNull("apiData")) {
                org.json.JSONObject apiDataObj = obj.getJSONObject("apiData");
                System.out.println("apiData = " + apiDataObj);
                if (apiDataObj.has("token") && !apiDataObj.isNull("token")) {
                 token = apiDataObj.getString("token");                
                      }
                }
                System.out.println("token = " + token);
                                            
            }else{
            }

        } catch (JSONException ex) {
            Logger.getLogger(CallApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CallApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CallApi.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
       
      
       
       
        public static void main(String[] args) throws IOException {

        CallApi callApi = new CallApi();
        callApi.gethttp();
       
    }

    
}



