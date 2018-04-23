package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 科里化闭包
 */
def tellFortunes(closure) {
    Date date = new Date("04/23/2018")
    postFortune = closure.curry(date)
    postFortune "Your day is filled with ceremony"
    postFortune "They're features, not bugs"
}

tellFortunes() {
    date, fortune -> println "Fortune for ${date} is '${fortune}'"
}