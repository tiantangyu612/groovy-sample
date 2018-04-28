package me.flyness;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by lizhitao on 2018/4/28.
 */
public class ParameterPassing {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("groovy");
        System.out.println("Calling script from Groovy");
        try {
            scriptEngine.put("name", "Venkat");
            scriptEngine.eval("println \"Hello ${name} from Groovy\"; name += '!'");
            String name = (String) scriptEngine.get("name");
            System.out.println("Back in Java: " + name);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
