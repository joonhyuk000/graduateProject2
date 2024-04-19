package kopo.poly.service;


import kopo.poly.dto.BookDTO;

public interface IBookService {

    String apiURL = "http://api.kcisa.kr/openapi/API_CNV_065/request";

    // 날씨 API를 호출하여 날씨 결과 받아오기
    BookDTO getBook(BookDTO pDTO) throws Exception;
}

