package me.flyness.groovy.overview.gdk

/**
 * Created by lizhitao on 2018/4/28.
 */
class PriceExtension {
    static double getPrice(String self) {
        return new Random().nextDouble();
    }
}