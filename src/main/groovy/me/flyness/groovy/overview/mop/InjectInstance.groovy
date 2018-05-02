package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
class Person {
    def play() { println "playing..." }
}

def emc = new ExpandoMetaClass(Person)
emc.sing = { ->
    'oh baby baby'
}
emc.initialize()

def jack = new Person()
def paul = new Person()

jack.metaClass = emc

println jack.sing()

try {
    println paul.sing()
} catch (Exception e) {
    println e
}

jack.metaClass = null
try {
    jack.play()
    jack.sing()
} catch (Exception e) {
    println e
}