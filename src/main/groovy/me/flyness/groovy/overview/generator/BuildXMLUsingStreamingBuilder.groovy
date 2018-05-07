package me.flyness.groovy.overview.generator

import groovy.xml.StreamingMarkupBuilder

/**
 * Created by lizhitao on 2018/5/7.
 */
langs = ['C++': 'Stroustrup', 'Java': 'Gosling']

xmlDocument = new StreamingMarkupBuilder().bind {
    mkp.xmlDeclaration()
    mkp.declareNamespace(computer: "Computer")

    languages {
        comment << "Created using StreamingMarkupBuilder"
        langs.each { key, value ->
            computer.language(name: key) {
                author(value)
            }
        }
    }
}
println xmlDocument