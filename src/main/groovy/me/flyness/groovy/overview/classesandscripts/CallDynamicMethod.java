package me.flyness.groovy.overview.classesandscripts;

import groovy.lang.GroovyObject;

/**
 * Created by lizhitao on 2018/4/28.
 */
public class CallDynamicMethod {
    public static void main(String[] args) {
        GroovyObject groovyObject = new DynamicGroovyClass();

        Object result1 = groovyObject.invokeMethod("squeak", new Object[]{});
        System.out.println("Received: " + result1);

        Object result2 = groovyObject.invokeMethod("quack", new Object[]{"like", "a", "duck"});
        System.out.println("Received: " + result2);
    }
}
