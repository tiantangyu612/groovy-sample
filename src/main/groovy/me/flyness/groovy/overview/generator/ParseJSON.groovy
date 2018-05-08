package me.flyness.groovy.overview.generator

import groovy.json.JsonSlurper

/**
 * Created by lizhitao on 2018/5/8.
 */
def sluper = new JsonSlurper()
def person = sluper.parse(new FileReader('test.json'))
println person