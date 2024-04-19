/* Javascript Sample*/
var xhr = new XMLHttpRequest(); // XMLHttpRequest 객체 생성
var url = 'http://api.kcisa.kr/openapi/API_CNV_065/request'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '=cee32eeb-b344-47a6-a343-8478a1af9880' + '서비스키'; /*서비스키*/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('세션당 요청레코드수'); /*세션당 요청레코드수*/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('페이지수'); /*페이지수*/
queryParams += '&' + encodeURIComponent('schNm') + '=' + encodeURIComponent('학교명(필수값, 2자이상)'); /*학교명(필수값, 2자이상)*/
queryParams += '&' + encodeURIComponent('dist') + '=' + encodeURIComponent('인접 거리'); /*인접 거리*/

xhr.open('GET', url + queryParams); // GET 요청 준비
xhr.onreadystatechange = function () {
    if (this.readyState == 4) {

        console.log('status: ' + this.status); // 상태 코드 출력
        console.log('resultCode: ' + $(this.responseText).find('resultCode').text()); // 결과 코드 출력
        console.log('resultMsg: ' + $(this.responseText).find('resultMsg').text()); // 결과 메시지 출력

        var item = $(this.responseText).find('item'); // 항목 찾기
        $(item).each(function(){

            console.log("schNm" + $(this).find("schNm").text()); // 학교명 출력
            console.log("schTp" + $(this).find("schTp").text()); // 학교 유형 출력
            console.log("instDt" + $(this).find("instDt").text()); // 설립일 출력
            console.log("schRoadAddr" + $(this).find("schRoadAddr").text()); // 학교 도로 주소 출력
            console.log("schLatPos" + $(this).find("schLatPos").text()); // 학교 위도 출력
            console.log("schLotPos" + $(this).find("schLotPos").text()); // 학교 경도 출력
            console.log("fcltyNm" + $(this).find("fcltyNm").text()); // 시설명 출력
            console.log("lclasNm" + $(this).find("lclasNm").text()); // 대분류명 출력
            console.log("fcltyRoadNmAddr" + $(this).find("fcltyRoadNmAddr").text()); // 시설 도로명 주소 출력
            console.log("description" + $(this).find("description").text()); // 설명 출력
            console.log("subDescription" + $(this).find("subDescription").text()); // 서브 설명 출력
            console.log("homepageUrl" + $(this).find("homepageUrl").text()); // 홈페이지 URL 출력
            console.log("telNo" + $(this).find("telNo").text()); // 전화번호 출력
            console.log("openInstNm" + $(this).find("openInstNm").text()); // 개설 기관명 출력
            console.log("pvsnInstNm" + $(this).find("pvsnInstNm").text()); // 제공 기관명 출력
            console.log("dataStdDate" + $(this).find("dataStdDate").text()); // 데이터 표준일 출력
            console.log("fcltyLatPos" + $(this).find("fcltyLatPos").text()); // 시설 위도 출력
            console.log("fcltyLotPos" + $(this).find("fcltyLotPos").text()); // 시설 경도 출력
            console.log("dist" + $(this).find("dist").text()); // 거리 출력

        });

    };

}
xhr.send(''); // 요청 전송
