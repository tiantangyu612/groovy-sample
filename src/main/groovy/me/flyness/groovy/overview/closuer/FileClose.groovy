package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 关闭文件
 */
new FileWriter('output.txt').withWriter { writer ->
    writer.write('a')
} // 不再需要自己调用 close()