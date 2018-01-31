package com.bob.project.utils.validate;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

import javax.validation.constraints.NotNull;

import com.bob.project.utils.validate.ann.Email;
import com.bob.project.utils.validate.ann.Max;
import com.bob.project.utils.validate.ann.MaxLength;
import com.bob.project.utils.validate.ann.Min;
import com.bob.project.utils.validate.ann.NotEmpty;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * 数据校验器
 *
 * @author wb-jjb318191
 * @create 2018-01-31 10:35
 */
public enum Validator {

    /**
     * 邮箱校验器
     */
    EMAIL(Email.class) {
        @Override
        public void validate(Annotation ann, Object value) {
            Email email = checkAnnApplicable(ann, Email.class);
            if (email.notNull() && !StringUtils.hasLength((String)value)) {
                throw new IllegalStateException(nullErrorInfo(email.name()));
            }
            Assert.isInstanceOf(String.class, value, stringErrorInfo(email.name()));
            Assert.isTrue(EMAIL_PATTERN.matcher((String)value).matches(), email.name() + "不符合邮箱标准");
        }
    },

    /**
     * 字符串最大长度校验器
     */
    MAX_LENGTH(MaxLength.class) {
        @Override
        public void validate(Annotation ann, Object value) {
            MaxLength maxLength = checkAnnApplicable(ann, MaxLength.class);
            Assert.isInstanceOf(String.class, value, stringErrorInfo(maxLength.name()));
            if (maxLength.notNull() && !StringUtils.hasLength((String)value)) {
                throw new IllegalStateException(nullErrorInfo(maxLength.name()));
            }
            Assert.isTrue(((String)value).length() <= maxLength.value(), maxLength.name() + "长度超过了" + maxLength.value());
        }
    },

    /**
     * 内部非空校验器
     */
    NOT_EMPTY(NotEmpty.class) {
        @Override
        public void validate(Annotation ann, Object value) {
            checkAnnApplicable(ann, NotEmpty.class);
        }
    },

    /**
     * 非空校验器
     */
    NOT_NULL(NotNull.class) {
        @Override
        public void validate(Annotation ann, Object value) {
            checkAnnApplicable(ann, NotNull.class);
        }
    },

    /**
     * 最小值校验器
     */
    MIN(Min.class) {
        @Override
        public void validate(Annotation ann, Object value) {
            checkAnnApplicable(ann, Min.class);
        }
    },

    /**
     * 最大值校验器
     */
    MAX(Max.class) {
        @Override
        public void validate(Annotation ann, Object value) {
            checkAnnApplicable(ann, Max.class);
        }
    };

    private Class<? extends Annotation> annotation;

    private static final String EMAIL_RULE = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_RULE);

    Validator(Class<? extends Annotation> annotation) {
        this.annotation = annotation;
    }

    /**
     * 验证注解类型是否契合
     *
     * @param ann
     * @param clazz
     */
    private static <T> T checkAnnApplicable(Annotation ann, Class<T> clazz) {
        Assert.state(ann.annotationType() == clazz, "待校验注解的类型不匹配");
        return (T)ann;
    }

    private static String stringErrorInfo(String prefix) {
        return "[" + prefix + "]属性必须为字符串类型";
    }

    private static String nullErrorInfo(String prefix) {
        return "[" + prefix + "]属性不能为空";
    }

    /**
     * 数据校验
     *
     * @param ann
     * @param value
     * @return
     */
    public abstract void validate(Annotation ann, Object value);
}