/*
+--------------------------------------------------------------------------------------+
|Federal University Of Juiz de Fora - UFJF - Minas Gerais - Brazil                     |
|Institute of Hard Sciences - ICE                                                     |
|Computer Science Departament - DCC                                                    |
|Project.........: qodra - video search                                                |
|Created in......:12/12/2013                                                           |
|--------------------------------------------------------------------------------------+
*/


package br.ufjf.ontology;

public interface QodraOntology {

    public static final String TITLE = "http://purl.org/dc/terms/title";//Título do vídeo
    
    public static final String COURSE = "http://purl.org/dc/terms/course";//Nome do curso

    public static final String DATE = "http://purl.org/dc/terms/date";//Data do vídeo
    
    public static final String KEYWORDS= "http://purl.org/dc/terms/keyword";//Palavras chaves
    
    public static final String ABSTRACT = "http://purl.org/dc/terms/abstract";//Resumo do vídeo

    public static final String DESCRIPTION = "http://purl.org/dc/terms/description";//Texto transcrito (Modulo ASR)

    public static final String REFERENCES = "http://purl.org/dc/terms/references";//Links que descrevem o conteúdo (Módulo Anotação Semântica)

    public static final String PUBLISHER = "http://purl.org/dc/terms/publisher";//Universidade org. Produtora

    public static final String CREATOR = "http://purl.org/dc/terms/creator";//Autor do vídeo

    public static final String LICENSE = "http://purl.org/dc/terms/license";//Termos de distribuição

    public static final String LANGUAGE = "http://purl.org/dc/terms/language";//Idioma do áudio do vídeo

    public static final String EDUCATIONLEVEL = "http://purl.org/dc/terms/educationLevel";// Nível de ensino

    public static final String N_TRIPLE_FORMAT = "<%s>\t<%s>\t<%s>";
    
}
