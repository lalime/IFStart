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
	     
		//System.out.println("This is a JUnit test ! \n We are in setUpBeforeClass() method");
	
	}

	@Test
	public void test() {
	
		/*// data-model
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
	      input.put("exampleObject", exampleObject);*/
	      
		// data-model
	      Map<String, Object> input = new HashMap<String, Object>();
	      input.put("custname", "cedric Lalime");
	      input.put("selname", "Lionnel leunkeu");

	      // create list
	      List<FactureBean> systems = new ArrayList<FactureBean>();
	      FactureBean fb[] = new FactureBean[5]; 

	      fb[0] = new FactureBean("Pel","Pelle", 3, 1500, 19.6);
	      fb[1] = new FactureBean("cim", "Sac de ciment", 10, 4600, 12.5);
	      fb[2] = new FactureBean("Cl", "Clous", 2, 500, 12);
	      fb[3] = new FactureBean("Tr", "Truelle", 2, 1000, 10);
	      fb[4] = new FactureBean("Hu", "Huile", 1, 579.23, 10.3);
	      systems.add(fb[0]);
	      systems.add(fb[1]);
	      systems.add(fb[2]);
	      systems.add(fb[3]);
	      systems.add(fb[4]);

	      input.put("systems", systems);
	      input.put("message", "Lalime");
	      double montHt = fb[0].getMontHT()+fb[1].getMontHT()+fb[2].getMontHT()+fb[3].getMontHT()+fb[4].getMontHT();
	      double monttva = fb[0].getMontTVA()+fb[1].getMontTVA()+fb[2].getMontTVA()+fb[3].getMontTVA()+fb[4].getMontTVA();
	      input.put("montHT", montHt);
	      input.put("montTVA", monttva);
	      input.put("montTTC", montHt + monttva);
	      
		
		
	      setTth(new TemplateToHtml("factemplate.ftl", input,"index.html"));
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
