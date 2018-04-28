package me.flyness.groovy.overview.gdk

/**
 * Created by lizhitao on 2018/4/28.
 */
def ticker = "ORCL"
println "Price for $ticker using static method is ${String.getPrice(ticker)}"
println "Price for $ticker using instance method is ${ticker.getPrice()}"