package kopo.poly.libraryBookSearch;/* Java Sample */
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class OpenApi {
    public static void main(String[] args) throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://api.kcisa.kr/openapi/service/rest/convergence2017/conver7"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=39394e18-90c8-41b6-a5e5-9d28f38e0a01"); /*서비스키*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*세션당 요청레코드수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지수*/
        urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode("빅데이터", "UTF-8")); /*검색어*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
//json type으로 응답받고 싶을 때는 아래 주석을 제거하시고 사용바랍니다.
        conn.setRequestProperty("Accept","application/json");
        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {

            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        } else {

            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {

            sb.append(line);

        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

    }

}