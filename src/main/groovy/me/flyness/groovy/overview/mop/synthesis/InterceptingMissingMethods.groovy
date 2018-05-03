package me.flyness.groovy.overview.mop.synthesis

/**
 * Created by lizhitao on 2018/5/3.
 */
class Person3 implements GroovyInterceptable {
    def work() { 'working...' }
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def invokeMethod(String name, args) {
        System.out.println "intercepting call for $name"

        def method = metaClass.getMetaMethod(name, args)

        if (method) {
            method.invoke(this, args)
        } else {
            metaClass.invokeMethod(this, name, args)
        }
    }

    def methodMissing(String name, args) {
        System.out.println "methodMissing called for $name"
        def methodInList = plays.find { it == name.split('play')[1] }

        if (methodInList) {
            def impl = { Object[] vargs ->
                "playing ${name.split('play')[1]}..."
            }

            Person3 instance = this
            instance.metaClass."$name" = impl

            impl(args)
        } else {
            throw new MissingMethodException(name, Person3.class, args)
        }
    }
}

jack = new Person3()
println jack.work()
println jack.playTennis()
println jack.playVolleyBall()
println jack.playBasketBall()

try {
    jack.playFootball()
} catch (Exception e) {
    println e
}