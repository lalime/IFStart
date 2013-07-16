/**
 * 
 */
package com.adorsys.ifstart;

import org.junit.Test;


/**
 * @author lalime
 *
 */
public class HtmlToPdfTest {

	@Test
	public void test() {
	
	
	 HtmlToPdf htp = new HtmlToPdf("index.html", "converted.pdf","adorsys_ifstart html to pdf");
     htp.convertToPdf();
		
	
	}
	}


