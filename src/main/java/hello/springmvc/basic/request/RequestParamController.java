package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class RequestParamController {
    // 옛날 방식
    @RequestMapping("/request-param-v1") //post랑 get 분리 안되어있다!
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // String username = request.getParameter("username");
        // int age = Integer.parseInt(request.getParameter("age"));
        // response.getWriter().write("ok");
    }
    // domain은 /basic/hello-form.html임
    @ResponseBody // 이거 적으면 http 바디에 문자열로 넣어버림!
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("username={}, age={}",memberName,memberAge);
        return "ok";
    }

    @ResponseBody // 이거 적으면 http 바디에 문자열로 넣어버림!
    @RequestMapping("/request-param-v3")
    public String requestV3 ( @RequestParam String username,
            @RequestParam int age
    ){
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody // 이거 적으면 http 바디에 문자열로 넣어버림!
    @RequestMapping("/request-param-v4")
    // String int Integer등 단순 타입이면 @RequestParam 생략가능!
    public String requestV4 ( String username, int age){
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody // 이거 적으면 http 바디에 문자열로 넣어버림!
    @RequestMapping("/request-required")
    //
    public String requestParamRequired (
            @RequestParam(required = true) String username, int age){
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody // 이거 적으면 http 바디에 문자열로 넣어버림!
    @RequestMapping("/request-param-default")
    //
    public String requestParamDefault(
            @RequestParam(required = true) String username,
            @RequestParam(required = false, defaultValue ="100") int age){
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody // 이거 적으면 http 바디에 문자열로 넣어버림!
    @RequestMapping("/request-param-map")
    // parameter의 키값이 중복되지 않게 설정하자!! 굳이 중복되면 MultiValueMap사용!
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap){
        log.info("username={}, age={}",paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    // 스프링 mvc는 @ModelAttribute가 있으면 다음을 실행
    // HelloData 객체를 생성!
    // 요청 파라미터 이름으로 HelloData객체의 프로퍼티를 찾음
    // 해당 프로퍼티의 setter를 호출해서 값을 바인딩!!

    // 만약 age=abc 해버리면 BindException 발생!
    //
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(
            @ModelAttribute HelloData helloData
            ){
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        return "ok";
    }
    // 스프링은 Stirng,int, Integer등 단순 타입 => @RequestParam
    // 아니면 @ModelAttribute로 봄!(argument resolver로 지정하면 모델 안됨!)

}
