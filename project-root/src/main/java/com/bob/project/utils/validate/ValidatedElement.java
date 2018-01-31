package com.bob.project.utils.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

/**
 * 待校验元素
 *
 * @author wb-jjb318191
 * @create 2018-01-31 13:36
 */
public class ValidatedElement {

    private Field field;
    private List<Annotation> annotations;

    public ValidatedElement(Field field, List<Annotation> annotations) {
        this.field = field;
        this.annotations = annotations;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }
}
