package me.flyness.groovy.overview.mop.synthesis

/**
 * Created by lizhitao on 2018/5/3.
 */
class Person2 {
    def work() { "working..." }
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def methodMissing(String name, args) {
        System.out.println "methodMissing called for $name"
        def methodInList = plays.find { it == name.split('play')[1] }
        if (methodInList) {
            def impl = { Object[] vargs ->
                "playing ${name.split('play')[1]}..."
            }

            Person2 instance = this
            instance.metaClass."$name" = impl
            impl(args)
        } else {
            throw new MissingMethodException(name, Person.class, args)
        }
    }
}

jack = new Person2()

println jack.work()
println jack.playTennis()
println jack.playVolleyBall()
println jack.playBasketBall()

try {
    jack.playFootball()
} catch (Exception e) {
    println e
}