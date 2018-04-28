package me.flyness.groovy.overview.gdk

/**
 * Created by lizhitao on 2018/4/28.
 */
process = "wc".execute()
process.out.withWriter {
    it << "Let the world know...\n"
    it << "Groovy Rocks!\n"
}
println process.in.text
//println process.text