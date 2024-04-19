package kopo.poly.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BookDTO {

    private String schNm;
    private String schTp;
    private String instDt;
    private String schRoadAddr;
    private Long schLatPos;
    private Long schLotPos;
    private String fcltyNm;
    private String lclasNm;
    private String fcltyRoadNmAddr;
    private String description;
    private String subDescription;
    private String homepageUrl;
    private String tellNo;
    private String openInstNm;
    private String pvsnlnstNm;
    private String dataStdDate;
    private String fcltyLatPos;
    private String fcltyLotPos;
    private String dist;

}

