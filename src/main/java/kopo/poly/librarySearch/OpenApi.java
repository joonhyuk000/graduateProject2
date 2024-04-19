package kopo.poly.librarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class OpenApi {
    public static void main(String[] args) throws IOException {
        // OpenAPI 호출을 위한 URL 생성
        StringBuilder urlBuilder = new StringBuilder("http://api.kcisa.kr/openapi/API_CNV_065/request"); /*URL*/
        // 서비스키 및 요청 파라미터 설정
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=cee32eeb-b344-47a6-a343-8478a1af9880"); /*서비스키*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*세션당 요청레코드수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지수*/
        urlBuilder.append("&" + URLEncoder.encode("schNm","UTF-8") + "=" + URLEncoder.encode("은평초등학교", "UTF-8")); /*학교명(필수값, 2자이상)*/
        urlBuilder.append("&" + URLEncoder.encode("dist","UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*인접 거리*/

        // URL 객체 생성
        URL url = new URL(urlBuilder.toString());
        // HTTP 연결 객체 생성
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // HTTP 요청 메서드 설정
        conn.setRequestMethod("GET");
        // 요청 헤더 설정
        conn.setRequestProperty("Content-type", "application/json");
        // JSON 형식의 응답을 받고 싶을 때는 아래 주석을 해제하세요.
        // conn.setRequestProperty("Accept","application/json");

        // HTTP 응답 코드 출력
        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        // HTTP 응답 코드가 200 ~ 300 사이인 경우
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            // 정상 응답일 때는 InputStream을 사용하여 응답을 읽어옴
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            // 오류 응답일 때는 ErrorStream을 사용하여 응답을 읽어옴
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        // 응답 데이터를 저장할 StringBuilder 객체 생성
        StringBuilder sb = new StringBuilder();
        String line;
        // 한 줄씩 읽어와 StringBuilder에 추가
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        // 연결 종료
        conn.disconnect();
        // 응답 데이터 출력
        System.out.println(sb.toString());
    }
}
