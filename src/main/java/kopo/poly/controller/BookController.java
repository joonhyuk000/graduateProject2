package kopo.poly.controller;


import jakarta.servlet.http.HttpServletRequest;
import kopo.poly.dto.BookDTO;
import kopo.poly.service.IBookService;
import kopo.poly.util.CmmUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(value = "/book")
@RequiredArgsConstructor
@RestController
public class BookController {

    private final IBookService bookService;

    @GetMapping(value = "getBook")
    public BookDTO getBook(HttpServletRequest request) throws Exception {

        // 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
        log.info(this.getClass().getName() + ".getBook Start!");

        String schNm = CmmUtil.nvl(request.getParameter("schNm")); // 자바스크립트로부터 받은 위, 경도 값
        String schTp = CmmUtil.nvl(request.getParameter("schTp")); // 자바스크립트로부터 받은 위, 경도 값
        String instDt = CmmUtil.nvl(request.getParameter("instDt")); // 자바스크립트로부터 받은 위, 경도 값
        String schRoadAddr = CmmUtil.nvl(request.getParameter("schRoadAddr")); // 자바스크립트로부터 받은 위, 경도 값


        BookDTO pDTO = new BookDTO();
        pDTO.setSchNm(schNm);
        pDTO.setSchTp(schTp);
        pDTO.setSchTp(instDt);
        pDTO.setSchTp(schRoadAddr);


        // 내가 필요한 정보만 추출한 날씨 정보 가져오기
        BookDTO rDTO = bookService.getBook(pDTO);

        if (rDTO == null) {
            rDTO = new BookDTO();

        }

        // 로그 찍기(추후 찍은 로그를 통해 이 함수 호출이 끝났는지 파악하기 용이하다.)
        log.info(this.getClass().getName() + ".getBook End!");

        return rDTO;
    }
}
