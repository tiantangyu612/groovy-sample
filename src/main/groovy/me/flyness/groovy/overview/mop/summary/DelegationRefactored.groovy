package me.flyness.groovy.overview.mop.summary

/**
 * Created by lizhitao on 2018/5/3.
 */
class Manager2 {
    {
        delegateCallsTo Worker, Expert, GregorianCalendar
    }

    def schedule() { println "schedule ..." }
}

Object.metaClass.delegateCallsTo = { Class... klassOfDelegates ->
    def objectOfDelegates = klassOfDelegates.collect { it.newInstance() }
    delegate.metaClass.methodMissing = { String name, args ->
        println "intercepting call to $name..."
        def delegateTo = objectOfDelegates.find {
            it.metaClass.respondsTo(it, name, args)
        }

        if (delegateTo) {
            delegateTo.metaClass."$name" = { Object[] vargs ->
                delegateTo.invokeMethod(name, vargs)
            }
            delegateTo.invokeMethod(name, args)
        } else {
            throw new MissingMethodException(name, delegate.getClass(), args)
        }
    }
}

peter = new Manager2()
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