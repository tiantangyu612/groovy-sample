package me.flyness.groovy.overview.mop.synthesis

/**
 * Created by lizhitao on 2018/5/3.
 */
class Person5 {}

def emc = new ExpandoMetaClass(Person5)
emc.methodMissing = { String name, args ->
    "I'm Jack of all trades... I can $name"
}
emc.initialize()

def jack = new Person5()
def paul = new Person5()

jack.metaClass = emc

println jack.sing()
println jack.dance()
println jack.juggle()

try {
    paul.sing()
} catch (Exception e) {
    println e
}