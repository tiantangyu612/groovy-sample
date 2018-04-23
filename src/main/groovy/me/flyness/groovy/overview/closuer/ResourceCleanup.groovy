package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 资源清理
 */
class Resource {
    def open() { print 'opened...' }

    def close() { print 'closed' }

    def read() { print 'read...' }

    def write() { print 'write...' }

    static use(closure) {
        def r = new Resource()
        try {
            r.open()
            closure(r)
        } finally {
            r.close()
        }
    }
}

def resource = new Resource()
resource.open()
resource.read()
resource.write()

println()

Resource.use {
    res ->
        res.read()
        res.write()
}