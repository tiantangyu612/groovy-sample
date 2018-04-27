package me.flyness.groovy.overview.string

/**
 * Created by lizhitao on 2018/4/27.
 * 惰性求值
 */
what = new StringBuilder('fence')
text = "The cow jumped over the $what"
println text

what.replace(0, 5, 'moon')
println text

price = 684.71
company = 'Google'
quote = "Today $company stock closed at $price"
println quote

stocks = [Apple: 663.01, Microsoft: 30.95]
stocks.each {
    key, value ->
        company = key
        price = value
        println quote
}

quote = "Today ${-> company} stock closed at ${-> price}"
stocks.each {
    key, value ->
        company = key
        price = value
        println quote
}