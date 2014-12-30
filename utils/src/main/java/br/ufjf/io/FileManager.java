/*
+--------------------------------------------------------------------------------------+
|Federal University Of Juiz de Fora - UFJF - Minas Gerais - Brazil                     |
|Institute of Hard Sciences - ICE                                                      |
|Computer Science Departament - DCC                                                    |
|Project.........: qodra - video search                                                |
|Created in......:12/12/2013                                                           |
|Updated in.......24/12/2014                                                           |
|--------------------------------------------------------------------------------------+
*/

package br.ufjf.io;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class FileManager {

    private static final Logger LOGGER = Logger.getLogger(FileManager.class);

    /**
     * Store a file on disk
     *
     * @param filename
     * @param content
     */
    public static final void writeFile(String filename, String content) {

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            out.write(content);
            out.close();
        } catch (IOException e) {
            LOGGER.error("It was not possible to store the file");
            LOGGER.error("Filename: ".concat(filename));
            LOGGER.error("Content: ".concat(content));
        }

    }
    
    
    /**
     * Lista de arquivos
     * @param root: diretorio inicial
     * @param extension: extensão de arquivos desejada (*) para todos
     * @return todos os arquivos a partir do diretorio root
     * @throws Exception 
     */
    public static final ArrayList<File> listFiles(File root, String extension) throws Exception{
        ArrayList<File> result = new ArrayList<File>();
           File[] filesDir = root.listFiles();  
        
        for (File file : filesDir) {
            if (file.isDirectory()) {
                //navega recursivamente nos diretorios abaixo
                ArrayList<File> recursiveFiles = listFiles(file, extension);  
                //adiciona os arquivos encontrados no subdiretorio
                for (File recursiveFile : recursiveFiles) {
                    result.add(recursiveFile);
                }
            } else {
                //Adiciona no resultado o arquivo encontrado dentro do diretorio:
                if (accept(file.getName(), extension)) {
                    result.add(file);
                    //System.out.println(file.getPath());
                }
            }
        }
        return result;
    }

    /**
     * Filtro de arquivos
     * @param fileName: nome do arquivo
     * @param extension: extensão de arquivo a ser aceita
     * @return true se o arquivo termina com a estensção ou se extension for igual "*" false caso contrario
     */
    private static boolean accept(String fileName, String extension){
        if (extension.equals("*")) return true;
        return fileName.toLowerCase().endsWith(extension.toLowerCase());
    }

}
