package kopo.poly.controller;

import kopo.poly.service.IUserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping(value = "/project")
@RequiredArgsConstructor
@Controller
public class ProjectController {

    private final IUserInfoService userInfoService;

    @GetMapping(value = "userRegForm")
    public String example() {

        log.info(this.getClass().getName() + ".project/userRegForm Start!");

        log.info(this.getClass().getName() + ".project/userRegForm End!");

        return "project/userRegForm";
    }

    @GetMapping(value = "login")
    public String login() {
        log.info(this.getClass().getName() + ".project/login Start!");

        log.info(this.getClass().getName() + ".project/login End!");

        return "project/login";
    }

    @GetMapping(value = "idSearch")
        public String idSearch() {
            log.info(this.getClass().getName() + ".project/idSearch Start!");

            log.info(this.getClass().getName() + ".project/idSearch End!");

            return "project/idSearch";
    }

    @GetMapping(value = "pwdSearch")
        public String pwdSearch() {
        log.info(this.getClass().getName() + ".project/pwdSearch Start!");

        log.info(this.getClass().getName() + ".project/pwdSearch End!");

        return "project/pwdSearch";
    }
    @GetMapping(value = "index")
        public String index() {
            log.info(this.getClass().getName() + ".project/index Start!");

            log.info(this.getClass().getName() + ".project/index End!");

            return "project/index";
    }

    @GetMapping(value = "userExit")
    public String userExit() {
        log.info(this.getClass().getName() + ".project/userExit Start!");

        log.info(this.getClass().getName() + ".project/userExit End!");

        return "project/userExit";
    }

    @GetMapping(value = "librarySearch")
    public String librarySearch() {
        log.info(this.getClass().getName() + ".project/librarySearch Start!");

        log.info(this.getClass().getName() + ".project/librarySearch End!");

        return "project/librarySearch";
    }

    @GetMapping(value = "libraryBookSearch")
    public String libraryBookSearch() {
        log.info(this.getClass().getName() + ".project/libraryBookSearch Start!");

        log.info(this.getClass().getName() + ".project/libraryBookSearch End!");

        return "project/libraryBookSearch";
    }

    @GetMapping(value = "librarySearchExcel")
    public String librarySearchExcel() {
        log.info(this.getClass().getName() + ".project/librarySearchExcel Start!");

        log.info(this.getClass().getName() + ".project/librarySearchExcel End!");

        return "project/libraryBookSearchExcel";

    }

    @GetMapping(value = "libraryBookSearchExcel")
    public String libraryBookSearchExcel() {
        log.info(this.getClass().getName() + ".project/libraryBookSearchExcel Start!");

        log.info(this.getClass().getName() + ".project/libraryBookSearchExcel End!");

        return "project/libraryBookSearchExcel";

    }

    @GetMapping(value = "searchIndex")
    public String searchIndex() {
        log.info(this.getClass().getName() + ".project/searchIndex Start!");

        log.info(this.getClass().getName() + ".project/searchIndex End!");

        return "project/searchIndex";
    }

}
