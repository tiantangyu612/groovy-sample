package me.flyness.groovy.overview.gdk

/**
 * Created by lizhitao on 2018/4/28.
 */
def printThreadInfo(msg) {
    def currentThread = Thread.currentThread()
    println "$msg Thread is ${currentThread}.Daemon? ${currentThread.isDaemon()}"
}

printThreadInfo('Main')

Thread.start {
    printThreadInfo "Started"
    sleep(3000) { println 'Interrupted' }
    println "Finished Started"
}

Thread.startDaemon {
    printThreadInfo "Started Daemon"
    sleep(5000) { println 'Interrupted' }
    println "Finished Started Daemon"
}