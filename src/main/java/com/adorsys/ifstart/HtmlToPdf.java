/**
 * 
 */
package com.adorsys.ifstart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

/**
 * @author lalime
 *
 */
public class HtmlToPdf {
	private String file_to_convert;
	private String convertedFile;
	
	public HtmlToPdf(String file_to_convert,  String convertedFile) {
		super();
		this.file_to_convert = file_to_convert;
		this.convertedFile = convertedFile;
		 
	}
	
	
	
    //System.out.println(""+url);
    
    public String getFile_to_convert() {
		return file_to_convert;
	}

	public void setFile_to_convert(String file_to_convert) {
		this.file_to_convert = file_to_convert;
	}


	public String getConvertedFile() {
		return convertedFile;
	}



	public void setConvertedFile(String convertedFile) {
		this.convertedFile = convertedFile;
	}



	public void convertToPdf() {
    	String url = null;
		try {
			url = new File(file_to_convert).toURI().toURL().toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println(""+e.getMessage());
			e.printStackTrace();
		}
    OutputStream os = null;
	try {
		os = new FileOutputStream(convertedFile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println(" Fichier non trouvé !"+e.getMessage());
		e.printStackTrace();
	}       
    ITextRenderer renderer = new ITextRenderer();
    renderer.setDocument(url);      
    renderer.layout();
    try {
		renderer.createPDF(os);
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		System.out.println(""+e.getMessage());
		e.printStackTrace();
	}        
    try {
		os.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(""+e.getMessage());
		e.printStackTrace();
	}
    }
}
