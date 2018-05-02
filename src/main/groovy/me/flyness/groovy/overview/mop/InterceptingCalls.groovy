package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
class Car implements GroovyInterceptable {
    def check() { System.out.println 'check called ...' }

    def start() { System.out.println 'start called ...' }

    def drive() { System.out.println 'drive called ...' }

    def invokeMethod(String name, args) {
        System.out.print "Call to $name intercepted ..."

        if (name != 'check') {
            System.out.print 'running filter ...'
            Car.metaClass.getMetaMethod('check').invoke(this, null)
        }

        def validMethod = Car.metaClass.getMetaMethod(name, args)
        if (validMethod != null) {
            validMethod.invoke(this, args)
        } else {
            Car.metaClass.invokeMethod(this, name, args)
        }
    }
}

car = new Car()
car.start()
car.drive()
car.check()

try {
    car.speed()
} catch (Exception e) {
    println e
}