package hello.springmvc.basic.requestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.lang.reflect.Method;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic", "/hello-go"}, method = RequestMethod.GET)
    public String helloBasic(){
        log.info("hello basic");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v1")
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mappingGet-V2");
        return "ok";
    }
    // 마지막 / 도 그냥포함 시켜줌!
    // GET으로 안보내면 405뜸!

    // 이거 실무용! mapping/userA
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        // @PathVariable String userId 라고 변수명이 같으면 가능
        log.info("mappingPath userId={}",data);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath2(@PathVariable("userId") String userId, @PathVariable("orderId") Long orderId){
        // @PathVariable String userId 라고 변수명이 같으면 가능
        log.info("mappingPath userId={} orderId={}",userId,orderId);
        return "ok";
    }

    // consume이라는 프로듀스가 있음
    // 소비자입장에서 요청으 컨텐츠 타입을 설정해줄수가있음!!
    //
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsume(){
        log.info("mappingConsume");
        return "ok";
    }

    @GetMapping(value = "/mapping-param",params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }
    @GetMapping(value = "/mapping-header",headers= "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }


}
