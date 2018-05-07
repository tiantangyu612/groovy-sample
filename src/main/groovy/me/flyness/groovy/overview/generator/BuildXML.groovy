package me.flyness.groovy.overview.generator

import groovy.xml.MarkupBuilder

/**
 * Created by lizhitao on 2018/5/7.
 */
langs = ['C++': 'Stroustrup', 'Java': 'Gosling']
writer = new StringWriter()
bldr = new MarkupBuilder(writer)
bldr.languages {
    langs.each { key, value ->
        language(name: key) {
            author(value)
        }
    }
}
println writer