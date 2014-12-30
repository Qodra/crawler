/*
+--------------------------------------------------------------------------------------+
|Federal University Of Juiz de Fora - UFJF - Minas Gerais - Brazil                     |
|Institute of Hard Sciences - ICE                                                     |
|Computer Science Departament - DCC                                                    |
|Project.........: qodra - video search                                                |
|Created in......:12/12/2013                                                           |
|--------------------------------------------------------------------------------------+
*/

package br.ufjf.video;

import br.ufjf.io.FileManager;
import br.ufjf.io.XMLManager;
import br.ufjf.ontology.QodraOntology;

import org.apache.commons.lang.StringEscapeUtils;

public class Video {
	
    
    private static final String TITLE[] = {"general","title", "string"};
    private static final String COURSE[] = {"videoaula","educational","course", "title", "string"};
    private static final String DATE[] = {"lifecycle", "contribute", "date"};
    private static final String KEYWORDS[] = {"general", "keyword", "string"};
    private static final String ABSTRACT[] = {"general", "description", "string"};
    private static final String PUBLISHER[] = {"lifecycle", "contribute", "entity"};
    private static final String CREATOR[] = {"metametadata", "contribute", "entity"};
    private static final String LANGUAGE[] = {"general", "language"};
    
    
    public String getRDF(String xmlFile){
    	StringBuilder sb = new StringBuilder();

    	XMLManager.loadXMLFile(xmlFile);
        
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.TITLE,StringEscapeUtils.escapeJava(XMLManager.getValue(TITLE))));
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.COURSE,StringEscapeUtils.escapeJava(XMLManager.getValue(COURSE))));
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.DATE,XMLManager.getValue(DATE)));
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.KEYWORDS,StringEscapeUtils.escapeJava(XMLManager.getValue(KEYWORDS))));
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.ABSTRACT,StringEscapeUtils.escapeJava(XMLManager.getValue(ABSTRACT))));
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.DESCRIPTION,StringEscapeUtils.escapeJava("Módulo ASR")));/// modulo Anotação semantica
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.REFERENCES,StringEscapeUtils.escapeJava("Modulo Anotação semântica")));
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.PUBLISHER,StringEscapeUtils.escapeJava(XMLManager.getValue(PUBLISHER))));
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.CREATOR,StringEscapeUtils.escapeJava(XMLManager.getValue(CREATOR))));
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.LICENSE, StringEscapeUtils.escapeJava("GPL")));
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.LANGUAGE,XMLManager.getValue(LANGUAGE)));
        sb.append("\n");
        sb.append(getTriple(XMLManager.getValue("entry"),QodraOntology.EDUCATIONLEVEL,StringEscapeUtils.escapeJava("Superior")));
        sb.append("\n");
        
       // FileManager.writeFile("/home/jayme/Documents/qodra/crawler/video-search/files/allegrograph.nt", sb.toString());
        return sb.toString();
    	
    }
    
    private String getTriple(String subject, String predicate, String object){
        return String.format(QodraOntology.N_TRIPLE_FORMAT,subject,predicate,object);
    }    
}
