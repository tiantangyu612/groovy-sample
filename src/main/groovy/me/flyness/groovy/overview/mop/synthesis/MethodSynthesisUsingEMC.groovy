package me.flyness.groovy.overview.mop.synthesis

/**
 * Created by lizhitao on 2018/5/3.
 */
class Person4 {
    def work() { 'working...' }
}

Person4.metaClass.invokeMethod = { String name, args ->
    System.out.println "intercepting call for $name"

    def method = Person4.metaClass.getMetaMethod(name, args)
    if (method) {
        method.invoke(delegate, args)
    } else {
        Person4.metaClass.invokeMissingMethod(delegate, name, args)
    }
}

Person4.metaClass.methodMissing = { String name, args ->
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    System.out.println "methodMissing called for $name"
    def methodInList = plays.find { it == name.split('play')[1] }

    if (methodInList) {
        def impl = { Object[] vargs ->
            "playing ${name.split('play')[1]}..."
        }

        Person4.metaClass."$name" = impl
        impl(args)
    } else {
        throw new MissingMethodException(name, Person4.class, args)
    }
}

jack = new Person4()
println jack.work()
println jack.playTennis()
println jack.playVolleyBall()
println jack.playBasketBall()

try {
    jack.playFootball()
} catch (Exception e) {
    println e
}