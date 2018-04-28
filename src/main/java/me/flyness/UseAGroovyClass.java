package me.flyness;

import me.flyness.groovy.overview.classesandscripts.AGroovyClass;

/**
 * Created by lizhitao on 2018/4/28.
 */
public class UseAGroovyClass {
    public static void main(String[] args) {
        AGroovyClass aGroovyClass = new AGroovyClass();
        Object result = aGroovyClass.useClosure(new Object() {
            public String call() {
                return "You called from Groovy";
            }
        });

        System.out.println("Received: " + result);

        System.out.println("Received: " + aGroovyClass.passToClosure(2, new Object() {
            public String call(int value) {
                return "You called from Groovy with value: " + value;
            }
        }));
    }
}
