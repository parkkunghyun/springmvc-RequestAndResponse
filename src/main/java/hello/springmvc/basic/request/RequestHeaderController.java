package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value = "myCookie",required = false)String cookie){

        // MultiValueMap은 하나의 키에 여러 값 받기 가능! 배열로 반환!
        log.info("request={}",request);
        log.info("resp={}",response);
        log.info("httpMethod={}",httpMethod);
        log.info("locale={}",locale);
        log.info("multiValueMap={}",headerMap);
        log.info("host={}",host);
        log.info("myCookie={}",cookie);
        return "ok";

        // spring 공식 사이트 가면
        // handler Methods 가면 무엇을 파라미터로 받을 수있는지 알려줌!


    }
}
