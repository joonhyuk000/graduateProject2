package kopo.poly.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kopo.poly.dto.BookDTO;
import kopo.poly.service.IBookService;
import kopo.poly.util.CmmUtil;
import kopo.poly.util.NetworkUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BookService implements IBookService {

    @Value("${librarySearch.api.key}")
    private String apiKey;

    @Override
    public BookDTO getBook(BookDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".getBook Start!");

        String schNm = CmmUtil.nvl(pDTO.getSchNm());
        String schTp = CmmUtil.nvl(pDTO.getSchTp());
        String instDt = CmmUtil.nvl(pDTO.getInstDt());
        String schRoadAddr = CmmUtil.nvl(pDTO.getSchRoadAddr());

        String apiParam = "?schNm=" + schNm + "&schTp=" + schTp + "&instDt=" + instDt + "&schRoadAddr=" + schRoadAddr + "&appid=" + apiKey + "&units=metric";
        log.info("apiParam " + apiParam);

        String json = NetworkUtil.get(IBookService.apiURL + apiParam);
        log.info("json " + json);

        // JSON 구조를 Map 데이터 구조로 변경하기
        // 키와 값 구조의 JSON구조로부터 데이터를 쉽게 가져오기 위해 Map 데이터구조로 변경함
        Map<String, Object> rMap = new ObjectMapper().readValue(json, LinkedHashMap.class);

        // 현재 날씨 정보를 가지고 있는 current 키의 값 가져오기
        Map<String, Double> current = (Map<String, Double>) rMap.get("current");

        // 일별 날씨 조회(OpenAPI가 현재 날짜 기준으로 최대 7일까지 제공)
        List<Map<String, Object>> dailyList = (List<Map<String, Object>>) rMap.get("daily");

        List<BookDTO> pList = new LinkedList<>();

        log.info(this.getClass().getName() + ".getWeather End!");

        return pDTO;
    }
}

