/**  Classe Java de conversion d'un template (fichier .ftl) 
 *   en un fichier .html à l'aide du framework freemarker 
 *   Cette classe possede plusieurs attributs dont :
 *   tmplte represente le template à convertir
 *   dtemplate le chemin d'accès au template 
 *   dest le repertoire de destination du ficher html
 *   dmodel de model associé au fichier ftl de type Map(java.util.Map)
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
public class TemplateToHtml {

	private String tmplte, dtemplate, nfdest;
	private Map<?, ?> dmodel;
	private Configuration config;
	
	

	public TemplateToHtml(String tmplte, String dtemplate, Map<?, ?> dmodel, String nfdest) {
		super();
		this.tmplte = tmplte;
		this.dtemplate = dtemplate;
		this.dmodel = dmodel;
		this.setFileNamedest(nfdest);
		config = new Configuration();
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
	


	public void generateHtml() throws IOException{
		 
		    config.setDirectoryForTemplateLoading(new File(getDtemplate()));
		    config.setObjectWrapper(new DefaultObjectWrapper());
	        config.setDefaultEncoding("UTF-8"); 
	        config.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

        /* Get the template */
        Template temp = config.getTemplate(this.getTmplte());
        
     // File output
         FileWriter file = new FileWriter(new File(nfdest));
        
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
			
			System.out.println(""+ e.getMessage());
			e.printStackTrace();	
		} catch (IOException e) {
			
			System.out.println(""+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	}

	public String getFileNamedest() {
		return nfdest;
	}

	public void setFileNamedest(String nfdest) {
		this.nfdest = nfdest;
	}
}
