package br.com.andretanaka.locadoraaht.logger;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * by Andre Hiroshi Tanaka
 * andrehtgti2@gmail.com
 * www.andretanaka.com.br
 * 
 */

public class SLF4JAHT implements Serializable{
    
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("_yyyy_MM");

	public static Logger getLogger(Class cl){		
		boolean res = procuraArquivo("/log4j.properties");
		Logger slf4jLogger = LoggerFactory.getLogger(cl.getName());
		return slf4jLogger;
	}

	private static boolean procuraArquivo(String pathArquivo){
			Properties prop = new Properties();
			try {
				InputStream inputStream = SLF4JAHT.class.getResourceAsStream(pathArquivo);
				prop.load(inputStream);
				String logPath = prop.getProperty("log4j.appender.fileOut.File");
				File dir = new File(logPath);
				dir = dir.getParentFile();
				if(!dir.exists()){
					dir.mkdirs();
				}else{
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
	}




}
