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
	
	
	 HtmlToPdf htp = new HtmlToPdf("indx.html", "/home/lalime/Bureau/converted.pdf");
     htp.convertToPdf();
		
	
	}
	}


