package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
class Car2 {
    def check() { println 'check called ...' }

    def start() { println 'start called ...' }

    def drive() { println 'drive called ...' }
}

Car2.metaClass.invokeMethod = { String name, args ->
    print "Call to $name intercepted ..."

    if (name != 'check') {
        print 'running filter ...'
        Car2.metaClass.getMetaMethod('check').invoke(delegate, null)
    }

    def validMethod = Car2.metaClass.getMetaMethod(name, args)
    if (validMethod != null) {
        validMethod.invoke(delegate, args)
    } else {
        Car2.metaClass.invokeMissingMethod(delegate, name, args)
    }
}

car = new Car2()
car.start()
car.drive()
car.check()

try {
    car.speed()
} catch (Exception e) {
    println e
}