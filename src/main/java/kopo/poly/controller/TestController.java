package kopo.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String searchBooks(@RequestParam String schoolName, Model model) {
        // OpenAPI 호출을 위한 URL 및 파라미터 설정
        String apiUrl = "http://api.kcisa.kr/openapi/API_CNV_065/request";
        String serviceKey = "cee32eeb-b344-47a6-a343-8478a1af9880";
        String numOfRows = "20";
        String pageNo = "1";
        String dist = "20";

        // API 호출 및 결과를 받아오는 부분
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(apiUrl + "?serviceKey=" + serviceKey
                + "&numOfRows=" + numOfRows
                + "&pageNo=" + pageNo
                + "&schNm=" + schoolName
                + "&dist=" + dist, String.class);

        // 모델에 결과를 담아서 HTML로 전달
        model.addAttribute("result", result);

        // HTML 파일 이름 리턴
        return "test";
    }
}
