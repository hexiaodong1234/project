package com.bob.common.utils.request.post;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 情报数据组装标识注解
 *
 * @author wb-jjb318191
 * @create 2019-07-18 17:29
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpBody {
}