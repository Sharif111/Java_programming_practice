package apicalling;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class CallApi {

    public ResponseModel getNPSBeRemitAPI() {

        ResponseModel outModel = new ResponseModel();

        String apiData = "";
        String token = "";
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

                if (obj.has("apiData") && !obj.isNull("apiData")) {
                    org.json.JSONObject apiDataObj = obj.getJSONObject("apiData");
                    System.out.println("apiData = " + apiDataObj);
                    if (apiDataObj.has("token") && !apiDataObj.isNull("token")) {
                        token = apiDataObj.getString("token");
                    }
                }

                outModel.setToken(token);
                outModel.setStatus(status);
                System.out.println("token = " + token);

            } else {
            }

        } catch (JSONException ex) {
            Logger.getLogger(CallApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CallApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CallApi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return outModel;
    }

    public void responseNPSBeRemitAPI(String token) {

        String responseString = "";
        ArrayList aTmpList = new ArrayList();
        String fromDate = "01012023";
        String toDate = "05012023";

        try {

            String url = "http://192.168.155.16:83/api/NPSB/getNPSBHoldData/" + fromDate + "/"
                    + toDate;
            System.out.println("url = " + url);

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httppost = new HttpGet(url);

            httppost.addHeader("Authorization", "Bearer " + token);

            CloseableHttpResponse httpResponse = httpClient.execute(httppost);

            int status = httpResponse.getStatusLine().getStatusCode();

            System.out.println("httpResponse => " + status);

            if (status == 200) {

                responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println("response = " + responseString);

                JSONObject obj = new JSONObject(responseString);
                System.out.println("obj => " + obj);

                String apiData = "";
                String transactionID = "";
                String debitAcNo = "";
                String creditAcNo = "";
                String transactionAmount = "";
                String bankName = "";
                String transactionDate = "";
                String serialNo = "";
                String message = "";

                org.json.JSONArray apiDataObj = null;

                if (obj.has("apiData") && !obj.isNull("apiData")) {
                    apiDataObj = obj.getJSONArray("apiData");
                    System.out.println("apiDataObj = " + apiDataObj);

                    for (int i = 0; i < apiDataObj.length(); i++) {
                        JSONObject jsonObject = apiDataObj.getJSONObject(i);
                        System.out.println("jsonObject = " + jsonObject);

                        if (jsonObject.has("transactionID") && !jsonObject.isNull("transactionID")) {
                            transactionID = jsonObject.getString("transactionID");
                        }

                        if (jsonObject.has("drAccountNo") && !jsonObject.isNull("drAccountNo")) {
                            debitAcNo = jsonObject.getString("drAccountNo");

                        }

                        if (jsonObject.has("crAccountNo") && !jsonObject.isNull("crAccountNo")) {
                            creditAcNo = jsonObject.getString("crAccountNo");

                        }

                        if (jsonObject.has("amount") && !jsonObject.isNull("amount")) {
                            transactionAmount = jsonObject.getString("amount");

                        }

                        if (jsonObject.has("bankShortName") && !jsonObject.isNull("bankShortName")) {
                            bankName = jsonObject.getString("bankShortName");
                        }
                        if (jsonObject.has("date") && !jsonObject.isNull("date")) {
                            transactionDate = jsonObject.getString("date");
                        }

                        System.out.println("transactionID = " + transactionID);
                        System.out.println("TransactionAmount => " + transactionAmount);
                        System.out.println("");

                    }

                }

                if (apiDataObj == null) {
                    boolean isExecute = false;

                    if (obj.has("isExecute") && !obj.isNull("isExecute")) {
                        isExecute = obj.getBoolean("isExecute");
                    }

                    if (obj.has("message") && !obj.isNull("message")) {
                        message = obj.getString("message");
                    }

                    System.out.println("apiDataObj Dao => " + isExecute);
                    System.out.println("apiDataObj Dao=> " + message);

                }

            } else {
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws IOException {

        CallApi a = new CallApi();
        ResponseModel outModel = a.getNPSBeRemitAPI();
        if (outModel.getStatus() == 200) {
            a.responseNPSBeRemitAPI(outModel.getToken());
            System.out.println("outModeltoken = " + outModel.getToken());

        }
         
    }

}
