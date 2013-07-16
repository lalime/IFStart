package com.adorsys.ifstart;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class HtmlToPdf  {
	private String filetoconvert;
	private String convertedFile;
	private String title;
	
	public HtmlToPdf(String file_to_convert,  String convertedFile, String title) {
		super();
		this.filetoconvert = file_to_convert;
		this.convertedFile = convertedFile;
		this.title = title;
		 
	}
	
	
	
    //System.out.println(""+url);
    
    public String getFile_to_convert() {
		return filetoconvert;
	}

	public void setFile_to_convert(String file_to_convert) {
		this.filetoconvert = file_to_convert;
	}


	public String getConvertedFile() {
		return convertedFile;
	}



	public void setConvertedFile(String convertedFile) {
		this.convertedFile = convertedFile;
	}
	
	public String readFile(){
		String contenu = null;
		InputStream fileReader = null;
		BufferedReader input;
		try{
			
			
				// Création d'un flux de lecture de fichier final 
				fileReader = new FileInputStream(filetoconvert); 
				
				
				// creating a reader
				Reader utfReader = new InputStreamReader(fileReader,"UTF-8");
				
				// Creating a smarter reader that read line per line
				input = new BufferedReader(utfReader);
				
				//the end of line are different according to the operating system
				 String separator = System.getProperty("line.separator"); 
				
				// Object that will contains the file contents 
				 StringBuilder builder = new StringBuilder();
				String line = null;
				
				while ((line = input.readLine()) != null)
				{
					builder.append(line);
					builder.append(separator);
				} 
				contenu =  builder.toString();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Encodage non supporté !");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			finally{
				 try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		return contenu;
	}



	public void convertToPdf() {
		
		 try {
		      Document document = new Document(PageSize.LETTER);
		      PdfWriter pdfWriter = PdfWriter.getInstance
		           (document, new FileOutputStream(convertedFile));
		      document.open();
		      document.addAuthor("adorsys");
		      document.addCreator("lionnel lalime");
		      document.addSubject("Generating Pdf from Html");
		      document.addCreationDate();
		      document.addTitle(title);

		      XMLWorkerHelper worker = XMLWorkerHelper.getInstance();

		 
		      worker.parseXHtml(pdfWriter, document, new StringReader(readFile()));
		      document.close();
		      System.out.println("Done.");
		      }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		  
		
	}
}
