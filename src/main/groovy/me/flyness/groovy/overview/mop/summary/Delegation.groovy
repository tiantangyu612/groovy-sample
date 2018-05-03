package me.flyness.groovy.overview.mop.summary

/**
 * Created by lizhitao on 2018/5/3.
 */
class Worker {
    def simpleWork1(spec) { println "worker does work1 with spec $spec" }

    def simpleWork2() { println "worker does work2" }
}

class Expert {
    def advanceWork1(spec) { println "Expert does work1 with spec $spec" }

    def advanceWork2(scope, spec) { println "Expert does work2 with scope $scope spec $spec" }
}

class Manager {
    def worker = new Worker()
    def expert = new Expert()

    def schedule() { println "scheduling ..." }

    def methodMissing(String name, args) {
        println "interceptin call to $name"
        def delegateTo = null

        if (name.startsWith('simple')) {
            delegateTo = worker
        }

        if (name.startsWith('advance')) {
            delegateTo = expert
        }

        if (delegateTo?.metaClass.respondsTo(delegateTo, name, args)) {
            Manager instance = this
            instance.metaClass."$name" = { Object[] vargs ->
                delegateTo.invokeMethod(name, vargs)
            }
            delegateTo.invokeMethod(name, args)
        } else {
            throw new MissingMethodException(name, Manager.class, args)
        }
    }
}

peter = new Manager()
peter.schedule()
peter.simpleWork1('fast')
peter.simpleWork2()
peter.advanceWork1('fast')
peter.advanceWork2('protoType', 'fast')

try {
    peter.simpleWork3()
} catch (Exception e) {
    println e
}
