/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apicalling;

/**
 *
 * @author User
 */
public class ResponseModel {

    private String apiData = "";
    private String token = "";
    private int status = 0;

    public String getApiData() {
        return apiData;
    }

    public void setApiData(String apiData) {
        this.apiData = apiData;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    

}
