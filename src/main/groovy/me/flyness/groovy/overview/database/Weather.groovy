package me.flyness.groovy.overview.database

import groovy.sql.Sql
import groovy.xml.MarkupBuilder

/**
 * Created by lizhitao on 2018/4/28.
 */
def sql = Sql.newInstance('jdbc:mysql://localhost:3306/weatherinfo', 'root', '111111', 'com.mysql.jdbc.Driver')
println sql.connection.catalog

println "City           Temperature"
sql.eachRow('SELECT * FROM weather') {
    printf "%-20s%s\n", it.city, it[1]
}

processMeta = { metaData ->
    metaData.columnCount.times { i ->
        printf "%-21s", metaData.getColumnLabel(i + 1)
    }
    println ""
}

sql.eachRow('SELECT * FROM weather', processMeta) {
    printf "%-20s %s\n", it.city, it[1]
}

rows = sql.rows('SELECT * FROM weather')
println "Weather Info available for ${rows.size()}"

bldr = new MarkupBuilder()
bldr.weather {
    sql.eachRow('SELECT * FROM weather') {
        city(name: it.city, temperature: it.temperature)
    }
}

dataSet = sql.dataSet('weather')
citiesBelowFreezing = dataSet.findAll { it.temperature < 50 }
println "Cities below freezing:"
//citiesBelowFreezing.each {
//    println it.city
//}

println "Number of cities: " + sql.rows('SELECT * FROM weather').size()
dataSet.add(city: 'Denver', 'temperature': 19)
println "Number of cities: " + sql.rows('SELECT * FROM weather').size()

temperature = 50
sql.executeInsert("""INSERT INTO weather(city, temperature) 
VALUES ('Oklahoma City', ${temperature})""")
println sql.firstRow("SELECT  * FROM weather WHERE city='Oklahoma City'")