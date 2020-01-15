package my.mins.jmt.app.common.annotation.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 데이터 변조 AOP
 *
 * @author minssogi
 */
@Component
@Aspect
@Slf4j
public class DisguiseParameterAop {

    /**
     * @DisguiseRequestParameter 를 사용하는 메소드중 String parameter를 사용할 경우 UUID를 붙이는 변조작업 진행
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(my.mins.jmt.app.common.annotation.DisguiseRequestParameter)")
    public Object disguise(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        log.info("=== pointcut start ===");

        Object[] params = proceedingJoinPoint.getArgs();
        log.info("{}", params);

        log.info("=== 전달 받은 parameter 중 string parameter 위변조 시도 ====");
        for(int i = 0; i < params.length; i++) {
            Object object = params[i];

            if(object instanceof String) {
                params[i] = params[i] + UUID.randomUUID().toString();
                log.info("변조 : {} > {}", object, params[i]);
            }
        }

        log.info("=== pointcut end ===");
        return proceedingJoinPoint.proceed(params);
    }
}
