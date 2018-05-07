package me.flyness.groovy.overview.generator

import groovy.xml.MarkupBuilder

/**
 * Created by lizhitao on 2018/5/7.
 */
bldr = new MarkupBuilder()
bldr.languages {
    language(name: 'C++') { author('Stroustrup') }
    language(name: 'Java') { author('Gosling') }
}