package com.anka.base.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented  
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FCMD {
	
	public String fieldName() default "";
	
	public CMM type();
	
	public enum CMM{
		UUID,TEXT,CDATE,UDATE,ORDER,STATUS,PID,ICON;
	}
}
