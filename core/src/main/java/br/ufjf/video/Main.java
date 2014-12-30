/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufjf.video;

import br.ufjf.io.FileManager;
import br.ufjf.queue.QueueActiveMQ;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author jayme
 */
public class Main {
    public static void main(String args[]) throws Exception{

    	String rdf;
        String arquivo = "";
    	
        //lê todos os arquivos xml
        ArrayList<File> files = FileManager.listFiles(new File("/home/jayme/Documents/qodra/crawler/video-search/files/Qodra/RIOcomposer/Video Aulas/"),".xml");
        
        for (File file : files){
            
            System.out.println("Convertendo em RDF: "+file.getPath());
            rdf = new Video().getRDF(file.getPath());
            
            arquivo += rdf +"\n";
            System.out.println("Enviando para fila: qodra.Crawler.RdfStore");
            new QueueActiveMQ().send(rdf);
        }
        //FileManager.writeFile("/home/jayme/Documents/qodra/crawler/video-search/files/allegro.nt", arquivo);
            
    }
}
