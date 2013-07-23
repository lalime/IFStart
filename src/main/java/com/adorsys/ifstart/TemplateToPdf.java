package com.adorsys.ifstart;

import java.io.IOException;
import java.util.Map;

public class TemplateToPdf {
	
	private TemplateToHtml tohtml;
	private HtmlToPdf topdf;
	private String tmplte, dtemplate;
	private Map<?, ?> dmodel;
	private String convertedFile;
	
	
	
	
	
	
	
	public TemplateToPdf( String tmplte, Map<?, ?> dmodel, String convertedFile) {
		super();
		String nfdest = "myfile.html";
		
		this.tohtml = new TemplateToHtml(tmplte, dmodel, nfdest);
		this.topdf =  new HtmlToPdf(nfdest,convertedFile);
	}
	public TemplateToHtml getTohtml() {
		return tohtml;
	}
	public void setTohtml(TemplateToHtml tohtml) {
		this.tohtml = tohtml;
	}
	public HtmlToPdf getTopdf() {
		return topdf;
	}
	public void setTopdf(HtmlToPdf topdf) {
		this.topdf = topdf;
	}
	public String getTmplte() {
		return tmplte;
	}
	public void setTmplte(String tmplte) {
		this.tmplte = tmplte;
	}
	public String getDtemplate() {
		return dtemplate;
	}
	public void setDtemplate(String dtemplate) {
		this.dtemplate = dtemplate;
	}
	
	public Map<?, ?> getDmodel() {
		return dmodel;
	}
	public void setDmodel(Map<?, ?> dmodel) {
		this.dmodel = dmodel;
	}
	
	public String getConvertedFile() {
		return convertedFile;
	}
	public void setConvertedFile(String convertedFile) {
		this.convertedFile = convertedFile;
	}
	
	public void fromHtmlToPdf() throws IOException{
		tohtml.generateHtml();
	    topdf.convertToPdf();
	}
	
	
	
	

}
