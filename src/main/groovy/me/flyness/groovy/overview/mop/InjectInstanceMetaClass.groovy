package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
class Person2 {
    def play() { println "playing..." }
}

def jack = new Person2()
def paul = new Person2()

jack.metaClass.sing = { ->
    'oh baby baby'
}
println jack.sing()

try {
    paul.sing()
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

jack.metaClass {
    sing = { ->
        'oh baby baby ...'
    }

    dance = { ->
        'start the music ...'
    }
}
println jack.sing()
println jack.dance()