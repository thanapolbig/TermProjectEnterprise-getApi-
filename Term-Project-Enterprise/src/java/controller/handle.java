/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ASUS
 */
public class handle {
    public static String ParseJsonResponse(String status){
        try {
            String api = "";
            int s = parseInt(status);
            switch(s) {
                case 1:
                    api = "https://opend.data.go.th/get-ckan/datastore_search?resource_id=19c19fdc-7e41-4ac6-9f06-168a0cfc0eed";
                    //จำนวนเลขหมายโทรศัพท์เคลื่อนที่ที่ได้รับการจดทะเบียน
                    break;
                case 2:
                    api = "https://opend.data.go.th/get-ckan/datastore_search?resource_id=4c9ac1b1-32c3-48c4-97d3-50cff43c8223";
                    //ปริมาณการใช้งานเฉลี่ยจากบริการโทรศัพท์เคลื่อนที่ (นาที/เลขหมาย/เดือน)
                    break;
            }
            URL url = new URL(api);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            //adding header
            httpURLConnection.setRequestProperty("api-key", "FzAPT9XWN5HFUOkAROOD82WA1U1Hj6gw");

            String line = "";
            InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null){
                response.append(line);
            }
            bufferedReader.close();
            JSONObject json = new JSONObject(response.toString());
            JSONArray data = new JSONArray(json.getJSONObject("result").getJSONArray("records")); 
            return data.toString(4);
            //return json.getJSONObject("result").getJSONArray("records").toString(4);
            //return json.getJSONObject("result").getJSONArray("records").optJSONObject(0).toString(4);
            //return json.getJSONObject("result").getJSONArray("records").optJSONObject(0).get("REGION_NAME").toString(); 
        }
        catch (Exception e){
            return "Error: " + e;
        }
    }
}
