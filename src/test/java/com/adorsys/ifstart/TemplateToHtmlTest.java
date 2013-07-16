/**
 * 
 */
package com.adorsys.ifstart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author lalime
 *
 */
public class TemplateToHtmlTest {

	private TemplateToHtml tth;
	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	     
		System.out.println("This is a JUnit test ! \n We are in setUpBeforeClass() method");
	
	}

	@Test
	public void test() {
		System.out.println(" We are now entering in setUpBeforeClass() method");
		// data-model
	      Map<String, Object> input = new HashMap<String, Object>();
	      input.put("message", "vogella example");
	      input.put("container", "test");

	      // create list
	      List<ValueExampleObject> systems = new ArrayList<ValueExampleObject>();

	      systems.add(new ValueExampleObject("Android"));
	      systems.add(new ValueExampleObject("iOS States"));
	      systems.add(new ValueExampleObject("Ubuntu"));
	      systems.add(new ValueExampleObject("Windows7"));
	      systems.add(new ValueExampleObject("OS/2"));

	      input.put("systems", systems);

	      ValueExampleObject exampleObject = new ValueExampleObject("Java object");
	      input.put("exampleObject", exampleObject);
	      
	      setTth(new TemplateToHtml("ttemplate.ftl", "src/test/java/com/adorsys/ifstart", "/home/lalime/Bureau", input,"index.html"));
	      try {
			tth.generateHtml();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public TemplateToHtml getTth() {
		return tth;
	}

	public void setTth(TemplateToHtml tth) {
		this.tth = tth;
	}

}
