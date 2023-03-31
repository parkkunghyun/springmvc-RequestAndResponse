package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        // log를 사용하면 어떤 메소드에서 이걸 실행했는지도 알수있다!

        // 로그 레벨 선택
        log.trace("trace log={}",name); //
        log.debug("debug log={}",name); // 디버그인지 즉 개발 상태인지

        // 이것만 나옴!
        log.info("info log={}", name); // 중요한 정보인지
        log.warn("warn log={}",name); // 위험한지
        log.error("error log={}",name); // 에러 확인!

        // System.out.println하면 로그 정보가 다 남아버림!!

        // @Controller라고 하면 view를 반환!

        //RestController를 사용하면 String이 그대로 반환!
        // 반환값을 http메시지 바디에 바로 입력!
        return "ok";

        // log 제대로 사용법!
        // "name"+name 이라고 쓰는게 절대 아님!!
        // 자바언어는 +를 문자열 전에 작동시킴! -> 그래서 미리 만들어서 가지고 있게 됨!
        // 메모리와 cpu를 사용해버림!!, 출력안해도 낭비!!
        // 그래서 {}를 사용!! => 그러면 파라미터로 인식해서 출력해야할때만 설정함!!

        // println은 콘솔에 남음, 로고는 파일로 별도에 남기기도 가능!-> 네트워크로 전송도 가능!
        //
    }
}
