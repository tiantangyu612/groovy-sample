package me.flyness.groovy.overview.gdk

/**
 * Created by lizhitao on 2018/4/28.
 * 间接调用方法
 */
class Person {
    def walk() { println "Walking ..." }

    def walk(int miles) { println "Walking $miles miles ..." }

    def walk(int miles, String where) { println "Walking $miles miles $where ..." }
}

peter = new Person()
peter.invokeMethod('walk', null)
peter.invokeMethod('walk', 10)
peter.invokeMethod('walk', [10, 'uphill'] as Object[])