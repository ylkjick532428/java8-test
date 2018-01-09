package java8;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

// http://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/

public class Java8Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
		String name = "Mahesh";
		Integer result = null;
		try {
			nashorn.eval("console.log('" + name + "')");
			result = (Integer) nashorn.eval("10 + 2");
		} catch (ScriptException e) {
			System.out.println("Error executing script:" + e.getMessage());
		}
		System.out.println(result.toString());
	}

}


