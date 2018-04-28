package me.flyness;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by lizhitao on 2018/4/28.
 */
public class CallingScript {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("groovy");
        System.out.println("Calling script from Groovy");
        try {
            scriptEngine.eval("println 'Hello from Groovy'");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
