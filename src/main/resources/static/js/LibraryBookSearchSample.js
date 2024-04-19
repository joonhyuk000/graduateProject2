/* Javascript Sample*/
var xhr = new XMLHttpRequest();
var url = 'http://api.kcisa.kr/openapi/service/rest/convergence2017/conver7'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + '서비스키'; /*서비스키*/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('세션당 요청레코드수'); /*세션당 요청레코드수*/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('페이지수'); /*페이지수*/
queryParams += '&' + encodeURIComponent('keyword') + '=' + encodeURIComponent('검색어'); /*검색어*/

xhr.open('GET', url + queryParams);
xhr.onreadystatechange = function () {
    if (this.readyState == 4) {

        console.log('status: ' + this.status);
        console.log('resultCode: ' + $(this.responseText).find('resultCode').text());
        console.log('resultMsg: ' + $(this.responseText).find('resultMsg').text());

        var item = $(this.responseText).find('item');
        $(item).each(function(){

            console.log("rn" + $(this).find("rn").text());
            console.log("title" + $(this).find("title").text());
            console.log("description" + $(this).find("description").text());
            console.log("abstractDesc" + $(this).find("abstractDesc").text());
            console.log("affiliation" + $(this).find("affiliation").text());
            console.log("alternativeTitle" + $(this).find("alternativeTitle").text());
            console.log("charge" + $(this).find("charge").text());
            console.log("collectionDb" + $(this).find("collectionDb").text());
            console.log("contributor" + $(this).find("contributor").text());
            console.log("coverage" + $(this).find("coverage").text());
            console.log("createdDate" + $(this).find("createdDate").text());
            console.log("creator" + $(this).find("creator").text());
            console.log("extent" + $(this).find("extent").text());
            console.log("format" + $(this).find("format").text());
            console.log("grade" + $(this).find("grade").text());
            console.log("venue" + $(this).find("venue").text());
            console.log("spatial" + $(this).find("spatial").text());
            console.log("temporal" + $(this).find("temporal").text());
            console.log("time" + $(this).find("time").text());
            console.log("identifier" + $(this).find("identifier").text());
            console.log("issuedDate" + $(this).find("issuedDate").text());
            console.log("medium" + $(this).find("medium").text());
            console.log("period" + $(this).find("period").text());
            console.log("person" + $(this).find("person").text());
            console.log("reference" + $(this).find("reference").text());
            console.log("referenceIdentifier" + $(this).find("referenceIdentifier").text());
            console.log("relation" + $(this).find("relation").text());
            console.log("rights" + $(this).find("rights").text());
            console.log("source" + $(this).find("source").text());
            console.log("subjectCategory" + $(this).find("subjectCategory").text());
            console.log("subjectKeyword" + $(this).find("subjectKeyword").text());
            console.log("subDescription" + $(this).find("subDescription").text());
            console.log("tableOfContents" + $(this).find("tableOfContents").text());
            console.log("uci" + $(this).find("uci").text());
            console.log("url" + $(this).find("url").text());
            console.log("copyrightothers" + $(this).find("copyrightothers").text());
            console.log("digitalizedDate" + $(this).find("digitalizedDate").text());
            console.log("insertDate" + $(this).find("insertDate").text());
            console.log("language" + $(this).find("language").text());
            console.log("publisher" + $(this).find("publisher").text());
            console.log("regDate" + $(this).find("regDate").text());
            console.log("type" + $(this).find("type").text());
            console.log("email" + $(this).find("email").text());
            console.log("zipCode" + $(this).find("zipCode").text());
            console.log("position" + $(this).find("position").text());
            console.log("issn" + $(this).find("issn").text());

        });

    };

}
xhr.send('');