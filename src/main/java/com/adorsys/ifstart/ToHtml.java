/**
 * 
 */
package com.adorsys.ifstart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * @author lalime
 *
 */
public class ToHtml {

	private String tmplte, dtemplate, dest;
	private Map<?, ?> dmodel;
	private Configuration config;
	
	
	
	
	public ToHtml() {
	config = new Configuration();
	
	}

	public ToHtml(String template, Map<?, ?> dmodel) {
		super();
		this.tmplte = template;
		this.dmodel = dmodel;
	}
	
	public String getTmplte() {
		return tmplte;
	}
	public void setTmplte(String template) {
		this.tmplte = template;
	}
	
	public Map<?, ?> getDmodel() {
		return dmodel;
	}
	public void setDmodel(Map<?, ?> dmodel) {
		this.dmodel = dmodel;
	}		
	
	public String getDtemplate() {
		return dtemplate;
	}

	public void setDtemplate(String dtemplate) {
		this.dtemplate = dtemplate;
	}
	
	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}
	
	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public void TemplateToHtml() throws IOException{
		
		    config.setDirectoryForTemplateLoading(new File(getDtemplate()));
	        config.setObjectWrapper(new DefaultObjectWrapper());
	        config.setDefaultEncoding("UTF-8");
	        config.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

        /* Get the template */
        Template temp = config.getTemplate(this.getTmplte());
        
     // File output
         FileWriter file = new FileWriter(new File("output.html"));
        try {
			temp.process(getDmodel(), file);
			file.flush();
		} catch (TemplateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  finally {
	      if (file != null) {
	        try {
	          file.close();
	        } catch (Exception e2) {
	        System.out.println(""+ e2.getMessage());
	        }
	      }
	        
        

        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        try {
			temp.process(getDmodel(), out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			System.out.println(""+ e.getMessage());
			e.printStackTrace();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(""+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	}
}
