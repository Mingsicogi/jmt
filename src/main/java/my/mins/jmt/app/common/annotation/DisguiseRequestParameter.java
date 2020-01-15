package my.mins.jmt.app.common.annotation;

import java.lang.annotation.*;

/**
 * 해당 어노테이션을 사용하는 메소드의 경우 String을 사용하는 Parameter에 UUID를 추가하는 변조 작업을 함.
 *
 * @author minssogi
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DisguiseRequestParameter {
}
