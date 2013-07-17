package com.adorsys.ifstart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.adorsys.ifstart.TemplateToPdf;

/**
 * 
 */

/**
 * @author lalime
 *
 */
public class TemplateToPdfTest {



	@Test
	public void test() {
		// data-model
	      Map<String, Object> input = new HashMap<String, Object>();
	      input.put("message", "Lalime");
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
		TemplateToPdf ttp = new TemplateToPdf("ttemplate.ftl", "src/test/java/com/adorsys/ifstart", input, "ifinal.pdf");	
		try {
			ttp.fromHtmlToPdf();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
