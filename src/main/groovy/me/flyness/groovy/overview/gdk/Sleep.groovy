package me.flyness.groovy.overview.gdk

/**
 * Created by lizhitao on 2018/4/27.
 */
thread = Thread.start {
    println "Thread started"
    startTime = System.nanoTime()
    new Object().sleep(2000)
    endTime = System.nanoTime()
    println "Thread done in ${(endTime - startTime) / 10**9} seconds"
}
new Object().sleep(100)
println "Let's interrupt that thread"
thread.interrupt()
thread.join()

def playWithSleep(flag) {
    thread = Thread.start {
        println "Thread started"
        startTime = System.nanoTime()
        new Object().sleep(2000) {
            println "Interrupted ..." + it
            flag
        }
        endTime = System.nanoTime()
        println "Thread done in ${(endTime - startTime) / 10**9} seconds"
    }

    thread.interrupt()
    thread.join()
}

playWithSleep(true)
playWithSleep(false)