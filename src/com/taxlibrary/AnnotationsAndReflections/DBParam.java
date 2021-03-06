package com.taxlibrary.AnnotationsAndReflections;

/**
 * Created by ktoloc on 10.06.2016.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DBParam {
    String dbName();
    String uid();
    String password();
}